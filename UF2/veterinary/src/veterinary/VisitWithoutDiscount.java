package veterinary;

public class VisitWithoutDiscount extends Visit {

	/**
	 * Creates a visit without discount.
	 * 
	 * @param date  the date of the visit, in format DD/MM/YYYY.
	 * @param shift the shift of the visit. It can be 'M' (morning), 'A' (afternoon)
	 *              or 'D' (whole day).
	 */
	public VisitWithoutDiscount(String date, char shift) {
		super(date, shift);
	}

	/**
	 * Calculates how much the visit costs if there is no applied discount. IVA is
	 * applied.
	 * 
	 * @return the cost.
	 */
	public double calculateCost() {
		return this.grossPrice + this.grossPrice * Visit.IVA / 100;
	}

}
