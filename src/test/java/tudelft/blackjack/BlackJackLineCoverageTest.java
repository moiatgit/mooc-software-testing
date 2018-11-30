package tudelft.blackjack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * Rules:
 * 
 * - the closer to 21 wins
 * - the program must return the number of points of the winner
 * - if a player > 21 loses
 * - if both players > 21 return 0

 * Testing strategy
 * - general cases: left wins (20, 1) -> 20 right wins (1, 20)-> 20
 * - players over 21: (1, 22) -> 1, (22, 1) -> 1, (22, 22) -> 0 
 * 
 * Testing for coverage:
 * - left > 21
 * - right > 21
 * - left > right
 * - right > left
 */


public class BlackJackLineCoverageTest {

	/*
    @Test
    public void bothPlayersGoTooHigh() {
        int result = new BlackJack().play(30, 30);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void leftPlayerWins() {
        int result = new BlackJack().play(10, 9);
        Assertions.assertEquals(10, result);
    }
    */
	@Test
	public void leftTooMuch() {
		int result = new BlackJack().play(22, 1);
		Assertions.assertEquals(1, result);
	}
	@Test
	public void rightTooMuch() {
		int result = new BlackJack().play(1, 22);
		Assertions.assertEquals(1, result);
	}
	@Test
	public void leftOverRight() {
		int result = new BlackJack().play(1, 21);
		Assertions.assertEquals(21, result);
	}
	@Test
	public void rightOverLeft() {
		int result = new BlackJack().play(1, 21);
		Assertions.assertEquals(21, result);
	}
}
