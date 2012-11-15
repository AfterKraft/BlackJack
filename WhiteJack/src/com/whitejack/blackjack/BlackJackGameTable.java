package com.whitejack.blackjack;

import java.util.List;

import com.whitejack.api.Dealer;
import com.whitejack.api.GameTable;
import com.whitejack.api.User;

public class BlackJackGameTable extends GameTable {
	
	

	public BlackJackGameTable(Dealer dealer, List<User> users) {
		super(dealer, users);
	}
	@Override
	public void playGame() {
		initialize();
		shuffle();
		boolean run = true;
		do {
			for (User user : users) {
				run = play(user);
				if(!run)
					break;
			}
		} while (run);
		gameOver();

		
	}

	@Override
	public void getCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean play(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void gameOver() {
		// TODO Auto-generated method stub
		
	}

	

}
