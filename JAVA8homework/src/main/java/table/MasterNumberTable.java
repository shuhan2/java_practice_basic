package table;

import java.util.Objects;

public class MasterNumberTable {

  private String number;

  public MasterNumberTable(String number) {
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
    MasterNumberTable that = (MasterNumberTable) o;
    return number.equals(that.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}