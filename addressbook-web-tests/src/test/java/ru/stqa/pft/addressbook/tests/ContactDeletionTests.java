package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Z51-70 on 10.01.2017.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    app.getNavigationHelper().gotoContactEditPage();
    app.getContactHelper().submitContactDeletion();
    app.getNavigationHelper().gotoHomePage();
  }
}
