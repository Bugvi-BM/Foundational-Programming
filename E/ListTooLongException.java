/**
 * Denne Exception class bærer to arrays og forkorter dem. Den vil blive aktiveret i så fald, 
 * at inputs fra brugeren medfører et eller to arrays der er har flere end 15 elementer. 
 * @author Búgvi Magnussen
 * @version 2.0
 * @date 8/11/2016
 * 
 */
public class ListTooLongException extends Exception {
    
    private String message;
    private int[] numbers;
    private String[] labels;
    private int[] modNumbers;
    private String[] modLabels;

    /**
     * Tager imod to arrays der er for lange, og laver to nye arrays ud af de første 15 elementer i de orginale arrays. 
     * @param String message, int[] numbers, String[] labels
     * 
     */
    
    public ListTooLongException(String message, int[] numbers, String[] labels) {
        this.message = message;
        this.numbers = numbers;
        this.labels = labels;

        modNumbers = new int[15];
        modLabels = new String[15];
        for(int i = 0 ; i < Histogram.maxCollums ; i++) {
            modNumbers[i] = numbers[i];
            
            
        }

        for(int i = 0 ; i < Histogram.maxCollums ; i++) {
            modLabels[i] = labels[i];
            
            
        }

    }
    
    /**
     * Returnerer det nye kortere numbers array.
     * @return int[]
     */
    public int[] getModifiedNumbers() {

        return modNumbers;
    }
    
    /**
     * Returnerer det nye kortere labels array.
     * @return String[]
     */
        public String[] getModifiedLabels() {

        return modLabels;
    }
    
    /**
     * Returnerer exception beskeden
     * @return String
     */
    public String getMessage() {
        return message;
    }
    

}
