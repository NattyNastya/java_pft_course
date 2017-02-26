package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAdditionalData;
import ru.stqa.pft.addressbook.model.ContactMainData;
import ru.stqa.pft.addressbook.model.ContactPhonesData;
import ru.stqa.pft.addressbook.model.ContactSecondaryData;

import java.util.List;

/**
 * Created by Z51-70 on 10.01.2017.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.goTo().contactCreationForm();
      app.contact().create(
              new ContactMainData().withFirst_name("ANNA").withLast_name("Mikhin").withNickname("Super_duper").withTitle("Surgeons").withContact_company("1st clinic").withGeneral_address("Suhaya str."),
              new ContactPhonesData().withHome_phone("-").withMobile_phone("+375290000000").withWork_phone("+375170000000").withFax("-"),
              new ContactAdditionalData().withEmail("K.test@mail.ru").withEmail_2("K.Test2@gmail.com").withEmail_3("-").withHomepage_link("http://www.1crp.by/").withBirthYear("1988").withAnniverYear("2010").withGroup("TEST3"),
              new ContactSecondaryData().withAddress_2("Second Address").withPhone_2("12312312").withNotes("Test notes"));
    }
  }

  @Test//(enabled = false)
  public void testContactDeletion() {
    List<ContactMainData> before = app.contact().list();
    //int before = app.contact().count();
    int index = before.size() - 1; //It's Last element in the Contact list
    app.contact().delete(index);
    List<ContactMainData> after = app.contact().list();
    //int after = app.contact().count();
    Assert.assertEquals(after.size(), before.size() - 1); //check number of items in the contact collection after contact deletion

    //as we are deleting last entry, so before comparing we need to delete last entry from 'before' collection
    before.remove(before.size() - 1);

    //cycle takes place for each index of 'before' and 'after' collections and compares them
    Assert.assertEquals(before, after);

  }
}
