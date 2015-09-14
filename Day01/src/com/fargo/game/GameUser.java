package com.fargo.game;

import java.util.Scanner;

public class GameUser {

	public static void main(String[] args) {
		int guess = -1;
		Scanner scanner = new Scanner(System.in);
		GameEngine gameEngine = new GameEngine();
		while(!gameEngine.isGameOver()){
			guess = scanner.nextInt();
			try {
				gameEngine.play(guess);
			} catch (GameException e) {
				e.printStackTrace();
			}
			System.out.println(gameEngine.getMessage());
			System.out.println("Attempts: " + gameEngine.getAttempts());
		}
	}

}
