package ru.stqa.pft.addressbook;

public class ContactSecondaryData {
  private final String address_2;
  private final String phone_2;
  private final String notes;

  public ContactSecondaryData(String address_2, String phone_2, String notes) {
    this.address_2 = address_2;
    this.phone_2 = phone_2;
    this.notes = notes;
  }

  public String getAddress_2() {
    return address_2;
  }

  public String getPhone_2() {
    return phone_2;
  }

  public String getNotes() {
    return notes;
  }
}
