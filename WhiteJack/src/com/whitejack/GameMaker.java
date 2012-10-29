package com.whitejack;

import java.util.Scanner;
import java.util.logging.Logger;

public class GameMaker {

	private boolean stand=false;
	private boolean bust=false;
	private static Logger log = Logger.getLogger(GameMaker.class.getName());

	public GameMaker() {
		log.info("GameMaker Started!");
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
	public void initGame() {

		//Sets up Dealer and Deck
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		deck.shuffle();
		deck.isShuffled = true;

		Scanner input = new Scanner(System.in);

		//Requests the amount of players to be added to the game
		//TODO: Implement multiplayer functionality
		
		//Collect userName
		System.out.println("Please enter your name: ");
		String userName = input.nextLine();
		User user = new User(userName, userName);
		user.isPlayable = true;
		user.isActiveUser = true;
		log.fine("User '"+ userName+ "' has been set up as Playable");

		System.out.println("Thank you "+ userName +", Welcome to WhiteJack.");

		//Request a bet amount
		System.out.println("How much would you like to bet? ");

		while(!input.hasNextInt()) {
			log.finest("[GameMaker]: User has entered something else than an Integer!");
			System.out.println("Please enter a number!");
			input.nextLine();
		}
		user.bet=input.nextInt();
		log.fine("[GameMaker]: User has set their bet to "+user.bet);

		//Deal Cards

		if(deck.isShuffled != true) {
			log.finest("Deck has just been shuffled by GameMaker");  //Debugging line
			deck.shuffle();
		}
		
		dealer.recieveCard(deck);
		log.finer("[GameMaker] The Dealer has just recieved their first card");  //Debugging line
		
		dealer.recieveCard(deck);
		log.finer("[GameMaker] The Dealer has just recieved their second card.");  //Debugging line
		
		log.fine("[GameMaker] The Dealer's hand value is: "+ dealer.getHandValue());  //Debugging line

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
				System.out.println("Sorry, but your input was invalid, please try again.\n");  //Debugging 
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
