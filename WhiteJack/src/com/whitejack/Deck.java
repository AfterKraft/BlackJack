package com.whitejack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<Card>();
	private boolean isShuffled;
	
	public Deck() {
		populate();
		this.isShuffled = false;
	}
	
	public Card deal() {
		int deckSize = deck.size();
		Card c = deck.remove( deckSize - 1 );
		return c;
	}
	
	public ArrayList<Card> deal( int n ) {
		int deckSize = deck.size();
		List<Card> tempHand = deck.subList( deckSize-n,  deckSize );
		ArrayList<Card> hand = new ArrayList<Card>( tempHand );
		tempHand.clear();	// make sure the sub-range is deleted from deck.
		return hand;
	}
	
	public void shuffle() {
		if ( deck.size() < 52 ) {
			deck.clear();
			populate();
		}
		Collections.shuffle( this.deck );
		isShuffled = true;
	}
	
	public boolean isShuffled() { return isShuffled; }
	
	public int size() {
		return deck.size();
	}
	
	private void populate() {
		for ( Card.Suit s : Card.Suit.values() )
			for ( Card.Rank r : Card.Rank.values() )
				deck.add( new Card( r, s ) );
	}
}
