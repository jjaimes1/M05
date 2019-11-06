/*
 * Rent.java
 * 		
 * Copyright 2011 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 *
 */

package harbour;

/**
 * Modelizes a rent of a wharfage.
 */
public class Rent {
    /** Dni of contract holder */
    private String dni;
    /** Name of contract holder */
    private String name;
    /** Initial date of the rent */
    private String iniDate;
    /** End date of the rent */
    private String endDate;
    /** Wharfage code that is rented */
    private String wharfageCode;
    /** The boat that will be park in the wharfage */
    private Boat boat;
    /** Fixed value for each boat */
    private static final double FIXED_VALUE = 2;

    // Constructor

    public Rent(String dni, String name, String iniDate, String endDate, String wharfageCode) {
        this.dni = dni;
        this.name = name;
        this.iniDate = iniDate;
        this.endDate = endDate;
        this.wharfageCode = wharfageCode;
    }

    /**
     * Calculates the duration of the rent.
     * 
     * @return the number of days of the rent.
     */
    public long days() {
        return JodaDT.durationInSeconds(JodaDT.parseDDMMYYYY(iniDate), JodaDT.parseDDMMYYYY(endDate)) / 3600 / 24 + 1;
    }

    /**
     * Calculates the amount to be paid for all the duration of the rent.
     * 
     * @return the amount.
     */
    public double amount() {
        return this.days() * this.boat.amountAccordingToBoat() * Rent.FIXED_VALUE;
    }

    /**
     * Calculates the amount to be paid per day.
     * 
     * @return the amoutn.
     */
    public double amountPerDay() {
        return this.amount() / this.days();
    }

    // Getters & setters

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getWharfageCode() {
        return wharfageCode;
    }

    public String getIniDate() {
        return iniDate;
    }

    public String getEndDate() {
        return endDate;
    }

}
