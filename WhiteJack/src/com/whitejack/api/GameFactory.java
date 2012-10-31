package com.whitejack.api;


public interface GameFactory {

	public Game createGame(Dealer dealer, Deck deck, User user);
	
	
}
