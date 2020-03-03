package table;

import java.util.Objects;

public class GeneralDataTableSAP  {

  private String number;

  public GeneralDataTableSAP(String number) {
    this.number = number;
  }

  public String getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeneralDataTableSAP that = (GeneralDataTableSAP) o;
    return number.equals(that.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}