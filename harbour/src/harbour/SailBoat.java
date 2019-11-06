/*
 * SailBoat.java
 * 		
 * Copyright 2011 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 *
 */

package harbour;

/**
 * Modelizes a sail boat.
 */
public class SailBoat extends SportsBoatWithoutMotor {
    
        /** Number of masts of the sail boat */
	public int nMasts;

	// Constructor
	public SailBoat(String regPlate, double length, int year, int nMasts) {
		super(regPlate, length, year);
		this.nMasts = nMasts;
	}

	@Override
	public double amountAccordingToBoat() {
		return this.baseAmount() + this.nMasts;
	}
}
