import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;

/**
 * En klasse der tegner et histogram objekt. 
 * @author Búgvi Magnussen
 * @version 2.0
 * @date 8/11/2016
 */
public class Histogram extends JComponent {

    private int[] numbers;
    private String[] labels;
    private int n;
    public static final int maxCollums = 15;

    /**
     * Laver et histogram objekt. Kaster en række exceptions i så fald at inputs ikke er acceptable. 
     * @param int[], String[], int n
     * @throws InputsNotMatchingException, ListTooLongException
     */
    public Histogram(int[] numbers, String[] labels, int n) throws InputsNotMatchingException, ListTooLongException {
        if(numbers.length != labels.length) {
            throw new InputsNotMatchingException("The List of numbers and the list of labels do not have an equal amount of elements."+ 
                "\n" +
                "Please restart 'Histogram' and try again with different inputs");
        }
        for(int i : numbers) {
            if(i < 0 || i > 100) {
                throw new InputsNotMatchingException("Numbers selected must be between 0 and 100." + 
                    "\n" +
                    "Please restart 'Histogram' and try again with different inputs");
            }
        }
        for(String s : labels) {
            if(s.length() == 0 || s.length() > 3) {
                throw new InputsNotMatchingException("Labels must be between 1 and 3 characters long." + 
                    "\n" +
                    "Please restart 'Histogram' and try again with different inputs");
            }
        }
        if(numbers.length > 15 || labels.length > 15) {
            throw new ListTooLongException("Too many elements in list of labels or list of numbers. Maximum number of elements is 15." +
                "\n" +
                "Only showing first 15 elements.", numbers, labels);

        }

        this.numbers = numbers;
        this.labels = labels;
        this.n = n;

    }
    /**
     * Tegner et kordinat system.
     */
    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.drawLine(200, 630, 200, 60);
        g.drawLine(201, 630, 201, 60);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 

        // draw values on y-axis
        int j = 180;
        int h = 640;
        for(int i = 0 ; i <= 100 ; i += 10) {
            if(i == 0) {    // draws the min value
                g.drawString(Integer.toString(i), j, h);
                g.drawLine(200, h-10, 210, h-10);                
                h -= 55;
                j -= 15;
            } else if (i != 100) {  // draws the values between min and max
                g.drawString(Integer.toString(i), j, h);
                g.drawLine(200, h-10, 210, h-10);
                h -= 55;
            } else if (i == 100) {   // draws the max value
                j -= 15;
                g.drawString(Integer.toString(i), j, h);
                g.drawLine(200, h-10, 210, h-10);
            }

        }

        g.drawLine(201, 630, 1001, 630);
        g.drawLine(201, 631, 1001, 631);

        insertValues(g);
    }

    /**
     * Denne metode bliver kaldt af paint metoden. 
     * Anvender inputs fra programmets to arrays og skalerer histogrammet. 
     */
    public void insertValues(Graphics g) {
        double cw = Math.floor(780/labels.length);
        int collumWidth = (int) cw - 40;

        //double hw = Math.ceil(columWidth/2);
        //int halfWidth = (int) hw;
        int halfWidth = (int) Math.ceil(collumWidth/2);

        int j = 221 + halfWidth;

        for(int i = 0 ; i < labels.length ; i++) {
            if(labels.length >= 10 && numbers.length >= 10) {
                g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 

                String s = labels[i];
                int sLength = (int) Math.round(s.length()*6.6);
                g.drawString(labels[i], j-sLength, 656);
                j += collumWidth + 40;
            } else {
                String s = labels[i];
                int sLength = s.length()*10;
                g.drawString(labels[i], j-sLength, 656);
                j += collumWidth + 40;
            }
        }
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 

        int col = 0;
        j = 221;
        int baseline = 630;
        for(int i = 0 ; i < labels.length ; i++) {

            double d = Math.ceil(numbers[i]*5.5);

            int difference = (int) d;
            if(n==0) {
                switch (col % 5) {
                    case 0:
                    g.setColor(Color.BLUE);
                    break;

                    case 1:
                    g.setColor(Color.GREEN);
                    break;

                    case 2:
                    g.setColor(Color.RED);
                    break;

                    case 3:
                    g.setColor(Color.YELLOW);
                    break;

                    case 4:
                    g.setColor(Color.MAGENTA);
                    break;

                }
            } 

            if(numbers[i] == 0) {
                g.fillRect(j, baseline-difference-1, collumWidth, difference);
                j += collumWidth+40;
                col++;
            } else {
                g.fillRect(j, baseline-difference-1, collumWidth, difference+1);
                j += collumWidth+40;
                col++;
            }
        }
        col = 0;
        g.setColor(Color.BLACK);
    }

}

