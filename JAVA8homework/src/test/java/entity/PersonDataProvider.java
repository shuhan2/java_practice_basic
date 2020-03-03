package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import table.AddressTable;
import table.EmailTable;
import table.TelephoneTable;


public class PersonDataProvider {

  public static Person providePersonWithNumber1() {

    AddressTable addressTable =
        new AddressTable("1", "China", "Beijing", "Any Street");

    List<TelephoneTable> telephoneTables =
        new ArrayList<>(Arrays.asList(
            new TelephoneTable("1", "+1", "123"),
            new TelephoneTable("1", "+1", "456")));

    List<EmailTable> emailTables =
        new ArrayList<>(Arrays.asList(
            new EmailTable("1", "2343@gmail.com"),
            new EmailTable("1", "2344@gmail.com")));

    return new Person("1", telephoneTables, addressTable, emailTables);
  }


  public static Person providePersonWithNumber2() {

    AddressTable addressTable =
        new AddressTable("2", "China", "Beijing", "Any Street");

    List<TelephoneTable> telephoneTables =
        Arrays.asList(
            new TelephoneTable("2", "+1", "123"),
            new TelephoneTable("2", "+1", "456"));

    List<EmailTable> emailTables =
        Arrays.asList(
            new EmailTable("2", "2343@gmail.com"),
            new EmailTable("2", "2344@gmail.com")
        );

    return new Person("2", telephoneTables, addressTable, emailTables);
  }
}
