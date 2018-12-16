/**
 * A Tree class.
 * Simulates a tree and how it grows.
 * @author (Búgvi Magnussen)
 * @version 1.0
 * 
 */

public class Tree {
    
    //attributes of a tree
    public int age;
    public double height;
    
    /**
     * Constructs a tree object. 
     * Age starts at 1.
     */
    public Tree() {
        age = 1;
    }
    
    /**
     *Simulates the growth of the tree over a year by increasing age by 1.
     */
    public void growOneYear() {
        age++;
    }
    
    /**
     * Prints out details about a tree.
     */
    public void show() {
        System.out.println("Age: " + age + "\n" + "Height: " + height);
    }
    
    /**
     * Returns the height of the tree.
     * @return double height
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * Returns the age of the tree.
     * @return int age
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Calculates how much shadow a tree is in and returns a shadowfactor. 
     * @param int i, int j, NewForest forest used to select a tree in a forrest
     * @return double shadowfactor
     * 
     */
    public double shadow(int i, int j, NewForest forest) {
        int k = 0;

        if(checkForTree(i,j,forest)) {
            double focusTreeHeight = forest.getTree(i,j).getHeight();

            if(checkForTree(i-1,j,forest) && forest.getTree(i-1,j).getHeight() > focusTreeHeight) {
                k++;
            }
            if(checkForTree(i+1,j,forest) && forest.getTree(i+1,j).getHeight() > focusTreeHeight) {
                k++;
            }
            if(checkForTree(i,j-1,forest) && forest.getTree(i,j-1).getHeight() > focusTreeHeight) {
                k++;
            }
            if(checkForTree(i,j+1,forest) && forest.getTree(i,j+1).getHeight() > focusTreeHeight) {
                k++;
            }
        }
        return k/10.0;
    }    
    
    /**
     * Checks if a selected location is within a forrests dimensions. 
     * @param inte i, int j, NewForest forest used to select a tree in a forrest
     * @return true if tree exists
     */
    public boolean checkForTree(int i, int j, NewForest forest) {
        if(i >= 0 && i <= forest.getDimensions()) {
            if(j >= 0 && j <= forest.getDimensions()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Simulates the growth of a tree over a year, taking into account how shadow affects the growth.
     * @param int i, int j, NewForest forest used to select a tree in a forrest
     */
    public void growOneYear(int i, int j, NewForest forest) {
        
        //Har brugt relativ højdetilvækst istedet for absolut, da det ikke var specificeret.
        if(this.checkForTree(i,j,forest)) {
            double oldHeight = this.getHeight();
            this.growOneYear();
            double newHeight = this.getHeight();
            double growthPrct = Math.pow(newHeight/oldHeight,1/1-0);
            double shadowFactor = this.shadow(i,j,forest);
            height = newHeight - shadowFactor*growthPrct;
        }
    }
}

