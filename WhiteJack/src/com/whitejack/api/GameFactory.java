package com.whitejack.api;

import java.util.List;

/**
 * GameFactory is now using Generics of Types Game and GameTable. These must be
 * honored in all of our API & API implementation.
 * 
 * @author gabizou
 * 
 * @param <G>
 *            Type Game
 * @param <GT>
 *            Type GameTable
 */
public interface GameFactory<G extends Game, GT extends GameTable<G>> {

	/**
	 * Creates a GameTable setup with the dealer and list of users playing.
	 * 
	 * @param dealer
	 * @param users
	 * @return
	 */
	public GT createTable(Dealer dealer, List<User> users);

	/**
	 * Creates the Game object for all Game logic to be processed
	 * 
	 * @return
	 */
	public G createGame();

}