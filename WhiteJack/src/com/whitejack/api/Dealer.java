package com.whitejack.api;

public class Dealer extends Player {
	
	public boolean isPlayable = false;
	public String userName= "Dealer";
	public final String playerName="Dealer";
	public boolean isActiveUser = false;
	
	protected int handValue;
	protected int balance;

	
	public Dealer() {
		super.userName = userName;
		
		
	}
	
	public void clearTable() {
		
	}
	
	public void dealHand() {
		
	}

}
