package com.whitejack.api;

import java.net.URL;

import javax.swing.ImageIcon;

import com.whitejack.api.applets.BetHandler;

public class Card {

	private int cardID;
	private int value;
	protected String suits[];
	private String suit;
	protected String ranks[];
	private String rank;
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
	private void setPath(String string)
	{
		this.path = string;
	}
	private void setURL()
	{
		path = "/com/whitejack/images/GameTable/";
		path += rank + suit;
		url = BetHandler.class.getResource(path);
		icon = new ImageIcon(url);
	}
	public URL getURL()
	{
    	return url;
	}
	public String getSuit()
	{
		String suit = suits[cardID / 13];
		return suit;
	}
	private void setSuit()
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
	public void displayImage(int cardID)
	{
		// pull the card image from url and show on a gui
	}
	public void hideImage()
	{                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
 		
	}
	public int getValue()
	{
		return value;
	}
	private void setValue(int value)
	{
		this.value = value;
	}
}
