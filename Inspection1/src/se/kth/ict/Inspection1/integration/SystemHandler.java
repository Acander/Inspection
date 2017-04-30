package se.kth.ict.Inspection1.integration;

import se.kth.ict.Inspection1.model.Receipt;

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
		date = new Date();
	}
	
	/**
	 * Invites the customer through to the workshop, by telling 
	 * the garage system to open the door
	 * and telling the display system to display the current number
	 */
	public void inviteCustomer()
	{
		garage.openDoor();
		display.displayCurrentCustomerServiceNumber();
	}
	
	/**
	 * Instructs the Garage system to close the door
	 */
	
	public void closingDoor()
	{
		garage.closeDoor();
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
}
