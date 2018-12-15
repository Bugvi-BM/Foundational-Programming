/*Búgvi Magnussen
 * buma@itu.dk
 */

// Opgave 2A

//Class Declaration
public class Quadratic {
    
    //fields
    //Field variables have an underscore in their names to help differentiate
    private double _a;
    private double _b;
    private double _c;
    
    //Constructor
    //Creates a Quadratic object with the parameters a,b,c.
    public Quadratic(double a, double b, double c) {
       
       _a = a;
       _b = b;
       _c = c;
       
    }

    /*Method 1
    *This method has no return value.
    *This method prints out the appropriate statement.
    */
    public void show() {
        
        System.out.println(_a + "x^2 + " + _b + "x + " + _c);
        
    }
    
    /*Method 2
     * This method returns a double value. 
     * This method solves the polynomial for given the parameter x. 
     */
    public double compute(double x) {
        
        return _a*Math.pow(x,2)+_b*x+_c;
        
    }
    
    /*Method 3
     * This method has no return value. 
     * This method solves the polynomial and finds out how many solutions there are
     */
    public void solve() {
        
        double d = Math.pow(_b,2)-4*_a*_c;
        double x1; 
        double x2;

        
        if (d < 0) {
            System.out.println("Der er ingen løsning");
            
        } else if (d == 0) {
            System.out.println("Der er en løsning");
            x1 = ((-_b)+Math.sqrt(d))/2*_a;
            System.out.println("rod1 = " + x1);
        
        } else {
            System.out.println("Der er to løsninger");
            x1 = ((-_b)+Math.sqrt(d))/2*_a;
            x2 = ((-_b)-Math.sqrt(d))/2*_a;
            System.out.println("rod1 = " + x1);
            System.out.println("rod2 = " + x2);
           
        }
        
    }
    
    /*Method 4
     * This method has no return value. 
     * This method checks if the field variable _a = 0. Further, it finds the solution.
     */
    public void superSolve() { 
        double x1;
        
        if (_a == 0) {
           x1 = -_c/_b;
           System.out.println("Vi har en førstegrad ligning med rod1 = " + x1);
        } else {
            solve();
       
        }
    }
    
    /*Method 5
     * This method has no return value.
     * This method checks if a=0 && b=0
     */
    public void robustSolve() { 
        double x1;
        
        if (_a == 0 && _b == 0) {
            System.out.println("Vi har en vandret linje og derfor ingen løsning");

        } else {
            superSolve();
            
        }
    }
}

