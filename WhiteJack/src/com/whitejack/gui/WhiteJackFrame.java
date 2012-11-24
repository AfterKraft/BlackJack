package com.whitejack.gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.net.URL;

public class WhiteJackFrame extends JFrame {

	/**
	 * This is the "mainframe" underlying the whole GUI construction.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	java.awt.Container c;
	WhiteJackBackground mbgp;
	JButton b1, b2, b3, b4, b5;
	// ButtonListener btn1, btn2, btn3, btn4, btn5;
	JPanel p1;

	public static URL button1 = WhiteJackFrame.class
			.getResource("/com/whitejack/images/Buttons/HitBtnUp.gif");
	public static URL button2 = WhiteJackFrame.class
			.getResource("/com/whitejack/images/Buttons/StandBtnUp.gif");
	public static URL button3 = WhiteJackFrame.class
			.getResource("/com/whitejack/images/Buttons/DoubleDownBtnUp.gif");
	public static URL button4 = WhiteJackFrame.class
			.getResource("/com/whitejack/images/Buttons/SplitBtnUp.gif");
	public static URL button5 = WhiteJackFrame.class
			.getResource("/com/whitejack/images/Buttons/SurrenderBtnUp.gif");

	public WhiteJackFrame() {

		System.out
				.println("\nGame begins...Now about to construct WhiteJackFrame");
		c = getContentPane();
		mbgp = new WhiteJackBackground();
		mbgp.setLayout(new BorderLayout());
		p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 5));

		b1 = new JButton("", new ImageIcon(button1));
		// btn1 = new PlayerOptionHandler();
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("HIT!");
			}
		});

		b2 = new JButton("", new ImageIcon(button2));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("STAND!");
			}
		});
		b3 = new JButton("", new ImageIcon(button3));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("DOUBLE DOWN!");
			}
		});
		b4 = new JButton(new ImageIcon(button4));
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("SPLIT!");
			}
		});
		final ImageIcon Surrender = new ImageIcon(button5);
		b5 = new JButton(Surrender);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("SURRENDER!");
			}
		});
		b5.setVisible(true);

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		mbgp.add(p1, BorderLayout.SOUTH);
		c.add(mbgp);
	}
}
