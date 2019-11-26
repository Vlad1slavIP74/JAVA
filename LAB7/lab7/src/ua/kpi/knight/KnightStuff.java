package ua.kpi.knight;

import java.util.ArrayList;

import ua.kpi.my_set.MySet;

public class KnightStuff {

  public static void main(String[] args) {
    Knight knight1 = new Knight("Duke1", new ArrayList<>(), "Roland1", 29);
    Knight knight2 = new Knight("Duke2", new ArrayList<>(), "Roland2", 30);
    Knight knight3 = new Knight("Duke3", new ArrayList<>(), "Roland3", 31);
    Knight knight4 = new Knight("Duke4", new ArrayList<>(), "Roland4", 32);
    Knight knight5 = new Knight("Duke5", new ArrayList<>(), "Roland5", 33);

    MySet knights1 = new MySet(knight1);
    knights1.add(knight1);
    knights1.add(knight2);
    knights1.add(knight3);
    knights1.add(knight4);
    knights1.add(knight5);

    System.out.println("First knights:");
    System.out.println(knights1);

    Knight knight6 = new Knight("Duke6", new ArrayList<>(), "Roland6", 34);
    Knight knight7 = new Knight("Duke7", new ArrayList<>(), "Roland7", 35);
    Knight knight8 = new Knight("Duke8", new ArrayList<>(), "Roland8", 36);
    Knight knight9 = new Knight("Duke9", new ArrayList<>(), "Roland9", 37);
    Knight knight10 = new Knight("Duke10", new ArrayList<>(), "Roland10", 38);

    ArrayList<Knight> knightsList = new ArrayList<>(5);
    knightsList.add(knight6);
    knightsList.add(knight7);
    knightsList.add(knight8);
    knightsList.add(knight9);
    knightsList.add(knight10);

    MySet knights2 = new MySet(knightsList);

    System.out.println("Second knights:");
    System.out.println(knights2);

    System.out.println("Second knights after removing 'Roland7' and 'Roland8':");
    knights2.remove(knight7);
    knights2.remove(knight8);
    System.out.println(knights2);

    System.out.println("Is first knights equals to second knights: ");
    System.out.println(knights1.equals(knights2));
  }
}
