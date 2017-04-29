package se.kth.ict.Inspection1.model;

import se.kth.ict.Inspection1.integration.SystemHandler;
/**
 * The purpose of the receipt is to give the customer a view
 * of the transactions and calculations that has been performed
 * @author Adrian
 *
 */

public class Receipt {
	private double amountPaid;
	private double inspectionCost;
	private double change;
	
	/**
	 * Creates a new Receipt for printout
	 * @param amountPaid
	 * @param inspectionCost
	 * @param change
	 */
	
	public Receipt(double amountPaid, double inspectionCost, double change)
	{
		this.amountPaid = amountPaid;
		this.inspectionCost = inspectionCost;
		this.change = change;
	}
	
	/**
	 * Instructs the SystemHandler to print out the created receipt
	 */
	
	public double getAmountPaid()
	{
		return amountPaid;
	}
	
	public double getInspectionCost()
	{
		return inspectionCost;
	}
	
	public double getChange()
	{
		return change;
	}

}
