package table;


import java.util.Arrays;
import java.util.List;

public class PersonSetDataProvider {

  public static PersonSet providePersonSetWithNumber1() {
    List<MasterNumberTable> masterNumberTables =
        Arrays.asList(new MasterNumberTable("1"));

    List<TelephoneTable> telephoneTableS =
        Arrays.asList(
            new TelephoneTable("1", "+1", "123"),
            new TelephoneTable("1", "+1", "456"));

    List<AddressTable> addressTables =
        Arrays.asList(new AddressTable("1", "China", "Beijing", "Any Street"));

    List<EmailTable> emailTableS =
        Arrays.asList(new EmailTable("1", "2343@gmail.com"),
                      new EmailTable("1", "2344@gmail.com"));

    return new PersonSet(masterNumberTables, telephoneTableS, addressTables, emailTableS);
  }

  public static PersonSet providePersonSetWithNumber1And2() {
    List<MasterNumberTable> masterNumberTables =
        Arrays.asList(new MasterNumberTable("1"),
                      new MasterNumberTable("2"));

    List<AddressTable> addressTables =
        Arrays.asList(
            new AddressTable("1", "China", "Beijing", "Any Street"),
            new AddressTable("2", "China", "Beijing", "Any Street")
        );

    List<TelephoneTable> telephoneTables =
        Arrays.asList(
            new TelephoneTable("1", "+1", "123"),
            new TelephoneTable("1", "+1", "456"),
            new TelephoneTable("2", "+1", "123"),
            new TelephoneTable("2", "+1", "456"));

    List<EmailTable> emailTables =
        Arrays.asList(
            new EmailTable("1", "2343@gmail.com"),
            new EmailTable("1", "2344@gmail.com"),
            new EmailTable("2", "2343@gmail.com"),
            new EmailTable("2", "2344@gmail.com")
        );

    return new PersonSet(masterNumberTables, telephoneTables, addressTables, emailTables);
  }
}
