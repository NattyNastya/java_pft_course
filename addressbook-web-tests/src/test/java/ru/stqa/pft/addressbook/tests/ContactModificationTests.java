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
              new ContactMainData().withFirst_name("ANNA").withLast_name("Mikhin").withNickname("Super_duper").withTitle("Surgeons").withContact_company("1st clinic").withGeneral_address("Suhaya str."),
              new ContactPhonesData().withHome_phone("-").withMobile_phone("+375290000000").withWork_phone("+375170000000").withFax("-"),
              new ContactAdditionalData().withEmail("K.test@mail.ru").withEmail_2("K.Test2@gmail.com").withEmail_3("-").withHomepage_link("http://www.1crp.by/").withBirthYear("1988").withAnniverYear("2010").withGroup("TEST3"),
              new ContactSecondaryData().withAddress_2("Second Address").withPhone_2("12312312").withNotes("Test notes"));
    }
  }

  @Test//(enabled = false)
  public void testContactModification() {
    List<ContactMainData> before = app.contact().list();
    //int before = app.contact().count();
    int index = before.size() - 1; // last element in the contact list

    ContactMainData mainData = new ContactMainData().withId(before.get(before.size() - 1).getId()).withFirst_name("Anastasiya").withLast_name("Khamitsevich").withNickname("Super_duper-test").withTitle("The Surgeon").withContact_company("1st clinic").withGeneral_address("Suhaya str. - test");
    ContactPhonesData phonesData = new ContactPhonesData().withHome_phone("13579").withMobile_phone("+375297777777").withWork_phone("+375175555555").withFax("11111111");
    ContactAdditionalData additionalData = new ContactAdditionalData().withEmail("Kostya.test@mail.ru").withEmail_2("Konstantin.Test2@gmail.com").withEmail_3("none").withHomepage_link("http://www.1crp.by/uz-spec").withBirthYear("1987").withAnniverYear("2012");
    ContactSecondaryData secondaryData = new ContactSecondaryData().withAddress_2("Second Test Address").withPhone_2("5557555").withNotes("Be healthy");

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
