package table;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class CustomerSAPResultSet  {
private List<String> masterNumbers;
  private List<GeneralDataTableSAP> generalDataTableSAPs;

  private List<AddressTableSAP> addressTableSAPs;

  private List<TelephoneTableSAP> telephoneTableSAPs;

  private List<EmailTableSAP> emailTableSAPs;

  public CustomerSAPResultSet(List<GeneralDataTableSAP> generalDataTableSAPs, List<TelephoneTableSAP> telephoneTableSAPs, List<AddressTableSAP> addressTableSAPs,
                              List<EmailTableSAP> emailTableSAPs) {
    this.generalDataTableSAPs = generalDataTableSAPs;
    this.addressTableSAPs = addressTableSAPs;
    this.telephoneTableSAPs = telephoneTableSAPs;
    this.emailTableSAPs = emailTableSAPs;
  }

  public Stream<CustomerSAP> groupToCustomerSAPs() {

    Map<String, List<AddressTableSAP>> addressMap = addressTableSAPs.stream()
        .collect(groupingBy(AddressTableSAP::getMasterNumber));

    Map<String, List<TelephoneTableSAP>> telephoneMap = telephoneTableSAPs.stream()
        .collect(groupingBy(TelephoneTableSAP::getMasterNumber));

    Map<String, List<EmailTableSAP>> emailMap = emailTableSAPs.stream()
        .collect(groupingBy(EmailTableSAP::getMasterNumber));


    return generalDataTableSAPs.stream().map(customerMasterSAP -> {
      String customerNumber = customerMasterSAP.getNumber();
      return new CustomerSAP(customerMasterSAP.getNumber(), telephoneMap.getOrDefault(customerNumber, new ArrayList<>()), buildAddressTableSAP(addressMap, customerNumber),
                             emailMap.getOrDefault(customerNumber, new ArrayList<>()));

    });
  }



  private AddressTableSAP buildAddressTableSAP(Map<String, List<AddressTableSAP>> addressMap, String customerNumber) {
    List<AddressTableSAP> customerAddressTableSAPSAPS = addressMap.getOrDefault(customerNumber, new ArrayList<>());
    if (customerAddressTableSAPSAPS.isEmpty()) {
      return null;
    }
    return customerAddressTableSAPSAPS.get(0);
  }

  public List<AddressTableSAP> getAddressTableSAPs() {
    return addressTableSAPs;
  }

  public List<TelephoneTableSAP> getTelephoneTableSAPs() {
    return telephoneTableSAPs;
  }

  public List<EmailTableSAP> getEmailTableSAPs() {
    return emailTableSAPs;
  }

  public void setGeneralDataTableSAPs(List<GeneralDataTableSAP> generalDataTableSAPs) {
    this.generalDataTableSAPs = generalDataTableSAPs;
  }

  public void setAddressTableSAPs(List<AddressTableSAP> addressTableSAPs) {
    this.addressTableSAPs = addressTableSAPs;
  }

  public void setEmailTableSAPs(List<EmailTableSAP> emailTableSAPs) {
    this.emailTableSAPs = emailTableSAPs;
  }

  public void setTelephoneTableSAPs(List<TelephoneTableSAP> telephoneTableSAPs) {
    this.telephoneTableSAPs = telephoneTableSAPs;
  }
}
