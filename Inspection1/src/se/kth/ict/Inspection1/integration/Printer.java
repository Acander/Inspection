package se.kth.ict.Inspection1.integration;

import se.kth.ict.Inspection1.model.Receipt;
import se.kth.ict.Inspection1.model.Results;

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
		System.out.println(formulatedPrintoutForReceipt(receipt));
	}
	
	/**
	 * Prints out the results to the console.
	 */
	
	public void printResults(Results results)
	{
		System.out.println(formulatedPrintoutForResults(results));
	}
	
	/**
	 * This method builds together a clear structure for printout. Notice that a few spots
	 * (such as change and credit card info) are left blank if the receipt does not
	 * contain such information
	 * @param receipt
	 * @return a formulated receipt ready for printout
	 */
	
	private String formulatedPrintoutForReceipt(Receipt receipt)
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
		printout.append("\n");
		printout.append("CreditCardInformation: ");
		printout.append("Number: ");
		printout.append(receipt.getCreditCard().getNumber());
		printout.append("\n");
		printout.append("Date: ");
		printout.append(receipt.getDate().getday()+"/"+receipt.getDate().getMonth());
		return printout.toString();
	}
	
	/**
	 * Constructs a formulated result list that can be neatly printed out.
	 * @param results
	 * @return a formulated string that contains the different results
	 */
	
	private String formulatedPrintoutForResults(Results results)
	{
		StringBuilder printout = new StringBuilder();
		goesThroughCheckList(printout, results);
		return printout.toString();
	}
	
	private void goesThroughCheckList(StringBuilder printout, Results results)
	{
		for (int i=0; i<results.getResults().length;i++)
		{
			translateResult(printout, i, results);
		}
	}
	
	private void translateResult(StringBuilder printout, int counter, Results results)
	{
		if (results.getResultByNumber(counter))
		{
			printout.append("Inspection item number " +counter+" was approved");
		}
		else
		{
			printout.append("Inspection number "+counter+" was unapproved");
		}
			
		printout.append("\n");
	}

}
