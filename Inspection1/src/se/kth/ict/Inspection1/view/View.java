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
		controller.specifyThatAnewInspectionIsAboutToTakePlace(2, 5);
		controller.closeGarageDoor();
		double cost = controller.enterRegNumberToProduceCostAndInspectionList("MGD545");
		System.out.print("Receipt 1: (Cash)\n");
		double change = controller.registerAmountOfCashPaid(3000);
		System.out.println();
		System.out.print("Receipt 2: (Creditcard)\n");
		controller.enterCreditCardInforMation(new CreditCard(3456, "62783945473", "this", new Date(2, 17), 871));
		
		System.out.println();
		InspectionCheckList checkList = controller.specifyWhatToInspect();
		System.out.println("Inspection Checklist:");
		System.out.println(checkList.toString());
		
		controller.enterResult(true);
		controller.enterResult(false);
		controller.enterResult(false);
		System.out.println("Results:");
		controller.printResults(controller.getResults());
		
		controller.openGarageDoor();
		controller.closeGarageDoor();
	}

}
