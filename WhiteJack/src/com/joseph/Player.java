package com.joseph;

//import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
//import java.io.PrintStream;
//import java.io.UnsupportedEncodingException;

public class Player {

	public static final int BJ_BETSIZE = 5;
	private String name;
	private boolean isPlaying;
	private float chipCount = 200.0f;
	private float currentBet;
	private final List<Hand> hands = new ArrayList<Hand>(); 
	
	/** Player c'tors are responsible to create a default Hand.
	 * 
	 */
	public Player() {
		this.name = "Anonymous";
	}

	public Player( String name ) {
		this.name = name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void addHand() {
		Hand defaultHand = new Hand();
		hands.add( defaultHand );
	}

	public List<Hand> getHands() {
		return hands;
	}
	
	/** Return default hand */
	public Hand getHand() {
		assert( hands.size() == 1 );
		return hands.get( 0 );
	}
	
	/** Add a card to the default hand (first hand) */
	public void addCard( Card card ) {
		Hand defaultHand = hands.get( 0 );
		defaultHand.addCard( card );
		defaultHand.setBet( getCurrentBet() );	// this is called twice (NO NEED)!!
	}

	public void addCard( Card card, Hand hand ) {
		assert( hands.contains( hand ) );
		hands.get( hands.indexOf(hand) ).addCard( card );
	}
	
	public void setStatus( Hand hand, Hand.Status status ) {
		assert( hands.contains( hand ) );
		hand.setStatus( status );
	}
	
	public Hand splitHand( Hand hand ) {
		assert( hands.contains( hand ) );
		Hand newHand = hand.split();
		newHand.setBet( currentBet );
		hands.add( newHand );
		return newHand;
	}

	public void doubleBet( Hand hand ) {
		assert( hands.contains( hand ) );
		hand.setBet( 2 * currentBet );
	}

	/** Receive bet for default hand */
	public float receiveBet( Scanner scanner ) {

		System.out.format( "[Player:%s, Total:%.2f], place your bet=", getName(), chipCount );
		currentBet = 0.0f;
		try {
			if ( scanner.hasNextFloat() ) {
				currentBet = scanner.nextFloat();
				// System.err.println( "current bet=" + currentBet );
			}
		} catch ( InputMismatchException e ) {
			e.printStackTrace();
			scanner.next();
		}

		// Make sure hands array is empty, before adding a default hand
		hands.clear();
		if ( currentBet > 0.0f ) {
			Hand defaultHand = new Hand();
			defaultHand.setBet( currentBet );
			hands.add( defaultHand );		// Add a new Hand to first index
		}
		
        return currentBet;
	}
	
	/** receiveRequest method waits for the Player to make his move.
	 *  All options available to Player have already been communicated
	 *  to him, including which Hand he's currently playing.
	 * @param hand
	 * @return
	 */
	public synchronized int receiveRequest( Hand hand, Scanner scanner ) {
		
		List<Card> cards = hand.getCards( );

		System.out.format( "[Player:%s]-[hand:%d] ", getName(), hands.indexOf( hand) );		
		for ( Card c : cards ) {
			//System.out.print( c.toLabel() + "  " );
			System.out.print( c.toLabel() + " " );
		}
		System.out.print( "(Value:" + hand.calcValue() + ")");
/*		
		try {
			PrintStream out = new PrintStream( System.out, true, "UTF-16" );
			for ( Card c : cards ) {
				out.print( c.toLabel() );
			}
		} catch ( UnsupportedEncodingException e ) {
		}
*/
		System.out.format( "\nPlayer %s [hand:%d], select your choice " +
				"(0=STAND, 1=HIT, 2=DOUBLEDOWN, 5=SPLIT): ", getName(), hands.indexOf(hand) );
		
        int request = -1;
		try {
			if ( scanner.hasNextInt() ) {
				request = scanner.nextInt();
				// System.err.println( "request=" + request );
			}
		} catch ( InputMismatchException e ) {
			e.printStackTrace();
			scanner.next();
		}
        return request;
	}
	
	public void setPlaying( boolean isPlaying ) { this.isPlaying = isPlaying; }
	public boolean isPlaying() { return this.isPlaying; }
	

	/** Win: value > 0, Lose: value < 0, Push: value == 0 */
	public void setWinLosePush( Hand hand, float value ) {
		assert( hands.contains( hand ) );
		
		displayWinLosePushMessage( hand, value );
		
		hand.setBet( 0f );
//		if ( hands.indexOf( hand ) != 0 )
//			hands.remove( hand );
		addChipCount( value );
	}
	
	private void displayWinLosePushMessage( Hand hand, float value ) {
		if ( hand.getStatus() == Hand.Status.LOST ) {
			System.out.format( "[Player:%s, Total:%.2f]-[hand:%d, %s (Value:%d) LOST $%.2f]%n",
					getName(), getChipCount(), hands.indexOf(hand), hand.getCards(), hand.calcValue(), value );
		} else if ( hand.getStatus() == Hand.Status.WON ) {
			System.out.format( "[Player:%s, Total:%.2f]-[hand:%d, %s (Value:%d) WON $%.2f]%n",
					getName(), getChipCount(), hands.indexOf(hand), hand.getCards(), hand.calcValue(), value );
		} else {
			System.out.format( "[Player:%s, Total:%.2f]-[hand:%d, %s (Value:%d) PUSH $%.2f]%n",
					getName(), getChipCount(), hands.indexOf(hand), hand.getCards(), hand.calcValue(), value );
//			System.out.format( "Player %s [hand:%d push $%.2f%n]", getName(), hands.indexOf(hand), value );
		}
	}
	
	public void setChipCount( float chipCount ) {
		this.chipCount = chipCount;
	}
	public void addChipCount( float chipCount ) {
		this.chipCount += chipCount;
	}
	
	public float getChipCount()		{ return this.chipCount; }
	public float getCurrentBet()	{ return this.currentBet; }
}
