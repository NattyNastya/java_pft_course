package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Z51-70 on 19.03.2017.
 */
public class ContactDetailedInfoTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.goTo().contactCreationForm();
      app.contact().create(
              new ContactData().withFirst_name("Kostik").withLast_name("Mikhin").withNickname("Super_duper").withTitle("Surgeons").withContact_company("1st clinic").withGeneral_address("Suhaya str.").withHome_phone("(8017)0001000").withMobile_phone("+375290000000").withWork_phone("+375170000000").withFax("-").withAddress_2("Second Address").withPhone_2("12312312").withNotes("Test notes").withEmail("K.test@mail.ru").withEmail_2("K.Test2@gmail.com").withEmail_3("-").withHomepage_link("http://www.1crp.by/").withBirthYear("1988").withAnniverYear("2010").withGroup("TEST3"));
    }
  }

  @Test
  public void testContactDetailInfo() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    app.contact().returnToHomePage();
    app.contact().viewContactById(contact.getId());
    String contactViewInfo = app.contact().contactDetails();
    assertThat(cleanedViewInfo(contactViewInfo), equalTo(mergeAll(contactInfoFromEditForm)));
  }

  private String cleanedViewInfo(String contactViewInfo) {
    return contactViewInfo.replaceAll("H:", "").replaceAll("M:", "").replaceAll("W:", "").replaceAll("P:", "").replaceAll("Modify", "").replaceAll("Print", "").replaceAll("\n\n", "\n").replaceAll("\n\n\n\n", "");
  }

  private String mergeAll(ContactData contact) {
    return Arrays.asList(contact.getFirst_name(), contact.getLast_name(), contact.getGeneral_address(), contact.getHome_phone(), contact.getMobile_phone(), contact.getWork_phone(), contact.getAllEmails(), contact.getPhone_2()).stream().filter((s -> !s.equals(""))).map(String::trim).collect(Collectors.joining("\n"));
  }
}
