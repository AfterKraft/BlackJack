package com.whitejack.app;

import org.apache.log4j.Logger;

import com.whitejack.api.GameFactory;
import com.whitejack.api.GameMaker;
import com.whitejack.gofish.GoFishFactory;

public class WhiteFish {
	
	//initialize starting variables for startup
	//TODO: We have none yet.
	private static Logger log = Logger.getLogger("WhiteFish");
	
	//main thread to start application
	public static void main(String[] args) {
		
		//Print Activation messages for debugging
		log.info("====================\n"+"Welcome to WhiteFish\n");
		log.info("\n");
		
		//Start GameMaker
		GameMaker GM = new GameMaker();  //Initialize GameMaker
		GameFactory gf = new GoFishFactory();   //Initialize a BlackJack Game
		GM.initGame(gf);   //Start the Game making process
		GM.startGame();   //Start playing BlackJack
	}

}
