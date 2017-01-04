package ru.stqa.pft.addressbook.model;

public class ContactMainData {
  private final String first_name;
  private final String middle_name;
  private final String last_name;
  private final String nickname;
  private final String title;
  private final String contact_company;
  private final String general_address;

  public ContactMainData(String first_name, String middle_name, String last_name, String nickname, String title, String contact_company, String general_address) {
    this.first_name = first_name;
    this.middle_name = middle_name;
    this.last_name = last_name;
    this.nickname = nickname;
    this.title = title;
    this.contact_company = contact_company;
    this.general_address = general_address;
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
}
