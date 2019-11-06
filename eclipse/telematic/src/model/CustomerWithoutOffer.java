/*
 * UserWithoutOffer.java        1.1 24/09/2013
 *   
 * Copyright 2011-2013 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

package model;

/**
 * This class modelizes users with no offers.
 * 
 * @author Mònica Ramírez Arceda
 * @version 1.0 24/09/2013
 */
public class CustomerWithoutOffer extends Customer {

	/**
	 * UserWithoutOffer constructor.
	 * 
	 * @param name        the user name
	 * @param dni         the user dni
	 * @param priceMinute the price per minute this user will pay for his/her
	 *                    connections
	 */
	public CustomerWithoutOffer(String name, String dni, double priceMinute) {
		super(name, dni, priceMinute);
	}

	/**
	 * Calculates the bill amount. Users without offers pay the total of minutes by
	 * the price per minute.
	 * 
	 * @return the bill amount
	 */
	@Override
	public double billAmount() {
		return this.totalMinutes() * this.priceMinute;
	}

}
