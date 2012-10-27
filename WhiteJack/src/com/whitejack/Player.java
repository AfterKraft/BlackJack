package com.whitejack;

public abstract class Player {
	
	public String userName;
	protected int[] Hand;
	public boolean isActiveUser;
	public int balance;
	
	public Player() {
		
	}
	
	public Player(String username) {
		
	}
	
	public void stand() {
		
	}
	
	public void hit() {
		
	}
	
	public void surrender() {
		
	}
	
	public void split() {
		
	}
	
	public void doubleDown() {
		
	}
	
	public int getHandValue() {
		return Hand[0];
		
	}
	
	public void quitGame() {
		
	}

}
