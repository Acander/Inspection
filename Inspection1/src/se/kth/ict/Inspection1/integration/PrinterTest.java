package se.kth.ict.Inspection1.integration;

import se.kth.ict.Inspection1.model.Results;
import se.kth.ict.Inspection1.integration.InspectionCheckList;
import se.kth.ict.Inspection1.model.Receipt;
import se.kth.ict.Inspection1.integration.CreditCard;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class PrinterTest {
	ByteArrayOutputStream outContent;
	
	@Before
	public void setUp()
	{
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void tearDown()
	{
		outContent = null;
		System.setOut(null);
	}

	@Test
	public void testPrintResults() 
	{
		InspectionCheckList checkList = new InspectionCheckList();
		Results results = new Results(checkList);
		Printer printer = new Printer();
		
		results.storeResult(true);
		results.storeResult(false);
		results.storeResult(true);
		
		printer.printResults(results);
		String expResult = "Inspection item number 0 was approved\n"
				+ "Inspection number 1 was unapproved\n"+"Inspection item number 2 was approved\n";
		String result = outContent.toString();
		assertTrue("Wrong printout.", result.contains(expResult));
	}
	
	@Test
	public void testPrintReceiptCreditCard()
	{
		Printer printer = new Printer();
		Date date = new Date(2, 5);
		CreditCard creditCard = new CreditCard(4567, "uefhreui", "568976", date, 678);
		Receipt receipt = new Receipt(1200, 1200, creditCard, date);
		printer.printReceipt(receipt);
		String expResult = "The cost for the inspection is: 1200\nThe amount paid: 1200\nThe total change is: 0\n"
				+"CreditCardInformation: \nNumber: uefhreui\nDate: 2/5";
		String result = outContent.toString();
		assertTrue("Wrong printout.", result.contains(expResult));
	}

}
