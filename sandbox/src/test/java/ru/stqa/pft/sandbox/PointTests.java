package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Z51-70 on 25.12.2016.
 */
public class PointTests {

  @Test
  public void testDestance () {

    Point p1 = new Point(0, 0);
    Point p2 = new Point(2, 2);

    System.out.println(p1.distance(p2));

    double actualRes = Math.rint(p1.distance(p2));
    System.out.println(actualRes);                 // Rounding the actual result
    Assert.assertEquals(actualRes, 3.0);

  }

  @Test
  public void testCase2() {
    System.out.println("This is Test Case 2");
  }

  @BeforeMethod
  public void beforeMethod() {
    System.out.println("This test will be executed Before every Method");
  }

  @AfterMethod
  public void afterMethod() {
    System.out.println("This test will be executed After every Method");
  }

  @BeforeClass
  public void beforeClass() {
    System.out.println("This test will be executed Before every Class");
  }

  @AfterClass
  public void afterClass() {
    System.out.println("This test will be executed After every Class");
  }

  @BeforeTest
  public void beforeTest() {
    System.out.println("Before test execution");
  }

  @AfterTest
  public void afterTest() {
    System.out.println("After Test execution");
  }

}
