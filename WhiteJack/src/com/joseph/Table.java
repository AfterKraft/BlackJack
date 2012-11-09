package com.joseph;

import java.util.List;

public class Table {

	private List<Player> players;
	public Table() {
		new Dealer();
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
	}
	public void addChipCount( float chipCount ) {
	}
	public void reduceChipCount( float chipCount ) {
	}
	
	
}
