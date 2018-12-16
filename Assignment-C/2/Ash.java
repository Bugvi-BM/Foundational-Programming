/**
 * Ash class
 * A subclass of Tree. Represents a Ash tree.
 * @Author (Búgvi Magnussen)
 */

public class Ash extends Tree {
    
    /**
     * Creates an Ash tree object
     * Calls the superclass constructor and initiates the height at 1.0
     */
    public Ash () {
        super();
        height = 1.0;

    }
    
    /**
     * Creates a Ash tree object with a chosen age and height
     * @param int age, double height
     */
    public Ash (int age, double height) {
        this.age = age;
        this.height = height;
        
    }
    
    /**
     * Simulates how a Ash tree grows over a year.
     * grows the height by a certain percentage if height < 15
     */
    public void growOneYear() {
        super.growOneYear();
        if(height < 15) {
            height *= 1.20;
        }
        
    }
    
    /**
     * Prints details about the Ash tree.
     */
    public void show() {
        System.out.println("Ask:");
        super.show();
    }
}