package table;


import entity.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class PersonSet {
  private List<MasterNumberTable> masterNumberTables;

  private List<AddressTable> addressTables;

  private List<TelephoneTable> telephoneTables;

  private List<EmailTable> emailTables;

  public PersonSet(List<MasterNumberTable> masterNumberTables, List<TelephoneTable> telephoneTables, List<AddressTable> addressTables,
                   List<EmailTable> emailTables) {
    this.masterNumberTables = masterNumberTables;
    this.addressTables = addressTables;
    this.telephoneTables = telephoneTables;
    this.emailTables = emailTables;
  }

  public Stream<Person> groupToPersons() {

    Map<String, List<AddressTable>> addressMap = addressTables.stream()
        .collect(groupingBy(AddressTable::getMasterNumber));

    Map<String, List<TelephoneTable>> telephoneMap = telephoneTables.stream()
        .collect(groupingBy(TelephoneTable::getMasterNumber));

    Map<String, List<EmailTable>> emailMap = emailTables.stream()
        .collect(groupingBy(EmailTable::getMasterNumber));


    return masterNumberTables.stream().map(personMaster -> {
      String personNumber = personMaster.getNumber();
      return new Person(personMaster.getNumber(), telephoneMap.getOrDefault(personNumber, new ArrayList<>()), buildAddressTable(addressMap, personNumber),
                        emailMap.getOrDefault(personNumber, new ArrayList<>()));

    });
  }

  private AddressTable buildAddressTable(Map<String, List<AddressTable>> addressMap, String personNumber) {
    List<AddressTable> personAddressTableS = addressMap.getOrDefault(personNumber, new ArrayList<>());
    if (personAddressTableS.isEmpty()) {
      return null;
    }
    return personAddressTableS.get(0);
  }

  public List<AddressTable> getAddressTables() {
    return addressTables;
  }

  public List<TelephoneTable> getTelephoneTables() {
    return telephoneTables;
  }

  public List<EmailTable> getEmailTables() {
    return emailTables;
  }

  public void setMasterNumberTables(List<MasterNumberTable> masterNumberTables) {
    this.masterNumberTables = masterNumberTables;
  }

  public void setAddressTables(List<AddressTable> addressTables) {
    this.addressTables = addressTables;
  }

  public void setEmailTables(List<EmailTable> emailTables) {
    this.emailTables = emailTables;
  }

  public void setTelephoneTables(List<TelephoneTable> telephoneTables) {
    this.telephoneTables = telephoneTables;
  }
}
