package dayPlus1;

/*
 * Program.java        1.0 25/10/2011
 *
 * Models the program.
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

	/**
	 * Determines the next day of a date. This method does NOT validate if input the
	 * date is correct.
	 * 
	 * @param d a day (an integer number between 1 and 31).
	 * @param m a month (an integer number between 1 and 12).
	 * @param y a year (an integer number between 1583 and 3000).
	 * @return the date plus one day, with the format "dd/mm/yyyy".
	 */
	public String dayPlus1(int d, int m, int y) {
		if (m == 4 || m == 6 || m == 9 || m == 11) {
			if (d < 30) { // If it's not the last day of the month, add 1 day
				d++;
			} else { // If it's the last day of the month, reset the day and add
				// 1
				// month
				d = 1;
				m++;
			}
		} else if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
			if (d < 31) // If it's not the last day of the month, add 1 day
				d++;
			else { // If it's the last day of the month, reset the day
				d = 1;
				if (m == 12) { // If it's the last month, reset the month and
					// add 1 year
					m = 1;
					y++;
				} else { // If it's not the last month, add 1 month
					m++;
				}
			}
			// If it's February and a leap year
		} else if (isLeapYear(y)) {
			if (d < 29) // If it's not the last day of the month, add 1 day
				d++;
			else { // If it's the last day of the month, reset the day and add 1
				// month
				d = 1;
				m++;
			}
		} else { // if it's February and not a leap year
			if (d < 28)// If it's not the last day of the month, add 1 day
				d++;
			else { // If it's the last day of the month, reset the day and add 1
				// month
				d = 1;
				m++;
			}
		}
		// Return the date plus one day
		return d + "/" + m + "/" + y;
	}
}
