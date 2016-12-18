package ru.stqa.pft.sandbox;

/**
 * Created by Z51-70 on 18.12.2016.
 */
public class DistanceBetweenCoordinates {

  public static void main(String[] args) {

    Point p1 = new Point();
    Point p2 = new Point();
    p1.x = 5;
    p1.y = 6;
    p2.x = 7;
    p2.x = 8;

    System.out.println("The distance between coordinates is " + distance(p1, p2));
  }

  public static double distance (Point p1, Point p2){
    return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
  }
}
