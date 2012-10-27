package com.whiejack;
import java.util.*;
import java.io.Serializable;

public class Deal {

	// Test driver for the Deck/Card classes
    public static void main(String args[]) {
    	
    	int numRounds = 2;
        int numPlayers = 5;
        int cardsPerRound = 1;
        Hand[] hands = new Hand[numPlayers];
        
        Deck deck = new Deck();
        deck.shuffle();

        System.out.println( "\nUsing hand.getCards" );
       	for (int j = 0; j < numPlayers; j++) {
    		hands[j] = new Hand();
       		for ( int i = 0; i < numRounds; i++ ) {
    			ArrayList<Card> cards = deck.deal( cardsPerRound );
    			hands[j].addCards( cards );
        	}
			System.out.println( "P" + (j+1) + ":" + hands[j].getCards() + ", " );
        }
        
        // Calc the value of players hand
        System.out.println( "Calc value of players hand:" );
        int k = 1;
        for ( Hand h : hands ) {
			System.out.print( "P" + (k++) + ":" + h.calcValue() + ", " );
        }
        
        // A second way:
        System.out.println( "\nUsing deck.deal()" );
        for ( int i = 0; i < numRounds; i++ ) {
        	for (int j = 0; j < numPlayers; j++)
        		System.out.print( "P" + (j+1) + ":" + deck.deal( cardsPerRound ) + ", " );
        	System.out.println();
        }
    }
}

//=============================================================================
//	Class Hand (consider to extend ArrayList)
class Hand {
	private List<Card> cards = new ArrayList<Card>();
	
	public Hand() {
		
	}
	
	public void addCard( Card card ) {
		cards.add( card );
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
	
	public int size() { return cards.size(); }
	public void clear() { cards.clear(); }

	public List<Card> getCards( ) {
		return cards;
	}
	
	public int calcValue() {
		int value = 0;
		for ( Card c : cards ) {
			value += c.getValue();
		}
		return value;
	}
}

//=============================================================================
//Class Deck
class Deck {
	private List<Card> deck = new ArrayList<Card>();
	private boolean isShuffled;
	
	public Deck() {
		for ( Card.Suit s : Card.Suit.values() )
			for ( Card.Rank r : Card.Rank.values() )
				deck.add( new Card( r, s ) );
		this.isShuffled = false;
	}
	
	
	public ArrayList<Card> deal( int n ) {
		int deckSize = deck.size();
		List<Card> tempHand = deck.subList( deckSize-n,  deckSize );
		ArrayList<Card> hand = new ArrayList<Card>( tempHand );
		tempHand.clear();	// make sure the sub-range is deleted from deck.
		return hand;
	}
	
	public void shuffle() {
        Collections.shuffle( this.deck );
	}
	
	public boolean isShuffled() { return isShuffled; }
}


//=============================================================================
//Class Card
class Card implements Serializable {
	
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
    
    public enum Rank { DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
    	EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);
    
    	final int value;
    	Rank( int value ) {
    		this.value = value;
    	}
    }

    private final Rank rank;
    private final Suit suit;
    
    public Card( Rank rank, Suit suit ) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank rank() { return rank; }
    public Suit suit() { return suit; }

	public int getValue() 	{ return rank.value; }
    
    public String toString() { return rank + " of " + suit; }
}

