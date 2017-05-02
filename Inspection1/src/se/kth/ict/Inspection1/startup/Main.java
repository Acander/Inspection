package se.kth.ict.Inspection1.startup;

import se.kth.ict.Inspection1.integration.SystemHandler;
import se.kth.ict.Inspection1.controller.Controller;
import se.kth.ict.Inspection1.view.View;

public class Main {

	public static void main(String[] args) {
		SystemHandler systemHandler = new SystemHandler();
		Controller controller = new Controller(systemHandler);
		View view = new View(controller);
		
		view.sampleExecution();
		

	}

}
