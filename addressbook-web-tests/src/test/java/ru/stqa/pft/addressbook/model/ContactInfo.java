package ru.stqa.pft.addressbook.model;

/**
 * Created by Z51-70 on 13.03.2017.
 */
public class ContactInfo {
  private ContactMainData mainData;
  private ContactSecondaryData secondaryData;
  private ContactAdditionalData additionalData;

  public ContactInfo() {
  }

  public ContactInfo(ContactMainData mainData, ContactSecondaryData secondaryData,
                     ContactAdditionalData additionalData) {
    this.mainData = mainData;
    this.secondaryData = secondaryData;
    this.additionalData = additionalData;
  }

  public ContactInfo withMainData(ContactMainData mainData) {
    this.mainData = mainData;
    return this;
  }


  public void setSecondaryData(ContactSecondaryData secondaryData) {
    this.secondaryData = secondaryData;
  }

  public void setAdditionalData(ContactAdditionalData additionalData) {
    this.additionalData = additionalData;
  }

  public ContactMainData getMainData() {
    return mainData;
  }

  public ContactSecondaryData getSecondaryData() {
    return secondaryData;
  }

  public ContactAdditionalData getAdditionalData() {
    return additionalData;
  }
}
