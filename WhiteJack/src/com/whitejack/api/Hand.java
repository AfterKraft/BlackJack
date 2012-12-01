package com.whitejack.api;

import java.util.ArrayList;
import java.util.List;

public class Hand extends ArrayList<Card> {
	// Hand is a unique class of its own rather than a generic ArrayList<Deck>

	ArrayList<Card> hand = new ArrayList<Card>();
    public enum Status { PLAYING, STANDING, WON, LOST, TIE, BJ_WON  }
    private Status status;
	private List<Card> cards = new ArrayList<Card>();
	private float bet;
	public Hand(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	public int getValue() {
		return 0;
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
