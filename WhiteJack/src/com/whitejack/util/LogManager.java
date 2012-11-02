package com.whitejack.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;


public class LogManager {
	
	public Logger wjlogger = Logger.getLogger("WhiteJack");
	
	public LogManager() {
		wjlogger.setLevel(Level.INFO);
		BasicConfigurator.configure();
		
	}

	/**
	 * @param args
	 */
	
	
	

}
