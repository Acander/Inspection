package se.kth.ict.Inspection1.controller;

import se.kth.ict.Inspection1.integration.SystemHandler;
import se.kth.ict.Inspection1.integration.InspectionCheckList;
import se.kth.ict.Inspection1.model.Amount;
import se.kth.ict.Inspection1.model.Inspection;
import se.kth.ict.Inspection1.model.Vehicle;
import se.kth.ict.Inspection1.model.CashPayment;
import se.kth.ict.Inspection1.model.Receipt;
import se.kth.ict.Inspection1.integration.CreditCard;
import se.kth.ict.Inspection1.model.Results;

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
	public Results inspectionResults;
	
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
	
	/**
	 * Registers amount paid by the customer and instructs the printer to print out a receipt
	 * to the customer
	 * @param amountPaid
	 * @return the amount of change that should be given back
	 */
	
	public double registerAmountOfCashPaid(double amountPaid)
	{
		CashPayment cashPayment = new CashPayment(costForInspection.getCost(), amountPaid);
		Receipt receipt = new Receipt(amountPaid, costForInspection.getCost(), cashPayment.getChange());
		systemHandler.timeToPrintReceipt(receipt);
		return cashPayment.getChange();
	}
	
	/**
	 * This method is used in the event of a credit card payment. 
	 * It uses the credit card information to aquire a payment authorization 
	 * and if this is approved it instructs the system to print the receipt
	*/
	public void enterCreditCardInforMation(CreditCard creditCard)
	{
		double costForTheInspection = costForInspection.getCost();
		if(systemHandler.payByCard(creditCard, costForTheInspection))
		{
			Receipt receipt = new Receipt(costForTheInspection, costForTheInspection, creditCard);
			systemHandler.timeToPrintReceipt(receipt);
			
		}
	}
	
	public InspectionCheckList specifyWhatToInspect()
	{
		inspectionResults = new Results(specifiedInspectionToBeMade.getInspectionCheckList());
		return specifiedInspectionToBeMade.getInspectionCheckList();
	}
	
	public void enterResult(boolean result)
	{
		
	}
	
}
