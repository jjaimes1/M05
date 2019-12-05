package leapYears;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProgramTest {

	Program p;

	@Before
	public void init() {
		this.p = new Program();
	}

	@Test
	public void testYearMultiple400() {
		boolean result = this.p.isLeapYear(2000);
		assertTrue(result);
	}

	@Test
	public void testYearMultiple4NotMultiple100() {
		boolean result = this.p.isLeapYear(2012);
		assertTrue(result);
	}

	@Test
	public void testYearNotMultiple400Multiple4Multiple100() {
		boolean result = this.p.isLeapYear(1700);
		assertFalse(result);
	}

	@Test
	public void testYearNotMultiple400NotMultiple4Multiple100() {
		boolean result = this.p.isLeapYear(2200);
		assertFalse(result);
	}

	@Test
	public void testYearNotMultiple400NotMultiple4NotMultiple100() {
		boolean result = this.p.isLeapYear(1999);
		assertFalse(result);
	}

}
