package com.whitejack.blackjack;

import java.util.Scanner;

import com.whitejack.api.Dealer;
import com.whitejack.api.Deck;
import com.whitejack.api.DeckArrayManager;
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

public class BlackJackGame extends Game 
{
	public Dealer dealer;
	public DeckArrayManager deck;
	public User user;
	public boolean stand,bust;
//	public Scanner input;
	public BetHandler betHandler;
	public Scanner input = new Scanner(System.in);
	
	private static final Logger log = Logger.getLogger("WhiteJack");
	
	public enum Play { Hit, Stay, Stand, DoubleDown, Split, Surrender };
	
	
	public BlackJackGame() 
	{
		deck = new DeckArrayManager();
	}


	@Override
	public void start() 
	{
		betHandler = new BetHandler(); // first order is to start bet
		System.out.println("hi");
		deck.initDeck();
		deck.shuffle();
		deck.displayHand(2); 
		log.debug("[BlackJack] inside start() method");
	}
	public void play()
	{
		start();
	}
	/**
	 * Universal hit method to which we can now use as all actors on the
	 * game are of type Player. Generics are usefull man :)
	 * @param player
	 */
	private void hit(Player player) 
	{
	
	}
	private void stand(Player player) 
	{
	
	}
	private void split(Player player) 
	{
	
	}
	private void doubleDown(Player player)
	{
		
	}
}