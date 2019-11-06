/*
 * SportsBoatWithMotor.java
 * 		
 * Copyright 2011 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 *
 */

package harbour;

/**
 * Modelizes a sports boat with motor.
 */
public class SportsBoatWithMotor extends Boat {

    /** Boat power */
    protected int power;

    // Constructor
    
    public SportsBoatWithMotor(String regPlate, double length, int year, int power) {
        super(regPlate, length, year);
        this.power = power;
    }

    @Override
    public double amountAccordingToBoat() {
        return this.baseAmount() + this.power;
    }

}
