
/**
 * A demo class. 
 * @author Búgvi Magnussen
 * @date 24/11/2016
 */
public class Demo {
    public static void main(String[] args) {
        Dealer d = new Dealer("Billige Biler"); 
        Car c1 = new Car("Ragnar", "ABC-123"); 
        Car c2 = new Car("Rollo", "UVW-456"); 
        Car c3 = new Car("Floki", "XYZ-789"); 
        d.addCar(c1);
        d.addCar(c2);
        d.addCar(c3);
        d.show();
        c1.setPrice(10000); c3.setPrice(30000); d.showPriced(); System.out.println(d.total()); Car[] cars = d.toArray();
        for (int i=0; i<cars.length; i++) {
            System.out.println(cars[i]);
        }
    } 
}