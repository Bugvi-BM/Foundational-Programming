/**
 * Ash class. Represents an Ash tree.
 * A subclass of Tree
 * @Author (Búgvi Magnussen)
 */

public class Ash extends Tree {

    /**
     * Creates an Ash tree
     */
    public Ash () {
        age = 1;
        height = 1.0;

    }
    
    /**
     * Creates an Ash tree with a specified age and height
     * @param select int age and double height
     */
    public Ash (int age, double height) {
        this.age = age;
        this.height = height;
        
    }
    
    /**
     * Simulates the growth of a Ash tree over a year. Height increases as long as height < 15
     */
    public void growOneYear() {
        super.growOneYear();
        if(height < 15) {
            height *= 1.20;
        }
        
    }
    
    /**
     * Prints the details about an Ash tree
     */
    public void show() {
        System.out.println("Ask:");
        super.show();
    }
}