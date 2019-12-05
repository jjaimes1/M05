package veterinary;

public abstract class Visit {
	/** The date of the visit, in format DD/MM/YYYY **/
	protected String date;
	/**
	 * The shift of the visit. It can be 'M'(Morning) 'A' (Afternoon) or 'D' (whole
	 * Day)
	 **/
	private char shift;
	/** The animal to visit */
	private Animal animal;
	/** The gross price of the visit */
	protected double grossPrice;
	/** IVA to apply to the visit, in percentage */
	protected static final double IVA = 21;

	/**
	 * Creates a Visit.
	 * 
	 * @param date  the date of the visit
	 * @param shift the shift of the visit. It can be 'M' (morning), 'A' (afternoon)
	 *              or 'D' (whole day).
	 */
	public Visit(String date, char shift) {
		this.date = date;
		this.shift = shift;
		this.grossPrice = 0;
	}

	/**
	 * Calculates how much the visit costs.
	 * 
	 * @return the cost
	 */
	public abstract double calculateCost();

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public String getDate() {
		return this.date;
	}

	/**
	 * Gets the shift.
	 * 
	 * @return the shift
	 */
	public char getShift() {
		return this.shift;
	}

	/**
	 * Gets the animal.
	 * 
	 * @return the animal
	 */
	public Animal getAnimal() {
		return this.animal;
	}

	/**
	 * Gets the gross price.
	 * 
	 * @return the gross price
	 */
	public double getGrossPrice() {
		return this.grossPrice;
	}

	/**
	 * Sets the animal.
	 * 
	 * @param animal the animal to set
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	/**
	 * Sets the gross price.
	 * 
	 * @param grossPrice the gross price to set
	 */
	public void setGrossPrice(double grossPrice) {
		this.grossPrice = grossPrice;
	}

	/**
	 * Calculates the hash code.
	 * 
	 * @return the hash code.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.date == null) ? 0 : this.date.hashCode());
		result = prime * result + this.shift;
		return result;
	}

	/**
	 * Determines if an object is equal to the visit. Two visits are equal if they
	 * have the same date and the same shift.
	 * 
	 * @param obj an object
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visit other = (Visit) obj;
		if (this.date == null) {
			if (other.date != null)
				return false;
		} else if (!this.date.equals(other.date))
			return false;
		if (this.shift != other.shift)
			return false;
		return true;
	}

}
