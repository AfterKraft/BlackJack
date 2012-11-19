package com.whitejack.blackjack;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.whitejack.api.Dealer;
import com.whitejack.api.GameTable;
import com.whitejack.api.User;
import com.whitejack.api.applets.BetHandler;

public class BlackJackGameTable extends GameTable {

	private static final Logger log = Logger.getLogger("WhiteJack");
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
	@Override
	public void setupTable() {
		int a=0;
		for(User user : users) {
			Scanner sac = new Scanner(System.in);
			log.debug("[BlackJackGameTable] inside setupTable() method");
			log.info(user.userName+", how much would you like to bet?");
			while(sac.hasNextLine() && !sac.hasNextInt()) {
				System.out.println("Please enter a number!\n");
				a = sac.nextInt();
				log.debug("The value for a is:"+a);
			}
			log.debug("The value for a OUTSIDE THE WHILE LOOP is:"+a);
			int betAmmount=a;
			if(betAmmount>user.balance) {
				do{
					System.out.println(user.userName+", you can't bet more than you have!");
					System.out.println(user.userName+", for reference, you have "+user.balance);
					betAmmount= sac.nextInt();
				} while(betAmmount>user.balance);
			}

			user.bet(betAmmount);
			sac.close();
		}
		super.game = new BlackJackGame();
		super.isSetUp = true;
	}
	/**
	 * Removes the User with userName matching from the GameTable
	 * 
	 * This can be called if a player can NOT play (isPlayable=false)
	 * @param user
	 */

	@Override
	public void removePlayer(User user) {
		//Sets the boolean states to false for any system checks
		//User temp = new User(User user);
		log.debug("User name to remove is: "+user.userName);
		int index= -1;
		for(int i=0; i<super.users.size(); i++) {
			User temp1 = super.users.get(i);
			log.debug("Temp1;s username is: "+temp1.userName);
			log.debug("Temp's name is :"+user.userName);
			if (temp1.userName.equals(user.userName)) {
				index = super.users.indexOf(temp1);
			} else {
			}
		}
		log.debug("the index to be removed is: "+index);
		super.users.remove(index);
		log.debug("[BlackJackGameTable] The requested user has been removed from the GameTable User list");
	}

	/*
	 * (non-Javadoc)
	 * For now we'll have to be downcasting to BlackJackGame. Yes, it's 
	 * not something we want to be doing, but to do otherwise,
	 * we'll have to implement Generics
	 * 
	 * @see com.whitejack.api.GameTable#startGame()
	 */
	/**
	 * Starts a round of the game. Need to implement the new
	 * DeckArrayManager
	 */
	@Override
	protected void startGame() {
		this.game = new BlackJackGame();

		game.play();
		for(User user: users) {
			((BlackJackGame)game).requestCard(user);
			((BlackJackGame)game).doubleDown(user);
			((BlackJackGame)game).split(user);
		}



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
