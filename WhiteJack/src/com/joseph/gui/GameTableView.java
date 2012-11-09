package com.joseph.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * GameTableView sets up the client side background 
 * with NorthPanel, SouthPanel, TableCenter, TableRight
 * and PlayersView panels. This panel is called by the
 * GUIManager (Handles events for status changes)
 * @author gabizou
 *
 */
class GameTableView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon backgroundIcon;
	private URL backgroundIconURL = GameTableView.class.getResource("/com/whitejack/images/GameTable/BackGround.gif");
	
	public GameTableView() {
		backgroundIcon = new ImageIcon(backgroundIconURL);
		setOpaque( false );
		setPreferredSize( new Dimension( 990, 555 ) );
		
		setLayout( new BorderLayout() );
		
		SouthPanel south = new SouthPanel();
		south.setVisible(true);
		
		
		add( new NorthPanel(), BorderLayout.NORTH );
		add( south, BorderLayout.SOUTH );
		add( new TableCenterPanel() , BorderLayout.CENTER );
		add( new PlayersView(), BorderLayout.WEST );
		add( new TableRightPanel(), BorderLayout.EAST );
		
	}
	
	@Override
	protected void paintComponent( Graphics g )  {
		  g.drawImage( backgroundIcon.getImage(), 0, 0, null );
		  super.paintComponent(g);
	}
}