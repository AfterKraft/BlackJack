package com.whitejack.gofish;

import com.whitejack.api.Dealer;
import com.whitejack.api.Deck;
import com.whitejack.api.Game;
import com.whitejack.api.GameFactory;
import com.whitejack.api.User;

public class GoFishFactory implements GameFactory {

	@Override
	public Game createGame(Dealer dealer, Deck deck, User user) {
		// TODO Auto-generated method stub
		return new GoFish(dealer, deck, user);
	}

}
