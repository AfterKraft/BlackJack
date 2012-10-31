package com.whitejack.api;

import java.util.logging.Logger;

import com.whitejack.api.Player;
import com.whitejack.util.Time;

public class User extends Player {
	
	public String playerName;
	public String dateCreated;
	public int bet;
	public int balance;
	private static Logger logger = Logger.getLogger(User.class.getName());

	/** 
	 * User constrcutor creates a default user of default balance and generic
	 * username and stores the dateCreated as a string for storage purposes
	 */
	public User() {
		
		logger.warning("[User] Making a Default User!");  //Debugging Line
		balance = 300;
		playerName = "DefaultUser";
		userName = playerName;
		isPlayable = true;
		Time time = new Time();
		dateCreated = time.getCurrentTime();
		logger.warning("[User] Default user created!");  //Debugging Line
		
	}
	
	public User(String playerName, String userName) {
		this.playerName = playerName;
		this.userName = userName;
		Time time = new Time();
		dateCreated = time.getCurrentTime();
		isPlayable = true;
		balance = 300;
		logger.info("[User] User "+playerName+" has been created!");  //Debugging Line
	}
	
	public void bet(int amount) {
		balance -= amount;
		logger.finest("[User] The user: "+playerName+"'s balance has be deducted by "+ amount);  //Debugging Line
	}
	
	public int getCurrentBalance() {
		return this.balance;
	}
	
	public void recieveMoney(int amount) {
		balance +=amount;
		logger.finest("[User] The user: "+playerName+"'s balance has be replenished by "+ amount);  //Debugging Line
	}
	
	public void displayStatus() {
		
	}

}
