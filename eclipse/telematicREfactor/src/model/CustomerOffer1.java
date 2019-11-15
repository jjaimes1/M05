/*
 * UserOffer1.java        1.1 24/09/2013
 *   
 * Copyright 2011-2013 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

package model;

/**
 * Describes a company user that has offer 1.
 * 
 * @author Mònica Ramírez Arceda
 * @version 1.0 24/09/2013
 */
public class CustomerOffer1 extends CustomerWithOffer {

	/**
	 * UserOffer1 constructor.
	 * 
	 * @param name        the user name
	 * @param dni         the user dni
	 * @param priceMinute the price per minute this user will pay for his/her
	 *                    connections
	 */
	public CustomerOffer1(String name, String dni, double priceMinute) {
		super(name, dni, priceMinute);
	}

	/**
	 * Calculates the bill amount. Users with offer 1 pay the total of minutes by
	 * the price per minute minus a discount, but the 3 first minutes are free.
	 * 
	 * @return the bill amount
	 */
	@Override
	public double billAmount() {
		double minutes2invoice = 0;
		for (Connection c : this.connections) {
			double minutes = c.nMinutes();
			if (minutes > 3) {
				minutes2invoice += minutes - 3;
			}
		}
		return minutes2invoice * this.priceMinute;
	}

}
