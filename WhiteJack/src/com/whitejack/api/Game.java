package com.whitejack.api;

/**
 * Holds all game specific methods for game specific logic
 * 
 * Abstract for comparison and possible aggregation of
 * available games
 * 
 * @author gabizou
 *
 */
public abstract class Game {
	
	protected Dealer dealer;
	protected Deck deck;
	protected User user;
	
	public void start() {
		
	}

}
