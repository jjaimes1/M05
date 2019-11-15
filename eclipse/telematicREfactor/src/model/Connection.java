/*
 * Connection.java        1.1 24/09/2013
 *   
 * Copyright 2011-2013 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

package model;

/**
 * This class modelizes an user connection. It stores the initial date time and
 * the ending date time of the connection.
 * 
 * @author Mònica Ramírez Arceda
 * @version 1.1 24/09/2013
 */
public class Connection {

	/** Connection initial datetime */
	private String iniDateTime;
	/** Connection end datetime */
	private String endDateTime;

	/**
	 * Creates a connection.
	 * 
	 * @param iniDateTime the initial date time of the connection.
	 * @param endDateTime the ending date time of the connection.
	 */
	public Connection(String iniDateTime, String endDateTime) {
		this.iniDateTime = iniDateTime;
		this.endDateTime = endDateTime;
	}

	/**
	 * Calculates the duration in minutes of the connection.
	 * 
	 * @return number of minutes.
	 */
	public long nMinutes() {
		long seconds = JodaDT.durationInSeconds(JodaDT.parseDDMMYYYYhhmm(this.iniDateTime),
				JodaDT.parseDDMMYYYYhhmm(this.endDateTime));
		return seconds / 60;
	}
}
