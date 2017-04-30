package se.kth.ict.Inspection1.model;

import se.kth.ict.Inspection1.integration.SystemHandler;
import se.kth.ict.Inspection1.integration.CreditCard;
/**
 * The purpose of the receipt is to give the customer a view
 * of the transactions and calculations that has been performed.
 * Works as DTO for later use by the printer
 * @author Adrian
 *
 */

public class Receipt {
	private double amountPaid;
	private double inspectionCost;
	private double change;
	private CreditCard creditCard; 
	
	/**
	 * Creates a new Receipt for later printout in the event of a cash payment
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
	 * Creates a new Receipt for later printout in the event of a credit card payment
	 * @param amountPaid
	 * @param inspectionCost
	 * @param change
	 * @param creditCard
	 */
	
	public Receipt(double amountPaid, double inspectionCost, CreditCard creditCard)
	{
		this.amountPaid = amountPaid;
		this.inspectionCost = inspectionCost;
		this.creditCard = creditCard;
	}
	
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
	
	public CreditCard getCreditCard()
	{
		return creditCard;
	}

}
