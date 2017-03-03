package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.*;

/**
 * Created by Z51-70 on 05.01.2017.
 */
public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  // Fill in New contact form
  public void fillContactMainInfo(ContactMainData contactMainData) {
    clickClearAndSendkeys(name("firstname"), contactMainData.getFirst_name());

    clickClearAndSendkeys(name("middlename"), contactMainData.getMiddle_name());

    clickClearAndSendkeys(name("lastname"), contactMainData.getLast_name());

    clickClearAndSendkeys(name("nickname"), contactMainData.getNickname());

    //Here will be photo selection

    clickClearAndSendkeys(name("title"), contactMainData.getTitle());

    clickClearAndSendkeys(name("company"), contactMainData.getContact_company());

    clickClearAndSendkeys(name("address"), contactMainData.getGeneral_address());
  }

  public void fillContactPhones(ContactPhonesData contactPhonesData) {
    clickClearAndSendkeys(name("home"), contactPhonesData.getHome_phone());

    clickClearAndSendkeys(name("mobile"), contactPhonesData.getMobile_phone());

    clickClearAndSendkeys(name("work"), contactPhonesData.getWork_phone());

    clickClearAndSendkeys(name("fax"), contactPhonesData.getFax());
  }

  public void fillContactAdditionalInfo(ContactAdditionalData contactAdditionalData, boolean creation) {
    clickClearAndSendkeys(name("email"), contactAdditionalData.getEmail());

    clickClearAndSendkeys(name("email2"), contactAdditionalData.getEmail_2());

    clickClearAndSendkeys(name("email3"), contactAdditionalData.getEmail_3());

    clickClearAndSendkeys(name("homepage"), contactAdditionalData.getHomepage_link());

    //fillContactBirthday
    dropdownMenuSelection(xpath("//form/select[1]"),"19"); //select Birth Day

    dropdownMenuSelection(xpath("//form/select[2]"),"March"); //select Birth Month
    clickClearAndSendkeys(name("byear"), contactAdditionalData.getBirthYear());

    //Anniversary
    dropdownMenuSelection(xpath("//form/select[3]"),"30"); //select Anniversary Day
    dropdownMenuSelection(xpath("//form/select[4]"),"July"); //select Anniversary Month
    clickClearAndSendkeys(name("ayear"), contactAdditionalData.getAnniverYear());

    //creation = true -> select Group exist on the page, else - does not exist
    if (creation) {
      new Select(wd.findElement(name("new_group"))).selectByVisibleText(contactAdditionalData.getGroup());
    } else {
      Assert.assertFalse(isElementPresented(name("new_group"))); //check that element shouldn't exist
    }
  }

  /*public void selectContactGroup() {
    dropdownMenuSelection(xpath("//form/select[5]"),"5");
  }*/

  public void fillContactSecondaryInfo(ContactSecondaryData contactSecondaryData) {
    clickClearAndSendkeys(name("address2"), contactSecondaryData.getAddress_2());

    clickClearAndSendkeys(name("phone2"), contactSecondaryData.getPhone_2());

    clickClearAndSendkeys(name("notes"), contactSecondaryData.getNotes());
  }

  public void returnToContactPage() {
    findElement(linkText("home")).click();
  }

  public void submitContactCreation() {
    findElement(xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void  submitContactModification() {
    wd.findElement(xpath("//*[@id='content']/form/input[@value=\"Update\"]")).click();
  }

  public void submitDeletion() {
    findElement(xpath("//div[@id='content']/form[2]/input[2]")).click();
  }

  public void create(ContactMainData cMainData, ContactPhonesData cPhonesData,
                     ContactAdditionalData cAdditionalData, ContactSecondaryData cSecondaryData) {
    fillContactInfo(cMainData, cPhonesData, cAdditionalData, cSecondaryData);
    submitContactCreation();
    returnToContactPage();
  }

  public void modifyContact(ContactMainData mainData, ContactPhonesData phonesData, ContactAdditionalData additionalData, ContactSecondaryData secondaryData) {
    editContactById(mainData.getId());
    edit(mainData, phonesData, additionalData, secondaryData);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(ContactMainData contact) {
    editContactById(contact.getId());
    submitDeletion();
    returnToHomePage();
  }

  public void fillContactInfo(ContactMainData cMainData, ContactPhonesData cPhonesData,
                               ContactAdditionalData cAdditionalData, ContactSecondaryData cSecondaryData) {
    fillContactMainInfo(cMainData);
    fillContactPhones(cPhonesData);
    fillContactAdditionalInfo(cAdditionalData, true);
    fillContactSecondaryInfo(cSecondaryData);
  }

  public void edit(ContactMainData cMainData, ContactPhonesData cPhonesData,
                   ContactAdditionalData cAdditionalData, ContactSecondaryData cSecondaryData) {
    fillContactMainInfo(cMainData);
    fillContactPhones(cPhonesData);
    fillContactAdditionalInfo(cAdditionalData, false);
    fillContactSecondaryInfo(cSecondaryData);
  }

  public void returnToHomePage() {
    if (isElementPresented(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void editContact(int index) {
    if (isElementPresented(By.xpath(".//*[@id='content']/h1"))
            && wd.findElement(By.xpath(".//*[@id='content']/h1")).getText().equals("Edit / add address book entry")
            && isElementPresented(By.name("update"))) {
      return;
    }
    wd.findElements(By.xpath("//*[@id='maintable']/tbody/tr/td[8]")).get(index).click();
  }

  public void editContactById(int id) {
    if (isElementPresented(By.xpath(".//*[@id='content']/h1"))
            && wd.findElement(By.xpath(".//*[@id='content']/h1")).getText().equals("Edit / add address book entry")
            && isElementPresented(By.name("update"))) {
      return;
    }
    wd.findElement(By.cssSelector("a[href*='edit.php?id=" + id + "']")).click();
  }

  public boolean isThereAContact() {
    return isElementPresented(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//*[@id='maintable']/tbody/tr[@name='entry']"));//by xpath will be found element of ContactMainData class
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      ContactMainData contact = new ContactMainData().withId(id).withFirst_name(firstname).withLast_name(lastname).withGeneral_address(address);
      contacts.add(contact);
    }
    return contacts;
  }
}
