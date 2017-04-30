package se.kth.ict.Inspection1.model;

import se.kth.ict.Inspection1.integration.InspectionCheckList;

/**
 * The class the defines the inspection itself, meaning what vehicle to inspect
 * and what to inspect on it. This is probably one of the more central
 * classes in the program
 * @author Adrian
 *
 */

public class Inspection {
	private Vehicle vehicle;
	private InspectionCheckList checkList;

	/**
	 * Creates an object with contributed information about witch car and what to inspect
	 * @param vehicle
	 * @param regNum
	 */
	public Inspection(Vehicle vehicle, InspectionCheckList checkList )
	{
		this.vehicle = vehicle;
		this.checkList = checkList;
	}
	
	public String getRegNum()
	{
		return vehicle.getRegNum();
	}
	
	public InspectionCheckList getInspectionCheckList()
	{
		return checkList;
	}
}
