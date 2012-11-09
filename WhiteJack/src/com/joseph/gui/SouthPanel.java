package com.joseph.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


class SouthPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton hitButton;
	JButton standButton;
	JButton doubleButton;
	JButton splitButton;
	JButton surrenderButton;
	
	public SouthPanel() {
		setLayout( new GridLayout( 1, 5 ) );
		setOpaque( false );
		
		standButton = new Button( "Stand" );
		hitButton = new Button( "Hit" );
		doubleButton = new Button( "DoubleDown" );
		splitButton = new Button( "Split" );
		surrenderButton = new Button( "Surrender" );

		add( standButton );
		add( hitButton );
		add( doubleButton );
		add( splitButton );
		add( surrenderButton );
		surrenderButton.setEnabled( false );	// Not implemented yet
	}
}