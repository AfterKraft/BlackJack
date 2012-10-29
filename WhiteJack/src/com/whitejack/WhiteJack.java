package com.whitejack;

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
		GM.initGame(1);
	}

}
