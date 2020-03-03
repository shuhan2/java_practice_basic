package table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CustomerData {

  public static CustomerSAP createCompleteOSqlCustomer() {

    AddressTableSAP addressTableSAP =
        new AddressTableSAP("0000102056", "TH", "North York", "123456 Any Street");

    List<TelephoneTableSAP> telephoneTableSAPs =
        new ArrayList<>(Arrays.asList(
            new TelephoneTableSAP("0000102056", "+1", "123"),
            new TelephoneTableSAP("0000102056", "+1", "456")));

    List<EmailTableSAP> emailTableSAPs =
        new ArrayList<>(Arrays.asList(
            new EmailTableSAP("0000102056", "2343@gmail.com"),
            new EmailTableSAP("0000102056", "2344@gmail.com")));

    return new CustomerSAP("0000102056", telephoneTableSAPs, addressTableSAP, emailTableSAPs);
  }


  public static CustomerSAP createOtherCompleteOSqlCustomer() {

    AddressTableSAP addressTableSAP =
        new AddressTableSAP("0000102057", "TH", "North York", "123456 Any Street");

    List<TelephoneTableSAP> telephoneTableSAPs =
        Arrays.asList(
            new TelephoneTableSAP("0000102057", "+1", "123"),
            new TelephoneTableSAP("0000102057", "+1", "456"));

    List<EmailTableSAP> emailTableSAPs =
        Arrays.asList(
            new EmailTableSAP("0000102057", "2343@gmail.com"),
            new EmailTableSAP("0000102057", "2344@gmail.com")
        );

    return new CustomerSAP("0000102057", telephoneTableSAPs, addressTableSAP, emailTableSAPs);
  }
}
