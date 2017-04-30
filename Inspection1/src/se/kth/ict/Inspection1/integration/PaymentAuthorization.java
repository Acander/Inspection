package se.kth.ict.Inspection1.integration;

import se.kth.ict.Inspection1.integration.CreditCard;

class PaymentAuthorization {
	/**
	 * Initializes a specific Payment Authorization situation
	 */
	public PaymentAuthorization(){}
	
	/**
	 * Dummy implementation of a payment authorization.
	 * @param creditCard
	 * @param costForInspection
	 * @return true, always.
	 */
	
	public boolean authorizPayment(CreditCard creditCard, double costForInspection)
	{
		return true;
	}

}
