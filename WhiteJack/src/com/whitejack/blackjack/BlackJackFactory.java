package com.whitejack.blackjack;

import com.whitejack.api.Dealer;
import com.whitejack.api.Deck;
import com.whitejack.api.Game;
import com.whitejack.api.GameFactory;
import com.whitejack.api.User;

/**
 * BlackJackFactory
 * @author gabizou
 *
 */

public class BlackJackFactory implements GameFactory {

	@Override
	public Game createGame(Dealer dealer, Deck deck, User user) {
		
		return new BlackJack(dealer, deck, user);
	}
}
