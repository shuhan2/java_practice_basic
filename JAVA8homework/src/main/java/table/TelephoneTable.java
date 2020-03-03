package table;

import java.util.Objects;

public class TelephoneTable {

  private String masterNumber;
  private String countryCode;

  private String telephoneNumber;

  public TelephoneTable(String masterNumber, String countryCode, String telephoneNumber) {
    this.masterNumber = masterNumber;
    this.countryCode = countryCode;
    this.telephoneNumber = telephoneNumber;
  }

  public String getMasterNumber() {
    return masterNumber;
  }

  public void setMasterNumber(String masterNumber) {
    this.masterNumber = masterNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelephoneTable that = (TelephoneTable) o;
    return Objects.equals(masterNumber, that.masterNumber) &&
        Objects.equals(countryCode, that.countryCode) &&
        Objects.equals(telephoneNumber, that.telephoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(masterNumber, countryCode, telephoneNumber);
  }
}

