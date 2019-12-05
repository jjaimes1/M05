package calc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import calc.Calculator;

public class CalculatorTestJUnit {

	private Calculator c;

	/**
	 * Initialization of tests.
	 */
	@Before
	public void init() {
		this.c = new Calculator();
	}

	/**
	 * Tests addition of two numbers.
	 */
	@Test
	public void testAdd() {
		double result = this.c.add(25, 30);
		assertEquals(55, result, 0);
	}

	/**
	 * Tests division of two numbers.
	 */
	@Test
	public void testDivide() {
		double result = this.c.divide(5, 2);
		assertEquals(2.5, result, 0);
	}

	/**
	 * Tests division by zero.
	 */
	@Test(expected = ArithmeticException.class)
	public void testDivideByZero() {
		this.c.divide(10, 0);
	}

}
