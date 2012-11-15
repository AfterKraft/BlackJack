package com.whitejack.api;

import java.util.List;


public interface GameFactory {

	public GameTable createGame(Dealer dealer, List<User> users);
	
	
}
