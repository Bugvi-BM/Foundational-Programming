/**
 * A Date object represents a date in the Gregorian calendar, and allows 
 * calculation of 
 * weekday, distance between two dates, leap year, ISO week number 
 * and similar.  The Gregorian calendar was adopted by the Roman 
 * Catholic church in 1582, by Denmark and Norway in 1700, and by Great
 * Britain and its North American colonies in 1752.
 * 
 * @author Peter Sestoft
 * @version 2007-09-27
 */

public class Date {
    /** The year, such as 2007 */
    public final int year;
    /** The month, 1-12 */
    public final int month;
    /** The day within the month, 1-31 */
    public final int day;

    private static final int[] monthLength
    = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    /**
     * Construct a Date, such as new Date(1945, 12, 31)
     */
    public Date(int year, int month, int day) {
        this.year = year; this.month = month; this.day = day;
    }

    /**
     * The sequence number of the day, where 1 January year 1 is day number 0
     * 
     * @return     The day sequence number
     */
    public int dayNumber() {
        int previousYears = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
        return previousYears + dayInYearNew() - 1;
    }

    /**
     * The sequence number of the day within the year
     * 
     * @return     The day sequence number 1-366 within the year
     */
    public int dayInYear() {
        int number = day;
        for (int i=1; i<month; i++) {
            number += monthLength[i-1];
        }
        if (isLeapyear() && month >= 3) {
            number++;
        }
        return number;
    }

    public int dayInYearNew() {
        int m = (month+9)%12, janfeb = (isLeapyear() && month >= 3 ? 60 : 59);
        return (m/5 * 153 + m%5 * 30 + (m%5 + 1)/2 + janfeb) % 365 + day;
    }
    /*
     * Den nye dayInYear giver de samme resultater, når man kalder alle tests, som den gamle.
     * Forskellen er dog, at det er lidt hurtigere i gennemsnit at kalde dayInYearNew 100000 end
     * det er at kalde dayInYear 100000. Dog er det ikke særlig meget, men igennem tiden kan det 
     * blive til meget. 
     * I bund og grund ser den ud til at virke lige så godt som den gamle, men der skal flere tests til 
     * som jeg stadig ikke har lavet. Jeg vil mene at alle metoderne skulle testes godt igennem med brug
     * af dayInYearNew. 
     */
    
    
    /**
     * Does this date belong to a leap year?
     * 
     * @return     True if the date belongs to a leap year, otherwise false.
     */
    public boolean isLeapyear() {
        return (year%4 == 0 && year%100 != 0) || year%400 == 0;
    }

    /**
     * The number of days from this date to the given end date.
     * 
     * @param endDate The end date
     * @return     The number of days from this date to the given end date.
     *             Zero if the dates are identical.  Negative if endDate 
     *             precedes this date.
     */
    public int daysTill(Date endDate) {
        return endDate.dayNumber() - this.dayNumber();
    }

    /**
     * The weekday of this date
     * 
     * @return     The weekday as an integer 0, 1, ..., 6 where Monday=0
     */
    public int weekDay() {
        return this.dayNumber() % 7;
    }

    /**
     * The ISO week number of this date
     * 
     * @return     The ISO week number 0, 1, 2, ..., 52, 53 where week 1 is 
     *             the first week of the year that contains a Thursday;
     *             the days before that belong to week 52 or 53 of the 
     *             previous year, but we put them in week 0 for simplicity.
     */
    public int weekNumber() {
        return (dayInYearNew() - 1 - weekDay() + 3 + 7) / 7;
    }

    /** 
     * The date following this date (NB: current implementation is wrong)
     *
     * @return      A new Date object representing the date following the given one.
     *              For instance, if the given date is 2007-10-02 then a new 
     *              Date object
     *              representing 2007-10-03 is returned, if the given date is 
     *              2007-10-31 then 2007-11-01 is returned, and if the given 
     *              date is 2007-12-31 then 2008-01-01 is returned.
     */
    public Date next() {
        return new Date(1945, 12, 24);
    }

    /**
     * The date in ISO format
     * 
     * @return     The date in ISO format, such as "1945-12-31"
     */
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}