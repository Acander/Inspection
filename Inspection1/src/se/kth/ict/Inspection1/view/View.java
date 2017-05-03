package se.kth.ict.Inspection1.view;

import se.kth.ict.Inspection1.controller.Controller;
import se.kth.ict.Inspection1.integration.CreditCard;
import se.kth.ict.Inspection1.integration.Date;
import se.kth.ict.Inspection1.integration.InspectionCheckList;
/**
 * This is simply an hardcoded view, which represents 
 * the users interface of the system
 * @author Adrian
 *
 */

public class View {
	private Controller controller;
	
	/**
	 * Creates a new instance
	 * @param controller The controller that is to be used
	 */
	
	public View(Controller controller)
	{
		this.controller = controller;
	}
	
	public void sampleExecution()
	{
		System.out.println("*Display que number and opening garage door.");
		controller.specifyThatAnewInspectionIsAboutToTakePlace(2, 5);
		System.out.println();
		System.out.println("*Closing garage door.");
		controller.closeGarageDoor();
		System.out.println();
		
		System.out.println("*Registration number is entered and cost is calculated.");
		double cost = controller.enterRegNumberToProduceCostAndInspectionList("MGD545");
		System.out.println("Inspectior sais: Cost for the inspection is "+cost+ "kr.");
		System.out.println();
		
		System.out.println("*Customer hands over payment.");
		System.out.println("*Amount of Cash is registrered.");
		System.out.println("*Receipt is printed.");
		System.out.println();
		System.out.print("Receipt 1: (Cash)\n");
		double change = controller.registerAmountOfCashPaid(3000);
		System.out.println();
		System.out.println("*In the even of a creditCard payment: The customer enter credit card information.");
		System.out.println("*Receipt is printed");
		System.out.println();
		System.out.print("Receipt 2: (Creditcard)\n");
		controller.enterCreditCardInforMation(new CreditCard(3456, "62783945473", "this", new Date(2, 17), 871));
		
		System.out.println();
		System.out.println("*The inspectors checklist is inspected and a result list is created in the system.");
		InspectionCheckList checkList = controller.specifyWhatToInspect();
		System.out.println("Inspection Checklist:");
		System.out.println(checkList.toString());
		
		System.out.println("*Individual results are written in.");
		System.out.println("*When list is full the results are shown.");
		System.out.println();
		controller.enterResult(true);
		controller.enterResult(false);
		controller.enterResult(false);
		System.out.println("Results:");
		controller.printResults(controller.getResults());
		
		System.out.println();
		System.out.println("*Opening Garage door");
		controller.openGarageDoor();
		System.out.println("*Closing Garage door");
		controller.closeGarageDoor();
	}

}
