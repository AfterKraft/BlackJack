package com.whitejack.api;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class DeckArrayManager extends Deck
{
	private static DeckArrayManager instance;
	private boolean cardIsPlayable = true;
	private Card[] card;
	private int[] deck = new int[52];
	private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	private int count = 0;
	private ArrayList<Card> stack = new ArrayList<Card>();
	private ArrayList<Card> heap = new ArrayList<Card>();
	private ArrayList<Card> recycleBin = new ArrayList<Card>();
	private static Logger log = Logger.getLogger("WhiteJackAPI");
	/**
	 *  This method is accessed from 
	 *  outside the class by 
	 *  deck = DeckArrayManager.getDeckArrayManager();
	 */
	public DeckArrayManager() 
	{
	}
	public int getCount() 
	{
		return count;
	}
	public void setCount(int c) 
	{
		count = c;
	}
	public boolean needShuffle() 
	{
		if (count == 50)
			return true;
		else
			return false;
	}
	public static DeckArrayManager getDeckArrayManager() 
	{
		if (instance == null)
		{
			instance = new DeckArrayManager();
			log.debug("[DeckArrayManager] inside getter() method");
		}
		return instance;
	}
	/**
	 * Returns a card
	 */
	public void serveCard() 
	{
		if (needShuffle() == false) 
		{
			count++;
		} 
		else 
		{
			shuffle();
		}
		// otherwise, go ahead and deal one card and be sure to increment counter and activate the push array() method
	}

	// Recycle all cards into stack
	/**
	 * Initializes the deck array
	 */
	public void initDeck() 
	{
		for (int i = 0; i < deck.length; i++)
			deck[i] = i;
	}

	// Shuffle the cards
	/**
	 * Shuffles the current deck
	 */
	public void shuffle() 
	{
		for (int i = 0; i < deck.length; i++) 
		{
			// Generate an index randomly
			int index = (int)(Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[index]; 
			deck[index] = temp;
		}
		log.debug("[DeckArrayManager] shuffle() method");
	}

	/**
	 * Push a card into the array <list> 
	 * @param list
	 * @param card
	 */
	public void push(ArrayList<Card> list, int card) 
	{
		list.add(this.card[card]);
	}

	/**
	 * Pull a card from the array <list>
	 * @param list
	 * @param card
	 */
	public void pull(ArrayList<Card> list, int card) 
	{
		list.remove(this.card[card]);
	}

	/**
	 * 
	 * @param cardID
	 */
	public void serveHand(int cardID) 
	{	// Deal out one hand to one player
		int temp = 0;
		for (int i = count; i < count + 1; i++) 
		{
			String suit = suits[deck[i] / 13];
			String rank = ranks[deck[i] % 13];
			log.debug("Card number " + deck[i] + ": " 
					+ rank + " of " + suit);
			count++;
			temp = deck[i];

		}
		log.debug("[DeckArrayManager] serveHand() method");
	}	

	/**
	 * This will display a hand with the first cards defined by num
	 * @param num
	 */
	public void displayHand(int num) 
	{ 	
		//Display the first hand of cards with the specified size of cards
		for (int i = 0; i < num; i++) 
		{
			String suit = suits[deck[i] / 13];
			String rank = ranks[deck[i] % 13];
			log.debug("Card number " + deck[i] + ": " 
					+ rank + " of " + suit);	
		}
	}

	/**
	 * Getter for Card
	 */
	public void getCard()
	{
	}
	/**
	 * Setter for Card
	 */
	public void setCard() 
	{
	}
}