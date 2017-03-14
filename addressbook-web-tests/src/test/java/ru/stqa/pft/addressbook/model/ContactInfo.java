package ru.stqa.pft.addressbook.model;

/**
 * Created by Z51-70 on 13.03.2017.
 */
public class ContactInfo {
  private ContactMainData mainData;
  private ContactAdditionalData additionalData;

  public ContactInfo() {
  }

  public ContactInfo(ContactMainData mainData, ContactAdditionalData additionalData) {
    this.mainData = mainData;
    this.additionalData = additionalData;
  }

  public ContactInfo withMainData(ContactMainData mainData) {
    this.mainData = mainData;
    return this;
  }

  public void setAdditionalData(ContactAdditionalData additionalData) {
    this.additionalData = additionalData;
  }

  public ContactMainData getMainData() {
    return mainData;
  }

  public ContactAdditionalData getAdditionalData() {
    return additionalData;
  }
}
