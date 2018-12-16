/**
 * Denne klasse er en exception der kastes når der ikke er lige mange elementer i de to input arrays.
 * 
 * @author Búgvi Magnussen
 * @version 2.0
 * @date 8/11/2016
 */


public class InputsNotMatchingException extends Exception {
    
    String message;
    
    /**
     * Laver en Inputs not matching exception med en message. 
     */
    public InputsNotMatchingException(String message) {
        this.message = message;
        
    }
    /**
     * returnere message
     * @return String message
     */
    public String getMessage() {
        return message;
    }
}