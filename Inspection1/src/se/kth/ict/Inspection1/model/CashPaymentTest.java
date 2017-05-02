package se.kth.ict.Inspection1.model;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import org.junit.Test;


public class CashPaymentTest {
	private CashPayment cashPayment;
	
	@Before
	public void setUp()
	{
		cashPayment = new CashPayment(1200, 2000);
	}

	@After
	public void tearDown()
	{
	}
	
	@Test
	public void test() 
	{
		double expResult = 800.0;
		double result = cashPayment.getChange();
		assertTrue("Not correct change", expResult == result);
	}

}
