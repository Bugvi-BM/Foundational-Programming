/**
 * A Tree class. Represents a tree.
 * @author (Búgvi Magnussen)
 * @version 1.0
 */

public class Tree {
    //a trees characteristics
    public int age;
    public double height;
    
    /**
     * Simulate the growth of a tree over a year.
     */
    public void growOneYear() {
        age++;
    }
    
    /**
     * Prints details about a tree. 
     */
    public void show() {
        System.out.println("Age: " + age + "\n" + "Height: " + height);
    }
}