package com.joseph;

public class Deal {

    public static void main(String args[]) {
    	
    	Server server = new Server();
    	server.tableSession();
    	
    }
	
	// Test driver for the Deck/Card classes
	/*
    public static void main(String args[]) {
    	
    	int numRounds = 2;
        int numPlayers = 5;
        int cardsPerRound = 1;
        Hand[] hands = new Hand[numPlayers];
        
        Deck deck = new Deck();
        deck.shuffle();

        System.out.println( "\nUsing hand.getCards" );
       	for (int j = 0; j < numPlayers; j++) {
    		hands[j] = new Hand();
       		for ( int i = 0; i < numRounds; i++ ) {
    			ArrayList<Card> cards = deck.deal( cardsPerRound );
    			hands[j].addCards( cards );
        	}
			System.out.println( "P" + (j+1) + ":" + hands[j].getCards() + ", " );
        }
        
        // Calc the value of players hand
        System.out.println( "Calc value of players hand:" );
        int k = 1;
        for ( Hand h : hands ) {
			System.out.print( "P" + (k++) + ":" + h.calcValue() + ", " );
        }
        
        // A second way:
        System.out.println( "\nUsing deck.deal()" );
        for ( int i = 0; i < numRounds; i++ ) {
        	for (int j = 0; j < numPlayers; j++)
        		System.out.print( "P" + (j+1) + ":" + deck.deal( cardsPerRound ) + ", " );
        	System.out.println();
        }
    }
    */
}

