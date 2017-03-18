package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = 0;
  private String first_name;
  private String middle_name;
  private String last_name;
  private String nickname;
  private String title;
  private String contact_company;
  private String general_address;

  private String home_phone;
  private String mobile_phone;
  private String work_phone;
  private String fax;
  private String phone_2;
  private String allPhones;

  private String address_2;
  private String notes;

  private String email;
  private String email_2;
  private String email_3;
  private String allEmails;
  private String homepage_link;
  private String birthYear;
  private String anniverYear;
  private String group;

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirst_name(String first_name) {
    this.first_name = first_name;
    return this;
  }

  public ContactData withMiddle_name(String middle_name) {
    this.middle_name = middle_name;
    return this;
  }

  public ContactData withLast_name(String last_name) {
    this.last_name = last_name;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withContact_company(String contact_company) {
    this.contact_company = contact_company;
    return this;
  }

  public ContactData withGeneral_address(String general_address) {
    this.general_address = general_address;
    return this;
  }
  public ContactData withHome_phone(String home_phone) {
    this.home_phone = home_phone;
    return this;
  }

  public ContactData withMobile_phone(String mobile_phone) {
    this.mobile_phone = mobile_phone;
    return this;
  }

  public ContactData withWork_phone(String work_phone) {
    this.work_phone = work_phone;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withPhone_2(String phone_2) {
    this.phone_2 = phone_2;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAddress_2(String address_2) {
    this.address_2 = address_2;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail_2(String email_2) {
    this.email_2 = email_2;
    return this;
  }

  public ContactData withEmail_3(String email_3) {
    this.email_3 = email_3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withHomepage_link(String homepage_link) {
    this.homepage_link = homepage_link;
    return this;
  }

  public ContactData withBirthYear(String birthYear) {
    this.birthYear = birthYear;
    return this;
  }

  public ContactData withAnniverYear(String anniverYear) {
    this.anniverYear = anniverYear;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public String getMiddle_name() {
    return middle_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getContact_company() {
    return contact_company;
  }

  public String getGeneral_address() {
    return general_address;
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

  public String getPhone_2() {
    return phone_2;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAddress_2() {
    return address_2;
  }

  public String getNotes() {
    return notes;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail_2() {
    return email_2;
  }

  public String getEmail_3() {
    return email_3;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getHomepage_link() {
    return homepage_link;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public String getAnniverYear() {
    return anniverYear;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData mainData = (ContactData) o;

    if (id != mainData.id) return false;
    if (first_name != null ? !first_name.equals(mainData.first_name) : mainData.first_name != null) return false;
    if (middle_name != null ? !middle_name.equals(mainData.middle_name) : mainData.middle_name != null) return false;
    if (last_name != null ? !last_name.equals(mainData.last_name) : mainData.last_name != null) return false;
    return general_address != null ? general_address.equals(mainData.general_address) : mainData.general_address == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
    result = 31 * result + (middle_name != null ? middle_name.hashCode() : 0);
    result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
    result = 31 * result + (general_address != null ? general_address.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", first_name='" + first_name + '\'' +
            ", middle_name='" + middle_name + '\'' +
            ", last_name='" + last_name + '\'' +
            ", general_address='" + general_address + '\'' +
            '}';
  }
}
