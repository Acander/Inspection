package se.kth.ict.Inspection1.controller;

import se.kth.ict.Inspection1.integration.SystemHandler;
import se.kth.ict.Inspection1.integration.InspectionCheckList;
import se.kth.ict.Inspection1.model.Amount;
import se.kth.ict.Inspection1.model.Inspection;
import se.kth.ict.Inspection1.model.Vehicle;
import se.kth.ict.Inspection1.model.CashPayment;

/**
 * There is only one real Controller in the program.
 * Every operation in the program has its root 
 * here.
 * @author Adrian
 *
 */

public class Controller {
	private SystemHandler systemHandler;
	public Inspection specifiedInspectionToBeMade;
	public Amount costForInspection;
	
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
	
	/**Asks the system to calculate the cost for the inspection and to specify what
	 * is to be inspected
	 * 
	 * @param registrationNumber
	 * @return the cost for the inspection 
	 */
	
	public double enterRegNumberToProduceCostAndInspectionList(String regNum)
	{
		Vehicle vehicleToInspect = new Vehicle(regNum);
		InspectionCheckList whatToInspectOnVehicle = systemHandler.produceInspectionList();
		specifiedInspectionToBeMade = new Inspection(vehicleToInspect, whatToInspectOnVehicle);
		costForInspection = new Amount();
		return costForInspection.getCost();
	}
	
	public double registerAmountOfCashPaid(double amountPaid)
	{
		CashPayment cashPayment = new CashPayment(costForInspection.getCost(), amountPaid);
		return cashPayment.getChange();
	}
}
