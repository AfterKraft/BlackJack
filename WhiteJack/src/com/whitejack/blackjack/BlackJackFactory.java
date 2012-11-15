package com.whitejack.blackjack;

import java.util.List;

import com.whitejack.api.Dealer;
import com.whitejack.api.Deck;
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
	public GameTable createGame(Dealer dealer, List<User> users) {
		
		return new BlackJackTable(dealer, users);
	}

}
