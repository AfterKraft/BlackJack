package com.whitejack.api.event.handler;

public interface GameTableEventHandler {

	public void communicateToUser();

	public void playerWins();

	public void playerLoses();

	public void playerBets();

	public void playerSplits();

	public void playerDoubles();

	public void cardsSwept();

	public void cardShuffling();

	public void newGameBeginsSound();

	public void hitJackpot();

	public void cardTurnedUp();

	public void cardHitTable();
	// TODO Come up with GameTable Specific methods

}
