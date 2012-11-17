package com.whitejack.api.applets;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.whitejack.gui.WhiteJackFrame;

public class BetHandler extends JApplet implements ActionListener
{
	private MyPanel p;
	private JFrame frame;
	private PanelListener handler;
	private JTextField t1 = new JTextField();
	
	public BetHandler()
	{
		setPreferredSize(new Dimension(1095, 135));
		frame = new JFrame();
		frame.setSize(1095,135);
		frame.add(this);
		p = new MyPanel();
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("You just bet ");
	}
}