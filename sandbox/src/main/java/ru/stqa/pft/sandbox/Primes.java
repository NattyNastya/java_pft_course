package ru.stqa.pft.sandbox;

/**
 * Created by Z51-70 on 28.01.2017.
 */
public class Primes {

  public static boolean isPrime(int n) {
    int i = 2;
    for ( ; i < n; i++) {
      if (n % i == 0) {
        System.out.println("(FOR loop) N is NOT a prime = " + n);
        System.out.println("(FOR loop) and i = " + i);
        return  false;
      }
    }
    return true;
  }

  public static boolean isPrimeFast(int n) {

    int m = (int) Math.sqrt(n);
    for (int i = 2; i < m; i++) {
      if (n % i == 0) {
        return  false;
      }
    }
    return true;
  }

  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < n && n % i != 0) {
      i++;
    }
    return i == n;
  }

  public static boolean isPrime(long n) {
    int i = 2;
    for ( ; i < n; i++) {
      if (n % i == 0) {
        System.out.println("(FOR loop) N is NOT a prime = " + n);
        System.out.println("(FOR loop) and i = " + i);
        return  false;
      }
    }
    return true;
  }
}
