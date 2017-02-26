package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAdditionalData;
import ru.stqa.pft.addressbook.model.ContactMainData;
import ru.stqa.pft.addressbook.model.ContactPhonesData;
import ru.stqa.pft.addressbook.model.ContactSecondaryData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreation() {
    app.goTo().homePage();
    List<ContactMainData> before = app.contact().list();
    //int before = app.contact().count();

    ContactMainData mainData = new ContactMainData().withFirst_name("Konstantin").withLast_name("Mikhin").withNickname("Super_duper").withTitle("Surgeons").withContact_company("1st clinic").withGeneral_address("Suhaya str.");
    ContactPhonesData phonesData = new ContactPhonesData().withHome_phone("-").withMobile_phone("+375290000000").withWork_phone("+375170000000").withFax("-");
    ContactAdditionalData additionalData = new ContactAdditionalData().withEmail("K.test@mail.ru").withEmail_2("K.Test2@gmail.com").withEmail_3("-").withHomepage_link("http://www.1crp.by/").withBirthYear("1988").withAnniverYear("2010").withGroup("TEST3");
    ContactSecondaryData secondaryData = new ContactSecondaryData().withAddress_2("Second Address").withPhone_2("12312312").withNotes("Test notes");

    app.goTo().contactCreationForm();
    app.contact().create(mainData, phonesData, additionalData, secondaryData);
    List<ContactMainData> after = app.contact().list();
    //int after = app.contact().count();
    Assert.assertEquals(after.size(), before.size() + 1); //check on the number of items in the contact collection after contact creation

    mainData.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(mainData);

    Comparator<? super ContactMainData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
