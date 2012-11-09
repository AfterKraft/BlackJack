package com.joseph.gui;

import java.io.Serializable;


public class Card implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Suit { Clover, Diamond, Heart, Spade }
//	public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

	public enum Rank { Deuce(2), Three(3), Four(4), Five(5), Six(6), Seven(7),
		Eight(8), Nine(9), Ten(10), Jack(10), Queen(10), King(10), Ace(11);

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

//	public String toString() { return rank + " of " + suit; }
	@Override public String toString() {
		
		String sCard = "";
		switch ( rank ) {
		case Jack:	sCard = "Jack";	break;
		case Queen: sCard = "Queen"; break;
		case King:	sCard = "King"; break;
		case Ace:	sCard = "Ace"; break;
		case Deuce: case Three: case Four: case Five: case Six: case Seven: case Eight: case Nine: case Ten:
			sCard = Integer.toString( getValue() );
			break;
		}
		
		sCard = sCard + suit;
		return sCard;
	}
	
	public String toLabel() {
		String sRank = "";
		switch ( rank() ) {
		case Jack:	sRank = "J"; break;
		case Queen: sRank = "Q"; break;
		case King:	sRank = "K"; break;
		case Ace:	sRank = "A"; break;
		case Deuce: case Three: case Four: case Five: case Six: case Seven: case Eight: case Nine: case Ten:
			sRank = Integer.toString( getValue() );
			break;
		}
		String sSuit = "";
		switch ( suit() ) {
		case Clover:  sSuit = "\u2663"; break;
		case Diamond: sSuit = "\u2666"; break;
		case Heart:   sSuit = "\u2665"; break;
		case Spade:	  sSuit = "\u2660";	break;
		}
		
		return sRank + ":" + sSuit;
	}
	
}

