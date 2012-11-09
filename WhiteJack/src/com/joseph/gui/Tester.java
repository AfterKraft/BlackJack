package com.joseph.gui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;


public class Tester {
	
	static List<String> playerNames = new ArrayList<String>(
			Arrays.asList( "Yossi", "David", "Gabe", "Ramel", "Kevin", "Rory" )
			);
	
	static PlayerView mainPlayerView;

	// Move the following method to actual class
	public static void setMainPlayerView( PlayerView playerView ) {
		mainPlayerView = playerView;
	}
	
	// Move the following method to actual class
	public static void displayInPlayerMainView( Player2ndView player2ndView ) {

		mainPlayerView.removeAll();
		
		JPanel handsArea = player2ndView.getHandsArea();
		for ( Component hv : handsArea.getComponents() ) {
			Hand2ndView hand2ndView = (Hand2ndView)hv;
			
			HandView handView = new HandView();
			
			for ( Component cv : hand2ndView.getComponents() ) {
				CardLabelView cardLabelView = (CardLabelView)cv;
				Card card = cardLabelView.getCard();
				
				handView.add( new CardView( card ) );
			}
			
			mainPlayerView.add( handView );
		}
		
		mainPlayerView.validate();
	}

	
	public static void testDealerView( DealerView dealerView ) {
		
		CardView.DEFAULT_WIDTH = 80;
		HandView handView = new HandView();
		handView.add( new CardView( new Card( Card.Rank.Ace, Card.Suit.Spade) ) );
		handView.add( new CardView( new Card( Card.Rank.Ten, Card.Suit.Clover) ) );
		handView.add( new CardView( new Card( Card.Rank.Queen, Card.Suit.Heart ) ) );

		dealerView.add( handView );
	}
	

	public static List<String> getPlayerNames() {
		return playerNames;
	}
	
	public static void testPlayerMainView( PlayerView playerView ) {
		
		HandView handView1 = new HandView();
		HandView handView2 = new HandView();
		HandView handView3 = new HandView();

		CardView.DEFAULT_WIDTH = 60;
		
		handView1.add( new CardView( new Card( Card.Rank.Ace, Card.Suit.Spade) ) );
		handView1.add( new CardView( new Card( Card.Rank.Ten, Card.Suit.Clover) ) );

		handView2.add( new CardView( new Card( Card.Rank.Three, Card.Suit.Clover) ) );
		handView2.add( new CardView( new Card( Card.Rank.Deuce, Card.Suit.Clover) ) );
		handView2.add( new CardView( new Card( Card.Rank.Nine, Card.Suit.Spade)) );
		handView2.add( new CardView( new Card( Card.Rank.King, Card.Suit.Diamond ) ) );
		handView2.add( new CardView( new Card( Card.Rank.Queen, Card.Suit.Heart ) ) );
		handView2.add( new CardView( new Card( Card.Rank.Jack, Card.Suit.Clover) ) );

		handView3.add( new CardView( new Card( Card.Rank.Four, Card.Suit.Heart) ) );
		
		playerView.add( handView1 );
		playerView.add( handView2 );
		playerView.add( handView3 );
	}
	
	public static void testPlayersWithHands( Component[] players ) {

		testPlayer0( (Player2ndView)players[0] );
		testPlayer1( (Player2ndView)players[1] );
		testPlayer2( (Player2ndView)players[2] );
		testPlayer3( (Player2ndView)players[3] );
//		testPlayer4( (Player2ndView)players[4] );
		testPlayer5( (Player2ndView)players[5] );
	}
		
	public static void testPlayer0( Player2ndView playerView ) {
		Hand2ndView handView1 = new Hand2ndView();
		Hand2ndView handView2 = new Hand2ndView();
		Hand2ndView handView3 = new Hand2ndView();

		handView1.add( new CardView( new Card( Card.Rank.Jack, Card.Suit.Spade) ) );
		handView1.add( new CardView( new Card( Card.Rank.Ten, Card.Suit.Clover) ) );
	
		handView2.add( new CardView( new Card( Card.Rank.Three, Card.Suit.Clover) ) );
		handView2.add( new CardView( new Card( Card.Rank.Deuce, Card.Suit.Clover) ) );
		handView2.add( new CardView( new Card( Card.Rank.Nine, Card.Suit.Spade)) );
		handView2.add( new CardView( new Card( Card.Rank.King, Card.Suit.Diamond ) ) );
		handView2.add( new CardView( new Card( Card.Rank.Queen, Card.Suit.Heart ) ) );
		handView2.add( new CardView( new Card( Card.Rank.Jack, Card.Suit.Clover) ) );

		handView3.add( new CardView( new Card( Card.Rank.Four, Card.Suit.Heart) ) );

		playerView.getHandsArea().add( handView1 );
		playerView.getHandsArea().add( handView2 );
		playerView.getHandsArea().add( handView3 );
	}

