package com.whitejack.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import org.apache.log4j.Logger;

/**
 * A setup class to create games, determining amount of players etc.
 * 
 * @author gabizou
 *
 */
public class GameMaker {

	private static Logger log = Logger.getLogger("WhiteJack");

	protected Game game;
	protected GameTable gameTable;
	protected List<User> users;
	private int numOfPlayers;
	private Scanner input = new Scanner(System.in);

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
		this.users = new ArrayList<User>();

		for(int i=0; i<numOfPlayers; i++) {
			User user = new User();

			log.info("Alright, Player "+(i+1)+": What is your name?");
			user.userName = input.nextLine();
			user.playerName = user.userName;
			log.info("Thank you, "+user.userName+" has been added to the game.");
			this.users.add(user);
			int temp = users.indexOf(user);
			log.debug("Yo, this user "+user.userName+" has an index of: "+temp);
		}
		System.out.println("All players have been added.");

		//System.out.println("Player: "+ player.userName+ " has been added to the game!");  //Old debug line

	}



	/**
	 * Creates a GameFactory to create the 
	 * gameType specific Game and GameTable
	 * 
	 * Game = Game logic used by GameTable
	 * GameTable = container for the <User> list and executes Game methods
	 */
	public void setupGame(GameFactory gameFactory) {

		//Sets up Dealer and Deck
		Dealer dealer = new Dealer();

		System.out.println("How many players will be playing?");
		while(!input.hasNextInt()) {
			System.out.println("Please enter a number!");
			input.nextLine();
		}
		numOfPlayers= input.nextInt();
		addPlayers(numOfPlayers);

		gameTable = gameFactory.createTable(dealer, this.users);
		if(!gameTable.isSetUp) {
			gameTable.setupTable();
		} else {
			startGame();
		}

	}

	//TODO write ability to save games to file
	public void saveGame() {

	}
	//TODO write ability to load games from file
	public void loadGame() {

	}

	public void getCard() {

	}
	public void setCard() {

	}

	public void getWinHand() {

	}

	public void startGame() {
		// TODO Auto-generated method stub
		gameTable.startGame();

//		gameTable = null;

	}

}