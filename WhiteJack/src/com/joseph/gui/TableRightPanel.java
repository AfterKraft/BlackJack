package com.joseph.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//-----------------------------------------------------------------------------
class TableRightPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private URL path = TableRightPanel.class.getResource("/com/whitejack/images/GameTable/");
	private ImageIcon imageIcon = new ImageIcon( path+"TableRight.jpg" );
	
	public TableRightPanel() {
		  setPreferredSize( new Dimension( imageIcon.getIconWidth(), imageIcon.getIconHeight() ) );
		  setOpaque( false );
	}
	
	@Override
	protected void paintComponent( Graphics g )  {
		super.paintComponent(g);
		g.drawImage( imageIcon.getImage(), 0, 0, null );
	}
}