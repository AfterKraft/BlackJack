package com.whitejack.api;

import org.apache.log4j.Logger;

/**
 * what the Deck class represents is an array of cards that in essence whose
 * arrayLength (num of cards in it) can vary. in default it is 52, the hand can
 * be considered a subclass of Deck (and in fact Hand extends Deck)
 * 
 * @author kevin
 * 
 */
public class Deck extends Card {

	protected int[] deck = new int[52];
	protected int count = 0;
	public boolean isShuffled;
	private int cardCount;
	private static Logger log = Logger.getLogger("WhiteJack");
	private int numDecks = 1;
	private int numCards = 52;

	public Deck(int n) {
		this.setNumCards(n);
		isShuffled = false;
		setCardCount(0);
	}

	// Recycle all cards into stack
	/**
	 * Initializes the deck array
	 */

	public int getCount() {
		return count;
	}

	public void setCount(int c) {
		count = c;
	}

	public void show() {
	}

	public boolean needShuffle() // ->brought from DeckArrayManager
	{
		if (count == 52)
			return true;
		else
			return false;
	}

	public void shuffle() {
		for (int i = 0; i < deck.length; i++) {
			// Generate an index randomly
			int index = (int) (Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
		log.debug("[" + Deck.class.getName() + "] shuffle() method");
	}

	public Card serveCard() {
		Card temp = new Card();
		int tempID = 0;
		String suit = suits[deck[count] / 13];
		String rank = ranks[deck[count] % 13];
		log.debug("Card number " + deck[count] + ": " + rank + " of " + suit);
		this.count++;
		tempID = deck[count];
		log.debug("[Deck] serveHand() method");
		temp.setCardID(tempID);
		return temp;
	}

	// Recycle all cards into stack
	/**
	 * Initializes the deck array
	 */
	public void initDeck() {
		for (int i = 0; i < deck.length; i++)
			deck[i] = i;
	}

	/**
	 * Returns a hand array with the @param cardAmmount of cards already dealt
	 * through the method.
	 * 
	 * @param cardAmmount
	 *            Determines the amount of cards to deal into the hand array
	 *            before returning the array
	 * @return
	 */
	public Hand[] serveHand(int cardAmmount) {
		int tempCardID = 0;
		Card tempCard = new Card();
		Hand[] hand = new Hand[1];
		for (int i = cardAmmount; i < cardAmmount + 1; i++) {
			String suit = suits[deck[count] / 13];
			String rank = ranks[deck[count] % 13];
			log.debug("Card number " + deck[i] + ": " + rank + " of " + suit);
			count++;
			tempCardID = deck[i];
			tempCard.setCardID(tempCardID);
			hand[1].add(tempCard);

		}
		log.debug("[Deck] serveHand() method");

		return hand;
	}

	/**
	 * This will display a hand with the first cards defined by num
	 * 
	 * @param num
	 */
	public void displayHand(int num) {
		// Display the first hand of cards with the specified size of cards
		for (int i = 0; i < num; i++) {
			String suit = suits[deck[i] / 13];
			String rank = ranks[deck[i] % 13];
			log.debug("Card number " + deck[i] + ": " + rank + " of " + suit);
		}
	}

	public void displayHand() {

	}

	public Card dealCard() {
		return null;
		/*
		 * log.debug(
		 * "[Deck] Check to make sure the Deck.dealcard has been started. in Deck"
		 * ); //Debugging line Card temp=card[i]; log.debug(
		 * "[Deck] The temporary temp object of type Card has been created!");
		 * //Debugging line i++;
		 * log.debug("[Deck] i has been post incremented!"); //Debugging line
		 * log.debug("[Deck] temp has a value of: "+ temp); //Debugging line int
		 * count = temp.getValue(); if(count>9) cardCount--; else if(count<7)
		 * cardCount++; return temp;
		 */
	}

	public int getNumDecks() {
		return numDecks;
	}

	public void setNumDecks(int numDecks) {
		this.numDecks = numDecks;
	}

	public int getNumCards() {
		return numCards;
	}

	public void setNumCards(int numCards) {
		this.numCards = numCards;
	}

	public int getCardCount() {
		return cardCount;
	}

	public void setCardCount(int cardCount) {
		this.cardCount = cardCount;
	}
}