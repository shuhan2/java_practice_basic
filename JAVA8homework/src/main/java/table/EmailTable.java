package table;

import java.util.Objects;

public class EmailTable {

  private String masterNumber;

  private String emailAddress;

  public EmailTable(String masterNumber, String emailAddress) {
    this.masterNumber = masterNumber;
    this.emailAddress = emailAddress;
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
    EmailTable that = (EmailTable) o;
    return Objects.equals(masterNumber, that.masterNumber) &&
        Objects.equals(emailAddress, that.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(masterNumber, emailAddress);
  }
}
