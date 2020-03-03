package table;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerSetData {

  public static CustomerSAPResultSet createOSqlCompleteCustomerSet() {
    List<GeneralDataTableSAP> generalDataTableSAPs =
        new ArrayList<>(Arrays.asList(new GeneralDataTableSAP("0000102056")));

    List<TelephoneTableSAP> telephoneTableSAPSAPS =
        new ArrayList<>(Arrays.asList(
            new TelephoneTableSAP("0000102056", "+1", "123"),
            new TelephoneTableSAP("0000102056", "+1", "456")));

    List<AddressTableSAP> addressTableSAPs =
        new ArrayList<>(Arrays.asList(new AddressTableSAP("0000102056", "TH", "North York", "123456 Any Street")));
    List<EmailTableSAP> emailTableSAPSAPS =
        new ArrayList<>(Arrays.asList(new
            EmailTableSAP("0000102056","2343@gmail.com"),

            new EmailTableSAP("0000102056","2344@gmail.com")
                ));


    return new CustomerSAPResultSet(generalDataTableSAPs, telephoneTableSAPSAPS, addressTableSAPs
        , emailTableSAPSAPS);
  }

  public static CustomerSAPResultSet createMultipleDataOSqlCompleteCustomerSet() {
    List<GeneralDataTableSAP> generalDataTableSAPs =
        new ArrayList<>(
            Arrays.asList(new GeneralDataTableSAP("0000102056"),
            new GeneralDataTableSAP("0000102057")
            ));

    List<AddressTableSAP> addressTableSAPs =
        new ArrayList<>(Arrays.asList(
            new AddressTableSAP("0000102056","TH", "North York",  "123456 Any Street"),
            new AddressTableSAP("0000102057","TH", "North York",  "123456 Any Street")

            ));

    List<TelephoneTableSAP> telephoneTableSAPs =
        Arrays.asList(
            new TelephoneTableSAP("0000102056","+1", "123"),
            new TelephoneTableSAP("0000102056","+1", "456"),
            new TelephoneTableSAP("0000102057","+1", "123"),
            new TelephoneTableSAP("0000102057","+1", "456"));

    List<EmailTableSAP> emailTableSAPs =
        Arrays.asList(
            new EmailTableSAP("0000102056", "2343@gmail.com"),
            new EmailTableSAP("0000102056", "2344@gmail.com"),
            new EmailTableSAP("0000102057", "2343@gmail.com"),
            new EmailTableSAP("0000102057", "2344@gmail.com")
            );

   return new CustomerSAPResultSet(generalDataTableSAPs, telephoneTableSAPs, addressTableSAPs, emailTableSAPs);
  }
}
