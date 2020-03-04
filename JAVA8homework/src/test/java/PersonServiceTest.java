import entity.Person;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import entity.MasterNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonServiceTest {

  @Test
  void should_return_person_when_get_person_given_numbers_1() {
    PersonService personService = new PersonService();

    Stream<Person> person = personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("1")));
    Stream<Person> expectedPerson = Stream.of(PersonDataProvider.providePersonWithNumber1());

    assertEquals(expectedPerson, person);
  }

  @Test
  void should_return_empty_when_get_person_given_numbers_3() {
    PersonService personService = new PersonService();

    Stream<Person> person = personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("3")));
    Stream<Person> expectedPerson = Stream.empty();

    assertEquals(expectedPerson, person);
  }
}