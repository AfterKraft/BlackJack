package com.whitejack;

import java.util.ArrayList;
import java.util.List;


public class Hand {

    public enum Status { PLAYING, STANDING, WON, LOST, TIE, BJ_WON  }
    private Status status;

	private List<Card> cards = new ArrayList<Card>();
	private float bet;
	
	public Hand() {
		this.status = Status.PLAYING;
	}
	
	public void addCard( Card card ) {
		int size = cards.size();
		cards.add( card );
		assert( cards.size() == size + 1 );
	}
	
	public void addCards( ArrayList<Card> cards ) {
		this.cards.addAll( cards );
	}
	
	public boolean removeCard( Card card ) {
		assert( cards.contains( card ));
		return cards.remove( card );
	}
	
	public Card removeCard( int index ) {
		return cards.remove( index );
	}

	public Hand split() {
		assert( cards.size() == 2 );
		Card card = removeCard( 1 );
		Hand hand = new Hand();
		hand.addCard( card );
		return hand;
	}
	
	public void setStatus( Status status ) {
		this.status = status;
	}
	public Status getStatus() {
		return status;
	}
	
	public int size() { return cards.size(); }
	public void clear() { cards.clear(); }

	public List<Card> getCards( ) {
		return cards;
	}
	
	public int calcValue() {
		int handValue = 0;
		int numOfAces = 0;
		// First calculate minimum hand (Ace=1)
		for ( Card card : cards ) {
			int cardValue = card.getValue();
			if ( cardValue == 1 ) {
				numOfAces += 1;
			}
			handValue += cardValue;
		}
		
		// At most we can take advantage of 1 Ace
		if ( numOfAces > 0 && handValue < 12 ) {
			handValue += 10;
		}
		
		return handValue;
	}
	
	public void setBet( float bet ) {
		this.bet = bet;
	}
	
	public float getBet() {
		return bet;
	}
	
}
