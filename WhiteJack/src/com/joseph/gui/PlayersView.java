package com.joseph.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;

import java.net.URL;
import javax.swing.*;

import javax.swing.BorderFactory;


public class PlayersView extends BlackjackView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private URL path = PlayersView.class.getResource("/com/whitejack/images/GameTable/");
	private ImageIcon imageIcon = new ImageIcon( path + "TableLeft.jpg" );
	private Player2ndView selectedPlayerView;

	public PlayersView() {
		setLayout( new GridLayout( 3, 2, 5, 5 ) );
		setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		setPreferredSize( new Dimension( imageIcon.getIconWidth(), imageIcon.getIconHeight() ) );
		setOpaque( false );

		for ( String name : Tester.getPlayerNames() ) {
			add( new Player2ndView( name ) );
		}

		Tester.testPlayersWithHands( getComponents() );

		addMouseListener( new MouseAdapter() {
			@Override
			public void mousePressed( MouseEvent e ) {
				Object source = e.getSource();

				if ( source instanceof Player2ndView ) {

					Player2ndView player2ndView = (Player2ndView)source;

					if ( player2ndView.getHandsArea().getComponentCount() > 0 ) {

						for ( Component c : getComponents() ) {
							((Player2ndView)c).setSelected( false );
						}

						selectedPlayerView = player2ndView;
						selectedPlayerView.setSelected( true );

						Tester.displayInPlayerMainView( (Player2ndView)source );
					}

					repaint();
				} 
			}
		});

	}

	@Override
	protected void paintComponent( Graphics g )  {
		super.paintComponent(g);
		g.drawImage( imageIcon.getImage(), 0, 0, null );
	}
}
