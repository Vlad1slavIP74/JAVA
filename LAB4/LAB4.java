package LAB4;

public class LAB4 {
    public static void main(String[] args) {
        SportEquipment football = new SportEquipment("football", 1000, 500);
        System.out.println(football.info()[0]);
    }
}

class SportEquipment {
    String type;
    Integer price;
    Integer count;

    SportEquipment(String type, Integer price, Integer count) {
        this.type = type;
        this.price = price;
        this.count = count;
    }
    public String[] info() {
        return new String[] {this.type, this.price.toString(), this.count.toString()};
    }
}