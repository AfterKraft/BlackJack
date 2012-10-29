package com.whitejack;

import java.util.Scanner;


public class GameMaker {

	private boolean stand=false;
	private boolean bust=false;

	public GameMaker() {
		initGame();


	}

	/**
	 * Adds the player to the game and sets their isActiveUser to true for 
	 * system checks. 
	 * @param player
	 */
	public void addPlayer(Player player) {

		//Debug line for verification of Starting addPlayer() method
		player.isActiveUser = true;
		System.out.println("Player: "+ player.userName+ " has been added to the game!");

	}

	/**
	 * API comment: Removes a player of type Player from the Game. GameMaker 
	 * sets the Player to be unplayable unless the player object is playable
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
	public void initGame() {

		//int amountOfPlayers;

		System.out.println("Starting WhiteJack Game Session\n");

		//Sets up Dealer and Deck
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		deck.shuffle();
		deck.isShuffled = true;

		Scanner input = new Scanner(System.in);

		//Requests the amount of players to be added to the game
		//TODO: Implement multiplayer functionality
		//Circumvented for sake of lacking multiplayer functionality
		/*

		try {
			amountOfPlayers = input.nextInt();
			if(amountOfPlayers!=1) {
				System.out.println("Please enter a valid number of players (Currently 1): ");
				amountOfPlayers = input.nextInt();
			}
		}
		catch (NumberFormatException e) {
			System.out.println("That is not a valid entry! Please enter a number of players (Currently 1): ");
			amountOfPlayers = input.nextInt();
		}
		finally {
			input.close();
		}
		 */
		//Collect userName
		System.out.println("Please enter your name: ");
		String userName = input.nextLine();
		User user = new User(userName, userName);
		user.isPlayable = true;
		user.isActiveUser = true;

		System.out.println("Thank you "+user.userName+", Welcome to WhiteJack.");

		//Start GameTable for WhiteJack
		/*
		GameTable gametable = new GameTable();
		 */

		//Request a bet amount
		System.out.println("How much would you like to bet? ");

		try {
			user.bet=input.nextInt();
		} catch(NumberFormatException e) {
			System.out.println("That wasn't a valid amount, please enter a numerical integer to bet!");
		} finally {
			System.out.println("You have bet: $"+user.bet);
		}

		//Deal Cards

		if(deck.isShuffled = true) {
			System.out.println("Deck has just been shuffled by GameMaker");  //Debugging line
			deck.shuffle();
		}
		
		dealer.recieveCard(deck);
		System.out.println("[GameMaker] The Dealer has just recieved their first card");  //Debugging line
		
		dealer.recieveCard(deck);
		System.out.println("[GameMaker] The Dealer has just recieved their second card.");  //Debugging line
		
		System.out.println("[GameMaker] The Dealer's hand value is: "+ dealer.getHandValue());  //Debugging line

		user.recieveCard(deck);
		user.recieveCard(deck);
		System.out.println("Your hand value is: "+ user.getHandValue());

		//Requests whether user wishes to hit, stay, or surrender

		System.out.println("Do you wish to Hit(1), Stay (2), or Surrender(3)? ");
		int inputAction = 0;
		while(!stand) {
			try {
				inputAction= input.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("Sorry, but your input was invalid, please try again.\n");
				System.out.println("Do you wish to Hit(1), Stay (2), or Surrender(3)? ");
			} finally {
				if(inputAction==1)
				{  
					user.recieveCard(deck);
					System.out.println("You drew a:");
					System.out.println(user.getCard());
					System.out.println("Your hand value is: "+ user.getHandValue());
					if(user.getHandValue()>21)
					{
						System.out.println("BUST!");
						stand=true;
						bust=true;
					}
				}
				else if(inputAction==2)
					stand=true;
				else if(inputAction==3)
				{
					System.out.println("You are returned: $"+user.bet/2);
					user.recieveMoney(user.bet/2);
				}
				else
					System.out.println("Invalid entry");
			}
		}

		if(stand && !bust) {
			System.out.println("\nThe dealer flips over his card to reviel a:");
			System.out.println(dealer.getCard());
			System.out.println("His hand value is: "+dealer.getHandValue());
			while(dealer.getHandValue()<17)
			{
				System.out.println("The dealer draws another card");
				dealer.recieveCard(deck);
				dealer.getCard();
				System.out.println(dealer.getCard());
				System.out.println("His hand value is: "+dealer.getHandValue());
			}
			System.out.println("The dealer stands.\n");
			if(dealer.getHandValue()>21)
			{
				System.out.println("The dealer busts! \nYou WIN!");
				System.out.println("You won: "+2*user.bet);
				user.recieveMoney(2*user.bet);
				System.out.println("You have: $"+user.balance);
			}
			else if(dealer.getHandValue()>user.getHandValue())
			{
				System.out.println("You Lose!");
				System.out.println("You lost: $"+user.bet);
			}
			else
			{
				System.out.println("You Won!");
				System.out.println("You won: $"+2*user.bet);
				user.recieveMoney(2*user.bet);
				System.out.println("You have: $"+user.balance);
			}
		}
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

}
