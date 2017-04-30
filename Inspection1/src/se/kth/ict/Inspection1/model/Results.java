package se.kth.ict.Inspection1.model;

import se.kth.ict.Inspection1.integration.InspectionCheckList;

public class Results {
	private InspectionCheckList checkList;
	private boolean[] results;
	private int count = 0;
	private static final int limit = 3;
	
	/**
	 * Creates an array representing an array of results from the inspection
	 * @param checkList
	 */
	
	public Results(InspectionCheckList checkList)
	{
		this.checkList = checkList;
		results = new boolean[3];
	}

	/**
	 * The storeResult method ads boolean variables representing 
	 * the individual inspection result from a part of the inspection
	 * @param result
	 */
	
	public void storeResult(boolean result)
	{
		if(counter() < limit)
		{
			results[count] = result;
		}
	}
	
	/**
	 * This method works as a counter for the storeResult method above.
	 * The method uses the global variable count.
	 * @return the updated counter value
	 */
	
	private int counter()
	{
		count++;
		return count;
	}

	public boolean[] getResults()
	{
		return results;
	}
	
	public boolean getResultByNumber(int arrayNumber)
	{
		return results[arrayNumber];
	}
}
