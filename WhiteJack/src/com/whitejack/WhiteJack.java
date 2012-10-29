package com.whitejack;

//import WhiteJack packages
import com.whitejack.*;
import com.whitejack.Audio.*;
import com.whitejack.GUIManager.*;

//import Java Libraries
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WhiteJack {
	
	//initialize starting variables for startup
	//TODO: We have none yet.
	
	//main thread to start application
	public static void main(String[] args) {
		
		//Print Activation messages for debugging
		System.out.println("====================\n"+"Welcome to WhiteJack\n");
		System.out.println("");
		
		//Ask for player name
		System.out.println("Please enter a username: ");
		Scanner input = new Scanner(System.in);
		
		Player player = new User();
		player.userName = input.nextLine();
		
		//Add player to Game
		GameMaker GM = new GameMaker();
		GM.addPlayer(player);
	}

}
