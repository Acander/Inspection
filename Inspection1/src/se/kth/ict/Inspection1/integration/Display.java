package se.kth.ict.Inspection1.integration;

/**
 * This class represents the external Display systems which is visible for
 * the customers waiting outside the garage
 * @author Adrian
 *
 */

class Display {
	private int currentNumber = 0;
	/**
	 * Creates a a display controller
	 */
	
	public Display(){}
	
	/**
	 * Displays the current cue number for the customers to see
	 */
	
	public void displayCurrentCustomerServiceNumber()
	{
		System.out.println(currentNumber);
		incrementCurrentNumberForNextCustomer();
	}
	
	private void incrementCurrentNumberForNextCustomer()
	{
		currentNumber++;
	}

}
