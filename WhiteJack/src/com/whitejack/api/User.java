package com.whitejack.api;



import org.apache.log4j.Logger;

import com.whitejack.api.Player;
import com.whitejack.util.Time;

public class User extends Player {
	
	public String playerName;
	public String dateCreated;
	public int bet;
	private static Logger log = Logger.getLogger("WhiteJack");
	
	/** 
	 * User constructor creates a default user of default balance and generic
	 * username and stores the dateCreated as a string for storage purposes
	 */
	public User() {
		
		log.warn("[User] Making a Default User!");  //Debugging Line
		super.balance = 300;
		playerName = "DefaultUser";
		userName = playerName;
		isPlayable = true;
		Time time = new Time();
		dateCreated = time.getCurrentTime();
		log.warn("[User] Default user created!");  //Debugging Line
		
	}
	
	/**
	 * Creates a customized User 
	 * @param playerName
	 * @param userName
	 */
	public User(String playerName, String userName) {
		this.playerName = playerName;
		this.userName = userName;
		Time time = new Time();
		dateCreated = time.getCurrentTime();
		isPlayable = true;
		super.balance = 300;
		//TODO try to save User's in a file list of sorts.
		log.info("[User] User "+playerName+" has been created!");  //Debugging Line
	}
	
	public void bet(int amount) {
		super.balance -= amount;
		log.debug("[User] The user: "+userName+"'s balance has be deducted by "+ amount);  //Debugging Line
	}
	
	public int getCurrentBalance() {
		return this.balance;
	}
	
	public void recieveMoney(int amount) {
		balance +=amount;
		log.debug("[User] The user: "+playerName+"'s balance has be replenished by "+ amount);  //Debugging Line
	}
	
	public void displayStatus() {
		
	}

}
