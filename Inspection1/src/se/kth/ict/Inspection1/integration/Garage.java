package se.kth.ict.Inspection1.integration;

/**
 * The Garage class. The main purpose in this system is to
 * open and close the garage door.
 * @author Adrian
 *
 */

class Garage {
	private boolean doorOpen = false;
	/**
	 * Creates a controller for the external Garage system.
	 */
	
	public Garage(){}
	
	/**
	 * Instructs the external Garage system to open the door.
	 */
	
	public void openDoor()
	{
		doorOpen = true;
	}
	
	/**
	 * Instructs the external Garage system to close the door.
	 */
	
	public void closeDoor()
	{
		doorOpen = false;
	}
	

}
