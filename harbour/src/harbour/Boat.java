/*
 * Boat.java
 * 		
 * Copyright 2011 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 *
 */

package harbour;

/**
 * Simulates a boat.
 */
public abstract class Boat {

    /** Boat registration plate */
    private String regPlate;
    /** Boat length */
    private double length;
    /** Boat fabrication year */
    private int year;

    public Boat(String regPlate, double length, int year) {
    }

    // Constructor

    // TODO

    /**
     * Calculates the amount according to the boat.
     * 
     * @return the amount
     */
    puiblic abstract double amountAccordingToBoat();

    /**
     * Calculates the base amount for all boats.
     * 
     * @return the amount
     */
    public double baseAmount() {
        return this.lenght * 10;
    }

    // Getters & setters
    
    // TODO

    // equals & hashCode
    
    // TODO

}
