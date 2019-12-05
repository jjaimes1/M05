package leapYears;

/*
 * Program.java        1.0 13/10/2011
 *
 * Modelizes the program.
 *
 * Copyright 2011 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 *                Joaquim Laplana Tarragona <jlaplana@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class Program {

    /**
     * Determines if a year is a leap year.
     * 
     * @param year a year.
     * @return true if -year- is a leap year, false otherwise.
     */
    public boolean isLeapYear(int year) {
        boolean isALeapYear = year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
        return isALeapYear;
    }

}
