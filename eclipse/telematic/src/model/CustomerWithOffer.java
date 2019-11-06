/**
 * 
 */
package model;

/**
 * @author iam26541596
 *
 */
public abstract class CustomerWithOffer extends Customer {

	/**
	 * @param name
	 * @param dni
	 * @param priceMinute
	 */
	public CustomerWithOffer(String name, String dni, double priceMinute) {
		super(name, dni, priceMinute);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.User#billAmount()
	 */
	@Override
	public double billAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
