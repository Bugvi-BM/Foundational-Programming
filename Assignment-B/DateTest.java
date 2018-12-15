
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

/**
 * The test class DateTest.
 *
 * @author  (Búgvi Magnussen)
 * @version (25/10/2016)
 */
public class DateTest
{
    /**
     * Default constructor for test class DateTest
     */
    public DateTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testTue20181002()
    {
        Date date1 = new Date(2018, 10, 02);
        assertEquals(1, date1.weekDay());
    }

    @Test
    public void test20180101()
    {
        Date date1 = new Date(2018, 1, 1);
        assertEquals(0, date1.weekDay());
        assertEquals(1, date1.weekNumber());
        assertEquals(1, date1.dayInYear());
        assertEquals(false, date1.isLeapyear());
    }

    @Test
    public void testYearEnd() {
        for(int i = 1582 ; i <= 2500 ; i++) {
            Date date1 = new Date(i, 12, 31);
            Date date2 = new Date(i+1, 1, 1);
            assertEquals(1, date1.daysTill(date2));
        }
    }

    @Test
    public void test20181231()
    {
        Date date1 = new Date(2018, 12, 31);
        assertEquals(0, date1.weekDay());
        assertEquals(53, date1.weekNumber());
        assertEquals(365, date1.dayInYear());
    }

    @Test
    public void testDaynumbers() {
        Date date1 = new Date(2018, 1, 31);
        assertEquals(31, date1.dayInYear());
        Date date2 = new Date(2018, 2, 1);
        assertEquals(32, date2.dayInYear());
        Date date3 = new Date(2018, 2, 28);
        assertEquals(59, date3.dayInYear());
        Date date4 = new Date(2018, 3, 1);
        assertEquals(60, date4.dayInYear());
        Date date5 = new Date(2018, 12, 1);
        assertEquals(335, date5.dayInYear());
        Date date6 = new Date(2018, 12, 31);
        assertEquals(365, date6.dayInYear());
    }

    @Test 
    public void testYearLength() {
        for(int i = 1582 ; i <= 2500 ; i++) {
            Date date1 = new Date(i, 1, 1);
            Date date2 = new Date(i, 12, 31);
            if(date1.isLeapyear()) {
                assertEquals(365, date1.daysTill(date2));
            } else {
                assertEquals(364, date1.daysTill(date2));
            }

        }
    }

    @Test
    public void testFebMar() {
        for(int i = 1582 ; i <= 2500 ; i++) {
            Date date1 = new Date(i, 2, 28);
            Date date2 = new Date(i, 3, 1);
            if(date1.isLeapyear()) {
                assertEquals(2, date1.daysTill(date2));
            } else {
                assertEquals(1, date1.daysTill(date2));
            }
        }
    }

    @Test
    /*
     * Denne test tester for urimelige datoer. Jeg har forsøgt at få den til at danne en masse
     * Date objekter, der ikke burde kunne eksistere. Testen påviser, at Date klassen ikke har nogon checks
     * når den danner Date objekter. 
     */
    public void testOutOfBounds() {
        Random random = new Random();
        int maxDaysLeft = 365;
        for(int i = 0 ; i <= 10000 ; i++) {
            Date date1 = new Date(1995, random.nextInt(), random.nextInt());
            Date date2 = new Date(1995, 12, 31);
            int days = date1.daysTill(date2);
            assertFalse(maxDaysLeft >= days);
        }
    }
    
    /*
     * Da det er muligt at danne datoer der ikke burde eksistere, forsvinder tilliden til programmet.
     * Flere tests kunne foretages, som for eksempel om leapyear altid bliver udregnet rigtigt
     * og om uge dagen altid er talt. 
     *
     * Før jeg ville vædde 210 kr på at klassen virker korrekt skulle der:
     * 1. Implementeres nogle checks for at sikkre at alle datoer er "lovlige".
     * 2. Laves flere tests hvor alle funktioner blev testet. 
     * For eksempel denne:
     */
    @Test
    public void testNextDate() {
        Date date1 = new Date(2004, 9, 29);
        Date date2 = new Date(2004, 9, 30);
        Date date3 = date1.next();
        
        assertEquals(date2, date3);
    }
    //Vi er nu stødt på endnu en fejl. 
    
    @Test
    /**
     * Tester hvor lang tid det tager at anvende dayInYear metoden 3000 gange.
     */
    public void testdayInYear() {
        Date date1 = new Date(2000, 12, 31);
        for(int i = 0 ; i <= 100000 ; i++) {
            date1.dayInYear();
        }
    }
    
    @Test
    /**
     * Tester hvor lang tid det tager at anvende dayInYearNew metoden 3000 gange.
     */
    public void testdayInYearNew() {
        Date date1 = new Date(2000, 12, 31);
        for(int i = 0 ; i <= 100000 ; i++) {
            date1.dayInYearNew();
        }
    }
    }


