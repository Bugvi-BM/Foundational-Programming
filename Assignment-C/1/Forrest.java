import java.util.ArrayList;

/**
 * Obligatorisk Opgave C #1
 * A Forrest Class. Represents a forrest and simulates how it grows.
 * 
 * @author (Búgvi Magnussen)
 * @version 1.0
 */

public class Forrest {
    //all trees saved in an arraylist
    private ArrayList<Tree> trees;
    
    /**
     * Creates a new forrest.
     */
    public Forrest () {
        trees = new ArrayList<>();
        
    }
    
    /**
     * Puts 4 pre-determined trees in the forrest.
     */
    public void initialize() {
        trees.add(new Ash(4, 2));
        trees.add(new Ash(6, 3.4));
        trees.add(new Beech(2, 0.7));
        trees.add(new Beech(3, 1.1));
    }
    
    /**
     * simulates the growth of the forrest over a year.
     */
    public void growOneYear() {
        for(Tree tree : trees) {
            tree.growOneYear();
        }
    }
    
    /**
     * Prints information about all the trees in the forrest
     */
    public void show() {
        for(Tree tree : trees) {
            tree.show();
        }
    }
    
    /**
     * Simulates the growth of the forrest over n years.
     * @param select int n for how many years
     */
    public void growManyYears(int n) {
        for(int i = 1 ; i <= n ; i++) {
            for(Tree tree : trees) {
                tree.growOneYear();
            }
        }
    }
}