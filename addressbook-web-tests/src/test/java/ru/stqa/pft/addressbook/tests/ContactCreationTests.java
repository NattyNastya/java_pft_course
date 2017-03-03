package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    //int before = app.contact().count();

    ContactMainData mainData = new ContactMainData().withFirst_name("Konstantin").withLast_name("Mikhin").withNickname("Super_duper").withTitle("Surgeons").withContact_company("1st clinic").withGeneral_address("Suhaya str.");
    ContactPhonesData phonesData = new ContactPhonesData().withHome_phone("-").withMobile_phone("+375290000000").withWork_phone("+375170000000").withFax("-");
    ContactAdditionalData additionalData = new ContactAdditionalData().withEmail("K.test@mail.ru").withEmail_2("K.Test2@gmail.com").withEmail_3("-").withHomepage_link("http://www.1crp.by/").withBirthYear("1988").withAnniverYear("2010").withGroup("TEST3");
    ContactSecondaryData secondaryData = new ContactSecondaryData().withAddress_2("Second Address").withPhone_2("12312312").withNotes("Test notes");

    app.goTo().contactCreationForm();
    app.contact().create(mainData, phonesData, additionalData, secondaryData);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1)); //check on the number of items in the contact collection after contact creation
    assertThat(after, equalTo(before.withAdded(mainData.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
