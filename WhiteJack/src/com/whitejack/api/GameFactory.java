package com.whitejack.api;

import java.util.List;

/**
 * A factory to create games and gametables
 * 
 * @author gabizou
 *
 */
public interface GameFactory {
	

	/**
	 * Creates a GameTable setup with the dealer and list of
	 * users playing. 
	 * @param dealer
	 * @param users
	 * @return
	 */
	public GameTable createTable(Dealer dealer, List<User> users);
	
	/**
	 * Creates the Game object for all Game logic to be processed
	 * @return
	 */
	public Game createGame();
	
	
}
