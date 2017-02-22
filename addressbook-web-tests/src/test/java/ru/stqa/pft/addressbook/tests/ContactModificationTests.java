package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAdditionalData;
import ru.stqa.pft.addressbook.model.ContactMainData;
import ru.stqa.pft.addressbook.model.ContactPhonesData;
import ru.stqa.pft.addressbook.model.ContactSecondaryData;

import java.util.Comparator;
import java.util.List;

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
                      "http://www.1crp.by/", "1988", "2010", "Anesthesiologist"),
              new ContactSecondaryData("Second Address", "12312312",
                      "Test notes"));
    }
    List<ContactMainData> before = app.getContactHelper().getContactList();
    //int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoContactEditPage(before.size() - 1);// edit last element

    ContactMainData mainData = new ContactMainData(before.get(before.size() - 1).getId(), "Anastasiya", null, "Khamitsevich", "Super_duper-test", "The Surgeon", "1st clinic", "Suhaya str. - test");
    ContactPhonesData phonesData = new ContactPhonesData("13579", "+375297777777", "+375175555555", "11111111");
    ContactAdditionalData additionalData = new ContactAdditionalData("Kostya.test@mail.ru", "Konstantin.Test2@gmail.com", "none", "http://www.1crp.by/uz-spec", "1987", "2012", null);
    ContactSecondaryData secondaryData = new ContactSecondaryData("Second Test Address", "5557555", "Be healthy");

    app.getContactHelper().editContactInfo(mainData, phonesData, additionalData, secondaryData);

    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<ContactMainData> after = app.getContactHelper().getContactList();
    // int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size()); //check on the number of items in the Contact collection after Contact modification

    before.remove(before.size() - 1);
    before.add(mainData);

    Comparator<? super ContactMainData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
