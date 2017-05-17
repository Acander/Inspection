package se.kth.ict.Inspection1.model;

import java.util.ArrayList;
import java.util.List;

import se.kth.ict.Inspection1.integration.InspectionCheckList;

public class Results {
	private InspectionCheckList checkList;
	private boolean[] results = new boolean[3];
	private int count = 0;
	private static final int limit = 3;
	private List<ResultsObserver> resultsObserversList = new ArrayList<>();
	
	/**
	 * Creates an array representing an array of results (three things here) from the inspection with a and inspectionCheckList
	 * (not used in this particular implementation) 
	 * @param checkList
	 */
	
	public Results(InspectionCheckList checkList)
	{
		this.checkList = checkList;
	}

	/**
	 * The storeResult method ads boolean variables representing 
	 * the individual inspection result from a part of the inspection
	 * @param result
	 */
	
	public void storeResult(boolean result)
	{
		if(count < limit)
		{
			results[count] = result;
			counter();
		}
		notifyObservers(result);
	}
	
	private void notifyObservers(boolean result)
	{
		for(ResultsObserver obs: resultsObserversList)
			obs.newResult(result);
	}
	
	/**
	 * Adds observers
	 * @param resultsObservers
	 */
	public void addObserver(List<ResultsObserver> resultsObservers)
	{
		resultsObserversList.addAll(resultsObservers);
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
	
	public InspectionCheckList getInspectionCheckList()
	{
		return checkList;
	}
}
