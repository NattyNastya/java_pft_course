package ru.stqa.pft.addressbook.model;

public class ContactMainData {
  private int id = 0;
  private String first_name;
  private String middle_name;
  private String last_name;
  private String nickname;
  private String title;
  private String contact_company;
  private String general_address;

  public ContactMainData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactMainData withFirst_name(String first_name) {
    this.first_name = first_name;
    return this;
  }

  public ContactMainData withMiddle_name(String middle_name) {
    this.middle_name = middle_name;
    return this;
  }

  public ContactMainData withLast_name(String last_name) {
    this.last_name = last_name;
    return this;
  }

  public ContactMainData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactMainData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactMainData withContact_company(String contact_company) {
    this.contact_company = contact_company;
    return this;
  }

  public ContactMainData withGeneral_address(String general_address) {
    this.general_address = general_address;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactMainData mainData = (ContactMainData) o;

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
    return "ContactMainData{" +
            "id='" + id + '\'' +
            ", first_name='" + first_name + '\'' +
            ", middle_name='" + middle_name + '\'' +
            ", last_name='" + last_name + '\'' +
            ", general_address='" + general_address + '\'' +
            '}';
  }
}
