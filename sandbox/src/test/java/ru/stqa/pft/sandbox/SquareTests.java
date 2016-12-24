package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Z51-70 on 24.12.2016.
 */
public class SquareTests {

  @Test
  public void testArea() {
    Square s = new Square(5);
    /*assert s.area() == 24*/; //expected result is not displayed

    Assert.assertEquals(s.area(), 25.0); // Now expected result will be displayed

/*    double x = 24;

    if ((x - s.area()) <= 1 && (x - s.area()) > 0) { //accept test if Actual result greater then Expected result for 1
      System.out.println("Test passed");
      System.out.println(x + " - " + s.area() + " = " + (x - s.area()));
      System.out.println("Actual result = " + s.area());
    } else Assert.assertEquals(s.area(), x);*/

  }
}
