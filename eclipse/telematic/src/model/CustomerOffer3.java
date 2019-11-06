/*
 * UserOffer3.java        1.1 24/09/2013
 *   
 * Copyright 2011-2013 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

package model;

/**
 * Describes a company user that has offer 3.
 * 
 * @author Mònica Ramírez Arceda
 * @version 1.1 24/09/2013
 */
public class CustomerOffer3 extends CustomerWithOffer {

	/**
	 * UserOffer3 constructor.
	 * 
	 * @param name        the user's name
	 * @param dni         the user's dni
	 * @param priceMinute the price per minute this user will pay for his/her
	 *                    connections
	 */
	public CustomerOffer3(String name, String dni, double priceMinute) {
		super(name, dni, priceMinute);
	}

	/**
	 * Calculates the bill amount. Users with offer 3 pay the total of minutes by
	 * the price per minute minus a discount, but the longest connection is free.
	 * 
	 * @return the bill amount
	 */
	@Override
	public double billAmount() {
		double minutesLongestConection = 0;
		for (Connection c : connections) {
			double minutes = c.nMinutes();
			if (minutes > minutesLongestConection) {
				minutesLongestConection = minutes;
			}
		}
		return totalMinutes() * priceMinute - minutesLongestConection * priceMinute;
	}

}
