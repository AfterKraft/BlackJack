package com.whitejack.blackjack;

import java.util.Scanner;

import com.whitejack.api.Dealer;
import com.whitejack.api.Deck;
import com.whitejack.api.Game;
import com.whitejack.api.Player;
import com.whitejack.api.User;
import com.whitejack.api.applets.BetHandler;

import org.apache.log4j.Logger;

/**
 * BlackJack class is to handle game logic for BlackJack. Here, the BlackJack will make a new
 * Object of BlackJack to run the game, while allowing another game to be created. This
 * also cleans up code in BlackJack & BlackJack.
 * @author gabizou
 *
 */

public class BlackJack extends Game {
	
	public Dealer dealer;
	public Deck deck;
	public User user;
	public boolean stand,bust;
	public Scanner input;
	public BetHandler betHandler;
	
	private static final Logger log = Logger.getLogger("WhiteJack");
	
	public enum Play { Hit, Stay, Stand, DoubleDown, Split, Surrender };
	
	
	public BlackJack() {
	}


	@Override
	public void start() {

		//Requests the amount of players to be added to the game
		//TODO: Implement multiplayer functionality
		input = new Scanner(System.in);
		//Request a bet amount
		System.out.print("How much would you like to bet? ");
		betHandler = new BetHandler(); 

		while(!input.hasNextInt()) {
			log.debug("[BlackJack]: User has entered something else other than an Integer!");
			System.out.println("Please enter a number!");
			input.nextLine();
		}
		user.bet=input.nextInt();
		log.debug("[BlackJack]: User has set their bet to "+user.bet);

		//Deal Cards

		if(deck.isShuffled != true) {
			log.debug("Deck has just been shuffled by BlackJack");  //Debugging line
			deck.shuffle();
		}

		dealer.recieveCard(deck);
		log.debug("[BlackJack] The Dealer has just recieved their first card");  //Debugging line

		dealer.recieveCard(deck);
		log.debug("[BlackJack] The Dealer has just recieved their second card.");  //Debugging line

		log.debug("[BlackJack] The Dealer's hand value is: "+ dealer.getHandValue());  //Debugging line

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
					hit(user);
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
			hit(dealer);
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
	
	/**
	 * Universal hit method to which we can now use as all actors on the
	 * game are of type Player. Generics are usefull man :)
	 * @param player
	 */
	private void hit(Player player) {
		
		player.recieveCard(deck);
		log.info(player.userName+" has drawn a " +player.getCard());
		log.info(player.userName+"'s hand has a value of: "+player.getHandValue());
		
	}
}