package se.kth.ict.Inspection1.integration;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;

public class InspectionCheckListTest {
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
	public void test() 
	{
		InspectionCheckList checkList = new InspectionCheckList();
		System.out.println(checkList.toString());
		String expResult = "1. Tires\n2. engine\n3. windowsChecked\n";
		String result = outContent.toString();
		assertTrue("Wrong printout.", result.contains(expResult));
	}

}
