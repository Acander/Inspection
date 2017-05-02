package se.kth.ict.Inspection1.integration;

import se.kth.ict.Inspection1.model.Amount;
import se.kth.ict.Inspection1.integration.Date;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PaymentAuthorizationTest {
	private PaymentAuthorization authorization;
	private CreditCard creditCard;
	private Amount amount;
	private Date date;

	@Before
	public void setup() 
	{
		authorization = new PaymentAuthorization();
		creditCard = new CreditCard(4646, "hej", "då", new Date(2, 5), 636);
		amount = new Amount();
	}
	
	@After
	public void tearDown()
	{
		authorization = null;
	}
	
	@Test
	public void testAuthorizeEqualTrue()
	{
		boolean expResult = true;
		boolean result = authorization.authorizPayment(creditCard, amount.getCost());
		assertEquals("Assert that authorization always return true", expResult, result);
	}

}