	public static void testPlayer1( Player2ndView playerView ) {
		Hand2ndView handView1 = new Hand2ndView();
		Hand2ndView handView2 = new Hand2ndView();

		handView1.add( new CardView( new Card( Card.Rank.Ace, Card.Suit.Spade) ) );
		handView1.add( new CardView( new Card( Card.Rank.Ten, Card.Suit.Clover) ) );

		handView2.add( new CardView( new Card( Card.Rank.Three, Card.Suit.Clover) ) );
		handView2.add( new CardView( new Card( Card.Rank.Deuce, Card.Suit.Clover) ) );
		handView2.add( new CardView( new Card( Card.Rank.Queen, Card.Suit.Heart ) ) );
		handView2.add( new CardView( new Card( Card.Rank.Jack, Card.Suit.Clover) ) );
		
		playerView.getHandsArea().add( handView1 );
		playerView.getHandsArea().add( handView2 );
	}

	public static void testPlayer2( Player2ndView playerView ) {
		Hand2ndView handView1 = new Hand2ndView();

		handView1.add( new CardView( new Card( Card.Rank.Ace, Card.Suit.Spade) ) );
		handView1.add( new CardView( new Card( Card.Rank.Ten, Card.Suit.Clover) ) );
		handView1.add( new CardView( new Card( Card.Rank.Three, Card.Suit.Clover) ) );
		handView1.add( new CardView( new Card( Card.Rank.Deuce, Card.Suit.Clover) ) );
		
		playerView.getHandsArea().add( handView1 );
	}

	public static void testPlayer3( Player2ndView playerView ) {
		Hand2ndView handView1 = new Hand2ndView();
		Hand2ndView handView2 = new Hand2ndView();

		handView1.add( new CardView( new Card( Card.Rank.Ace, Card.Suit.Spade) ) );
		handView1.add( new CardView( new Card( Card.Rank.Ten, Card.Suit.Clover) ) );
		handView1.add( new CardView( new Card( Card.Rank.Three, Card.Suit.Clover) ) );
		handView1.add( new CardView( new Card( Card.Rank.Deuce, Card.Suit.Clover) ) );

		handView2.add( new CardView( new Card( Card.Rank.Nine, Card.Suit.Spade)) );
		handView2.add( new CardView( new Card( Card.Rank.King, Card.Suit.Diamond ) ) );
		handView2.add( new CardView( new Card( Card.Rank.Queen, Card.Suit.Heart ) ) );
		handView2.add( new CardView( new Card( Card.Rank.Jack, Card.Suit.Clover) ) );
		
		playerView.getHandsArea().add( handView1 );
		playerView.getHandsArea().add( handView2 );
	}

	public static void testPlayer4( Player2ndView playerView ) {
		Hand2ndView handView1 = new Hand2ndView();

		handView1.add( new CardView( new Card( Card.Rank.King, Card.Suit.Heart) ) );
		handView1.add( new CardView( new Card( Card.Rank.Queen, Card.Suit.Heart) ) );

		playerView.getHandsArea().add( handView1 );
	}

	public static void testPlayer5( Player2ndView playerView ) {
		Hand2ndView handView1 = new Hand2ndView();
		Hand2ndView handView2 = new Hand2ndView();

		handView1.add( new CardView( new Card( Card.Rank.Jack, Card.Suit.Spade) ) );
		handView1.add( new CardView( new Card( Card.Rank.Ten, Card.Suit.Heart) ) );

		handView2.add( new CardView( new Card( Card.Rank.Four, Card.Suit.Heart) ) );

		playerView.getHandsArea().add( handView1 );
		playerView.getHandsArea().add( handView2 );
	}

}
