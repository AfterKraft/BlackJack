package com.joseph.gui;

import java.awt.Component;
import javax.swing.BoxLayout;


public class DealerView extends BlackjackView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DealerView() {
		setLayout( new BoxLayout( this, BoxLayout.X_AXIS ) );
		setAlignmentX( Component.CENTER_ALIGNMENT );
		//setBorder( BorderFactory.createLineBorder( Color.black ) );
		setOpaque( false );
		
		Tester.testDealerView( this );		// for testing purposes
	}
}
