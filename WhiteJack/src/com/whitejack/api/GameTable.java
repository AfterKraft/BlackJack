package com.whitejack.api;

import java.util.List;

/**
 * A table to contain players, uses Game as needed for game specific
 * methods/steps
 * 
 * @author gabizou
 * 
 */
public abstract class GameTable<G extends Game> {

	public Object Background;
	public Object TableLayout;
	protected Deck deck;
	protected List<User> users;
	protected Dealer dealer;
	protected boolean isSetUp;
	protected G game;

	protected GameTable(Dealer dealer, List<User> users) {
		this.users = users;
		this.dealer = dealer;
	}

	abstract protected void setupTable();

	abstract protected void getCard();

	abstract protected void shuffle();

	abstract protected void initialize();

	abstract protected void removePlayer(User user);

	public void playGame() {
		initialize();
		shuffle();
		boolean run = true;
		do {
			getCard();
			for (User user : users) {
				run = play(user);
				if (!run)
					break;
			}
		} while (run);
		gameOver();
	}

	/**
	 * Enable the UI widgets to indicate it's the user's turn to play. Enable
	 * the UI widgets so that the user can indicate his/her move; optionally
	 * requesting quitting the game.
	 * 
	 * @param user
	 * @return true if we are to continue the game; false if the player
	 *         requested quitting the game.
	 */
	abstract protected boolean play(User user);

	abstract protected void gameOver();

	abstract protected void startGame();
}