package ru.stqa.pft.addressbook.tests;

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
    app.getNavigationHelper().gotoContactEditPage();
    app.getContactHelper().fillContactMainInfo(new ContactMainData("Kostya - test", "Pavlovich - test",
            "Mikhin - test", "Super_duper-test", "The Surgeon", "1st clinic - test",
            "Suhaya str. - test"));

    //Fills Phone fields,
    app.getContactHelper().fillContactPhones(new ContactPhonesData("13579", "+375297777777",
            "+375175555555", "11111111"));

    //Fills Emails, Birthday and Anniversary dates
    app.getContactHelper().fillContactAdditionalInfo(new ContactAdditionalData("Kostya.test@mail.ru",
            "Konstantin.Test2@gmail.com", "none",
            "http://www.1crp.by/uz-spec", "1987", "2012"));
    ///app.getContactHelper().selectContactGroup();

    //Fills Secondary subsections
    app.getContactHelper().fillContactSecondaryInfo(new ContactSecondaryData("Second Test Address",
            "5557555", "Be healthy"));

    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}