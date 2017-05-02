package se.kth.ict.Inspection1.integration;

/**
 * The Databasemanger is used for temporary storage of data. In this case it
 * is the InspectionChecklist (What to inspect) that is stored here
 * @author Adrian
 *
 */

class DatabaseManager {
	private InspectionCheckList checkList = new InspectionCheckList();
	
	/**
	 * Creates a DatabaseManger
	 */
	
	public DatabaseManager(){}
	
	/**
	 * Basically a getMethod
	 * @return and object InspectionCheckList
	 */
	public InspectionCheckList findInspections()
	{
		return checkList;
	}

}
