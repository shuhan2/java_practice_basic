package entity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import table.AddressTable;
import table.EmailTable;
import table.TelephoneTable;

public class Person {

  private String masterNumber;
  private AddressTable addressTable;

  private List<TelephoneTable> telephoneTables;

  private List<EmailTable> emailTables;

  public Person() {
  }

  public Person(String masterNumber, List<TelephoneTable> telephoneTables, AddressTable addressTable,
                List<EmailTable> emailTables) {
    this.masterNumber = masterNumber;
    this.addressTable = addressTable;
    this.telephoneTables = telephoneTables;
    this.emailTables = emailTables;
  }

  public Optional<Address> getAddress() {
    return Optional.ofNullable(addressTable)
        .map(address -> new Address(address.getStreet(), address.getCity()));
  }

  public AddressTable getAddressTable() {
    return addressTable;
  }

  public List<EmailTable> getEmailTables() {
    return emailTables;
  }

  public List<TelephoneTable> getTelephoneTables() {
    return telephoneTables;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person that = (Person) o;
    return masterNumber.equals(that.masterNumber) &&
        addressTable.equals(that.addressTable) &&
        telephoneTables.equals(that.telephoneTables) &&
        emailTables.equals(that.emailTables);
  }

  @Override
  public int hashCode() {
    return Objects.hash(masterNumber, addressTable, telephoneTables, emailTables);
  }
}
