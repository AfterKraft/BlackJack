package com.joseph.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;


//-----------------------------------------------------------------------------
class Player2ndView extends BlackjackView {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	private Player player;
	private final String name;			// Temporary until we get the Player class done
	private int totalBet = 15;		// Temporary until we get the Player class done
	
	private JLabel jlblTitle;
	private JLabel jlblTotalBet;
	private JPanel jpnlHandsArea;

	private boolean isSelected = false;
	
	Border raisedBevel;
	Border loweredBevel;
	
	public Player2ndView( String name ) {
		this.name = name;
		setLayout( new BorderLayout( 2, 2 ) );
		setOpaque( false );

		Border margin = BorderFactory.createEmptyBorder( 5, 5, 5, 5 );
		Border raised = BorderFactory.createRaisedBevelBorder();
		Border lowered = BorderFactory.createLoweredBevelBorder();		
		raisedBevel = new CompoundBorder( margin, raised );
		loweredBevel = new CompoundBorder( margin, lowered );
		
		setBackground( new Color(50, 140, 100) );

		jlblTitle = new JLabel( name ) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override protected void paintComponent( Graphics g ) {
				g.setColor( Color.WHITE );
				g.drawString( "Player:  " + getText(), 10, 10 );
			}
		};

		jpnlHandsArea = createHandsArea();
		jpnlHandsArea.addMouseListener( new MouseAdapter() {
			@Override public void mousePressed( MouseEvent e ) {
				Object source = ((JPanel)e.getSource()).getParent();
				if ( source instanceof Player2ndView ) {
					System.out.println( "MouseListener: " + getName() );
					e.setSource( source );
					getParent().dispatchEvent( e );
					repaint();
				} 
			}
		});
		
		jlblTotalBet = new JLabel( "Total Bet:  " + totalBet );
		jlblTotalBet.setOpaque( false );
		
		add( jlblTitle, BorderLayout.NORTH );
		add( jpnlHandsArea, BorderLayout.CENTER );
		add( jlblTotalBet, BorderLayout.SOUTH );
	}

	public JPanel getHandsArea() {
		return jpnlHandsArea;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSelected( boolean isSelected ) {
		this.isSelected = isSelected; 
	}
	
	
	// Draw raised/lowered panel to simulate a toggle button
	@Override
	protected void paintComponent( Graphics g )  {
		if ( isSelected ) {
			g.translate( 2, 2 );
			setBorder( loweredBevel );
		} else {
			setBorder( raisedBevel );
		}
		
		super.paintComponent(g);
	}
	
	private JPanel createHandsArea() {
		jpnlHandsArea = new JPanel();
		jpnlHandsArea.setLayout( new BoxLayout( jpnlHandsArea, BoxLayout.X_AXIS ) );
		jpnlHandsArea.setAlignmentX( Component.CENTER_ALIGNMENT );
		//jpnlHandsArea.setBorder( BorderFactory.createLineBorder( Color.YELLOW ) );
		jpnlHandsArea.setOpaque( false );
		//setBackground( new Color(0,126,255,128) );
		return jpnlHandsArea;
	}
	
}