package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
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

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();

    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoContactCreationForm();
      app.getContactHelper().createContact(
              new ContactMainData("ANNA", null, "Mikhin",
                      "Super_duper", "Surgeons", "1st clinic", "Suhaya str."),
              new ContactPhonesData("-", "+375290000000", "+375170000000", "-"),
              new ContactAdditionalData("K.test@mail.ru", "K.Test2@gmail.com", "-",
                      "http://www.1crp.by/", "1988", "2010", "TEST3"),
              new ContactSecondaryData("Second Address", "12312312",
                      "Test notes"));
    }
    List<ContactMainData> before = app.getContactHelper().getContactList();
    //int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoContactEditPage(before.size() - 1);//Edit Last element
    app.getContactHelper().submitContactDeletion();
    app.getNavigationHelper().gotoHomePage();
    List<ContactMainData> after = app.getContactHelper().getContactList();
    //int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size() - 1); //check number of items in the Contact collection after Contact deletion

    //as we are deleting last entry, so before comparing we need to delete last entry from 'before' collection
    before.remove(before.size() - 1);

    //cycle takes place for each index of 'before' and 'after' collections and compares them
    for (int i =0; i < after.size(); i++) {
      Assert.assertEquals(before.get(i), after.get(i));
    }

  }
}
