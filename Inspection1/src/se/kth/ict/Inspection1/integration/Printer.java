package se.kth.ict.Inspection1.integration;

import se.kth.ict.Inspection1.model.Receipt;

public class Printer {
	
	/**
	 * Creates a controller for the printer.
	 */
	
	public Printer(){}
	
	/**
	 * Prints out the receipt to the console.
	 * @param receipt
	 */
	
	public void printReceipt(Receipt receipt)
	{
		System.out.println(formulatedPrintout(receipt));
	}
	
	private String formulatedPrintout(Receipt receipt)
	{
		StringBuilder printout = new StringBuilder();
		printout.append("The cost for the inspection is: ");
		printout.append(receipt.getInspectionCost());
		printout.append("\n");
		printout.append("The amount paid: ");
		printout.append(receipt.getAmountPaid());
		printout.append("\n");
		printout.append("The total change is: ");
		printout.append(receipt.getChange());
		return printout.toString();
	}
	
	

}
