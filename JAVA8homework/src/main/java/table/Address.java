package table;

import java.util.Objects;

public class Address {

  private String street;

  private String city;

  public Address(String street, String city) {
    this.street = street;
    this.city = city;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return street.equals(address.street) &&
        city.equals(address.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, city);
  }
}
