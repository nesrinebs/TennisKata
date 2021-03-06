package com.total.digitalfactory.tenniskata;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * Test Units of {@link TennisGameImpl}
 * 
 * @since 1.0
 */
/*
Implement a simple tennis game
**Rules:**
* Scores from zero to three points are described as "love", "fifteen", "thirty", and "forty" respectively.
* Case1: If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is "advantage" for the player in the lead.
* case2 If at least three points have been scored by each player, and the scores are equal, the score is "deuce".
* A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
*/
public class TestTennisGame {
	
	TennisPlayerImpl player1;
	TennisPlayerImpl player2;
	TennisGameImpl game;
	
	@Before
	public void initGame() {
		player1 = new TennisPlayerImpl("Roger Federer");
		player2 = new TennisPlayerImpl("Serena Williams");
		game = new TennisGameImpl(player1, player2);
		
	}
	
	@Test
	public void testInitGameWithLoveScore() {
		initGame();
		assertTrue(player1.getName().equalsIgnoreCase("Roger Federer"));
		assertTrue(player1.getScore() == 0);
		assertTrue(player2.getName().equalsIgnoreCase("Serena Williams"));
		assertTrue(player2.getScore() == 0);
		assertTrue(game.getScore().values().size() == 2);
		assertTrue(game.getScore().values().stream().allMatch(a -> TennisGameScoreEnum.customValueOf(0).equals(TennisGameScoreEnum.love)));
		
	}
	
	@Test
	public void testFiftheenScoreForScore1() {
		initGame();
		player1.winBall();
		assertTrue(player1.getScore() == 1);
		assertTrue(game.getScore().get(player1).equals(TennisGameScoreEnum.fiftheen));
		assertTrue(game.getScore().get(player2).equals(TennisGameScoreEnum.love));
		player2.winBall();
		assertTrue(player2.getScore() == 1);
		assertTrue(game.getScore().get(player1).equals(TennisGameScoreEnum.fiftheen));
		assertTrue(game.getScore().get(player2).equals(TennisGameScoreEnum.fiftheen));
		
	}
	
	@Test
	public void testThirtyForScore2() {
		initGame();
		player1.winBall();
		player2.winBall();
		player1.winBall();
		assertTrue(game.getScore().get(player1).equals(TennisGameScoreEnum.thirty));
		assertTrue(game.getScore().get(player2).equals(TennisGameScoreEnum.fiftheen));
	}
	
	@Test
	public void fortyShouldBeDescriptionForScore3() {
		initGame();
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			player1.winBall();
		});
		assertTrue(game.getScore().get(player1).equals(TennisGameScoreEnum.forty));
		assertTrue(game.getScore().get(player2).equals(TennisGameScoreEnum.love));
	}
	
	@Test
	public void advantageCase1() {
		initGame();
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			player1.winBall();
		});
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			player2.winBall();
		});
		
		assertTrue(game.getScore().get(player2).equals(TennisGameScoreEnum.advantage));
	}
	
	@Test
	public void deuceTest() {
		initGame();
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			player1.winBall();
		});
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			player2.winBall();
		});
		assertTrue(game.getScore().get(player1).equals(TennisGameScoreEnum.deuce));
		assertTrue(game.getScore().get(player2).equals(TennisGameScoreEnum.deuce));
		player1.winBall();
		assertFalse(game.getScore().get(player1).equals(TennisGameScoreEnum.deuce));
		System.out.println(game.getScore().get(player1));
		assertFalse(game.getScore().get(player2).equals(TennisGameScoreEnum.deuce));
		player2.winBall();
		assertTrue(game.getScore().get(player1).equals(TennisGameScoreEnum.deuce));
		assertTrue(game.getScore().get(player2).equals(TennisGameScoreEnum.deuce));
	}
	
	@Test
	public void testgameShouldBeWonCase3() {
		initGame();
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			player1.winBall();
		});
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			player2.winBall();
		});
		assertFalse(game.getScore().get(player1).equals(TennisGameScoreEnum.wingame));
		player1.winBall();
		assertTrue(game.getScore().get(player1).equals(TennisGameScoreEnum.wingame));
	}
	
}
