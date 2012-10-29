package com.whitejack;

import com.whitejack.*;
import com.whitejack.Audio.*;
import com.whitejack.GUIManager.*;

public class GameMaker {
	
	
	public void GameMaker() {
		
	}
	
	/**
	 * Adds the player to the game and sets their isActiveUser to true for 
	 * system checks. 
	 * @param player
	 */
	public void addPlayer(Player player) {
		
		//Debug line for verification of Starting addPlayer() method
		player.isActiveUser = true;
		System.out.println("Player: "+ player.userName+ " has been added to the game!");
		
	}
	
	/**
	 * API comment: Removes a player of type Player from the Game. GameMaker 
	 * sets the Player to be unplayable unless the player object is playable
	 * set by the addPlayer method.
	 * @param player
	 */
	
	public void removePlayer(Player player) {
		//Sets the boolean states to false for any system checks
		player.isPlayable = false;
		player.isActiveUser = false;
		
	}

	public void initGame() {

	}

	public void saveGame() {

	}

	public void resumeGame() {

	}

	public void getCard() {

	}
	public void setCard() {

	}

	public void getWinHand() {

	}

}
