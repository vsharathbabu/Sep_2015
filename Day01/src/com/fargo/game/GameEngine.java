package com.fargo.game;

public class GameEngine {

	private int target;
	private int attempts;
	private String message;
	private boolean gameOver;

	public GameEngine(){
		target = (int)(Math.random() * 100);
		attempts = 0;
		message = "";
	}
	
	public int getTarget() {
		return target;
	}

	public int getAttempts() {
		return attempts;
	}
	public String getMessage(){
		return message;
	}

	public void play(int guess) throws GameException{
		if(gameOver)
			throw new GameException("Game is already over");
		attempts++;
		checkGuess(guess);
		if(guess < target)
			message = GameConstants.Higher;
		else if(guess > target)
			message = GameConstants.Lower;
		else{
			message = GameConstants.Over;
			gameOver = true;
		}
	}

	private void checkGuess(int guess) throws GameException {
		if(guess < 1 || guess > 100)
			throw new GameException("Invalid guess: " + guess);
	}

	public boolean isGameOver() {
		return gameOver;
	}
}









