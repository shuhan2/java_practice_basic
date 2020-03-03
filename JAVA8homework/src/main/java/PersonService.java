import entity.Person;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import table.PersonSet;
import table.MasterNumberTable;

import static java.util.stream.Collectors.toList;

public class PersonService {

  private Map<List<String>, Optional<PersonSet>> persons;

  public PersonService() {
    this.persons = new HashMap<>();
    persons.put(Arrays.asList("1"), null);
    persons.put(Arrays.asList("2"), null);
  }

  private Stream<Person> getPersonResultSetAndGroupToPersons(List<MasterNumberTable> generalDataOfPersons) {
    return getPersonResultSetByGeneralDataOfPersons(generalDataOfPersons)
        .map(PersonSet::groupToPersons)
        .orElse(Stream.empty());
  }

  private Optional<PersonSet> getPersonResultSetByGeneralDataOfPersons(List<MasterNumberTable> masterNumberTables) {
    List<String> numbers = masterNumberTables.stream().map(MasterNumberTable::getNumber).collect(toList());

    return persons.get(numbers);
  }


}
