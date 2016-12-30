package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreation extends TestBase {

  @Test
  public void ContactCreation() {

    gotoContactCreationForm();

    fillContactMainInfo(new ContactMainData("Kostya", "Pavlovich", "Mikhin",
            "Super_duper", "Surgeons", "1st clinic", "Suhaya str."));

    //Fills Phone fields
    fillContactHomePhone();
    fillContactMobilePhone();
    fillContactWorkPhone();
    fillContactFax();

    //Fills Emails
    fillContactEmail();
    fillContactSecondEmail();
    fillContactThirdEmail();

    fillContactHomepage();
    fillContactBirthday();
    fillContactAnniversary();
    selectContactGroup();

    //Fills Secondary subsections
    fillContactAddress2();
    fillContactPhone2();
    fillContactNotes();

    submitContactCreation();
    returnToContactPage();
  }

}
