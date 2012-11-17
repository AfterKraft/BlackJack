package com.whitejack.api.applets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BetHandler extends JApplet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyPanel p;
	private JFrame frame;
//	private PanelListener handler;
	private JTextField t1 = new JTextField();
	
	public BetHandler()
	{
		setPreferredSize(new Dimension(1095, 135));
		frame = new JFrame();
		frame.setSize(1095,135);
		frame.add(this);
		p = new MyPanel();
//		p.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent e) 
//			{
//				System.out.println("You just bet ");
//			}
//		});
	
		setBackground(Color.YELLOW);
		this.add(p, BorderLayout.CENTER);
		this.add(t1, BorderLayout.SOUTH);
		frame.setVisible(true);
		init();
	}	

	public void init()
	{
		this.add(p, BorderLayout.CENTER);
	}
	public static BetHandler getBetHandler()
	{
		return new BetHandler();
	}
	public class MyPanel extends JPanel 
	{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private URL path = BetHandler.class.getResource("/com/whitejack/images/GameTable/WoodUp.gif"); // MAKE SURE TO CHANGE THIS BACK TO THE REAL PATH
		public MyPanel()
		{
			setPreferredSize(new Dimension(1095,95));
			setBackground(Color.GREEN);
			setLayout(new BorderLayout());
//			this.addActionListener(this);
			repaint();
		}

		private ImageIcon icon = new ImageIcon(path);
		public void paintComponent(Graphics g) 
		{
			super.paintComponent(g);
			g.setColor(Color.BLACK);
	//		g.drawImage(icon.getImage(), 0,0, icon.getIconWidth(), icon.getIconHeight(), this);
			g.drawImage(icon.getImage(), 0, 0, 1095, 55, this);
		}
	}
//	public static class PanelListener implements ActionListener
//	{	
			// TODO Auto-generated constructor stub
//			public void actionPerformed(ActionEvent e)
	//		{
	//			
	//			System.out.println("You just bet ");
	//		}		
//	}

}