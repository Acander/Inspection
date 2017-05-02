package se.kth.ict.Inspection1.model;

public class CashPayment {
	private double cost;
	private double amountPaid;
	/**
	 *Creates an instance of a cashPayment
	 */
	
	public CashPayment(double cost, double amountPaid)
	{
		this.cost = cost;
	}
	
	
	public double getChange()
	{
		return calculateChange();
	}

	private double calculateChange()
	{
		double change = amountPaid-cost;
		return change;
	}
}
