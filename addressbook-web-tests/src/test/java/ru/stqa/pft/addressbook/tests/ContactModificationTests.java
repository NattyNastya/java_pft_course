package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Z51-70 on 10.01.2017.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.goTo().contactCreationForm();
      app.contact().create(
              new ContactData().withFirst_name("ANNA").withLast_name("Mikhin").withNickname("Super_duper").withTitle("Surgeons").withContact_company("1st clinic").withGeneral_address("Suhaya str.").withHome_phone("-").withMobile_phone("+375290000000").withWork_phone("+375170000000").withFax("-").withAddress_2("Second Address").withPhone_2("12312312").withNotes("Test notes").withEmail("K.test@mail.ru").withEmail_2("K.Test2@gmail.com").withEmail_3("-").withHomepage_link("http://www.1crp.by/").withBirthYear("1988").withAnniverYear("2010").withGroup("TEST3"));
    }
  }

  @Test(enabled = true)
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();

    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirst_name("Anastasiya").withLast_name("Khamitsevich").withNickname("Super_duper-test").withTitle("The Surgeon").withContact_company("1st clinic").withGeneral_address("Suhaya str. - test").withHome_phone("13579").withMobile_phone("+375297777777").withWork_phone("+375175555555").withFax("11111111").withAddress_2("Second Test Address").withPhone_2("5557555").withNotes("Be healthy").withEmail("Kostya.test@mail.ru").withEmail_2("Konstantin.Test2@gmail.com").withEmail_3("none").withHomepage_link("http://www.1crp.by/uz-spec").withBirthYear("1987").withAnniverYear("2012");

    app.contact().modifyContact(contact);
    assertThat(app.contact().count(), equalTo(before.size())); //check on the number of items in the contact collection after contact modification
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
