
/**
 * An unchecked exception for handling when the price set for a car is negative. 
 */
public class IllegalPriceException extends RuntimeException {
    
    private String message;
    
    /**
     * Constructs the exception.
     * @param String message
     */
    public IllegalPriceException(String message) {
        this.message = message;
        
    }
    
    /**
     * Returns the exception message
     * @return String message
     */
    public String getMessage() {
        return message;
    }
}