package com.joseph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;


public class Server {
	
	private final Scanner scanner = new Scanner( System.in );

	public static final int BJ_STAND = 0;
	public static final int BJ_HIT = 1;
	public static final int BJ_DOUBLEDOWN = 2;
	public static final int BJ_SURRENDER = 3;
	public static final int BJ_INSURANCE = 4;
	public static final int BJ_SPLIT = 5;
	 
	private Deck deck = new Deck();
	
	private boolean tableInSession;
	private boolean dealerInSession;
	
	// private List<Player> players = new ArrayList<Player>();
	private List<Player> players = new LinkedList<Player>();
	private Player dealer = new Player( "Dealer" );
	
	public Server() {
		tableInSession = true;
		dealer.setChipCount( 1000 );
		
		players.add( new Player("Yossi") );
		players.add( new Player("David") );
		players.add( new Player("Gabe") );
		//players.add( new Player("Ramel") );
		//players.add( new Player("Kevin") );
		//players.add( new Player("Rory") );
	}
	
	/** Get initial bets from players.
	 * 
	 * @param players
	 */
	public void requestBets( List<Player> players, Scanner scanner ) {
		for ( Player player : players ) {
			float bet = player.receiveBet( scanner );
			player.setPlaying( bet > 0.0  );
		}
	}
	
	/** After bets are accepted, the dealer deals 2 rounds of 1-card
	 *  to each player, and to himself. The 2nd dealer card is faced down.
	 *  
	 * @param players
	 */
	public void dealCards( List<Player> players ) {
		// Deal 2 rounds of 1-card each
		for ( int i = 0; i < 2; i++ ) {
			for ( Player player : players ) {
				if ( player.isPlaying() ) {
					Card card = deck.deal();
					player.addCard( card );	// add card to default hand
				}
			}
			
			// Last, Dealer deal a card to himself
			Card card = deck.deal();
			dealer.addCard( card );
		}
	}
	
	public void dealCard( Player p, Hand h ) {
		Card card = deck.deal();	// deal 1 card
		p.addCard( card, h );
	}

	public void tableSession() {
		
		scanner.useLocale( Locale.US );
		
		while ( tableInSession ) {
			System.out.println( "========================================");
			System.out.println( "----- New Game (Shuffling Cards) -------");
			System.out.println( "========================================");
			dealerInSession = true;
			
			shuffleDeck();
			
			while ( dealerInSession ) {
				dealer.addHand();
				System.out.println( "--------- New Round ----------");
				
				requestBets( players, scanner );
				dealCards( players );
				checkBlackjack( players );
				
				// Now check player's request and deal 1-card at a time
				for ( Player player : players ) {
					if ( !player.isPlaying() )
						continue;
					
					Hand hand = player.getHand();	// get default hand
					while ( hand.getStatus() == Hand.Status.PLAYING ) {
						int request = player.receiveRequest( hand, scanner );	// for current hand
						switch ( request ) {
						case BJ_STAND:
							hand.setStatus( Hand.Status.STANDING );
							break;
						case BJ_HIT:
							dealCard( player, hand );
							// Check whether currentHand is Busted
							if ( hand.calcValue() > 21 ) {
								hand.setStatus( Hand.Status.LOST );
								player.setWinLosePush( hand, -hand.getBet() );
								dealer.addChipCount( hand.getBet() );
							}
							break;
						case BJ_DOUBLEDOWN:		// Deal 1 card only
							player.doubleBet( hand );
							dealCard( player, hand );
							hand.setStatus( Hand.Status.STANDING );
							break;
						case BJ_SPLIT:
							handleSplit( player, hand );
							assert( hand.getStatus() != Hand.Status.STANDING );
							break;
						case BJ_SURRENDER:
						case BJ_INSURANCE:
						default:
							assert( true );
							break;
						}
					}
				}	// End for
				
				// Finally, deal one card at a time to Dealer
				Hand dealerHand = dealer.getHand();
				int dealerValue = dealerHand.calcValue();
				while ( dealerValue < 17 ) {
					dealCard( dealer, dealerHand );
					dealerValue = dealerHand.calcValue();
					if ( dealerValue > 21 )
						dealerHand.setStatus( Hand.Status.LOST );
				}

				dealerValue = ( dealerHand.getStatus() != Hand.Status.LOST ) ? dealerValue : 0;

				// Compare remaining players hands to dealer's hand
				compareResults( dealerValue );
				
				dealer.getHands().clear();	// clear dealer hand
				// If number of cards in a deck becomes too low, re-shuffle the deck
				if ( deck.size() < 26 ) {
					dealerInSession = false;
				}
			}	// End while
		}
		
		scanner.close();
	}

