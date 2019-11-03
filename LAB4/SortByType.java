package LAB4;

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class SortByType implements Comparator<SportEquipment> {
    public int compare (SportEquipment first, SportEquipment second) {
        int res = String.CASE_INSENSITIVE_ORDER.compare(second.type, first.type);
        if (res == 0) {
            res = second.type.compareTo(first.type);
        }
        return res;
    }
}