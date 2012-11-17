package com.whitejack.api;

public abstract class Game implements Runnable
{
	protected Player players[];
	protected GameTable gameTable;
	
	// THIS IS FOR THE SINGLE THREAD OPTION
	public void start() 
	{		
	}
	public void stop()
	{
	}
	public void play()
	{
	}
	//THIS IS FOR THE MUL-THREAD OPTION
	public void run(){/* THE CODE HERE IS A THE @OVERRIDE FOR START() METHOD  */}
}