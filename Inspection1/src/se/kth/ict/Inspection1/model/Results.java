package se.kth.ict.Inspection1.model;

import se.kth.ict.Inspection1.integration.InspectionCheckList;

public class Results {
	private InspectionCheckList checkList;
	private boolean[] results;
	private int count = 0;
	private static final int limit = 3;
	
	public Results(InspectionCheckList checkList)
	{
		this.checkList = checkList;
		results = new boolean[3];
	}

	public void storeResult(boolean result)
	{
		if(counter() < limit)
		{
			results[count] = result;
		}
	}
	
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
