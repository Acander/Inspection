package se.kth.ict.Inspection1.integration;

/**
 * The Databasemanger is used for temporary storage of data. In this case it
 * is the InspectionChecklist (What to inspect) that is stored here
 * @author Adrian
 *
 */

public class DatabaseManger {
	private InspectionCheckList checkList
	
	/**
	 * Creates a DatabaseManger
	 */
	
	public DatabaseManger(InspectionCheckList checkList)
	{
		this.checkList = checkList;
	}

}
