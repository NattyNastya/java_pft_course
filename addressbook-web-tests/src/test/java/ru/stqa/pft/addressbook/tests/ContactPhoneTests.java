package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Z51-70 on 17.03.2017.
 */
public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.goTo().contactCreationForm();
      app.contact().create(
              new ContactData().withFirst_name("ANNA").withLast_name("Mikhin").withNickname("Super_duper").withTitle("Surgeons").withContact_company("1st clinic").withGeneral_address("Suhaya str.").withHome_phone("(8017)0001000").withMobile_phone("+375290000000").withWork_phone("+375170000000").withFax("-").withAddress_2("Second Address").withPhone_2("12312312").withNotes("Test notes").withEmail("K.test@mail.ru").withEmail_2("K.Test2@gmail.com").withEmail_3("-").withHomepage_link("http://www.1crp.by/").withBirthYear("1988").withAnniverYear("2010").withGroup("TEST3"));
    }
  }

  @Test(enabled = true)
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData cInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getHome_phone(), equalTo(cleaned(cInfoFromEditForm.getHome_phone())));
    assertThat(contact.getMobile_phone(), equalTo(cleaned(cInfoFromEditForm.getMobile_phone())));
    assertThat(contact.getWork_phone(), equalTo(cleaned(cInfoFromEditForm.getWork_phone())));
    assertThat(contact.getPhone_2(), equalTo(cleaned(cInfoFromEditForm.getPhone_2())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
