package com.whitejack.api;

import java.net.URL;

import javax.swing.ImageIcon;

import com.whitejack.api.applets.BetHandler;

public class Card {

	private int cardID;
	private String suits[], suit;
	private String ranks[], rank;
	private URL url;
	private String path;
	private ImageIcon icon;
	public Card()
	{
	}
	public Card(int i) 
	{
    	String suit = suits[i / 13];
    	String rank = ranks[i % 13];
	}
	public void setURL()
	{
		path = "/com/whitejack/images/GameTable/";
		path += rank + suit;
		url = BetHandler.class.getResource(path);
		icon = new ImageIcon(url);
	}
	public void getURL()
	{
    	
	}
	public String getSuit()
	{
		String suit = suits[cardID / 13];
		return suit;
	}
	public void setSuit()
	{
	}
	public String getRank()
	{
		return ranks[cardID % 13];
	}
	public void setCardID(int num) 
	{
		cardID = num;
	}
	public int getCardID()
	{
		return cardID;
	}
	public int getNumber() 
	{
		return cardID;
	}
	public void setSuit(String suit) 
	{
		this.suit=suit;
	}
	public int getValue()
	{
		return 0;
	}
}
