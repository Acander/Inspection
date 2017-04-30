package se.kth.ict.Inspection1.integration;

import se.kth.ict.Inspection1.model.Receipt;
import se.kth.ict.Inspection1.model.Results;
import se.kth.ict.Inspection1.integration.Printer;

public class SystemHandler {
	private Garage garage;
	private Display display;
	private Printer printer;
	private DatabaseManager databaseManager;
	private Date date;
	
	/**
	 * Creates a SystemHandler for use as a special "controller" unit
	 * in the integration layer (every command to the integration layer goes through here).
	 * To the systemHandler objects of type Garage, Display, Printer, DatabaseManger and date are 
	 * are also created.
	 */
	
	public SystemHandler()
	{
		garage = new Garage();
		display = new Display();
		printer = new Printer();
		databaseManager = new DatabaseManager();
	}
	
	/**
	 * Invites the customer through to the workshop, by telling 
	 * the garage system to open the door
	 * and telling the display system to display the current number
	 */
	public void inviteCustomer(int day, int month)
	{
		garage.openDoor();
		display.displayCurrentCustomerServiceNumber();
		date = new Date(day, month);
	}
	
	/**
	 * Instructs the Garage system to close the door.
	 */
	
	public void closingDoor()
	{
		garage.closeDoor();
	}
	
	/**
	 * Instructs the Garage system to close the door.
	 */
	
	public void openingDoor()
	{
		garage.openDoor();
	}
/**
 * Produces a checkList for the inspection
 * @return an object of the type InspectionCheckList 
 */
	public InspectionCheckList produceInspectionList()
	{
		return databaseManager.findInspections();
	}
	
	/**
	 * Orders the printer to print out the receipt
	 * @param receipt
	 */
	
	public void timeToPrintReceipt(Receipt receipt)
	{
		printer.printReceipt(receipt);
	}
	
	/**
	 * Orders the printer to print out the results from the exception
	 * @param results
	 */
	
	public void timeToPrintResults(Results results)
	{
		printer.printResults(results);
	}
	
	/**
	 * This method handles access to the external payment authorization system
	 * @param creditCard
	 * @param costForInspection
	 * @return boolean variable (true or false) describing if payment authorized
	 */
	
	public boolean payByCard(CreditCard creditCard, double costForInspection)
	{
		PaymentAuthorization paymentAuthorization = new PaymentAuthorization();
		return paymentAuthorization.authorizPayment(creditCard, costForInspection);
	}
	
	/**
	 * The is used in the receipt so therefore this method is neccesery.
	 * @return date
	 */
	
	public Date getDate()
	{
		return date;
	}
}
