package com.whitejack.app;

import com.whitejack.api.GameFactory;
import com.whitejack.api.GameMaker;
import com.whitejack.blackjack.BlackJackFactory;

public class WhiteJack {
	
	//initialize starting variables for startup
	//TODO: We have none yet.
	
	//main thread to start application
	public static void main(String[] args) {
		
		//Print Activation messages for debugging
		System.out.println("====================\n"+"Welcome to WhiteJack\n");
		System.out.println("");
		
		//Start GameMaker
		GameMaker GM = new GameMaker();
		GameFactory gf = new BlackJackFactory();
		GM.initGame(gf);
		GM.startGame();
	}

}
