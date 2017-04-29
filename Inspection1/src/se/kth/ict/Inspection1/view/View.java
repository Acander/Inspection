package se.kth.ict.Inspection1.view;

import se.kth.ict.Inspection1.controller.Controller;

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
	

}
