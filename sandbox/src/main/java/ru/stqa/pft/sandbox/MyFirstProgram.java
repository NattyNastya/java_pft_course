package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {

		hello("world");
    hello("user");
    hello("Nastya");

    double l = 5;
    System.out.println("The area of a square with side " + l + " = " + area(l));

    double a = 6;
    double b = 8;
    System.out.println("The area of a rectangle with sides " + a + " and " + b + " = " + area(a, b));
	}

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(double len) {
    return len * len;
  }

  public static double area(double a, double b) {
    return a * b;
  }
}
