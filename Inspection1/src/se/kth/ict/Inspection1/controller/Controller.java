package se.kth.ict.Inspection1.controller;

import se.kth.ict.Inspection1.integration.SystemHandler;
import se.kth.ict.Inspection1.integration.InspectionCheckList;
import se.kth.ict.Inspection1.integration.RegNumNotFoundException;
import se.kth.ict.Inspection1.model.Amount;
import se.kth.ict.Inspection1.model.Inspection;
import se.kth.ict.Inspection1.model.Vehicle;
import se.kth.ict.Inspection1.model.CashPayment;
import se.kth.ict.Inspection1.model.Receipt;
import se.kth.ict.Inspection1.LogHandler.se.LogHandler;
import se.kth.ict.Inspection1.integration.CreditCard;
import se.kth.ict.Inspection1.model.Results;
import se.kth.ict.Inspection1.integration.Date;
import se.kth.ict.Inspection1.integration.InputException;

/**
 * There is only one real Controller in the program.
 * Every operation in the program has its root 
 * here.
 * @author Adrian
 *
 */

public class Controller {
	private SystemHandler systemHandler;
	private Inspection specifiedInspectionToBeMade;
	private Amount costForInspection;
	private Results inspectionResults;
	
	/**
	 * Creates a Controller unit with an associated system handler for the integration layer.
	 */
	
	public Controller(SystemHandler systemHandler)
	{
		this.systemHandler = systemHandler;
	}
	
	/**
	 * Informs the system handler that an inspection is about to take place
	 */
	
	public void specifyThatAnewInspectionIsAboutToTakePlace(int day, int month)
	{
		systemHandler.inviteCustomer(day, month);
	}

	/**
	 * Instructs the integration layer to close the garage door
	 */
	public void closeGarageDoor()
	{
		systemHandler.closingDoor();
	}
	
	/**
	 * Instructs the system handler to open the garage door.
	 */
	
	public void openGarageDoor()
	{
		systemHandler.openingDoor();
	}
	
	/**Asks the system to calculate the cost for the inspection and to specify what
	 * is to be inspected
	 * 
	 * @param registrationNumber
	 * @return the cost for the inspection 
	 * @throws OperationFailedException if some exception is thrown after entered registration number
	 */
	
	public double enterRegNumberToProduceCostAndInspectionList(String regNum, LogHandler logHandler) throws OperationFailedException, InputException, RegNumNotFoundException
	{
		Vehicle vehicleToInspect = new Vehicle(regNum);
		InspectionCheckList whatToInspectOnVehicle = enterRegNum(vehicleToInspect, logHandler);
		specifiedInspectionToBeMade = new Inspection(vehicleToInspect, whatToInspectOnVehicle);
		costForInspection = new Amount();
		return costForInspection.getCost();
	}
	
	private InspectionCheckList enterRegNum(Vehicle vehicleToInspect, LogHandler logHandler) throws InputException, OperationFailedException, RegNumNotFoundException
	{
		InspectionCheckList whatToInspectOnVehicle = null;
		try{
			whatToInspectOnVehicle = systemHandler.produceInspectionList(vehicleToInspect, logHandler);
			} catch(InputException inputException)
			{
				logHandler.logException(inputException);
				throw new OperationFailedException();
			}
		return whatToInspectOnVehicle;
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
		Receipt receipt = new Receipt(amountPaid, costForInspection.getCost(), cashPayment.getChange(), systemHandler.getDate());
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
			Receipt receipt = new Receipt(costForTheInspection, costForTheInspection, creditCard, systemHandler.getDate());
			systemHandler.timeToPrintReceipt(receipt);
			
		}
	}
	
	/**
	 * Method that creates a result list and also returns and 
	 * returns a previously created inspection checklist.
	 * @return
	 */
	
	public InspectionCheckList specifyWhatToInspect()
	{
		inspectionResults = new Results(specifiedInspectionToBeMade.getInspectionCheckList());
		return specifiedInspectionToBeMade.getInspectionCheckList();
	}
	
	/**
	 * enterResutl is used for entering a specifc result from the inspection
	 * @param result
	 */
	
	public void enterResult(boolean result)
	{
		inspectionResults.storeResult(result);
	}
	
	public Results getResults()
	{
		return inspectionResults;
	}
	
	/**
	 * Instructs the system handler to print out the now filled result list
	 * @param results
	 */
	
	public void printResults(Results results)
	{
		systemHandler.timeToPrintResults(results);
	}
	
	
	
}
