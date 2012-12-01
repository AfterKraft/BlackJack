package com.whitejack.api;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class DeckArrayManager extends Deck {
	public DeckArrayManager(int n) 
	{
		super(n);
		// TODO Auto-generated constructor stub
	}
	private static DeckArrayManager instance;
	private static Logger log = Logger.getLogger("WhiteJackAPI");
	
	private Card[] card;
	private ArrayList<Card> stack;
	private ArrayList<Card> heap = new ArrayList<Card>();
	private ArrayList<Card> recycleBin = new ArrayList<Card>();
	
	/**
	 * This method is accessed from outside the class by deck =
	 * DeckArrayManager.getDeckArrayManager();
	 */
	public ArrayList<Card> createStack()
	{
		stack  = new ArrayList<Card>();
		return stack;
		
	}
	public int getCount() {
		return count;
	}

	public void setCount(int c) {
		count = c;
	}

	public boolean needShuffle() {
		if (count == 50)
			return true;
		else
			return false;
	}

	public static DeckArrayManager getDeckArrayManager() {
		if (instance == null) {
			instance = new DeckArrayManager(1);
			log.debug("[DeckArrayManager] inside getter() method");
		}
		return instance;
	}

	/**
	 * Push a card into the array <list>
	 * 
	 * @param list
	 * @param card
	 */
	public void push(ArrayList<Card> list, int card) {
		try {
			list.add(this.card[card]);
		} catch (Exception ex) {
			// if arrayList becomes empty handle exception here...
		}
	}

	public boolean isStackEmpty() // return true if needShuffle == true;
	{
		return false;
	}

	/**
	 * Pull a card from the array <list>
	 * 
	 * @param list
	 * @param card
	 */
	public void pull(ArrayList<Card> list, int card) {
		try {
			list.remove(this.card[card]);
		} finally {
		}
	}

	/**
	 * 
	 * @param cardID
	 * @return
	 */
//	public int serveHand(int cardID) { // Deal out one hand to one player
//		int temp = 0;
//		for (int i = count; i < count + 1; i++) {
//			String suit = suits[deck[i] / 13];
//			String rank = ranks[deck[i] % 13];
//			log.debug("Card number " + deck[i] + ": " + rank + " of " + suit);
//			count++;
//			temp = deck[i];

//		}
//		return temp;
//	}

	/**
	 * Getter for Card
	 */
	public void getCard() {
	}

	/**
	 * Setter for Card
	 */
	public void setCard() {
	}
}
