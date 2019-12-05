package test.severalCopies;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import severalCopies.Program;

public class ProgramTest {
	Program p;

	@Before
	public void init() {
		this.p = new Program();
	}

	@Test
	public void testSeveralCopiesOneElement() {
		int[] a = { 1 };
		assertFalse(p.severalCopies(a));
	}

	@Test
	public void testSeveralCopiesTwoDifferentElements() {
		int[] a = { 1, 2 };
		assertFalse(p.severalCopies(a));
	}

	@Test
	public void testSeveralCopiesTwoEqualElements() {
		int[] a = { 1, 1 };
		assertTrue(p.severalCopies(a));
	}

	@Test
	public void testSeveralCopiesDifferentElements() {
		int[] a = { 1, 2, 5, 4, 3, 7, 9, 0 };
		assertFalse(p.severalCopies(a));
	}

	@Test
	public void testSeveralCopiesWithEqualNotConsecutiveElements() {
		int[] a = { 1, 2, 5, 4, 2, 7, 9, 0 };
		assertTrue(p.severalCopies(a));
	}

	@Test
	public void testSeveralCopiesWithEqualConsecutiveElements() {
		int[] a = { 1, 2, 2, 4, 7, 9, 0 };
		assertTrue(p.severalCopies(a));
	}

	@Test
	public void testSeveralCopiesWithEqualConsecutiveAndNotConsecutiveElements() {
		int[] a = { 1, 2, 2, 4, 7, 2, 0 };
		assertTrue(p.severalCopies(a));
	}

	@Test
	public void testSeveralCopiesWithEqualElementsOneInFirstPosition() {
		int[] a = { 1, 2, 3, 4, 1, 7, 8 };
		assertTrue(p.severalCopies(a));
	}

	@Test
	public void testSeveralCopiesWithEqualElementsOneInLastPosition() {
		int[] a = { 8, 2, 3, 4, 1, 7, 1 };
		assertTrue(p.severalCopies(a));
	}

	@Test
	public void testSeveralCopiesWithEqualElementsInFirstAndLastPositions() {
		int[] a = { 1, 2, 3, 4, 8, 7, 1 };
		assertTrue(p.severalCopies(a));
	}

}
