/*
 * Player class Version 0.1_dev Copyright (c) Ramel Henderson, David Brown, Rory
 * Andrews, Kevin Nause, Joseph Cohen, Gabriel Harris-Rouquette 2012 All Rights
 * Reserved
 */

/*
 * Player class Version 0.1_dev Copyright (c) Ramel Henderson, David Brown, Rory
 * Andrews, Kevin Nause, Joseph Cohen, Gabriel Harris-Rouquette 2012 All Rights
 * Reserved
 */

package com.whitejack.api;

import org.apache.log4j.Logger;

public abstract class Player {

	private static Logger log = Logger.getLogger("WhiteJack");

	// Set default variables
	public String userName;
	public Hand[] hand;
	public boolean isActiveUser = false;
	protected int balance;
	private int handValue;
	public boolean isPlayable;
	private boolean ace;

	// Depreciated attributes
	public Card card[]; // don't need
	public int cardCount = 0;

	public Player() {
	}

	/**
	 * @deprecated This is used for a single thread program. DO NOT USE
	 * @param deck
	 */
	public void requestCard(Deck deck) {
		log.debug("[Player] Just to check that Player.recieveCard() has just been called."); // Debugging
																								// line

		card[cardCount] = deck.dealCard();
		log.debug("[Player] The Deck has just dealt a card to player by player"); // Debugging
																					// line

		handValue += card[cardCount].getValue();
		log.debug("[Palyer] The player's hand value has just been calculated."); // Debugging
																					// line

		if (card[cardCount].getValue() == 11) {
			ace = true;
		}
		cardCount++;
		log.debug("[Player] The Player's card count has just gone up!"); // Debugging
																			// line
	}

	public Card getCard() {

		return card[cardCount--];

	}

	public void addHand(Hand hand, int MAX_HANDS) {
		int empty = 0;
		int i=0;
		do {
			if (this.hand[i].isEmpty()) {
				empty = i;
				log.debug("There's the hand that it was added in as" +i);
			}
			i++;
		} while (!this.hand[i].isEmpty());
		log.debug(hand+ "With the hand number at "+empty);
		this.hand[empty] = hand;
	}

	public void addCard(Card card, int handID) {
		this.hand[handID].add(card);
	}

	/**
	 * This will return a string array for the player's status which includes
	 * username, balance, isActiveuser, and Hand value
	 * 
	 * @return
	 */

	public String[] getStats() {
		// TODO: implement the array format for Status
		String[] status = new String[5];
		status[0] = userName;
		status[1] = Integer.toString(balance);
		status[2] = Boolean.toString(isActiveUser);
		// status[3] = Integer.toString(hand[0]);
		// I commented this out for now to keep the code from breaking

		return status;
	}

	public int getHandValue() {

		if ((handValue > 21) && (ace)) { // Removes 10 points from handValue if
											// there is an Ace being counted as
											// 11
			handValue -= 10;
		}

		return handValue;

	}

	public void quitGame() {

	}

}