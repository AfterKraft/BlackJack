package com.whitejack.api.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

abstract class ButtonListener extends MouseAdapter implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		// System.out.println("HIT!");
		// System.out.println("STAND!");
		// System.out.println("DOUBLE DOWN!");
		// System.out.println("SPLIT!");
		// System.out.println("SURRENDER!");
	}
}