package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAdditionalData;
import ru.stqa.pft.addressbook.model.ContactMainData;
import ru.stqa.pft.addressbook.model.ContactPhonesData;
import ru.stqa.pft.addressbook.model.ContactSecondaryData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreation() {

    //app.getNavigationHelper().gotoHomePage();
    List<ContactMainData> before = app.getContactHelper().getContactList();
    //int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoContactCreationForm();
    app.getContactHelper().createContact(
            new ContactMainData("ANNA", null, "Mikhin",
                    "Super_duper", "Surgeons", "1st clinic", "Suhaya str."),
            new ContactPhonesData("-", "+375290000000", "+375170000000", "-"),
            new ContactAdditionalData("K.test@mail.ru", "K.Test2@gmail.com", "-",
                    "http://www.1crp.by/", "1988", "2010", "The Surgeons"),
            new ContactSecondaryData("Second Address", "12312312",
                    "Test notes"));
    List<ContactMainData> after = app.getContactHelper().getContactList();
    //int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size() + 1); //check on the number of items in the Contact collection after Contact creation
  }

}
