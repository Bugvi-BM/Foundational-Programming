import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * En GUI klasse. Denne klasse laver et GUI objekt der fungere som programmets graphical user interface.
 * @author Búgvi Magnussen
 * @version 2.0
 * @date 8/11/2016
 */
public class GUI {

    private JFrame frame;
    private int[] numbers;
    private String[] labels;
    private int[] modifiedNumbers;
    private String[] modifiedLabels;
    
    /**
     * Laver et GUI objekt. 
     * @param int[], String[]
     * 
     */
    public GUI(int[] numbers, String[] labels) {
        makeFrame();
        makeMenu();
        this.numbers = numbers;
        this.labels = labels;
        SwingUtilities.updateComponentTreeUI(frame);
    }
    
    /**
     * Laver en frame. Anvendes af konstruktoren. 
     */
    private void makeFrame() {

        frame = new JFrame("Histogram");
        frame.setPreferredSize(new Dimension(1300,800));
        Container contentPane = frame.getContentPane();

        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Laver menuen i graphical user interface og giver alle knapperne funktionalitet.
     */
    private void makeMenu() {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);

        JMenuItem histogramItem = new JMenuItem("Draw new histogram");
        histogramItem.addActionListener( 
            (ActionEvent e) -> { 

                try{
                    frame.getContentPane().removeAll();
                    int n = setColorMode();
                    Histogram h = new Histogram(numbers,labels,n);
                    frame.getContentPane().add(h);
                    SwingUtilities.updateComponentTreeUI(frame);
                } catch (InputsNotMatchingException ex) {
                    System.out.println(ex.getMessage());
                    infoBox(ex.getMessage(), "InputsNotMatchingException", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                } catch (ListTooLongException ex) {
                    System.out.println(ex.getMessage());
                    infoBox(ex.getMessage(), "ListTooLongException", JOptionPane.ERROR_MESSAGE);
                    modifiedNumbers = ex.getModifiedNumbers();
                    modifiedLabels = ex.getModifiedLabels();


                    retry(); 

                    //Fix this catch
                }

            }
        );
        fileMenu.add(histogramItem);

        JMenuItem infoItem = new JMenuItem("Info");
        infoItem.addActionListener(
            (ActionEvent e) -> {
                infoBox("This Program was created by Búgvi Magnussen." + "\n" + 
                    "The main purpose of this program is to draw a histogram." + "\n", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        );
        fileMenu.add(infoItem);

        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(
            (ActionEvent e) -> {
                System.exit(1);

            }
        );
        fileMenu.add(quitItem);

        JMenu helpMenu = new JMenu("Help");
        menubar.add(helpMenu);

        JMenuItem helpItem = new JMenuItem("Show help");
        helpItem.addActionListener(
            (ActionEvent e) -> {
                infoBox("Press 'File' and then 'Draw new histogram' to draw a histogram." + "\n" + 
                    "Press 'File' and then 'Info' for information about this program. " + "\n" +
                    "Press 'File' and then 'Quit' in order to quit the program.", "Help", JOptionPane.INFORMATION_MESSAGE);
            }
        );
        helpMenu.add(helpItem);

        JMenuItem coffeeItem = new JMenuItem("Coffee Please");
        coffeeItem.addActionListener(
            (ActionEvent e) -> {
                int n = coffee();

                if(n==0) {
                    infoBox("I am a program. I can't make coffee. Why are you even asking?", "Coffee", JOptionPane.QUESTION_MESSAGE);
                }

                if(n==1) {
                    infoBox("If you don't drink coffee, how are you ever going to be a good programmer?", "Coffee", JOptionPane.QUESTION_MESSAGE);
                }

            }
        );
        helpMenu.add(coffeeItem);

    }
    
    /**
     * Anvendes af makeMenu metoden. Laver et information popupvindue.
     * @param String infoMessage, String titleBar, int type
     * 
     */
    private static void infoBox(String infoMessage, String titleBar, int type)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Histogram: " + titleBar, type);
    }
    
    /**
     * En metode der laver et popupvindue hvor man kan vælge histogram farve mode. 
     * @return int
     */
    private int setColorMode() {

        Object[] options = {"Color mode", "Black/white mode"};

        int n = JOptionPane.showOptionDialog(null,
                "Please select color mode ",
                "Select mode",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);

        return n;
    }
    
    /**
     * En kaffe metode
     * @return int
     */
    private int coffee() {
        Object[] options = {"Yes, please", "No thanks"};
        int n = JOptionPane.showOptionDialog(null,"Do you want some coffee?", "Coffee?", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, null);

        return n;
    }
    
    /**
     * En metode der kaldes når der sker en fejl og programmet skal prøve igen at danne et histogram.
     * 
     */
    public void retry() {
        try {
            frame.getContentPane().removeAll();
            int n = setColorMode();
            Histogram h = new Histogram(modifiedNumbers,modifiedLabels,n);
            frame.getContentPane().add(h);
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception exc) {

            System.exit(1);
        }
    }
}
