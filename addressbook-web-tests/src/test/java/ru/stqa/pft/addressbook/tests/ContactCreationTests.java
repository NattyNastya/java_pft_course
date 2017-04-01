package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/test_img.jpg");

    ContactData newContact = new ContactData().withFirst_name("Konstantin").withLast_name("Mikhin").withNickname("Super_duper").withTitle("Surgeons").withContact_company("1st clinic").withGeneral_address("Suhaya str.").withHome_phone("(8017)111 2 333").withMobile_phone("+375290000000").withWork_phone("+375170000000").withFax("123").withAddress_2("Second Address").withPhone_2("12312312").withNotes("Test notes").withEmail("K.test@mail.ru").withEmail_2("K.Test2@gmail.com").withEmail_3("-").withHomepage_link("http://www.1crp.by/").withBirthYear("1988").withAnniverYear("2010").withPhoto(photo).withGroup("TEST3");

    app.goTo().contactCreationForm();
    app.contact().create(newContact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1)); //check on the number of items in the contact collection after contact creation
    assertThat(after, equalTo(before.withAdded(newContact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test(enabled = true)
  public void testBadContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    //int before = app.contact().count();

    ContactData newContact = new ContactData().withFirst_name("Konstantin'").withLast_name("Mikhin").withGroup("TEST3");

    app.goTo().contactCreationForm();
    app.contact().create(newContact);
    assertThat(app.contact().count(), equalTo(before.size())); //check on the number of items in the contact collection after contact creation
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

  @Test (enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println("Current dir is: " + currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/test_img.jpg");
    System.out.println("File absolute path: " + photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

}
