package se.kth.ict.Inspection1.integration;

import se.kth.ict.Inspection1.model.Vehicle;
import se.kth.ictInspection1.exceptions.RegNumNotFoundException;

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
	 * throws RegNumNotFoundException if the inputed registration number does not match the database data
	 */
	public InspectionCheckList findInspections(Vehicle vehicleToInspect) throws RegNumNotFoundException
	{
		isValidRegNum(vehicleToInspect);
		return checkList;
	}

	private void isValidRegNum(Vehicle vehicleWithRegNum) throws RegNumNotFoundException
	{
		if(!(vehicleWithRegNum.getRegNum() == "MGD545"))
			throw new RegNumNotFoundException(vehicleWithRegNum);
	}
}
