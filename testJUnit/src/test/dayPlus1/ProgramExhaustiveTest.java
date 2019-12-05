package test.dayPlus1;

import static org.junit.Assert.*;

import dayPlus1.Program;
import org.junit.Before;
import org.junit.Test;

public class ProgramExhaustiveTest {

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
	public void testJanuary() {
		String result;
		for (int i = 1; i <= 30; i++) {
			result = this.p.dayPlus1(i, 1, 2011);
			assertEquals(i + 1 + "/1/2011", result);
		}
		result = this.p.dayPlus1(31, 1, 2011);
		assertEquals("1/2/2011", result);
	}

	@Test
	public void testFebruary() {
		String result;
		for (int i = 1; i <= 27; i++) {
			result = this.p.dayPlus1(i, 2, 2011);
			assertEquals(i + 1 + "/2/2011", result);
		}
		result = this.p.dayPlus1(28, 2, 2011);
		assertEquals("1/3/2011", result);
		for (int i = 1; i <= 28; i++) {
			result = this.p.dayPlus1(i, 2, 2004);
			assertEquals(i + 1 + "/2/2004", result);
		}
		result = this.p.dayPlus1(29, 2, 2004);
		assertEquals("1/3/2004", result);
	}

	@Test
	public void testMarch() {
		String result;
		for (int i = 1; i <= 30; i++) {
			result = this.p.dayPlus1(i, 3, 2011);
			assertEquals(i + 1 + "/3/2011", result);
		}
		result = this.p.dayPlus1(31, 3, 2011);
		assertEquals("1/4/2011", result);
	}

	@Test
	public void testApril() {
		String result;
		for (int i = 1; i <= 29; i++) {
			result = this.p.dayPlus1(i, 4, 2011);
			assertEquals(i + 1 + "/4/2011", result);
		}
		result = this.p.dayPlus1(30, 4, 2011);
		assertEquals("1/5/2011", result);
	}

	@Test
	public void testMay() {
		String result;
		for (int i = 1; i <= 30; i++) {
			result = this.p.dayPlus1(i, 5, 2011);
			assertEquals(i + 1 + "/5/2011", result);
		}
		result = this.p.dayPlus1(31, 5, 2011);
		assertEquals("1/6/2011", result);
	}

	@Test
	public void testJune() {
		String result;
		for (int i = 1; i <= 29; i++) {
			result = this.p.dayPlus1(i, 6, 2011);
			assertEquals(i + 1 + "/6/2011", result);
		}
		result = this.p.dayPlus1(30, 6, 2011);
		assertEquals("1/7/2011", result);
	}

	@Test
	public void testJuly() {
		String result;
		for (int i = 1; i <= 30; i++) {
			result = this.p.dayPlus1(i, 7, 2011);
			assertEquals(i + 1 + "/7/2011", result);
		}
		result = this.p.dayPlus1(31, 7, 2011);
		assertEquals("1/8/2011", result);
	}

	@Test
	public void testAugust() {
		String result;
		for (int i = 1; i <= 30; i++) {
			result = this.p.dayPlus1(i, 8, 2011);
			assertEquals(i + 1 + "/8/2011", result);
		}
		result = this.p.dayPlus1(31, 8, 2011);
		assertEquals("1/9/2011", result);
	}

	@Test
	public void testSeptember() {
		String result;
		for (int i = 1; i <= 29; i++) {
			result = this.p.dayPlus1(i, 9, 2011);
			assertEquals(i + 1 + "/9/2011", result);
		}
		result = this.p.dayPlus1(30, 9, 2011);
		assertEquals("1/10/2011", result);
	}

	@Test
	public void testOctober() {
		String result;
		for (int i = 1; i <= 30; i++) {
			result = this.p.dayPlus1(i, 10, 2011);
			assertEquals(i + 1 + "/10/2011", result);
		}
		result = this.p.dayPlus1(31, 10, 2011);
		assertEquals("1/11/2011", result);
	}

	@Test
	public void testNovember() {
		String result;
		for (int i = 1; i <= 29; i++) {
			result = this.p.dayPlus1(i, 11, 2011);
			assertEquals(i + 1 + "/11/2011", result);
		}
		result = this.p.dayPlus1(30, 11, 2011);
		assertEquals("1/12/2011", result);
	}

	@Test
	public void testDecember() {
		String result;
		for (int i = 1; i <= 30; i++) {
			result = this.p.dayPlus1(i, 12, 2011);
			assertEquals(i + 1 + "/12/2011", result);
		}
		result = this.p.dayPlus1(31, 12, 2011);
		assertEquals("1/1/2012", result);
	}

}
