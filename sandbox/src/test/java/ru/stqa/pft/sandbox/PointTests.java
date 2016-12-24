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

    double expRes = Math.rint(p1.distance(p2));
    System.out.println(expRes);                 // Rounding the expected result
    Assert.assertEquals(expRes, 3.0);


  }
}
