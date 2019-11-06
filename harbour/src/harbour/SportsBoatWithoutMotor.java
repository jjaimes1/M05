/*
 * SportsBoatWithoutMotor.java
 * 		
 * Copyright 2011 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 *
 */

package harbour;

/**
 * Simulates a sports boat without motor.
 */
public class SportsBoatWithoutMotor extends Boat {

    // Constructor
    public SportsBoatWithoutMotor(String regPlate, double length, int year) {
        super(regPlate, length, year);
    }

    @Override
    public double amountAccordingToBoat() {
        return this.baseAmount();
    }

}
