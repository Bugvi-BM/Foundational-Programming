/**
 * A Beech class
 * A subclass of Tree. Simulates a Beech tree.
 * @Author (Búgvi Magnussen)
 */

public class Beech extends Tree {
    
    /**
     * Creates a Beech tree
     */
    public Beech() {
        age = 1;
        height = 0.5;
    }
    
    /**
     * Creates a Beech tree with specified age and height.
     * @param select int age and double height
     */
    public Beech(int age, double height) {
        this.age = age;
        this.height = height;
    }
    
    /**
     * Simulates the growth of a Beech tree over a year. Height increases as long as age < 65
     * @return void
     */
    public void growOneYear() {
        super.growOneYear();
        if(age < 65) {
            height *= 1.06;
        }
    }
    
    /**
     * Prints the details about an Ash tree
     * @return void
     */
    public void show() {
        System.out.println("Bøg:");
        super.show();
    }
}