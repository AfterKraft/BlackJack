package com.joseph.gui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;


//-----------------------------------------------------------------------------
class Hand2ndView extends BlackjackView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Hand2ndView() {
		
		setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );
		// setBorder( BorderFactory.createLineBorder( Color.GREEN ) );
		setPreferredSize( new Dimension( 150, 120 ) );
		setAlignmentY( Component.TOP_ALIGNMENT );
		setOpaque( false );
	}

	@Override public Component add( Component c ) {
		if ( c instanceof CardView ) {
			CardView cardView = (CardView)c;
			super.add( new CardLabelView( cardView.getCard() ) ); 
		}
		return c;
	}
}