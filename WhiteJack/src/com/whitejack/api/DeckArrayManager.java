package com.whitejack.api;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class DeckArrayManager extends Deck
{
	private static DeckArrayManager instance;
	private boolean cardIsPlayable = true;
	private Card[] card;
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

	/**
	 * Push a card into the array <list> 
	 * @param list
	 * @param card
	 */
	public void push(ArrayList<Card> list, int card) 
	{
		try
		{
			list.add(this.card[card]);
		}
		catch (Exception ex)
		{
			// if arrayList becomes empty handle exception here...
		}
	}
	public boolean isStackEmpty()	// return true if needShuffle == true;
	{
		return false;
	}	
	/**
	 * Pull a card from the array <list>
	 * @param list
	 * @param card
	 */
	public void pull(ArrayList<Card> list, int card) 
	{
		try
		{
			list.remove(this.card[card]);
		}
		catch (Exception ex)
		{
			// if arrayList becomes empty handle exception here...
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