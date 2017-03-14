package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Z51-70 on 10.01.2017.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.goTo().contactCreationForm();
      app.contact().create(
              new ContactMainData().withFirst_name("ANNA").withLast_name("Mikhin").withNickname("Super_duper").withTitle("Surgeons").withContact_company("1st clinic").withGeneral_address("Suhaya str.").withHome_phone("-").withMobile_phone("+375290000000").withWork_phone("+375170000000").withFax("-").withAddress_2("Second Address").withPhone_2("12312312").withNotes("Test notes").withEmail("K.test@mail.ru").withEmail_2("K.Test2@gmail.com").withEmail_3("-").withHomepage_link("http://www.1crp.by/").withBirthYear("1988").withAnniverYear("2010").withGroup("TEST3"));
    }
  }

  @Test//(enabled = false)
  public void testContactDeletion() {
    Contacts before = app.contact().all();
    ContactMainData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1)); //check number of items in the contact collection after contact deletion
    Contacts after = app.contact().all();

    //as we are deleting some entry, so before comparing we need to delete this entry from 'before' collection
    assertThat(after, equalTo(before.without(deletedContact)));

  }
}
