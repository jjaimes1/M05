package veterinary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VisitWithDiscount extends Visit {
	DateTimeFormatter formatterDDMMYYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/** The default discount, in percentage */
	private final static double DISCOUNT = 10;
	/** The discount during summer (july and august), in percentage */
	private final static double SUMMER_DISCOUNT = 15;

	/**
	 * Creates a visit without discount.
	 * 
	 * @param date  the date of the visit, in format DD/MM/YYYY.
	 * @param shift the shift of the visit. It can be 'M' (morning), 'A' (afternoon)
	 *              or 'D' (whole day).
	 */
	public VisitWithDiscount(String date, char shift) {
		super(date, shift);
	}

	/**
	 * Calculates how much the visit costs if there is an applied discount. The
	 * applied discount depends on the month of the year. If the visit is during
	 * July or August, SUMMER_DISCOUNT is applied, if the visit is during another
	 * month DISCOUNT is applied.
	 * 
	 * In any case, IVA is also applied after the discount is applied.
	 * 
	 * @return the cost.
	 */
	public double calculateCost() {
		LocalDate dtDate = LocalDate.parse(date, formatterDDMMYYYY);
		double discount = 0;
		if (dtDate.getMonthValue() == 7 || dtDate.getMonthValue() == 8) {
			discount = VisitWithDiscount.SUMMER_DISCOUNT;
		} else {
			discount = VisitWithDiscount.DISCOUNT;
		}
		double netPrice = this.grossPrice - this.grossPrice * discount / 100;
		netPrice += netPrice * Visit.IVA / 100;
		return netPrice;
	}

}
