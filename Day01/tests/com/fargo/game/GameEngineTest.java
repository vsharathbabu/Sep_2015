package com.fargo.game;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

public class GameEngineTest {

	private GameEngine gameEngine;
	
	@Test
	public void isRandomNumberGeneratedAtTheBeginning(){
		int target = gameEngine.getTarget();
		assertTrue(target > 0);
	}
	@Test
	public void isRandomNumberIsBetween1And100(){
		int target = gameEngine.getTarget();
		assertTrue(target > 0 && target < 100);
	}
	@Test
	public void isNumberOfAttemptsZeroAtTheBeginning(){
		int attempts = gameEngine.getAttempts();
		assertTrue(attempts == 0);
	}
	@Test
	public void checkIfMessageIsBlankInTheBeginning(){
		String message = gameEngine.getMessage();
		assertTrue("".equals(message));
	}
	@Test(expected=GameException.class)
	public void testIfUserEntersBetween1And100() throws GameException{
		int guess = -1;
		gameEngine.play(guess);
	}
	@Test
	public void checkIfMessageIsAimHigher()throws GameException,Exception{
		int guess = 50;
		setValueForTarget(75);
		gameEngine.play(guess);
		assertTrue("Aim Higher".equals(gameEngine.getMessage()));
	}
	@Test
	public void checkIfMessageIsAimLower()throws GameException,Exception{
		int guess = 50;
		setValueForTarget(45);
		gameEngine.play(guess);
		assertTrue("Aim Lower".equals(gameEngine.getMessage()));
	}
	@Test
	public void checkIfMessageIsYouHaveGotIt()throws GameException,Exception{
		int guess = 50;
		setValueForTarget(50);
		gameEngine.play(guess);
		assertTrue("You've got it!!!".equals(gameEngine.getMessage()));
	}
	@Test
	public void playAGame()throws GameException,Exception{
		setValueForTarget(77);
		int guess = 50;
		gameEngine.play(guess);
		assertTrue("Aim Higher".equals(gameEngine.getMessage()));
		guess = 75;
		gameEngine.play(guess);
		assertTrue("Aim Higher".equals(gameEngine.getMessage()));
		guess = 90;
		gameEngine.play(guess);
		assertTrue("Aim Lower".equals(gameEngine.getMessage()));
		guess = 77;
		gameEngine.play(guess);
		assertTrue("You've got it!!!".equals(gameEngine.getMessage()));
	}
	@Test
	public void playAGameAndCheckAttempts()throws GameException,Exception{
		setValueForTarget(77);
		int guess = 50;
		gameEngine.play(guess);
		guess = 75;
		gameEngine.play(guess);
		guess = 90;
		gameEngine.play(guess);
		guess = 77;
		gameEngine.play(guess);
		assertTrue(gameEngine.getAttempts() == 4);
	}
	@Test(expected=GameException.class)
	public void playAGameAfterItsOver()throws GameException,Exception{
		setValueForTarget(77);
		int guess = 50;
		gameEngine.play(guess);
		guess = 75;
		gameEngine.play(guess);
		guess = 90;
		gameEngine.play(guess);
		guess = 77;
		gameEngine.play(guess);
		gameEngine.play(guess);
	}
	
	@Test
	public void gameOverShouldBeFalseInTheBeginning(){
		assertTrue(!gameEngine.isGameOver());
	}
	
	private void setValueForTarget(int value) throws NoSuchFieldException, IllegalAccessException {
		Class gameCls = gameEngine.getClass();
		Field targetField =  gameCls.getDeclaredField("target");
		targetField.setAccessible(true);
		targetField.set(gameEngine, value);
	}
	
	
	
	
	
	
	@Before
	public void setUp(){
		gameEngine = new GameEngine();
	}
	
	@Test
	public void testSetUp() {
		assertNotNull(gameEngine);
	}

}
