/*
 * LuxuryYacht.java
 * 		
 * Copyright 2011 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 *
 */

package harbour;

public class LuxuryYacht extends SportsBoatWithMotor {

        /** Number of cabins of the luxury yacht */
	public int nCabins;

	// Constructor
	public LuxuryYacht(String regPlate, double length, int year, int power, int nCabins) {
		super(regPlate, length, year, power);
		this.nCabins = nCabins;
	}

	@Override
	public double amountAccordingToBoat() {
		return this.baseAmount() + this.power + this.nCabins;
	}

}
