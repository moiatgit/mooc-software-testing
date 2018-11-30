package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/*
 * Partitions:
 * 
 * 	- null entry
 *  - no mirror: "ab" -> ""
 *  - complete entries: "a" -> "a", "aba" -> "aba", "abcba" -> "abcba", "abba" -> "abba"
 *  - incomplete entries: "abca" -> "a", "abcdba" -> "ab" 
 */

public class MirrorTest {
	private Mirror mirror;
	@BeforeEach
	public void initialize() {
		mirror = new Mirror();
	}
	
	@Test
	public void nullEntry() {
		String result = mirror.mirrorEnds(null);
		Assertions.assertEquals("", result);
	}
	
	@Test
	public void noMirror() {
		Assertions.assertEquals("", mirror.mirrorEnds("ab"));
	}
	
	@ParameterizedTest
	@CsvSource({ "a,a", "aba,aba", "abca,a", "abcba,abcba", "abba,abba"})
	public void completeEntries(String entry, String expected) {
		String result = mirror.mirrorEnds(entry);
		Assertions.assertEquals(expected, result);
	}
	
	@ParameterizedTest
	@CsvSource({ "abca,a", "abcdba,ab"})
	public void incompleteEntries(String entry, String expected) {
		String result = mirror.mirrorEnds(entry);
		Assertions.assertEquals(expected, result);
	}

}
