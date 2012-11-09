package com.joseph.gui;

import java.awt.Component;
import javax.swing.BoxLayout;



public class PlayerView extends BlackjackView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlayerView() {
		setLayout( new BoxLayout( this, BoxLayout.X_AXIS ) );
		setAlignmentX( Component.CENTER_ALIGNMENT );
		// setBorder( BorderFactory.createLineBorder( Color.black ) );
		setOpaque( false );
		
		Tester.setMainPlayerView( this );
		Tester.testPlayerMainView( this );		// for testing purposes
	}
}
