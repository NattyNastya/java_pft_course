package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAdditionalData;
import ru.stqa.pft.addressbook.model.ContactMainData;
import ru.stqa.pft.addressbook.model.ContactPhonesData;
import ru.stqa.pft.addressbook.model.ContactSecondaryData;

/**
 * Created by Z51-70 on 10.01.2017.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();

    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoContactCreationForm();
      app.getContactHelper().createContact(
              new ContactMainData("ANNA", null, "Mikhin",
                      "Super_duper", "Surgeons", "1st clinic", "Suhaya str."),
              new ContactPhonesData("-", "+375290000000", "+375170000000", "-"),
              new ContactAdditionalData("K.test@mail.ru", "K.Test2@gmail.com", "-",
                      "http://www.1crp.by/", "1988", "2010", "The Surgeons"),
              new ContactSecondaryData("Second Address", "12312312",
                      "Test notes"));
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);//Contact selection by index (now it is the penultimate element)

    app.getNavigationHelper().gotoContactEditPage();
    app.getContactHelper().editContactInfo(
            new ContactMainData(null, "Pavlovich",
                    "Mikhin%%%", "Super_duper-test", "The Surgeon", "1st clinic",
                    "Suhaya str. - test"),
            new ContactPhonesData("13579", "+375297777777",
                    "+375175555555", "11111111"),
            new ContactAdditionalData("Kostya.test@mail.ru",
                    "Konstantin.Test2@gmail.com", "none",
                    "http://www.1crp.by/uz-spec", "1987", "2012", null),
            new ContactSecondaryData("Second Test Address",
                    "5557555", "Be healthy"));

    /*app.getContactHelper().fillContactMainInfo(new ContactMainData(null, "Pavlovich",
            "Mikhin", "Super_duper-test", "The Surgeon", "1st clinic",
            "Suhaya str. - test"));

    //Fills Phone fields,
    app.getContactHelper().fillContactPhones(new ContactPhonesData("13579", "+375297777777",
            "+375175555555", "11111111"));

    //Fills Emails, Birthday and Anniversary dates
    app.getContactHelper().fillContactAdditionalInfo(new ContactAdditionalData("Kostya.test@mail.ru",
            "Konstantin.Test2@gmail.com", "none",
            "http://www.1crp.by/uz-spec", "1987", "2012", null), false);

    //Fills Secondary subsections
    app.getContactHelper().fillContactSecondaryInfo(new ContactSecondaryData("Second Test Address",
            "5557555", "Be healthy"));*/

    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before); //check on the number of items in the Contact collection after Contact modification
  }
}
