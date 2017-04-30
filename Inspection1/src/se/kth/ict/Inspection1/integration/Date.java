package se.kth.ict.Inspection1.integration;

/**
 * This is a dummy class that represents a specific day that the inspection
 * takes place.
 * @author Adrian
 *
 */

public class Date {
	private int day = 27;
	private int month = 5;
	/**
	 * Creates a date for the system to use
	 */
	
	public Date(int day, int month)
	{
		this.day = day;
		this.month = month;
	}
	
	public int getday()
	{
		return day;
	}
	
	public int getMonth()
	{
		return month;
	}

}
