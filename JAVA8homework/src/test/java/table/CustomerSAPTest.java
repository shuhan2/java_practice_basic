package table;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CustomerSAPTest {

  @Test
  void should_return_address_without_country_and_region_when_get_address_given_address_table_from_sap() {
    CustomerSAP customerSAP = new CustomerSAP("1234",
                                              null,new AddressTableSAP("1234", "country", "city", "street"), null);

    Address expected = new Address("street", "city");

    Address actual = customerSAP.getAddress().orElse(new Address());

    assertEquals(expected, actual);
  }

  @Test
  void should_return_empty_when_get_address_given_address_table_from_sap_null() {
    //Then
    assertFalse(new CustomerSAP().getAddress().isPresent());
  }

}