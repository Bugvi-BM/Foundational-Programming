/*Búgvi Magnussen
 * buma@itu.dk
 */

//Opgave 3A

//Class declaration
public class Tree
{
    
    //field variables
    //The field variables have an underscore in their name to help differentiate. 
    private int _age;
    private double _height;
    private double _growthPrct;
    private boolean _alive;
    
    //Constructor
    //Creates a tree object
    public Tree(double growthPrct)
    {
        _age = 1;
        _height = 0.25;
        _growthPrct = growthPrct;
        _alive = true;

    }
    
    //Method 1
    //This method has no return value.
    //This method checks with if statements if the Tree is alive, if the height is less than
    //or equal to 20 and if the age is less than 120. It then increments the variables appropriately.
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
    //This method has no return value. 
    //This method uses an if statement to evaluate what to print to the terminal window. 
    public void show() {
        
            if (_alive) {
                System.out.println("alder = " + _age + "år");
                System.out.println("højde = " + _height + "meter");
            } else {
                System.out.println("Træet er dødt");
            }
    }
    
    //Method 3
    //This method returns the height of a Tree object.
    public double getHeight() {
        return _height;
    }
}

   