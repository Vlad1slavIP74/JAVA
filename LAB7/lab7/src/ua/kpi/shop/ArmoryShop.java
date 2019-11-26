package ua.kpi.shop;

import java.util.ArrayList;
import ua.kpi.ammunitions.*;

public class ArmoryShop {

  public void buy(ArrayList<Ammunition> inventory, String... ammun) {
    Ammunition temp;
    for (int i = 0; i < ammun.length; i++) {
      temp = defineAmmunition(ammun[i]);
      if (temp != null) {
        inventory.add(temp);
      }
    }
  }

  private Ammunition defineAmmunition(String type) {
    switch (type) {
      case "Armor":
        return new Armor(500, "L", false, 700, 25);
      case "Helm":
        return new Helm(100, "M", true, 100, 2);
      case "Lance":
        return new Lance(2, 100, 100, 10);
      case "Shield":
        return new Shield(200, "M", 120, 8);
      case "Sword":
        return new Sword(true, 80, 500, 10);
      default:
        System.out.println("Sir, I haven`t " + type + ".");
        return null;
    }


  }
}