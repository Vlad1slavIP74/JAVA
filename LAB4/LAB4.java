
package LAB4;

import java.util.*; 
import java.lang.*; 
import java.io.*; 


public class LAB4 {
    public static void main(String[] args) {
    LAB4 task1 = new LAB4();
    SportEquipment[] sportEquipmentArr = task1.create();

    for (int i=0; i<sportEquipmentArr.length; i++) 
            System.out.println(sportEquipmentArr[i]);
    
    System.out.println("\nSorted by price");
    
    Arrays.sort(sportEquipmentArr, new SortByPrice());
    for (int i=0; i<sportEquipmentArr.length; i++) 
            System.out.println(sportEquipmentArr[i]);
    Arrays.sort(sportEquipmentArr, new SortByType());
    System.out.println("\nSorted by type");
    for (int i=0; i<sportEquipmentArr.length; i++) 
            System.out.println(sportEquipmentArr[i]);
    }

    public SportEquipment[] create() {
        SportEquipment football = new SportEquipment("football", 1000, 600, "protection", "plastic");
        SportEquipment basketball = new SportEquipment("basketball", 100, 400, "protection", "tissue");
        SportEquipment swimming = new SportEquipment("basketball", 500, 200, "protection", "tissue");

        return new SportEquipment[] {football, basketball, swimming};
    }

    public void sort(SportEquipment[] sportEquipment) {
        Arrays.sort(sportEquipment, new SortByPrice());
    }
}

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

class SortByPrice implements Comparator<SportEquipment> {
    public int compare (SportEquipment first, SportEquipment second) {
        return  second.price - first.price;
    }
}
// case insensitive order
class SortByType implements Comparator<SportEquipment> {
    public int compare (SportEquipment first, SportEquipment second) {
        int res = String.CASE_INSENSITIVE_ORDER.compare(second.type, first.type);
        if (res == 0) {
            res = second.type.compareTo(first.type);
        }
        return res;
    }
}