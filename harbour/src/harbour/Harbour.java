/*
 * Harbour.java
 * 		
 * Copyright 2011 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 *
 */

package harbour;

import java.util.ArrayList;
import java.time.*;


/**
 * Modelizes a harbour
 */
public class Harbour {

    /** Harbour city */
    private String city;
    /** Harbour country */
    private String country;
    /** Harbour rents */
    private ArrayList<Rent> rents;

    // Constructor
    public Harbour(String city, String country) {
        this.city = city;
        this.country = country;
        this.rents = new ArrayList<Rent>();
    }

    /**
     * Adds a rent to the harbour.
     * 
     * @param r a rent
     * @return true if the rent has been added, false otherwise
     */
    public boolean add(Rent r) {
        return this.rents.add(r);
    }

    /**
     * Calculate the amount the harbour receives during a concrete month.
     * 
     * @param month a month
     * @param year a year
     * @return the amount received on month/year
     */
    public double calculateAmountMonth(int month, int year) {
        double total = 0;

        for (Rent r : rents) {
            // Get rent initial and end dates
            String iniDateS = r.getIniDate();
            DateTime iniDate = JodaDT.parseDDMMYYYY(iniDateS);
            String endDateS = r.getEndDate();
            DateTime endDate = JodaDT.parseDDMMYYYY(endDateS);
            // Calculate first and last day of the month
            DateTime iniMonth = new DateTime(year, month, 1, 0, 0, 0, 0);
            DateTime endMonth = iniMonth.plusMonths(1);
            // Traverse all days of the month and if one of these days is in the rent,
            // add the diary fee of this rent
            DateTime day = iniMonth;
            while (!day.equals(endMonth)) {
                if (JodaDT.isInInterval(day, iniDate.minusDays(1), endDate.plusDays(1))) {
                    total += r.amountPerDay();
                }
                day = day.plusDays(1);
            }
        }
        return total;
    }

    /**
     * Create a report with all rents of the harbour detailing the following information: DNI and name of rent holder,
     * the wharfa, intial and end date of the rent and the amount of the rent.
     * 
     * @param pathReport the path file where the report will be written.
     */
    public void reprotRents(String pathReport) {
        Writer w = new Writer(pathReport);
        w.println("INFORME LLOGUERS PORT " + city + " (" + country + ")");
        for (Rent r : rents) {
            w.print(r.getDni() + "\t" + r.getName() + "\t" + r.getWharfageCode() + "\t" + r.getIniDate() + "\t"
                    + r.getEndDate() + "\t" + r.amount() + "\n");
        }
        w.close();
    }

}
