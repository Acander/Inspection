package se.kth.ict.Inspection1.model;

import se.kth.ict.Inspection1.integration.InspectionCheckList;

public class Results {
	private InspectionCheckList checkList;
	private boolean[] results;
	
	public Results(InspectionCheckList checkList)
	{
		this.checkList = checkList;
		results = new boolean[3];
	}

	public void storeResult(boolean result)
	{
		
	}
}
