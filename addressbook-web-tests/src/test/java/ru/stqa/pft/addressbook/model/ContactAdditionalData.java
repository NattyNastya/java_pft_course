package ru.stqa.pft.addressbook.model;

public class ContactAdditionalData {
  private String email;
  private String email_2;
  private String email_3;
  private String homepage_link;
  private String birthYear;
  private String anniverYear;
  private String group;

  public ContactAdditionalData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactAdditionalData withEmail_2(String email_2) {
    this.email_2 = email_2;
    return this;
  }

  public ContactAdditionalData withEmail_3(String email_3) {
    this.email_3 = email_3;
    return this;
  }

  public ContactAdditionalData withHomepage_link(String homepage_link) {
    this.homepage_link = homepage_link;
    return this;
  }

  public ContactAdditionalData withBirthYear(String birthYear) {
    this.birthYear = birthYear;
    return this;
  }

  public ContactAdditionalData withAnniverYear(String anniverYear) {
    this.anniverYear = anniverYear;
    return this;
  }

  public ContactAdditionalData withGroup(String group) {
    this.group = group;
    return this;
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
}
