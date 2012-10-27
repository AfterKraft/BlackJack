package com.whitejack;

import com.whitejack.Player;

public class User extends Player {
	
	public String playerName;
	public boolean isActive;
	public java.util.Date dateCreated;

	public User() {
		
	}
	
	public User(String playerName, String userName) {
		this.playerName = playerName;
		this.userName = userName;
	}
	
	public int getCurrentBalance() {
		return this.balance;
	}
	
	public void displayStatus() {
		
	}

}
