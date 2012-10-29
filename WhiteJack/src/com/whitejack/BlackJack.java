package com.whitejack;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * BlackJack class is to handle game logic for BlackJack. Here, the GameMaker will make a new
 * Object of BlackJack to run the game, while allowing another game to be created. This
 * also cleans up code in GameMaker & BlackJack.
 * @author gabizou
 *
 */

public class BlackJack extends Game {
	
	public Dealer dealer;
	public Deck deck;
	public User user;
	public boolean stand,bust;
	
	private static final Logger log = Logger.getLogger(BlackJack.class.getName());
	
	public BlackJack(Dealer dealer, Deck deck, User user) {
		this.dealer = dealer;
		this.deck = deck;
		this.user = user;
	}


	public void start() {

		Scanner input = new Scanner(System.in);

		//Requests the amount of players to be added to the game
		//TODO: Implement multiplayer functionality

		//Collect userName
		

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
}