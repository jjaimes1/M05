/*
 * UserOffer2.java        1.1 24/09/2013
 *   
 * Copyright 2011-2013 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

package model;

/**
 * Describes a company user that has offer 2.
 * 
 * @author Mònica Ramírez Arceda
 * @version 1.0 24/09/2013
 */
public class CustomerOffer2 extends CustomerWithOffer {

	/** Discount applied to the user */
	private double discount;

	/**
	 * 
	 * UserOffer2 constructor.
	 * 
	 * @param name        the user name
	 * @param dni         the user dni
	 * @param priceMinute the price per minute this user will pay for his/her
	 *                    connections
	 * @param discount    the discount applied to this user
	 */
	public CustomerOffer2(String name, String dni, double priceMinute, double discount) {
		super(name, dni, priceMinute);
		this.discount = discount;
	}

	/**
	 * Calculates the bill amount. Users with offer 2 pay the total of minutes by
	 * the price per minute minus a discount.
	 * 
	 * @return the bill amount
	 */
	@Override
	public double billAmount() {
		double amountWithoutDiscount = this.totalMinutes() * this.priceMinute;
		double amountWithDiscount = amountWithoutDiscount * (1 - this.discount / 100);
		return amountWithDiscount;
	}
}
