package com.whitejack.app;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import com.whitejack.api.GameFactory;
import com.whitejack.api.GameMaker;
import com.whitejack.blackjack.BlackJackFactory;
import com.whitejack.gui.GUIManager;

public class WhiteJack {
	
	//initialize starting variables for startup
	//TODO: We have none yet.
	private static Logger log = Logger.getLogger("WhiteJack");
	
	//main thread to start application
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		
		//Print Activation messages for debugging
		log.info("====================\n"+"Welcome to WhiteJack\n");
		log.info("\n");
		
		//Start GameMaker
		GameMaker GM = new GameMaker();  //Initialize GameMaker
		GameFactory gf = new BlackJackFactory();   //Initialize a BlackJack Game
		GM.setupGame(gf);   //Start the Game making process
		GM.startGame();   //Start playing BlackJack
		
		GUIManager gui = new GUIManager();
		gui.startGUI();
	}

}
