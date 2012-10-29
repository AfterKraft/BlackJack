package com.whitejack;

public abstract class Player {
	
	//Set default variables
	public String userName;
	protected int[] Hand;
	public boolean isActiveUser = false;
	public int balance;
	public boolean isPlayable;
	
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
