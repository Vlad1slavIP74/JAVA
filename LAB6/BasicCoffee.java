package LAB6;

public class BasicCoffee {
    Float weight;
    String state;
    Float price;
    Integer count;

    public BasicCoffee(float weight, String state, float price, int count) {
        this.weight = weight;
        this.state = state;
        this.price = price;
        this.count = count;
    }

    public float SortCoffee() {
        float coefficient = this.price / this.weight;
        return coefficient;
    }
    public String toString() {
        return this.weight + " " +  this.state +
         " " +  this.price + " " + this.count;
   
    }
}