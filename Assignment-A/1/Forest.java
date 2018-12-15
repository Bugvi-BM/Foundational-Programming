/*Búgvi Magnussen
 * buma@itu.dk
 */

//Opgave 1A

//Class Declaration
public class Forest {
    
    //fields
    //Field variables have an underscore in their names to help differentiate
    //These variables are object type variables. 
    private Tree _tree1;
    private Tree _tree2;
    private Tree _tree3;
    
    //Constructor
    //Creates a Forest object.
    public Forest() {
        
        _tree1 = new Tree(10);
        _tree2 = new Tree(25);
        _tree3 = new Tree(40);
        
    }
    
    //Method 1
    //This method has no return value. 
    //This method calls the show method on all three trees in the Forest object.
    public void show() {
        
        _tree1.show();
        _tree2.show();
        _tree3.show();
        
    }
    
    //Method 2
    //This has no return value. 
    /*This method calls the grownOneYear method on all three trees in the forest object.
    *Further, it calls the Forest class' show method. 
    */
    public void growOneYear() {
        
        _tree1.growOneYear();
        _tree2.growOneYear();
        _tree3.growOneYear();
        
        this.show();
    }
}
