package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    //int before = app.contact().count();

    ContactMainData mainData = new ContactMainData().withFirst_name("Konstantin").withLast_name("Mikhin").withNickname("Super_duper").withTitle("Surgeons").withContact_company("1st clinic").withGeneral_address("Suhaya str.").withHome_phone("-").withMobile_phone("+375290000000").withWork_phone("+375170000000").withFax("-").withAddress_2("Second Address").withPhone_2("12312312").withNotes("Test notes");
    ContactAdditionalData additionalData = new ContactAdditionalData().withEmail("K.test@mail.ru").withEmail_2("K.Test2@gmail.com").withEmail_3("-").withHomepage_link("http://www.1crp.by/").withBirthYear("1988").withAnniverYear("2010").withGroup("TEST3");

    app.goTo().contactCreationForm();
    app.contact().create(mainData, additionalData);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1)); //check on the number of items in the contact collection after contact creation
    assertThat(after, equalTo(before.withAdded(mainData.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    //int before = app.contact().count();

    ContactMainData mainData = new ContactMainData().withFirst_name("Konstantin'").withLast_name(null).withNickname(null).withTitle(null).withContact_company(null).withGeneral_address(null).withHome_phone(null).withMobile_phone(null).withWork_phone(null).withFax(null).withAddress_2(null).withPhone_2(null).withNotes(null);
    ContactAdditionalData additionalData = new ContactAdditionalData().withEmail(null).withEmail_2(null).withEmail_3(null).withHomepage_link(null).withBirthYear(null).withAnniverYear(null).withGroup("TEST3");

    app.goTo().contactCreationForm();
    app.contact().create(mainData, additionalData);
    assertThat(app.contact().count(), equalTo(before.size())); //check on the number of items in the contact collection after contact creation
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before));
  }

}
