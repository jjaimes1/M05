package test.dayPlus1;

import static org.junit.Assert.*;

import dayPlus1.Program;
import org.junit.Before;
import org.junit.Test;

public class ProgramTest {

	Program p;

	@Before
	public void init() {
		this.p = new Program();
	}

	// isLeapYear tests

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

	// dayPlus1 tests

	@Test
	public void testJanuaryPenultimatetDay() {
		String result = this.p.dayPlus1(30, 1, 2011);
		assertEquals("31/1/2011", result);
	}

	@Test
	public void testJanuaryLastDay() {
		String result = this.p.dayPlus1(31, 1, 2011);
		assertEquals("1/2/2011", result);
	}

	@Test
	public void testFebruaryLastDayNotLeapYear() {
		String result = this.p.dayPlus1(28, 2, 2011);
		assertEquals("1/3/2011", result);
	}

	@Test
	public void testFebruaryPenultimateDayLeapYear() {
		String result = this.p.dayPlus1(28, 2, 2012);
		assertEquals("29/2/2012", result);
	}

	@Test
	public void testFebruaryLastDayLeapYear() {
		String result = this.p.dayPlus1(29, 2, 2012);
		assertEquals("1/3/2012", result);
	}

	@Test
	public void testMarchPenultimatetDay() {
		String result = this.p.dayPlus1(30, 3, 2011);
		assertEquals("31/3/2011", result);
	}

	@Test
	public void testMarchLastDay() {
		String result = this.p.dayPlus1(31, 3, 2011);
		assertEquals("1/4/2011", result);
	}

	@Test
	public void testAprilLastDay() {
		String result = this.p.dayPlus1(30, 4, 2011);
		assertEquals("1/5/2011", result);
	}

	@Test
	public void testMayPenultimatetDay() {
		String result = this.p.dayPlus1(30, 5, 2011);
		assertEquals("31/5/2011", result);
	}

	@Test
	public void testMayLastDay() {
		String result = this.p.dayPlus1(31, 5, 2011);
		assertEquals("1/6/2011", result);
	}

	@Test
	public void testJuneLastDay() {
		String result = this.p.dayPlus1(30, 6, 2011);
		assertEquals("1/7/2011", result);
	}

	@Test
	public void testJulyPenultimatetDay() {
		String result = this.p.dayPlus1(30, 7, 2011);
		assertEquals("31/7/2011", result);
	}

	@Test
	public void testJulyLastDay() {
		String result = this.p.dayPlus1(31, 7, 2011);
		assertEquals("1/8/2011", result);
	}

	@Test
	public void testAugustPenultimatetDay() {
		String result = this.p.dayPlus1(30, 8, 2011);
		assertEquals("31/8/2011", result);
	}

	@Test
	public void testAugustLastDay() {
		String result = this.p.dayPlus1(31, 8, 2011);
		assertEquals("1/9/2011", result);
	}

	@Test
	public void testSeptemberLastDay() {
		String result = this.p.dayPlus1(30, 9, 2011);
		assertEquals("1/10/2011", result);
	}

	@Test
	public void testOctoberPenultimatetDay() {
		String result = this.p.dayPlus1(30, 10, 2011);
		assertEquals("31/10/2011", result);
	}

	@Test
	public void testOctoberLastDay() {
		String result = this.p.dayPlus1(31, 10, 2011);
		assertEquals("1/11/2011", result);
	}

	@Test
	public void testNovemberLastDay() {
		String result = this.p.dayPlus1(30, 11, 2011);
		assertEquals("1/12/2011", result);
	}

	@Test
	public void testDecemberPenultimatetDay() {
		String result = this.p.dayPlus1(30, 12, 2011);
		assertEquals("31/12/2011", result);
	}

	@Test
	public void testDecemberLastDay() {
		String result = this.p.dayPlus1(31, 12, 2011);
		assertEquals("1/1/2012", result);
	}

	@Test
	public void testNormalDay() {
		String result = this.p.dayPlus1(3, 3, 2011);
		assertEquals("4/3/2011", result);
	}

}
