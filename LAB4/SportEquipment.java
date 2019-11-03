package LAB4;


class SportEquipment {
    String type;
    Integer price;
    Integer count;
    String appointment;
    String material;

    SportEquipment(String type, Integer price, Integer count, String appointment, String material) {
        this.type = type;
        this.price = price;
        this.count = count;
        this.appointment = appointment;
        this.material = material;
    }
    public String toString() {
        return this.type + " " +  this.price +
         " " +  this.appointment + " " + this.material + " " + this.count;
    }
}