package table;

import entity.Person;
import entity.PersonDataProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonSetTest {

  private static final String NO_MATCH_MASTER_NUMBER = "0000999999";

  @Test
  void should_return_single_person_when_group_to_person_given_person_master_data() {
    PersonSet personSet = PersonSetDataProvider.providePersonSetWithNumber1();

    List<Person> people = personSet.groupToPersons().collect(Collectors.toList());

    Person expected = PersonDataProvider.providePersonWithNumber1();
    assertEquals(1, people.size());
    assertEquals(expected, people.get(0));
  }

  @Test
  void should_return_multiple_persons_when_group_to_person_given_multiple_person_master_data() {
    PersonSet multipleDataPersonSet = PersonSetDataProvider.providePersonSetWithNumber1And2();

    List<Person> people = multipleDataPersonSet.groupToPersons().collect(Collectors.toList());

    assertEquals(2, people.size());
    Person firstPerson = PersonDataProvider.providePersonWithNumber1();
    Person secondPerson = PersonDataProvider.providePersonWithNumber2();
    assertTrue(people.contains(firstPerson));
    assertTrue(people.contains(secondPerson));
  }

  @Test
  void should_return_empty_stream_when_group_to_person_given_no_person_master_data() {
    PersonSet personSet = PersonSetDataProvider.providePersonSetWithNumber1();
    personSet.setMasterNumberTables(new ArrayList<>());

    Stream<Person> oSqlPersonStream = personSet.groupToPersons();

    assertEquals(0, oSqlPersonStream.count());
  }

  @Test
  void should_return_empty_address_when_group_to_person_given_no_address_matches_person_number() {
    PersonSet personSet = PersonSetDataProvider.providePersonSetWithNumber1();
    List<AddressTable> addressTables = personSet.getAddressTables();
    addressTables.forEach(addressTable -> addressTable.setMasterNumber(NO_MATCH_MASTER_NUMBER));
    personSet.setAddressTables(addressTables);

    List<Person> people = personSet.groupToPersons().collect(Collectors.toList());

    assertTrue(people.stream().allMatch(person -> Objects.isNull(person.getAddressTable())));
  }

  @Test
  void should_return_empty_email_when_group_to_person_given_no_email_matches_person_number() {
    PersonSet personSet = PersonSetDataProvider.providePersonSetWithNumber1();
    List<EmailTable> emailTables = personSet.getEmailTables();
    emailTables.forEach(emailTable -> emailTable.setMasterNumber(NO_MATCH_MASTER_NUMBER));
    personSet.setEmailTables(emailTables);

    List<Person> people = personSet.groupToPersons().collect(Collectors.toList());

    assertTrue(people.stream().allMatch(person -> person.getEmailTables().isEmpty()));
  }


  @Test
  void should_return_empty_telephone_when_group_to_o_sql_person_given_no_telephone_matches_person_number() {
    PersonSet personSet = PersonSetDataProvider.providePersonSetWithNumber1();
    List<TelephoneTable> telephoneTables = personSet.getTelephoneTables();
    telephoneTables.forEach(telephoneTable -> telephoneTable.setMasterNumber(NO_MATCH_MASTER_NUMBER));
    personSet.setTelephoneTables(telephoneTables);

    List<Person> people = personSet.groupToPersons().collect(Collectors.toList());

    assertTrue(people.stream().allMatch(person -> person.getTelephoneTables().isEmpty()));
  }


  @Test
  void should_return_empty_stream_when_group_to_o_sql_person_given_no_general_data() {
    PersonSet personSet = PersonSetDataProvider.providePersonSetWithNumber1();
    personSet.setMasterNumberTables(new ArrayList<>());

    List<Person> people = personSet.groupToPersons().collect(Collectors.toList());

    assertTrue(people.isEmpty());
  }

}