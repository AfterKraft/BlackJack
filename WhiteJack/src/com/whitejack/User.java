package com.whitejack;
import java.util.Calendar;

import com.whitejack.Player;
import com.whitejack.Utility.Time;

public class User extends Player {
	
	public String playerName;
	public boolean isActive;
	public String dateCreated;
	public boolean isPlayable= true;

	/** 
	 * User constrcutor creates a default user of default balance and generic
	 * username and stores the dateCreated as a string for storage purposes
	 */
	public User() {
		
		String playerName = "DefaultUser";
		boolean isPlayable = true;
		Time time = new Time();
		dateCreated = time.getCurrentTime();
		
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
