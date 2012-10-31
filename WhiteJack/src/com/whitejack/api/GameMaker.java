package com.whitejack.api;

import java.util.Scanner;
import java.util.logging.Logger;


public class GameMaker {
	
	protected Game game;
	
	private static Logger log = Logger.getLogger(GameMaker.class.getName());
	
	public GameMaker() {
		log.info("GameMaker Started!");
	}

	/**
	 * Adds the player to the game and sets their isActiveUser to true for 
	 * system checks. 
	 * @param player
	 */
	public void addPlayer(Player player) {

		//Debug line for verification of Starting addPlayer() method
		player.isActiveUser = true;
		log.info("Player '"+player.userName+"' added to game!");

		//System.out.println("Player: "+ player.userName+ " has been added to the game!");  //Old debug line

	}

	/**
	 * API comment: Removes a player of type Player from the Game. GameMaker 
	 * sets the Player to be un-playable unless the player object is playable
	 * set by the addPlayer method.
	 * @param player
	 */

	public void removePlayer(Player player) {
		//Sets the boolean states to false for any system checks
		player.isPlayable = false;
		player.isActiveUser = false;

	}

	/**
	 * Initializes a game of WhiteJack.
	 * 
	 * Future: Could be used to initialize different types of card games.
	 */
	public void initGame(GameFactory gameFactory) {

		//Sets up Dealer and Deck
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		deck.shuffle();
		deck.isShuffled = true;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your name: ");
		String userName = input.nextLine();
		User user = new User(userName, userName);
		user.isPlayable = true;
		user.isActiveUser = true;
		log.fine("User '"+ userName+ "' has been set up as Playable");

		System.out.println("Thank you "+ userName +", Welcome to WhiteJack.");

		game = gameFactory.createGame(dealer, deck, user);

		
		//Created switch statement for possibility to make other card games ;)
		
		/*
		switch(game) {
		case 1: BlackJack blackjack = new BlackJack(dealer, deck, user);
				blackjack.start(); break;
		default: BlackJack blackjack1 = new BlackJack(dealer, deck, user);
		blackjack1.start(); break;
		}
		*/
	}

	public void saveGame() {

	}

	public void resumeGame() {

	}

	public void getCard() {

	}
	public void setCard() {

	}

	public void getWinHand() {

	}

	public void startGame() {
		// TODO Auto-generated method stub
		game.start();
		
	}

}
