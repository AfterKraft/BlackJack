package com.whitejack.blackjack;

import java.util.List;

import com.whitejack.api.Dealer;
import com.whitejack.api.Game;
import com.whitejack.api.GameFactory;
import com.whitejack.api.GameTable;
import com.whitejack.api.User;

/**
 * BlackJackFactory
 * @author gabizou
 *
 */

public class BlackJackFactory implements GameFactory {

	@Override
	public GameTable createTable(Dealer dealer, List<User> users) {
		// TODO Auto-generated method stub
		return new BlackJackGameTable(dealer, users);
	}

	@Override
	public Game createGame() {
		// TODO Auto-generated method stub
		return new BlackJackGame();
	}
}
