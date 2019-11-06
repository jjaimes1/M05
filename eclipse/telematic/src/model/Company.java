/*
 * Company.java        1.1 24/09/2013
 *   
 * Copyright 2011-2013 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

package model;

import java.util.HashSet;

/**
 * Describes a telematic company.
 * 
 * @author Mònica Ramírez Arceda
 * @version 1.1 24/09/2013
 */
public class Company {

	/** Users of the company */
	private HashSet<Customer> users;

	/**
	 * Company constructor.
	 */
	public Company() {
		this.users = new HashSet<Customer>();
	}

	/**
	 * Add a user to the company.
	 * 
	 * @param u a user
	 * @return true if the user has been added, false otherwise
	 */
	public boolean add(Customer u) {
		return this.users.add(u);
	}

	/**
	 * List all users of the company. For each user the report details user's dni,
	 * name, number of connections, total of minutes, amount to be paid by the user,
	 * and what kind of offer he/she has.
	 */
	public void listUsers() {
		System.out.println("CLIENTS A FACTURAR");
		System.out.println("==================");
		System.out.printf("%-10s%-20s%-3s%8s%10s%7s\n", "DNI", "NOM", "CON", "MINS", "IMPORT", "OFERTA");
		for (Customer u : users) {
			System.out.printf("%-10s%-20s%3d%8.2f%10.2f", u.getDni(), u.getName(), u.getConnections().size(),
					u.totalMinutes(), u.billAmount());
			if (u instanceof CustomerOffer1) {
				System.out.printf("%5s", "1");
			} else if (u instanceof CustomerOffer2) {
				System.out.printf("%5s", "2");
			} else if (u instanceof CustomerOffer3) {
				System.out.printf("%5s", "3");
			}
			System.out.println("");
		}
	}
}
