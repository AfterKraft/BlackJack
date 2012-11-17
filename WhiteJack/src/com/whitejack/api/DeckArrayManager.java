package com.whitejack.api;

public class DeckArrayManager extends Deck
{
	private static DeckArrayManager instance;
    private int[] deck = new int[52];
    private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
      "10", "Jack", "Queen", "King"};
    
    /**
     *  This method is accessed from 
     *  outside the class by 
     *  
     *  deck = DeckArrayManager.getDeckArrayManager();
     * @return
     */
    
    public static DeckArrayManager getDeckArrayManager()
    {
    	if (instance == null)
    	{
	    	instance = new DeckArrayManager();
    	}
    	return instance;
    }
    
    // Recycle all cards into stack
    public void initDeck()
    {
    	for (int i = 0; i < deck.length; i++)
    		deck[i] = i;
    }
    // Shuffle the cards
    public void shuffle()
    {
	    for (int i = 0; i < deck.length; i++) 
	    {
	      // Generate an index randomly
	      int index = (int)(Math.random() * deck.length);
	      int temp = deck[i];
	      deck[i] = deck[index]; 
	      deck[index] = temp;
	    }
    }
    public void serveHand(int num)
    {	// Deal out one hand to one player
	    for (int i = 0; i < num; i++) 
	    {
	    	String suit = suits[deck[i] / 13];
	    	String rank = ranks[deck[i] % 13];
	    	System.out.println("Card number " + deck[i] + ": " 
	        + rank + " of " + suit);	
	    }
	}	
   
	public void displayHand(int num)
	{ 	//Display the first hand of cards with the specified size of cards
	    for (int i = 0; i < num; i++) 
	    {
	    	String suit = suits[deck[i] / 13];
	    	String rank = ranks[deck[i] % 13];
	    	System.out.println("Card number " + deck[i] + ": " 
	        + rank + " of " + suit);	
	    }
	}
	public void getCard() 
	{

	}
	public void setCard() 
	{

	}
	public void getStateMachine()
	{
		
	}
	public void setStateMachine()
	{
		
	}
}