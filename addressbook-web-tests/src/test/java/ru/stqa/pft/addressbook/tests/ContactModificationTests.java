package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.goTo().contactCreationForm();
      app.contact().create(
              new ContactMainData("ANNA", null, "Mikhin",
                      "Super_duper", "Surgeons", "1st clinic", "Suhaya str."),
              new ContactPhonesData("-", "+375290000000", "+375170000000", "-"),
              new ContactAdditionalData("K.test@mail.ru", "K.Test2@gmail.com", "-",
                      "http://www.1crp.by/", "1988", "2010", "Anesthesiologist"),
              new ContactSecondaryData("Second Address", "12312312",
                      "Test notes"));
    }
  }

  @Test//(enabled = false)
  public void testContactModification() {
    List<ContactMainData> before = app.contact().list();
    //int before = app.contact().count();
    int index = before.size() - 1; // last element in the contact list

    ContactMainData mainData = new ContactMainData(before.get(before.size() - 1).getId(), "Anastasiya", null, "Khamitsevich", "Super_duper-test", "The Surgeon", "1st clinic", "Suhaya str. - test");
    ContactPhonesData phonesData = new ContactPhonesData("13579", "+375297777777", "+375175555555", "11111111");
    ContactAdditionalData additionalData = new ContactAdditionalData("Kostya.test@mail.ru", "Konstantin.Test2@gmail.com", "none", "http://www.1crp.by/uz-spec", "1987", "2012", null);
    ContactSecondaryData secondaryData = new ContactSecondaryData("Second Test Address", "5557555", "Be healthy");

    app.contact().modifyContact(index, mainData, phonesData, additionalData, secondaryData);
    List<ContactMainData> after = app.contact().list();
    // int after = app.contact().count();
    Assert.assertEquals(after.size(), before.size()); //check on the number of items in the contact collection after contact modification

    before.remove(index);
    before.add(mainData);

    Comparator<? super ContactMainData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
