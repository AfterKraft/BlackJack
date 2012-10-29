package com.whitejack;

import com.whitejack.Player;
import com.whitejack.Utility.Time;

public class User extends Player {
	
	public String playerName;
	public String dateCreated;
	public int bet;

	/** 
	 * User constrcutor creates a default user of default balance and generic
	 * username and stores the dateCreated as a string for storage purposes
	 */
	public User() {
		balance = 300;
		playerName = "DefaultUser";
		userName = playerName;
		isPlayable = true;
		Time time = new Time();
		dateCreated = time.getCurrentTime();
		
	}
	
	public User(String playerName, String userName) {
		this.playerName = playerName;
		this.userName = userName;
	}
	
	public void bet(int amount) {
		balance -= amount;
	}
	
	public int getCurrentBalance() {
		return this.balance;
	}
	
	public void recieveMoney(int amount) {
		balance +=amount;
	}
	
	public void displayStatus() {
		
	}

}
