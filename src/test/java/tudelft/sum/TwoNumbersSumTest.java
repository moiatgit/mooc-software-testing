package tudelft.sum;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * Testing strategy
 * 
 * - basic test: [1,2,3] + [4, 5, 6] -> [5, 7, 9]
 * - require incr. on next digit: [1, 1, 5] + [1,1,5] -> [1, 2, 0], [1, 5, 5] + [1, 4, 6] -> [3, 0, 1]
 * - require new digit: [5] + [5] -> [1, 0], [5, 5, 5] + [5, 5, 6] -> [1, 1, 1, 1] 
 */

public class TwoNumbersSumTest {
	
	@Test
	public void basicTest() {
		ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3));
		ArrayList<Integer> second = new ArrayList<>(Arrays.asList(4, 5, 6));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(5, 7, 9));
		ArrayList<Integer> found = new TwoNumbersSum().addTwoNumbers(first, second);
		Assertions.assertEquals(expected, found);
	}
	
	
	@Test
	public void requireIncrementOnNextDigit() {
		ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 5, 5));
		ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1, 4, 6));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3, 0, 1));
		ArrayList<Integer> found = new TwoNumbersSum().addTwoNumbers(first, second);
		Assertions.assertEquals(expected, found);
	}
	
	@Test
	public void requireNewDigit() {
		ArrayList<Integer> first = new ArrayList<>(Arrays.asList(5, 5, 5));
		ArrayList<Integer> second = new ArrayList<>(Arrays.asList(5, 5, 6));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
		ArrayList<Integer> found = new TwoNumbersSum().addTwoNumbers(first, second);
		Assertions.assertEquals(expected, found);
	}
	
}
