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
			Scanner input = new Scanner(System.in);
			log.info("Alright, Player "+(i+1)+": What is your name?");
			user.userName = input.nextLine();
			log.info("Thank you, "+user.userName+" has been added to the game.");
			this.users.add(user);
		}
		System.out.println("All players have been added.");

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
	 * Creates a GameFactory to create the 
	 * gameType specific Game and GameTable
	 * 
	 * Game = Game logic used by GameTable
	 * GameTable = container for the <User> list and executes Game methods
	 */
	public void setupGame(GameFactory gameFactory) {

		//Sets up Dealer and Deck
		Dealer dealer = new Dealer();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("How many players will be playing?");
		while(!input.hasNextInt()) {
			System.out.println("Please enter a number!");
			input.nextLine();
		}
		numOfPlayers= input.nextInt();
		addPlayers(numOfPlayers);

		gameTable = gameFactory.createTable(dealer, this.users);
		game = gameFactory.createGame();
		if(!gameTable.isSetUp) {
			gameTable.setupTable();
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
		game.start();
		
	}

}
