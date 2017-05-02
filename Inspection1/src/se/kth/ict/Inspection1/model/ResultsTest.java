package se.kth.ict.Inspection1.model;

import static org.junit.Assert.*;

import java.util.Arrays;

import se.kth.ict.Inspection1.integration.InspectionCheckList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResultsTest {
	private InspectionCheckList checkList;
	private Results results;
	
	@Before
	public void setup()
	{
		checkList = new InspectionCheckList();
		results = new Results(checkList);
		results.storeResult(true);
		results.storeResult(false);
		results.storeResult(true);
		results.storeResult(false);
		results.storeResult(false);
		
	}
	
	@After
	public void tearDown()
	{
		checkList = null;
		results = null;
	}
	
	@Test
	public void testIfArrayIsCorrectlyFilledAndGetMethod() 
	{
		boolean[] array = new boolean[3];
		array[0] = true;
		array[1] = false;
		array [2] = true;
		boolean expResult = true;
		boolean result = Arrays.equals(array, results.getResults());
		assertEquals("The list created above is correctly filled", expResult, result);
	}
	
	@Test
	public void testIfArraySpaceIsCorectlyFetched()
	{
		boolean value = false;
		boolean expResult = false;
		boolean result = (value == (results.getResultByNumber(2)));
		assertEquals("The function getResultByNumber collects correct value", expResult, result);
	}

}
