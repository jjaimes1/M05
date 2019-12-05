
package calc;

/**
 * Calculadora amb les operacions bàsiques.
 * 
 */
public class Calculator {

	/**
	 * Adds two numbers.
	 * 
	 * @param num1 a real number.
	 * @param num2 a real number.
	 * @return the sum of numebr1 and number2
	 */
	public double add(double num1, double num2) {
		return num1 + num2;
	}

	/**
	 * Divides two numbers.
	 * 
	 * @param num1 a real number.
	 * @param num2 a real number.
	 * @return the division of number1 by number2
	 */
	public double divide(double num1, double num2) {
		if (num2 == 0)
			throw new ArithmeticException();
		return num1 / num2;
	}
}
