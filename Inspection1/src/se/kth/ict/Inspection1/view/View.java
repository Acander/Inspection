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
		controller.enterRegNumberToProduceCostAndInspectionList("MGD545");
		double change = controller.registerAmountOfCashPaid(3000);
		System.out.println(change);
		controller.enterCreditCardInforMation(new CreditCard(3456, "62783945473", "this", new Date(2, 17), 871));
		
		InspectionCheckList checkList = controller.specifyWhatToInspect();
		controller.enterResult(true);
		controller.enterResult(false);
		controller.enterResult(false);
		
		controller.openGarageDoor();
		controller.closeGarageDoor();
	}

}
