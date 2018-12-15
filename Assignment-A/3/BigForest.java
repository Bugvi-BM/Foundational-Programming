/*Búgvi Magnussen
 * buma@itu.dk
 */

//Opgave 3A

//Import class from library
import java.util.ArrayList;

//Class Delcaration
public class BigForest {
    
    //field variables
    //The field variables have an underscore in their names to help differentiate. 
    private ArrayList<Tree> _trees;
    
    //Constructor
    //Constructs an Arraylist object with the name _trees
    public BigForest() {
        
        _trees = new ArrayList<Tree>();
        
    }
    
    //Method 1
    //This method does not have a return value.
    //This method iterates over the collection _trees via a foreach loop, and calls the method show on each element.
    public void show() {
        
        for(Tree t : _trees) {
            t.show();
        }
    }
    
    
    //Method 2
    //This method has no return value.
    //This method iterates over the collection _trees via a foreach loop, and calls the method growOneYear on each element.
    public void growOneYear() {
        
        for(Tree t : _trees) {
        t.growOneYear();
        }
    }


    //Method 3
    //This method has no return value.
    //This method adds a Tree object to the _trees collection. 
    public void addTree(Tree t) {
        
        _trees.add(t);
    
    }
    
    
    //Method 4
    //This method has no return value.
    //This method calls the growOneYear method by the number of the parameter n, using a local variable x
    //and a while loop. 
    public void growManyYears(int n) {
        int x = 0;
        
        while (x <= n) {
            growOneYear();
            addTree(new Tree(10.0));
            x++;
        }

    }

    //Method 5
    //This method has double return type
    //This method calculates the average height of all the Tree objects in the _trees collection, 
    //using a foreach loop to iterate over the _trees collection. 
    public double averageHeight() {
        
        double totalHeight = 0.0;
        double averageHeight;
        
        for(Tree t : _trees) {
            
            totalHeight = totalHeight + t.getHeight();
            
        }
        averageHeight = totalHeight / _trees.size();
        return averageHeight;
    
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
