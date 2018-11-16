package tudelft.numfinder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumFinderTest {

	@Test
	void testOrderedDecreasing() {
		int[] values = new int[] {4, 3, 2, 1};
		NumFinder nf = new NumFinder();
		nf.find(values);
		assertEquals(4, nf.getLargest());
		assertEquals(1, nf.getSmallest());
	}

	@Test
	void testEmpty() {
		int[] values = new int[] {};
		NumFinder nf = new NumFinder();
		nf.find(values);
		assertEquals(4, nf.getLargest());
		assertEquals(1, nf.getSmallest());
	}

	
}
