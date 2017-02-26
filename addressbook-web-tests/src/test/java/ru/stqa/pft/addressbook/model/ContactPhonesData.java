package ru.stqa.pft.addressbook.model;

public class ContactPhonesData {
  private String home_phone;
  private String mobile_phone;
  private String work_phone;
  private String fax;

  public ContactPhonesData withHome_phone(String home_phone) {
    this.home_phone = home_phone;
    return this;
  }

  public ContactPhonesData withMobile_phone(String mobile_phone) {
    this.mobile_phone = mobile_phone;
    return this;
  }

  public ContactPhonesData withWork_phone(String work_phone) {
    this.work_phone = work_phone;
    return this;
  }

  public ContactPhonesData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public String getHome_phone() {
    return home_phone;
  }

  public String getMobile_phone() {
    return mobile_phone;
  }

  public String getWork_phone() {
    return work_phone;
  }

  public String getFax() {
    return fax;
  }
}
