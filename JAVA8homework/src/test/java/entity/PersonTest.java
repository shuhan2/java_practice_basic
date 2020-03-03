package entity;

import org.junit.jupiter.api.Test;
import table.AddressTable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PersonTest {

  @Test
  void should_return_address_without_country_and_region_when_get_address_given_address_table() {
    Person person = new Person("1234",
                               null, new AddressTable("1234", "country", "city", "street"), null);

    Address expected = new Address("street", "city");

    Address actual = person.getAddress().orElse(new Address());

    assertEquals(expected, actual);
  }

  @Test
  void should_return_empty_when_get_address_given_address_table_null() {
    //Then
    assertFalse(new Person().getAddress().isPresent());
  }

}