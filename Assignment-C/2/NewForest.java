import java.util.Random;

/**
 * Obligatorisk Opgave C #2.
 * 
 * A NewForrest Class
 * This class represents a forrest of size nxn.
 * Further, it simulates how the trees in the forrest age and grow. 
 * 
 * @author (Búgvi Magnussen)
 * @version 1.0
 */

public class NewForest {
    
    
    //A two dimensional array represents the forest.
    //int n is the size of the array.
    //Random is used for generating trees in the forest.
    
    private Tree[][] trees;
    private int n;
    private Random random;

    
    /**
     * Constructs a forrest of size nxn, or 4x4 in this case. 
     * It contains 8 Ash trees and 8 beech trees of random ages and random heights.
     */
    public NewForest() {
        
        random = new Random();
        n = 4;
        trees = new Tree[n][n];

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(j % 2 == 0) {
                    trees[i][j] = new Ash(random.nextInt(10)+1, random.nextDouble()+random.nextInt(4));
                } else {
                    trees[i][j] = new Beech(random.nextInt(10)+1, random.nextDouble()+random.nextInt(4));
                }
            }

        }
    }
    
    /**
     * Prints information about a particular tree in the forest.
     * @Param int i, int j used for positioning in the forest.

     */
    public void printiInfo(int i, int j) {
        getTree(i,j).show();
        System.out.println("Position: " + i + " " + j);
    }
    
    /**
     * Prints information about all trees in the forrest.
     */
    public void printAllInfo() {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                getTree(i,j).show();
                System.out.println("Position: " + i + " " + j);
            }
        }
    }
    
    /**
     * Returns the dimensions of the forrest
     * @return the length of the arrays in NewForest
     */
    public int getDimensions() {
        return n;
    }
    
    /**
     * Returns a tree in the forrest if it is indeed in the forrest.
     * @param int i, int j select a position in the forrest.
     * @return the tree on position i,j
     */
    public Tree getTree(int i, int j) {

        if(trees[i][j].checkForTree(i,j,this)) {

            return trees[i][j];
        } else {
            return null;
        }
    }
    
    /**
     * Used to simulate a year of growth in the forrest, taking into account how shadow affects growth.
     */
    public void growOneYear() {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(getTree(i,j) != null) {
                    getTree(i,j).growOneYear(i,j,this);
                }
            }
        }
    }
}
