package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

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
}
