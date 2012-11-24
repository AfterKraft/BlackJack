package com.whitejack.api;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {

	ArrayList<Card> hand = new ArrayList<Card>();

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
