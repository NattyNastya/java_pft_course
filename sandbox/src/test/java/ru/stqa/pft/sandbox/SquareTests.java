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

  }
}
