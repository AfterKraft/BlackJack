package com.whitejack.api;

import java.util.List;
import java.util.Scanner;


import org.apache.log4j.Logger;


public class GameMaker {
	
	private static Logger log = Logger.getLogger("WhiteJack");
	
	protected Game game;
	protected List<User> users;
	private int numOfPlayers;
	
	public GameMaker() {
		log.info("GameMaker Started!");
	}

	/**
	 * Adds the player to the game and sets their isActiveUser to true for 
	 * system checks. 
	 * @param player
	 */
	public void addPlayers(int numOfPlayers) {

		//Debug line for verification of Starting addPlayer() method
		this.numOfPlayers = numOfPlayers;
		for(int i=0; i<numOfPlayers; i++) {
			User user = new User();
			Scanner input = new Scanner(System.in);
			System.out.println("Alright, Player "+(i+1)+": What is your name?");
			user.userName = input.toString();
			System.out.println("Thank you Player "+(i+1)+ )
			
		}
		users.add(e)
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
	public void setupGame(GameFactory gameFactory) {

		//Sets up Dealer and Deck
		Dealer dealer = new Dealer();
		
		List<User> users;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("How many players will be playing?");
		numOfPlayers= input.nextInt();
		addPlayers(numOfPlayers);

		game = gameFactory.createGame(dealer, user);

		
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
