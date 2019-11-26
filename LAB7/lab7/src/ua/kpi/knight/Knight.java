package ua.kpi.knight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import ua.kpi.ammunitions.Ammunition;
import ua.kpi.ammunitions.Sword;

public class Knight extends Human {

  private String title;
  private ArrayList<Ammunition> ammunitions;
  private int hitPoints = 1000;

  public Knight(String title, ArrayList<Ammunition> ammun,
                String name, int age) {
    super(name, age);
    this.title = title;
    this.ammunitions = ammun;
  }

  public String getTitle() {
    return title;
  }

  public ArrayList<Ammunition> getAmmunition() {
    return ammunitions;
  }

  public int getHitPoints() {
    return hitPoints;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAmmunition(ArrayList<Ammunition> ammu) {
    this.ammunitions = ammu;
  }

  public void setHitPoints(int hitPoints) {
    this.hitPoints = hitPoints;
  }

  public void sortAmmunitionsByCost() {
    Collections.sort(ammunitions, new Comparator() {
      public int compare(Object o1, Object o2) {
        Ammunition a1 = (Ammunition) o1;
        Ammunition a2 = (Ammunition) o2;
        if (a1.getCost() > a2.getCost()) {
          return 1;
        }
        if (a2.getCost() > a1.getCost()) {
          return -1;
        }
        return 0;
      }
    });
  }

  public void sortAmmunitionsByWeight() {
    Collections.sort(ammunitions, new Comparator() {
      public int compare(Object o1, Object o2) {
        Ammunition a1 = (Ammunition) o1;
        Ammunition a2 = (Ammunition) o2;
        if (a1.getWeight() > a2.getWeight()) {
          return 1;
        }
        if (a2.getWeight() > a1.getWeight()) {
          return -1;
        }
        return 0;
      }
    });
  }

  public ArrayList<Ammunition> findAmmunitionsByCost(int lLim, int rLim) {
    ArrayList<Ammunition> needed = new ArrayList<>();
    sortAmmunitionsByCost();
    int lIndex = bSearch(ammunitions, lLim, 0, ammunitions.size());
    int rIndex = bSearch(ammunitions, rLim, 0, ammunitions.size());
    if (lIndex < 0) {
      lIndex = -1 * (lIndex + 1);
    }
    if (rIndex < 0) {
      rIndex = -1 * (rIndex + 1);
    }
    for (int i = 0; i < ammunitions.size(); i++) {
      if (i >= lIndex && i < rIndex) {
        needed.add(ammunitions.get(i));
      }
    }
    return needed;
  }

  private static int bSearch(ArrayList<Ammunition> list, Integer key, int left, int right) {

    if (left >= right) {
      return -(left + 1);
    } else {
      int mid = (left + right) / 2;
      if (list.get(mid).getCost() == key) {
        int i = 1;
        while (true) {
          if (mid - i >= 0) {
            if (list.get(mid - i).getCost() == key) {
              mid--;
            } else {
              return mid;
            }
          } else {
            return mid;
          }
        }

      }
      if (list.get(mid).getCost() > key) {
        right = mid;
      } else {
        left = mid + 1;
      }
      return bSearch(list, key, left, right);
    }
  }

  public void giveTheNameOfTheSword(String swordName) {
    boolean flag = true;
    for (Ammunition ammunition : ammunitions) {
      if (ammunition instanceof Sword) {
        ((Sword) ammunition).setName(swordName);
        flag = false;
        break;
      }
    }
    if (flag) {
      System.out.println("Sir, You haven`t sword!");
    }
  }

  public boolean equals(Knight other) {
    return (this.getName() == other.getName()) &&
           (this.getTitle() == other.getTitle()) &&
           (this.getAge() == other.getAge()) &&
           (this.getAmmunition().equals(other.getAmmunition()));
  }

  @Override
  public String toString() {
    StringBuilder knightDescription = new StringBuilder(super.toString() + " Title: " + title
            + ". Hit points: " + hitPoints + ".");
    if (!ammunitions.isEmpty()) {
      knightDescription.append("\n" + "----------AMMUNITIONS----------");
      for (Ammunition ammunition : ammunitions) {
        knightDescription.append(new StringBuilder(ammunition.toString()));
      }
    }
    return new String(knightDescription);
  }
}
