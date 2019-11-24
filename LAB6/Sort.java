package LAB6;

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class SortCoffeeByPriseWeight implements Comparator<BasicCoffee> {
    public int compare (BasicCoffee first, BasicCoffee second) {
        return (int)second.SortCoffee() - (int)first.SortCoffee();
    }
}