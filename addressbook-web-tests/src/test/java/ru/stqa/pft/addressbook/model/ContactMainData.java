package ru.stqa.pft.addressbook.model;

public class ContactMainData {
  private int id;
  private final String first_name;
  private final String middle_name;
  private final String last_name;
  private final String nickname;
  private final String title;
  private final String contact_company;
  private final String general_address;

  public ContactMainData(String first_name, String middle_name, String last_name, String nickname, String title, String contact_company, String general_address) {
    this.id = 0;
    this.first_name = first_name;
    this.middle_name = middle_name;
    this.last_name = last_name;
    this.nickname = nickname;
    this.title = title;
    this.contact_company = contact_company;
    this.general_address = general_address;
  }

  public ContactMainData(int id, String first_name, String middle_name, String last_name, String nickname, String title, String contact_company, String general_address) {
    this.id = id;
    this.first_name = first_name;
    this.middle_name = middle_name;
    this.last_name = last_name;
    this.nickname = nickname;
    this.title = title;
    this.contact_company = contact_company;
    this.general_address = general_address;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
