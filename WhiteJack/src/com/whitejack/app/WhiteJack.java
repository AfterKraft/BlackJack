package com.whitejack.app;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import com.whitejack.api.DeckArrayManager;
import com.whitejack.api.GameFactory;
import com.whitejack.api.GameMaker;
import com.whitejack.api.applets.BetHandler;
import com.whitejack.blackjack.BlackJackFactory;
import com.whitejack.gui.GUIManager;

public class WhiteJack {
	
	//initialize starting variables for startup
	//TODO: We have none yet.
	private static Logger log = Logger.getLogger("WhiteJack");
	
	//main thread to start application
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		// the following lines of code are for TESTING only OTHERWISE
		//THEY SHOULD BE COMMENTED OUT************************
		//DeckArrayManager d = DeckArrayManager.getDeckArrayManager();

		//END OF TESTING CODE***************
		
		//Print Activation messages for debugging
		log.info("====================\n"+"Welcome to WhiteJack\n");
		log.info("\n");
		
		//Start GameMaker
		GameMaker GM = new GameMaker();  //Initialize GameMaker
		log.info("\nSuccessfully launched GameMaker");
		GameFactory gf = new BlackJackFactory();   //Initialize a BlackJack Game
		log.info("\nSuccessfully initialized BlackJackFactory!");
		GM.setupGame(gf);   //Start the Game making process
		log.info("\nSuccessfully called setUpGame() method");
		GM.startGame();   //Start playing BlackJack
		GUIManager gui = new GUIManager();
		log.info("\ngui opened");
		gui.startGUI();
	}

}

