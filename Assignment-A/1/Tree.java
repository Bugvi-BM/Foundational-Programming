/*Búgvi Magnussen
 * buma@itu.dk
 */

//Opgave 1A

//Class declaration
public class Tree {
    
    //fields 
    //Field variables have an underscore in their names to help differentiate
    
    private int _age; 
    private double _height;
    private double _growthPrct;
    private boolean _alive;
    
    //Constructor
    //Creates a Tree object
    public Tree(double growthPrct) {
        _age = 1;
        _height = 0.25;
        _growthPrct = growthPrct;
        _alive = true;
    }
    
    //Method 1
    /*This method checks the boolean variable _alive is true, if yes the age variable
     * is incremented by 1. Further, if the _height variable is less than or equal to 20, 
     * the _height variable is incremented by the growth percent.
     * This method has no return value. 
     */
    public void growOneYear() {
        
        if (_alive) {
            _age = _age + 1; 
        
            if (_height <= 20) {
                _height = _height * (1 + _growthPrct/100);
            }
            
            if (_age > 120) {
                _alive = false;
            }
        }
    }
    
    //Method 2
    /*This method checks if the boolean variable _alive is true. If yes, the system prints out the appropriate
     * statements. Otherwise it prints out another statement. 
     * This method has no return value.
     */
    public void show() {
        
        if (_alive) {
            System.out.println("alder = " + _age + "år");
            System.out.println("højde = " + _height + "meter");
        } else {
            System.out.println("Træet er dædt");
        }
    }
}
   