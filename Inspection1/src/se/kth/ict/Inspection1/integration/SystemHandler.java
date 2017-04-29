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

}
