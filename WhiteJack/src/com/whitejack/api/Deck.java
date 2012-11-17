package com.whitejack.api;

import org.apache.log4j.Logger;

public class Deck extends Card{

	private Card[] card;
	private int i;
	public boolean isShuffled;
	private int cardCount;
	private static Logger log = Logger.getLogger("WhiteJack");

	public Deck() {

		card=new Card[52];
		
		for(i=1;i<=13;i++)
			card[i-1]=new Card(i,"Hearts");
		
		for(i=14;i<=26;i++)
			card[i-1]=new Card(i-13,"Diamonds");
		
		for(i=27;i<=39;i++)
			card[i-1]=new Card(i-26,"Clovers");
		
		for(i=40;i<=52;i++)
			card[i-1]=new Card(i-39,"Spades");

		i=0;
		isShuffled=false;
		cardCount=0;
	}

	public void show()
	{
		for(int j=0;j<card.length;j++)
			System.out.println(card[j]);
	}


/*	public void shuffle() {
		
		log.debug("[Deck]: Deck will be shuffled.");  //Debugging Line
		i=0;
		Card tempCard = new Card();
		int random=0,count=0,totalCards=0;
		while(totalCards!=52)
		{
			random=((int)(Math.random()*(51-count+1)));
			tempCard=card[count];
			card[count++]=card[random];
			card[random]=tempCard;
			totalCards++;
		}
		log.debug("[Deck]: Deck shuffled.");  //Debugging Line
		
		isShuffled=true;
		count=0;
	}*/

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

	public int cardNumber() {
		return i;
	}
	
	public int getCardCount(){
		return cardCount;
	}


}
