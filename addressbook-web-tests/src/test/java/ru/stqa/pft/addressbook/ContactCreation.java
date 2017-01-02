package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreation extends TestBase {

  @Test
  public void ContactCreation() {

    app.gotoContactCreationForm();

    app.fillContactMainInfo(new ContactMainData("Kostya", "Pavlovich", "Mikhin",
            "Super_duper", "Surgeons", "1st clinic", "Suhaya str."));

    //Fills Phone fields,
    app.fillContactPhones(new ContactPhonesData("-", "+375290000000", "+375170000000", "-"));

    //Fills Emails, Birthday and Anniversary dates
    app.fillContactAdditionalInfo(new ContactAdditionalData("K.test@mail.ru", "K.Test2@gmail.com", "-",
            "http://www.1crp.by/", "1988", "2010"));
    app.selectContactGroup();

    //Fills Secondary subsections
    app.fillContactSecondaryInfo(new ContactSecondaryData("Second Address", "12312312", "Test notes"));

    app.submitContactCreation();
    app.returnToContactPage();
  }

}