	/** During a Split session, the Dealer handles one Hand at a time.
	 *  The Dealer does not move to the next Hand unless all requests for
	 *  the current Hand are fulfilled.
	 * @param player
	 * @param hand
	 */
	public void handleSplit( Player player, Hand h ) {

		player.splitHand( h );
		
		List<Hand> hands = player.getHands();
		for ( Hand hand : hands ) {
			
			while ( hand.getStatus() == Hand.Status.PLAYING ) {
				int request = player.receiveRequest( hand, scanner );
				switch ( request ) {
				case BJ_STAND:
					hand.setStatus( Hand.Status.STANDING );
					break;
				case BJ_HIT:
					dealCard( player, hand );
					// Check whether currentHand is Busted
					if ( h.calcValue() > 21 ) {
						h.setStatus( Hand.Status.LOST );
						player.setWinLosePush( hand, -hand.getBet() );
						dealer.addChipCount( hand.getBet() );
					}
					break;
				case BJ_DOUBLEDOWN:
					player.doubleBet( hand );
					dealCard( player, hand );
					hand.setStatus( Hand.Status.STANDING );
					break;
				case BJ_SPLIT:
					handleSplit( player, hand );
					assert( hand.getStatus() != Hand.Status.STANDING );
					break;
				case BJ_SURRENDER:
				case BJ_INSURANCE:
				default:
					assert( true );
					break;
				}
				
			}
		}
	}
	
	/** After the first 2-card set is dealt, the dealer checks whether
	 *  any player has a Blackjack, and pays him 3/2 immediately.
	 * @param players
	 */
	public void checkBlackjack( List<Player> players ) {
		for ( Player p : players ) {
			if ( p.isPlaying() ) {
				Hand defaultHand = p.getHand();
				if ( 21 == defaultHand.calcValue() ) {
					defaultHand.setStatus( Hand.Status.WON );
					// pay player immediately 3/2 his bet and retire him from this round
					p.setWinLosePush( defaultHand, 3 * defaultHand.getBet() / 2 );
					dealer.addChipCount( -3/2 * defaultHand.getBet() );
				}
			}
		}
	}
	
	public void compareResults( int dealerValue ) {
		
		System.out.println( "\n!!!!!! Comparing Results !!!!!!" );
		System.out.format( "[Dealer:%s, Total:%.2f]-[%s (Value:%d) ]%n",
				dealer.getName(), dealer.getChipCount(), dealer.getHand().getCards(), dealer.getHand().calcValue() );
//		System.out.println( " Dealer Hand: " + dealer.getHand().getCards() );
		for ( Player player : players ) {
			// Check all players with hands that are standing
			for ( Hand hand : player.getHands() ) {
				if ( hand.getStatus() == Hand.Status.STANDING ) {
					int playerValue = hand.calcValue();
					if ( playerValue > dealerValue ) {
						hand.setStatus( Hand.Status.WON );
						player.setWinLosePush( hand, hand.getBet() );
						dealer.addChipCount( -hand.getBet() );
					} else if ( playerValue < dealerValue ) {
						hand.setStatus( Hand.Status.LOST );
						player.setWinLosePush( hand, -hand.getBet() );
						dealer.addChipCount( hand.getBet() );
					} else {	// PUSH
						hand.setStatus( Hand.Status.TIE );
						//player.setWinLosePush( hand, -hand.getBet() );
						player.setWinLosePush( hand, 0 );
						dealer.addChipCount( 0 );
					}
				}
			}
		}
	}	
	
	public void shuffleDeck( ) {
		deck.shuffle();
	}
	
}
