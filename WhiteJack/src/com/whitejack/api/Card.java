package com.whitejack.api;

public class Card {

	private int number;
	private String suit;

	public Card() {

	}

	public Card(int num, String suit) {
		number=num;
		this.suit=suit;
	}

	public void setNumber(int num) {
		number=num;
	}

	public int getNumber() {
		return number;
	}

	public void setSuit(String suit) {
		this.suit=suit;
	}

	public int getValue() {
		if(number==1)
			return 11;
		else if( number>10)
			return 10;
		return number;
	}

	public String toString() {
		if(number==1)
			return "Ace of "+suit;
		else if(number==11)
			return "Jack of "+suit;
		else if(number==12)
			return "Queen of "+suit;
		else if(number==13)
			return "King of "+suit;
		else
			return number+" of "+suit;
	}

}
