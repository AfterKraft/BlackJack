package com.whiejack;
import java.util.ArrayList;
import java.util.List;


// The Player Session class keeps track of which of Player's hands/split-hands
// to communicate with.
public class PlayerSession {
	private Player player;
	private Hand currentHand;
	
	PlayerSession( Player player ) {
		this.player = player;
	}
	
	public void addCard( Card c ) {
		currentHand.addCard( c );
	}
	
}


public class Player {

	private Hand[] splitHand;
	private int chipCount = 100;
	
	public Player() {
		splitHand = new Hand[4];	// At most split can have 4-way hand
	}
	
	public void addCard( Card c, int splitIndex ) {
		assert( splitIndex >= 0 && splitIndex < 4 );
		if ( splitHand[splitIndex] == null ) {
			splitHand[splitIndex] = new Hand();
		}
		splitHand[splitIndex].addCard( c );
	}

	// Split a hand into 2 sub-hands
	public void splitHand( int splitIndex ) {
		assert( splitIndex >= 0 && splitIndex < 4 );
		assert( splitHand[splitIndex] != null );

		Hand h = splitHand[splitIndex];
		assert( h.size() == 2 );
		Card c = h.removeCard( 1 );		// remove the last card of current split hand
		
		// Add the hand to next index in the splitHand array;
		int newHandIndex = splitIndex++;
		splitHand[ newHandIndex ] = new Hand();
		
		// Add the card removed froma above to new hand
		splitHand[ newHandIndex ].addCard( c );
	}

	public Hand getHand( int splitIndex ) {
		assert( splitIndex >= 0 && splitIndex < 4 );
		return splitHand[splitIndex]; 
	}
	
	public void setChipCount( int chipCount ) {
		this.chipCount = chipCount;
	}
	
	public int getChipCount() {	return this.chipCount; }
	
	public int reduceChipCount( int chipCount ) {
		this.chipCount -= chipCount;
		return this.chipCount;
	}
}
