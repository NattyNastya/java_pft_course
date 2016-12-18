package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {

   /* Point p1 = new Point();
    p1.x = 2;
    p1.y = 2;

    Point p2 = new Point();
    p2.x = 4;
    p2.y = 4;

    System.out.println("The distance between points is " + distance(p1, p2));*/

		hello("world");
    hello("user");
    hello("Nastya");

    Square s = new Square(5);
    System.out.println("The area of a square with side " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("The area of a rectangle with sides " + r.a + " and " + r.b + " = " + r.area());
	}

  /*public static double distance (Point p1, Point p2){
    return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
  }*/

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

}
