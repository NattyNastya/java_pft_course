package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Z51-70 on 29.01.2017.
 */
public class Collections {

  public static void main(String[] args) {
    String[] langs = new String[4];
    langs[0] = "Java";
    langs[1] = "C#";
    langs[2] = "Python";;
    langs[3] = "PHP";


    String[] langs2 = {"Java", "C#", "Python", "PHP"};
    System.out.println("The length of langs2 massive is " + langs2.length);

     for (int i = 0; i < langs2.length; i++) {
      System.out.println("I want to learn " + langs2[i]);
    }


    System.out.println("");

    String[] langs3 = {"English", "Italian", "Spanish", "German"};

    for (String l : langs3) {
      System.out.println("I want to learn " + l );
    }


    System.out.println("\n List example:");
    List<String> languages = new ArrayList<String>();
    languages.add("Japanese");
    languages.add("Java");
    languages.add("Java"); // elements can be duplicated

    for (String l: languages) {
      System.out.println("I want to learn " + l);
    }

    System.out.println("\n Arrays.asList example:");
    List<String> programLanguages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (int i = 0; i < programLanguages.size(); i++) {
      System.out.println("I want to learn " + programLanguages.get(i));
    }

    System.out.println("\n One more example:");
    List pLanguages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (Object l : pLanguages) {
      System.out.println("I want to learn " + l);
    }
  }
}
