/**
 * This class represents a car. It holds information about individual cars 
 * and can return information about the car and set the price of the car.
 * @author Búgvi Magnussen
 * @date 24/11/2016
 */
public class Car {
    
    private String owner;
    private String plate;
    private int price;
    
    /**
     * Constructs a car object. 
     * @param String owner and String plate
     * Price is initialised at 0.
     */
    public Car(String owner, String plate) {
        this.owner = owner;
        this.plate = plate;
        price = 0;
    }
    
    /**
     * Returns the price of the car. 
     */
    public int getPrice() {
        return price;
    }
    
    /**
     * Sets the price of the car. Throws an unchecked exception if the price is negative.
     * @param int price
     * @throws IllegalPriceException
     */
    public void setPrice(int price) {

        try{
            if(price >= 0) {
                this.price=price; 
            } else {
                throw new IllegalPriceException("Please Insert a valid price");
            }
        } catch(IllegalPriceException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Returns a String representation of the car. 
     * Format: owner's car #plate: price DKK.
     */
    public String toString() {
        return owner + "'s car #" + plate + ": " + price +" DKK";
        
    }
    
}