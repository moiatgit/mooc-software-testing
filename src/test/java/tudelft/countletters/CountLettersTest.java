package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountLettersTest {

    @Test
    public void multipleMatchingWords() {
        int words = new CountLetters().count("cats|dogs");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void multipleMatchingWordsWithR() {
        int words = new CountLetters().count("car|door");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void multipleNonLetters() {
        int words = new CountLetters().count("car||door");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void lastWordDoesNotMatch() {
        int words = new CountLetters().count("cats|dog");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void lastWordDoesNotMatchWhenR() {
        int words = new CountLetters().count("car|dog");
        Assertions.assertEquals(1, words);
    }

    
}