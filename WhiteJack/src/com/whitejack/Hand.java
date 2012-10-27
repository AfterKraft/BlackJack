package com.whitejack;

public class Hand {
	
	public String[] suits;
	public String[] rank;
	public String[] card;
	
	public Player player;

	
	public int getValue() {
		return 0;
		
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public boolean isHitOption() {
		return false;
		
	}
	
	public boolean isSplitOption() {
		return false;
		
	}
	
	public boolean isDealerHand() {
		return false;
		
	}
	
	
	
	

}
