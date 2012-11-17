package com.whitejack.api.applets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.whitejack.gui.WhiteJackFrame;

public class BetHandler extends JApplet
{
	private JPanel p;
	private JFrame f;
	private Image icon = new ImageIcon("/com/whitejack/images/GameTable/WoodUp.gif").getImage();
	private URL url;
	private JApplet applet;
	private PanelListener handler;
	private JTextField t1;
	private Image image;
	
	public void init()
	{
		setSize(1055,50);
		setLayout(new BorderLayout());
		p = new JPanel();
		add(p, BorderLayout.CENTER);
		URL url = WhiteJackFrame.class.getResource("/com/whitejack/images/GameTable/WoodUp.gif");
		setVisible(true);
		repaint();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.drawImage(image,0,0, getWidth(), getHeight(), Color.BLUE, p);
	}
	
	public static BetHandler getBetHandler()
	{
		return new BetHandler();
	}
}