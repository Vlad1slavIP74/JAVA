package ua.kpi.ammunitions;

public abstract class Ammunition {

  private int cost;
  private int weight;

  public Ammunition(int cost, int weight) {
    this.cost = cost;
    this.weight = weight;
  }

  public int getCost() {
    return cost;
  }

  public int getWeight() {
    return weight;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Cost: " + cost + ". Weight: " + weight + ".";
  }
}
