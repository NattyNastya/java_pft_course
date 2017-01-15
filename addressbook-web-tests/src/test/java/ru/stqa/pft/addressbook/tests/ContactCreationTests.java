package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAdditionalData;
import ru.stqa.pft.addressbook.model.ContactMainData;
import ru.stqa.pft.addressbook.model.ContactPhonesData;
import ru.stqa.pft.addressbook.model.ContactSecondaryData;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreation() {

    app.getNavigationHelper().gotoContactCreationForm();

    app.getContactHelper().fillContactMainInfo(new ContactMainData("NASTYA", "Pavlovich", "Mikhin",
            "Super_duper", "Surgeons", "1st clinic", "Suhaya str."));

    //Fills Phone fields,
    app.getContactHelper().fillContactPhones(new ContactPhonesData("-", "+375290000000", "+375170000000", "-"));

    //Fills Emails, Birthday and Anniversary dates
    app.getContactHelper().fillContactAdditionalInfo(new ContactAdditionalData("K.test@mail.ru", "K.Test2@gmail.com", "-",
            "http://www.1crp.by/", "1988", "2010"));
    app.getContactHelper().selectContactGroup();

    //Fills Secondary subsections
    app.getContactHelper().fillContactSecondaryInfo(new ContactSecondaryData("Second Address", "12312312", "Test notes"));

    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactPage();
  }

}
