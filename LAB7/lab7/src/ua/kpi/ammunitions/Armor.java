package ua.kpi.ammunitions;

public class Armor extends Ammunition {

  private String name = "NoName";
  private final boolean ceremonial;
  private int canTakeDamage;
  private String size;

  public Armor(int canTakeDamage, String size, boolean ceremonial, int cost, int weight) {
    super(cost, weight);
    this.canTakeDamage = canTakeDamage;
    this.size = size;
    this.ceremonial = ceremonial;
  }

  public String getName() {
    return name;
  }

  public int getCanTakeDamage() {
    return canTakeDamage;
  }

  public String getSize() {
    return size;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCanTakeDamage(int canTakeDamage) {
    this.canTakeDamage = canTakeDamage;
  }

  public void setSize(String size) {
    this.size = size;
  }

  @Override
  public String toString() {
    String noname = "";
    if (!name.equals("NoName")) {
      noname = "Name: " + name + ". ";
    }
    String armorType = ceremonial ? "ceremonial" : "normal";
    return "\n" + "#Armor." + noname + "It`s a " + armorType + ". It can take " + canTakeDamage
            + " damage. Size: " + size + ". " + super.toString();

  }
}
