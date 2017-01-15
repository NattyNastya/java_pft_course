package ru.stqa.pft.sandbox;

/**
 * Created by Z51-70 on 15.01.2017.
 */
public class Equation {

  private double a;
  private double b;
  private double c;

  private int n; //the number of roots of the equation

  public Equation(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;

    double d = b*b - 4*a*c; //calculated the discriminant of the equation

    if (d > 0) {
      n = 2;
    } else {
      if (d == 0) {
        n = 1;
      } else {
        n = 0;
      }
    }
  }

  public int rootNumber() {
    return n;
  }
}
