package veterinary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class Clinic {
	DateTimeFormatter formatterDDMMYYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/** List of Visits of the Clinic */
	private HashSet<Visit> visits;

	/**
	 * Creates a clinic.
	 */
	public Clinic() {
		this.visits = new HashSet<Visit>();
	}

	/**
	 * Add a visit to the clinic.
	 * 
	 * @param v a visit.
	 */
	public void addVisit(Visit v) {
		this.visits.add(v);
	}

	/**
	 * Determines if a day-shift is booked.
	 * 
	 * @param date  a date, in format DD/MM/YYYY.
	 * @param shift a shift: 'M'(Morning) 'A' (Afternoon) or 'D' (whole Day)
	 * @return true, if the date/shift is booked, false otherwise.
	 */
	public boolean bookedDay(String date, char shift) {
		boolean booked = false;
		for (Visit v : this.visits) {
			if (v.getDate().equals(date) && v.getShift() == shift) {
				booked = true;
			}
		}
		return booked;
	}

	/**
	 * Determines if a day is completely free, i.e., there is no booked shift.
	 * 
	 * @param date a date.
	 * @return true if the the day is free, false otherwise.
	 */
	public boolean freeDay(String date) {
		return !bookedDay(date, 'D') && !bookedDay(date, 'M') && !bookedDay(date, 'A');
	}

	/**
	 * Books a visit in the nearest date. A visit is created and is assigned to the
	 * clinic.
	 * 
	 * The following requisites are kept in mind:
	 * 
	 * - A pet needs a free morning shift (M) or an afternoon shift (A)U
	 * 
	 * - A farm animal needs a free whole day (D)
	 * 
	 * - A day can have two visits, one during the morning (M) and another one
	 * during the afternoon (A) or an unique visit during whole day (D)
	 * 
	 * - The clinic works all days of week.
	 * 
	 * @param animal   an animal to visit.
	 * @param discount true if the visit has discount, false otherwise.
	 */
	public String bookVisit(Animal a, boolean discount) {
		boolean foundDate = false;
		char shift = ' ';
		LocalDate dtDate = LocalDate.now().plusDays(1);
		String date = null;
		while (!foundDate) {
			date = dtDate.format(formatterDDMMYYYY);
			if (a instanceof Pet) {
				if (!bookedDay(date, 'D') 	
							&& !bookedDay(date, 'M')) {
					shift = 'M';
					foundDate = true;
				} else if (!bookedDay(date, 'D') 
							&& !bookedDay(date, 'A')) {
					shift = 'A';
					foundDate = true;
				} 
			} else {
				if (freeDay(date)) {
					shift = 'D';
					foundDate = true;
				} else {
					//do nothing
					foundDate = false;
				}
			}
			dtDate = dtDate.plusDays(1);
		}
		Visit v = null;
		if (discount) {
			v = new VisitWithDiscount(date, shift);
		} else {
			v = new VisitWithoutDiscount(date, shift);
		}
		v.setAnimal(a);
		this.addVisit(v);
		return date + "-" + shift;
	}

	/**
	 * Calculates the profit of the clinic until a date
	 * 
	 * @param date a date.
	 * @return the profit.
	 */
	public double profit(String date) {
		double profit = 0;
		for (Visit v : this.visits) {
			if (LocalDate.parse(v.getDate(), formatterDDMMYYYY).isBefore(LocalDate.parse(date, formatterDDMMYYYY))) {
				profit += v.calculateCost();
			}
		}
		return profit;
	}

	/**
	 * Creates a set of the animals of a certain type that have been visited before
	 * today.
	 * 
	 * @param type "pet" if we want to create a set with pets or "farm" otherwise
	 * @return a set of animals
	 */
	public HashSet<Animal> visitedAnimals(final String type)
	{

			return null;

	}

	/*
	    public boolean isBefore(ChronoLocalDate other) {
        if (other instanceof LocalDate) {
            return this.compareTo0((LocalDate)other) < 0;
        } else {
            return super.isBefore(other);
        }
    }
	 */
}
