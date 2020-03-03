package table;

import java.util.Objects;

public class AddressTable {

  private String masterNumber;

  private String country;

  private String city;

  private String street;

  public AddressTable(String masterNumber, String country, String city, String street) {
    this.masterNumber = masterNumber;
    this.country = country;
    this.city = city;
    this.street = street;
  }

  public String getMasterNumber() {
    return masterNumber;
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
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
    AddressTable that = (AddressTable) o;
    return Objects.equals(masterNumber, that.masterNumber) &&
        Objects.equals(country, that.country) &&
        Objects.equals(city, that.city) &&
        Objects.equals(street, that.street);
  }

  @Override
  public int hashCode() {
    return Objects.hash(masterNumber, country, city, street);
  }
}


