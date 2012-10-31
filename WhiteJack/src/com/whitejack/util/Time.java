package com.whitejack.util;

import java.util.*;

/**
 * Time class used for time management so that other classes don't need to
 * do so. This will be used for collecting the DateCreated etc for various users
 * 
 * Possible to utilize this for multiplayer (Gabe played stayed 5 hours ago)
 * @author gabizou
 *
 */

public class Time {
	
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	//private int second;   //Not used yet
	private int timezone;
	
	//Sets the current time based off the SYSTEM's time and timezone
	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.day = calendar.get(Calendar.DAY_OF_MONTH);
		this.month = calendar.get(Calendar.MONTH);
		this.year = calendar.get(Calendar.YEAR);
		this.timezone = calendar.get(Calendar.ZONE_OFFSET);
	}
	
	/**
	 * Returns a string of the current time based off setCurrentTime
	 * @return
	 */
	public String getCurrentTime() {
		//Goes through and sets the variables for the current time at time
		//the method is called
		this.setCurrentTime();
		String time = month+" "+day+","+year+" "+hour+":"+minute+"GMT"+timezone;
		return time;
	}

}
