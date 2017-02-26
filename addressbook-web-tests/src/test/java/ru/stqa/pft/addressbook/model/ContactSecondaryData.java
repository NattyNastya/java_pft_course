package ru.stqa.pft.addressbook.model;

public class ContactSecondaryData {
  private String address_2;
  private String phone_2;
  private String notes;

  public ContactSecondaryData withAddress_2(String address_2) {
    this.address_2 = address_2;
    return this;
  }

  public ContactSecondaryData withPhone_2(String phone_2) {
    this.phone_2 = phone_2;
    return this;
  }

  public ContactSecondaryData withNotes(String notes) {
    this.notes = notes;
    return this;
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
