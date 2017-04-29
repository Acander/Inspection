package se.kth.ict.Inspection1.integration;

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
 * Produces a checkList based on the registration number of the car
 * @param regNum
 * @return
 */
	public InspectionCheckList produceInspectionList(String regNum)
	{
		return findInspectionsByRegNum(regNum)
	}
}
