package se.kth.ict.Inspection1.integration;

/**
 * The Databasemanger is used for temporary storage of data. In this case it
 * is the InspectionChecklist (What to inspect) that is stored here
 * @author Adrian
 *
 */

class DatabaseManager {
	private InspectionCheckList checkList;
	
	/**
	 * Creates a DatabaseManger
	 */
	
	public DatabaseManager()
	{
		
	}
	
	public InspectionCheckList findInspections()
	{
		return new InspectionCheckList();
	}

}
