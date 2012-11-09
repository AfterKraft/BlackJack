package com.whitejack.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WhiteJackBackground extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageIcon icon;
	
	public static URL background = WhiteJackBackground.class.getResource("/com/whitejack/images/GameTable/WhiteJackTable0.jpg");
	
	
	public WhiteJackBackground() {
		icon = new ImageIcon(background);
		setOpaque(false);
		setPreferredSize(new Dimension(100, 100));
	}
	
	protected void paintComponent(Graphics g)
	{
		g.drawImage(icon.getImage(), 0,0, null);
		super.paintComponent(g);
	}

}
