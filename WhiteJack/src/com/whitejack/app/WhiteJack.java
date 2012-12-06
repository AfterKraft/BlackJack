package com.whitejack.app;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import com.whitejack.api.GameMaker;
import com.whitejack.blackjack.BlackJackFactory;
import com.whitejack.blackjack.BlackJackGame;
import com.whitejack.blackjack.BlackJackGameTable;
import com.whitejack.gui.GUIManager;

public class WhiteJack {

	// initialize starting variables for startup
	// TODO: We have none yet.
	private static Logger log = Logger.getLogger("WhiteJack");

	// main thread to start application
	public static void main(String[] args) {

		BasicConfigurator.configure();

		log.info("====================\n" + "Welcome to WhiteJack\n");
		log.info("\n");

		// Start GameMaker
		GameMaker<BlackJackGame, BlackJackGameTable, BlackJackFactory> GM = new GameMaker<BlackJackGame, BlackJackGameTable, BlackJackFactory>(4); // Initialize

		GM.gameFactory = new BlackJackFactory();
		GM.setupGame(); // Start the Game making process

		GUIManager gui = new GUIManager();
		log.info("\ngui opened");
		gui.startGUI();
	}

}
