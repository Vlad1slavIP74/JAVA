
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
