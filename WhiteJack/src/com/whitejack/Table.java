package com.whitejack;

import java.util.List;

public class Table {

	private List<Player> players;
	private Dealer dealer;
	
	public Table() {
		this.dealer = new Dealer();
	}
	
	public void addPlayer( Player p ) {
		players.add( p );
	}
	
	public void removePlayer( Player p ) {
		players.remove( p );
	}
}



class Dealer {

	private String name;
	private float chipCount = 10000.00f;
	private Hand hand;
	
	public Dealer() {
		hand = new Hand();
	}

	public Dealer( String name ) {
		this.name = name;
		hand = new Hand();
	}
	
	public void setName( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void addCard( Card card ) {
		// By default add a card to first hand
		hand.addCard( card );
	}
	
	public Hand getHand() {
		return hand; 
	}
	
	public void setChipCount( float chipCount ) {
		this.chipCount = chipCount;
	}
	public void addChipCount( float chipCount ) {
		this.chipCount += chipCount;
	}
	public void reduceChipCount( float chipCount ) {
		this.chipCount -= chipCount;
	}
	
	
}
