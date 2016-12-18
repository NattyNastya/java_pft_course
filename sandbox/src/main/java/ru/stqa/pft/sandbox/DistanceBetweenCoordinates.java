package ru.stqa.pft.sandbox;

/**
 * Created by Z51-70 on 18.12.2016.
 */
public class DistanceBetweenCoordinates {

  public static void main(String[] args) {
    Point p1 = new Point(2, 2);
    Point p2 = new Point(4, 15);

    System.out.println("The distance between " + p1.x + ", " + p1.y + " and " + p2.x + ", " + p2.y + " coordinates is " + p1.distance(p2));

  }

  /*public static double distance (Point p1, Point p2){
    return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
  }*/
}
