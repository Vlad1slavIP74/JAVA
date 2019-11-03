package LAB4;

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class SortByPrice implements Comparator<SportEquipment> {
    public int compare (SportEquipment first, SportEquipment second) {
        return  second.price - first.price;
    }
}