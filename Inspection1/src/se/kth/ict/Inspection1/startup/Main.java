package se.kth.ict.Inspection1.startup;

import se.kth.ict.Inspection1.integration.InputException;
import se.kth.ict.Inspection1.integration.RegNumNotFoundException;
import se.kth.ict.Inspection1.integration.SystemHandler;

import java.io.IOException;

import se.kth.ict.Inspection1.controller.Controller;
import se.kth.ict.Inspection1.controller.OperationFailedException;
import se.kth.ict.Inspection1.view.View;

public class Main {

	public static void main(String[] args) throws RegNumNotFoundException, InputException, OperationFailedException, IOException{
		SystemHandler systemHandler = new SystemHandler();
		Controller controller = new Controller(systemHandler);
		View view = new View(controller);
		
		view.sampleExecution(); 
		

	}

}
