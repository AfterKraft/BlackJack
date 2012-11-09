package com.joseph.gui;

import java.awt.*;
import javax.swing.*;


public class HandView extends BlackjackView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static private final Point offset = new Point( 20, 0 );
	private JLayeredPane layeredCards;
	private int curLayer;
	private Point origin;
	private int defaultCardWidth;
	
	public HandView() {
		setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );
		// setBorder( BorderFactory.createLineBorder( Color.RED ) );
		setPreferredSize( new Dimension( 200, 160 ) );
		setAlignmentX( Component.CENTER_ALIGNMENT );
		setOpaque( false );
		
		layeredCards = new JLayeredPane();
		// layeredCards.setBorder( BorderFactory.createLineBorder( Color.BLUE ) );
		curLayer = 0;
		origin = new Point( 0, 0 );
		
		add( layeredCards );
	}

	@Override public Component add( Component c ) {
		super.add( c );

		if ( c instanceof CardView ) {
			c.setBounds( origin.x, origin.y, CardView.DEFAULT_WIDTH, 124 );
			layeredCards.add( c, new Integer( curLayer ) );
		
			curLayer++;
			origin.translate( offset.x,  offset.y );

			defaultCardWidth = CardView.DEFAULT_WIDTH;
		}
		return c;
	}
	
	@Override protected void paintComponent( Graphics g )  {
		super.paintComponent( g );
		
		Dimension handViewSize = getSize( null );
		//System.out.println( "PC width=" + handViewSize.width + " height=" + handViewSize.height );

		int numCards = layeredCards.getComponentCount();
		int totalCardsWidth = ( defaultCardWidth + (numCards-1) * 20 );
		int offsetX = ( handViewSize.width - totalCardsWidth ) / 2;
		int offsetY = ( handViewSize.height - 124 ) / 2;
		
		layeredCards.setBounds( offsetX, offsetY, totalCardsWidth, 124 );
	}
}
