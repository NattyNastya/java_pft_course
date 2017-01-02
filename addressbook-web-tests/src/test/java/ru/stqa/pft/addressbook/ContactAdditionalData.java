package ru.stqa.pft.addressbook;

public class ContactAdditionalData {
  private final String email;
  private final String email_2;
  private final String email_3;
  private final String homepage_link;
  private final String birthYear;
  private final String anniverYear;

  public ContactAdditionalData(String email, String email_2, String email_3, String homepage_link, String birthYear, String anniverYear) {
    this.email = email;
    this.email_2 = email_2;
    this.email_3 = email_3;
    this.homepage_link = homepage_link;
    this.birthYear = birthYear;
    this.anniverYear = anniverYear;
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
}
