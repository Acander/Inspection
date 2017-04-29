package se.kth.ict.Inspection1.controller;

import se.kth.ict.Inspection1.integration.SystemHandler;
import se.kth.ict.Inspection1.model.*;

public class Controller {
	private SystemHandler systemHandler;
	private Amount paymentForInspections;
	
	public Controller()
	{
		systemHandler = new SystemHandler();
	}
	
	public void specifyThatAnewInspectionIsAboutToTakePlace()
	{
		systemHandler.inviteCustomer();
	}

	/**
	 * Instructs the integration layer to close the garage door
	 */
	public void closeGarageDoor()
	{
		systemHandler.closingDoor();
	}
	
	/**Asks the system to calculate the cost for the inspection and to Specify what
	 * is to be inspected
	 * 
	 * @param registrationNumber
	 * @return the cost for the inspection 
	 */
	
	public void enterRegNumberToProduceCostAndInspectionList(String regNum)
	{
		Vehicle vehicleToInspect = new Vehicle();
		InspectionCheckList whatToInspectOnVehicle = produceInspectionList(regNum);
		
	}
}
