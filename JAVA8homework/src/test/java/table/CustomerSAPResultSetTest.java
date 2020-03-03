package table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerSAPResultSetTest {

  @Test
  void should_return_single_customer_when_group_to_customer_given_customer_master_data() {
    CustomerSAPResultSet customerSet = CustomerSetData.createOSqlCompleteCustomerSet();

    List<CustomerSAP> customerSAPs = customerSet.groupToCustomerSAPs().collect(Collectors.toList());

    CustomerSAP expected = CustomerData.createCompleteOSqlCustomer();
    assertEquals(1, customerSAPs.size());
    assertEquals(expected, customerSAPs.get(0));
  }

  @Test
  void should_return_multiple_o_sql_customers_when_group_to_o_sql_customer_given_there_are_multiple_customer_master_data() {
    CustomerSAPResultSet multipleDataOSqlCompleteCustomerSet = CustomerSetData.createMultipleDataOSqlCompleteCustomerSet();

    List<CustomerSAP> customerSAPs = multipleDataOSqlCompleteCustomerSet.groupToCustomerSAPs().collect(Collectors.toList());

    assertEquals(2, customerSAPs.size());
    CustomerSAP firstCustomerSAP = CustomerData.createCompleteOSqlCustomer();
    CustomerSAP secondCustomerSAP = CustomerData.createOtherCompleteOSqlCustomer();
    assertTrue(customerSAPs.contains(firstCustomerSAP));
    assertTrue(customerSAPs.contains(secondCustomerSAP));
  }

  @Test
  void should_return_empty_stream_when_group_to_o_sql_customer_given_there_is_no_customer_master_data() {
    CustomerSAPResultSet customerSAPResultSet = CustomerSetData.createOSqlCompleteCustomerSet();
    customerSAPResultSet.setGeneralDataTableSAPs(new ArrayList<>());

    Stream<CustomerSAP> oSqlCustomerStream = customerSAPResultSet.groupToCustomerSAPs();

    assertEquals(0, oSqlCustomerStream.count());
  }
//
  @Test
  void should_return_empty_address_when_group_to_o_sql_customer_given_no_address_matches_customer_number() {
    CustomerSAPResultSet oSqlCompleteCustomerSet = CustomerSetData.createOSqlCompleteCustomerSet();
    List<AddressTableSAP> addressTableSAPs = oSqlCompleteCustomerSet.getAddressTableSAPs();
    addressTableSAPs.forEach(addressTableSAP -> addressTableSAP.setMasterNumber("0000999999"));
    oSqlCompleteCustomerSet.setAddressTableSAPs(addressTableSAPs);

    List<CustomerSAP> customerSAPs = oSqlCompleteCustomerSet.groupToCustomerSAPs().collect(Collectors.toList());

    assertTrue(customerSAPs.stream().allMatch(customerSAP -> Objects.isNull(customerSAP.getAddressTableSAP())));
  }

  @Test
  void should_return_empty_email_when_group_to_o_sql_customer_given_no_email_matches_customer_number() {
    // Given
    CustomerSAPResultSet oSqlCompleteCustomerSet = CustomerSetData.createOSqlCompleteCustomerSet();
    List<EmailTableSAP> emailTableSAPs = oSqlCompleteCustomerSet.getEmailTableSAPs();
    emailTableSAPs.forEach(emailTableSAP -> emailTableSAP.setMasterNumber("0000999999"));
    oSqlCompleteCustomerSet.setEmailTableSAPs(emailTableSAPs);

    // When
    List<CustomerSAP> customerSAPs = oSqlCompleteCustomerSet.groupToCustomerSAPs().collect(Collectors.toList());

    // Then
    assertTrue(customerSAPs.stream().allMatch(customerSAP -> customerSAP.getEmailTableSAPs().isEmpty()));
  }



  @Test
  void should_return_empty_telephone_when_group_to_o_sql_customer_given_no_telephone_matches_customer_number() {
    CustomerSAPResultSet oSqlCompleteCustomerSet = CustomerSetData.createOSqlCompleteCustomerSet();
    List<TelephoneTableSAP> telephoneTableSAPs = oSqlCompleteCustomerSet.getTelephoneTableSAPs();
    telephoneTableSAPs.forEach(telephoneTableSAP -> telephoneTableSAP.setMasterNumber("0000999999"));
    oSqlCompleteCustomerSet.setTelephoneTableSAPs(telephoneTableSAPs);

    List<CustomerSAP> customerSAPs = oSqlCompleteCustomerSet.groupToCustomerSAPs().collect(Collectors.toList());

    assertTrue(customerSAPs.stream().allMatch(customerSAP -> customerSAP.getTelephoneTableSAPs().isEmpty()));
  }



  @Test
  void should_return_empty_stream_when_group_to_o_sql_customer_given_no_general_data() {
    // Given
    CustomerSAPResultSet oSqlCompleteCustomerSet = CustomerSetData.createOSqlCompleteCustomerSet();
    oSqlCompleteCustomerSet.setGeneralDataTableSAPs(new ArrayList<>());

    List<CustomerSAP> customerSAPs = oSqlCompleteCustomerSet.groupToCustomerSAPs().collect(Collectors.toList());

    assertTrue(customerSAPs.isEmpty());
  }

}