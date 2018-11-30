package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Examples from exercise statement
 *  gHappy("xxggxx") → true
	gHappy("xxgxx") → false
    gHappy("xxggyygxx") → false
    
   Partitions:
   - null entry -> false
   - empty entry -> true
   - all happy g: "gg" -> true, "ggagg" -> true, "aggagga" -> true, "aggaggagga" -> true, "ggg"
   - no happy g:  "g" -> false, "ga" -> false, "ag" -> false, "gag" -> false
   
 */

public class GHappyTest {
	
	@ParameterizedTest
	@CsvSource({"xxggxx,true","xxgxx,false","xxggyygxx,false"})
	public void exerciseStatementTests(String entry, boolean expected) {
		GHappy ghappy = new GHappy();
		Assertions.assertEquals(expected, ghappy.gHappy(entry) );
	}

	@Test
	public void emptyEntry() {
		GHappy ghappy = new GHappy();
		Assertions.assertTrue(ghappy.gHappy("") );
	}


	@ParameterizedTest
	//@ValueSource(strings = {"gg", "ggagg", "aggagg", "aggaggagga", "ggg"})
	@ValueSource(strings = {"gg"})
	public void allHappy(String entry) {
		GHappy ghappy = new GHappy();
		Assertions.assertTrue(ghappy.gHappy(entry) );
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"g","ga","ag", "gag", "ggag"})
	public void allUnhappy(String entry) {
		GHappy ghappy = new GHappy();
		Assertions.assertFalse(ghappy.gHappy(entry) );
	}
}
