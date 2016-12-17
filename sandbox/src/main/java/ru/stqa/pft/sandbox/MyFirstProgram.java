package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {

		hello("world");
    hello("user");
    hello("Nastya");

    Square s = new Square();
    s.l = 5;
    System.out.println("The area of a square with side " + s.l + " = " + area(s));

    Rectangle r = new Rectangle();
    r.a = 6;
    r.b = 8;
    System.out.println("The area of a rectangle with sides " + r.a + " and " + r.b + " = " + area(r));
	}

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(Square s) {
    return s.l * s.l;
  }

  public static double area(Rectangle r) {
    return r.a * r.b;
  }
}
