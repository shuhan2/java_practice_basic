package table;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CustomerSAP {


  private String masterNumber;
  private AddressTableSAP addressTableSAP;

  private List<TelephoneTableSAP> telephoneTableSAPs;

  private List<EmailTableSAP> emailTableSAPs;

  public CustomerSAP(String masterNumber, List<TelephoneTableSAP> telephoneTableSAPs, AddressTableSAP addressTableSAP,
                     List<EmailTableSAP> emailTableSAPs) {
    this.masterNumber = masterNumber;
    this.addressTableSAP = addressTableSAP;
    this.telephoneTableSAPs = telephoneTableSAPs;
    this.emailTableSAPs = emailTableSAPs;
  }

  public Optional<Address> getAddress() {
    return Optional.ofNullable(addressTableSAP)
        .map(addressSAP -> new Address(addressSAP.getStreet(), addressSAP.getCity()));
  }

  public List<TelephoneTableSAP> getTelephoneTableSAPS() {
    return telephoneTableSAPs;
  }

  public AddressTableSAP getAddressTableSAP() {
    return addressTableSAP;
  }

  public List<EmailTableSAP> getEmailTableSAPs() {
    return emailTableSAPs;
  }

  public List<TelephoneTableSAP> getTelephoneTableSAPs() {
    return telephoneTableSAPs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerSAP that = (CustomerSAP) o;
    return Objects.equals(masterNumber, that.masterNumber) &&
        Objects.equals(addressTableSAP, that.addressTableSAP) &&
        Objects.equals(telephoneTableSAPs, that.telephoneTableSAPs) &&
        Objects.equals(emailTableSAPs, that.emailTableSAPs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(masterNumber, addressTableSAP, telephoneTableSAPs, emailTableSAPs);
  }
}
