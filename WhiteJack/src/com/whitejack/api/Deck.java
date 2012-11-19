package com.whitejack.api;

import org.apache.log4j.Logger;

public class Deck extends Card{

	private Card[] card;
	private int i;
	public boolean isShuffled;
	private int cardCount;
	private static Logger log = Logger.getLogger("WhiteJack");
    private int[] deck = new int[52];
	private int numDecks = 1;
	private int numCards = 52;
	public Deck() {

		isShuffled=false;
		cardCount=0;
	}
	public void show()
	{
		for(int j=0;j<card.length;j++)
			System.out.println(card[j]);
	}
	public Card dealCard() {
		
		log.debug("[Deck] Check to make sure the Deck.dealcard has been started. in Deck");  //Debugging line
		
		Card temp=card[i];
		log.debug("[Deck] The temporary temp object of type Card has been created!");  //Debugging line
		
		i++;
		log.debug("[Deck] i has been post incremented!");  //Debugging line
		
		log.debug("[Deck] temp has a value of: "+ temp); //Debugging line
		
		int count = temp.getValue();
		if(count>9)
			cardCount--;
		else if(count<7)
			cardCount++;
		return temp;		
	}
}
