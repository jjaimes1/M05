/*
 * TelematicTest.java        1.1 24/09/2013
 *   
 * Copyright 2011-2013 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

package app;

import model.Company;
import model.Connection;
import model.CustomerOffer1;
import model.CustomerOffer2;
import model.CustomerOffer3;
import model.CustomerWithoutOffer;

/**
 * A main program to test a Telematic Store.
 * 
 * @author Mònica Ramírez Arceda
 * @version 1.1 24/09/2013
 */
public class Main {

	/**
	 * Main methd that tests the program. Output should be:
	 * 
	 * <pre>
	 * CLIENTS A FACTURAR
	 * ==================
	 * DNI       NOM                 CON    MINS    IMPORT OFERTA
	 * 87654321  Jan Coll              2   17,00      1,20    3
	 * 12345678  Clara Putxet          1   57,00     11,40    2
	 * 55667788  Ramón Casamitjana     2   19,00      2,25    1
	 * 11223344  Josep Martí           3   19,00      1,90
	 * </pre>
	 * 
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		Company comp = new Company();
		Connection a = new Connection("18/05/2012-10:00", "18/05/2012-10:05");
		Connection b = new Connection("18/05/2012-10:06", "18/05/2012-10:15");
		Connection c = new Connection("18/05/2012-10:23", "18/05/2012-10:41");
		Connection d = new Connection("18/05/2012-11:12", "18/05/2012-11:13");
		Connection e = new Connection("18/05/2012-11:34", "18/05/2012-12:31");
		Connection f = new Connection("18/05/2012-12:40", "18/05/2012-12:45");
		Connection g = new Connection("18/05/2012-13:00", "18/05/2012-13:11");
		Connection h = new Connection("18/05/2012-13:21", "18/05/2012-13:27");
		CustomerWithoutOffer u1 = new CustomerWithoutOffer("Josep Martí", "11223344", 0.10);
		comp.add(u1);
		u1.add(a);
		u1.add(b);
		u1.add(f);
		CustomerOffer1 u2 = new CustomerOffer1("Ramón Casamitjana", "55667788", 0.15);
		comp.add(u2);
		u2.add(c);
		u2.add(d);
		CustomerOffer2 u3 = new CustomerOffer2("Clara Putxet", "12345678", 0.25, 20);
		comp.add(u3);
		u3.add(e);
		CustomerOffer3 u4 = new CustomerOffer3("Jan Coll", "87654321", 0.20);
		comp.add(u4);
		u4.add(g);
		u4.add(h);
		comp.listUsers();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	public Main() {
		// TODO Auto-generated constructor stub
	}

}