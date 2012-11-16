package com.whitejack.blackjack;

import java.util.List;
import java.util.Scanner;

import com.whitejack.api.Dealer;
import com.whitejack.api.GameTable;
import com.whitejack.api.User;

public class BlackJackGameTable extends GameTable {



	/**
	 * Creates a container for the User and dealer
	 * 
	 * @param dealer
	 * @param users
	 */
	public BlackJackGameTable(Dealer dealer, List<User> users) {
		super(dealer, users);
	}

	/**
	 * Sets up the GameTable taking user bets for all players in 
	 * playable <User> list.
	 */
	public void setupTable() {
		for(User user : users) {
			Scanner bet = new Scanner(System.in);
			System.out.print(user.userName+", how much would you like to bet?");
			while(!bet.hasNextInt()) {
				System.out.println("Please enter a number!");
				bet.nextLine();
			}
			int betAmmount=bet.nextInt();
			do{
				System.out.println(user.userName+", you can't bet more than you have!");
				System.out.println(user.userName+", for reference, you have "+user.balance);
				betAmmount= bet.nextInt();
			} while(betAmmount>user.balance);
			user.bet(betAmmount);
		}
		super.isSetUp = true;
	}

	/**
	 * Plays a round for each user in the <User> list
	 * 
	 * End of round should request if game should be replayed
	 */
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
