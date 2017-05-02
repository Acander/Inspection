package se.kth.ict.Inspection1.integration;

import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class DisplayTest {
	ByteArrayOutputStream outContent;
	Display display;
	
	@Before
	public void setup()
	{
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		display = new Display();
		display.displayCurrentCustomerServiceNumber();
	}

	@After
	public void tearDown()
	{
		outContent = null;
		System.setOut(null);
	}
	
	@Test
	public void test() 
	{
		display.displayCurrentCustomerServiceNumber();
		String expResult = "1";
		String result = outContent.toString();
		assertTrue("Wrong printout.", result.contains(expResult));
		
	}
}
