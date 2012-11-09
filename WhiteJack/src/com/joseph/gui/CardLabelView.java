package com.joseph.gui;

import java.awt.Color;

import javax.swing.JLabel;


//-----------------------------------------------------------------------------
class CardLabelView extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Card card;
	
	CardLabelView( Card card ) {
		super( card.toLabel() );
		this.card = card;
		if ( card.suit() == Card.Suit.Diamond || card.suit() == Card.Suit.Heart ) {
			setForeground( Color.RED );
		}
//		setOpaque( false );
	}

	public Card getCard()	{ return this.card; }
}