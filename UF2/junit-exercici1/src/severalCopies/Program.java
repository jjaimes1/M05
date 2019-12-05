package severalCopies;

/*
 * Program.java        1.0 12/12/2011
 *
 * Models the program.
 *
 * Copyright 2011 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 *                Joaquim Laplana Tarragona <jlaplana@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class Program {

    /**
     * Determines if there are repeated elements in an array.
     * 
     * @param array an array
     * @return true if there is a repeated element, false otherwise
     */
    public boolean severalCopies(int[] array) {
        boolean found = false;
        for (int i = 0; i < array.length && !found; i++) {
            for (int j = i + 1; j < array.length && !found; j++) {                
                if (array[i] == array[j]) {
                    found = true;
                }
            }
        }
        return found;
    }

}
