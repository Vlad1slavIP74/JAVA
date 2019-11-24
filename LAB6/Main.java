package LAB6;

import java.util.*; 
import java.lang.*; 
import java.io.*; 

public class Main {
    public static void main(String[] args) {
     Main task1 = new Main();
     BasicCoffee[] basicCoffee = task1.create();
     System.out.println("\nBefore");
     for (int i=0; i < basicCoffee.length; i++) 
        System.out.println(basicCoffee[i]);
    
    task1.sort(basicCoffee);
    System.out.println("\nAfter");
    for (int i=0; i < basicCoffee.length; i++) 
        System.out.println(basicCoffee[i]);

    }
    /** Method create 
     * @param null
     * @return {BasicCoffee[]}
     */
    public BasicCoffee[] create() {
        // weight, state, price, count
        GroundCoffee groundCoffee = new GroundCoffee(4, "GroundCoffee", 4f, 5);
        GrainCoffee grainCoffee = new GrainCoffee(3, "GrainCoffee", 300f, 2); 
        InstantCoffee instantCoffee = new InstantCoffee (5, "InstantCoffee", 1f, 12);
        return new BasicCoffee[] {groundCoffee, grainCoffee, instantCoffee};
    }
    /** Method sort  
     * @param BasicCoffee[] basicCoffee
     * @return {null}
     */
    public void sort(BasicCoffee[] basicCoffee) {
        Arrays.sort(basicCoffee, new SortCoffeeByPriseWeight());
    }
} 