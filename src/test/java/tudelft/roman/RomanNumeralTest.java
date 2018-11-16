package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Test cases:
 * - (done) basic: I, V, X, L, C, D, M
 * - (done) composed basic: II, III, VI, VII, VIII, XIII, XV
 * - (done) Subtracted: IV, IX, XL, CD, CM
 * - boundaries: MMMCMXCIX (3999)
 * - errors:
 * 	- null
 *  - more than three in a row: IIII, XXXX, CCCC, MMMM
 *  - unknown romanNumbers: A, XXA, XAX, AXX
 *  - numbers I,X,C can be repeated up to 3 times, but V,L,D can not be repeated at all
 */


public class RomanNumeralTest {
	private RomanNumeral roman;
	
	@BeforeEach
	public void initialize() {
	    roman = new RomanNumeral();
	}

    @Test
    public void singleNumber() {
        //// RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void numberWithManyDigits() {
        // RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("VIII");
        Assertions.assertEquals(8, result);
    }

    @Test
    public void numberWithSubtractiveNotation() {
        // RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("IV");
        Assertions.assertEquals(4, result);
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        // RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("XLIV");
        Assertions.assertEquals(44, result);
    }

    // My own tests

    @Test
    public void basicSymbols() {
        String[] romanNumbers = new String[] { "I", "V", "X", "L", "C", "D", "M" };
        int[] values = new int[] { 1,   5,  10,  50, 100, 500, 1000 };
        testSequence(romanNumbers, values);
    }

    @Test
    public void composedBasic() {
        String[] romanNumbers = new String[] {"II", "III", "VI", "VII", "VIII", "XIII", "XV" };
        int[] values = new int[] { 2,     3,    6,     7,      8,      13,  15};
        testSequence(romanNumbers, values);
    }

    @Test
    public void substractedBasic() {
        String[] romanNumbers = new String[] {"IV", "IX", "XL", "CD", "CM" };
        int[] values = new int[] { 4,    9,   40,  400,   900 };
        testSequence(romanNumbers, values);
    }

    @Test
    public void substractedComposed() {
        String[] romanNumbers = new String[] {"XIV", "XIX", "CXL", "MCD", "CMXLIX" };
        int[] values = new int[] { 14,    19,   140,  1400,   949 };
        testSequence(romanNumbers, values);
    }

    /**
     * Given an array of roman numbers and their expected integer values, it asserts
     * the conversion of each roman number matches the expected integer value 
     * @param romanNUmbers
     * @param expectedValues
     */
    private void testSequence(String[] romanNumbers, int[] expectedValues) {
        Assertions.assertEquals(romanNumbers.length, expectedValues.length);
        for (int i=0; i < romanNumbers.length; i++) {
            String romanNumber = romanNumbers[i];
            int expected = expectedValues[i];
            int result = roman.convert(romanNumber);
            Assertions.assertEquals(expected, result, "When roman number " + romanNumber);
        }
    }



}
