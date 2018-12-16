import java.util.*;

/**
 * This class represents a Dealer. The dealer stores a collection of 
 * cars and can show various information about them.
 * @author Búgvi Magnussen
 * @date 24/11/2016
 */
public class Dealer {
    
    private String name;
    private List<Car> cars;
    
    /**
     * Constructs a Dealer object.
     * @param String name
     */
    public Dealer(String name) {
        this.name = name; 
        cars = new ArrayList<>();
    }
    
    /**
     * Adds a car to the car collection. 
     * @param Car car
     */
    public void addCar(Car car) {
        cars.add(car);
    }
    
    /**
     * Shows information about all the current cars in the collection, by printing to the terminal.
     */
    public void show() {
        System.out.println("*** " + name + " ***");
        for(Car c : cars) {
            System.out.println(c);
        }
        System.out.println();
    }
    
    /**
     * Shows information about the cars in the collection that have been given a price. 
     */
    public void showPriced() {
        System.out.println("*** " + name + " ***");
        for(Car c : cars) {
            if(c.getPrice() != 0) {
                System.out.println(c);
            }
        }
        System.out.println();
    }
    
    /**
     * Returns the total price of all the cars in the collection.
     * @return int total.
     */
    public int total() {
        int total = 0;
   
        for(Car c : cars) {
            total += c.getPrice();
        }
        return total;	
    }
    
    /**
     * Converts the arraylist of cars into an array of cars and returns the array.
     * @return Car[] carArray
     * 
     */
    public Car[] toArray() {
        Car[] carArray = new Car[cars.size()];
        for(int i = 0 ; i < carArray.length ; i++) {
            carArray[i] = cars.get(i);
        }
        return carArray;
    }
}