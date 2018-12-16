/**
 * A Beech class
 * A subclass of Tree. Represents a Beech tree.
 * @author (Búgvi Magnussen)
 * @version 1.0
 */

public class Beech extends Tree {
    
    /**
     * Creates a Beech tree object
     * initiates height at 0.5.
     */
    public Beech() {
        super();
        height = 0.5;
    }
    
    /**
     * Creates a Beech tree object with a chosen age and height
     * @param int age, double height
     */
    public Beech(int age, double height) {
        this.age = age;
        this.height = height;
    }
    
    /**
     * Simulates how a Beech tree grows over a year.
     * grows the height by a certain percentage if age < 65
     */
    public void growOneYear() {
        super.growOneYear();
        if(age < 65) {
            height *= 1.06;
        }
    }
    
    /**
     * Prints details about the Beech tree
     */
    public void show() {
        System.out.println("Bøg:");
        super.show();
    }
}