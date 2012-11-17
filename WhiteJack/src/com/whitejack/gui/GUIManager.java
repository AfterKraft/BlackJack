package com.whitejack.gui;

import javax.swing.JFrame;

public class GUIManager {
	
	public void startGUI() {
		// The object

		System.out.println("\nGame begins...1Now about to open gui");
		WhiteJackFrame win= new WhiteJackFrame();
		win.setSize(990,585);
		win.setVisible(true);
		win.setResizable(false);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
