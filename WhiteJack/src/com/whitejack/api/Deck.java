package com.whitejack.api;

import org.apache.log4j.Logger;

public class Deck extends Card{

	private Card[] card;
	protected int[] deck = new int[52];
	private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	private int count = 0;
	private int i;
	public boolean isShuffled;
	private int cardCount;
	private static Logger log = Logger.getLogger("WhiteJack");
	private int numDecks = 1;
	private int numCards = 52;
	public Deck() {

		isShuffled=false;
		cardCount=0;
	}
	public int getCount() 
	{
		return count;
	}
	public void setCount(int c) 
	{
		count = c;
	}
	public void show()
	{
	}
	public boolean needShuffle() // ->brought from DeckArrayManager
	{
		if (count == 52)
			return true;
		else
			return false;
	}
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

	private void serveHand(int cardID) 
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

	public Card dealCard() 
	{
		return null;
/*		log.debug("[Deck] Check to make sure the Deck.dealcard has been started. in Deck");  //Debugging line
		
		Card temp=card[i];
		log.debug("[Deck] The temporary temp object of type Card has been created!");  //Debugging line
		
		i++;
		log.debug("[Deck] i has been post incremented!");  //Debugging line
		
		log.debug("[Deck] temp has a value of: "+ temp); //Debugging line
		
		int count = temp.getValue();
		if(count>9)
			cardCount--;
		else if(count<7)
			cardCount++;	
		return temp;		*/
	} 
}
