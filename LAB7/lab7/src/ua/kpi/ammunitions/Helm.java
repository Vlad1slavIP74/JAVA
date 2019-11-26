package ua.kpi.ammunitions;

public class Helm extends Ammunition {

  private String name = "NoName";
  private final boolean closeHelm;
  private int canTakeDamage;
  private String size;

  public Helm(int canTakeDamage, String size, boolean closeHelm, int cost, int weight) {
    super(cost, weight);
    this.canTakeDamage = canTakeDamage;
    this.size = size;
    this.closeHelm = closeHelm;
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
    String helmType = closeHelm ? "close helm" : "open helm";

    return "\n" + "#Helm." + noname + "It`s a " + helmType + ". It can take "
            + canTakeDamage + " damage. Size: " + size + "." + super.toString();

  }
}
