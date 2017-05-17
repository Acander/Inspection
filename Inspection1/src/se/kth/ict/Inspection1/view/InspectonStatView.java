package se.kth.ict.Inspection1.view;

import se.kth.ict.Inspection1.model.ResultsObserver;

class InspectionStatView implements ResultsObserver 
{
	
	int numberOfPassedInpections = 0;
	int numberOfFailedInpections = 0;
	
	public InspectionStatView(){}
	
	@Override 
	public void newResult(boolean result)
	{
		printCurrentState(result);
	}
	
	private void printCurrentState(boolean result)
	{
		System.out.println("### New Result from the inspection ###");
		if (result)
		{
			numberOfPassedInpections++;
			System.out.println("Number of approved Inpections: "+numberOfPassedInpections);
		}
		else
		{
			numberOfFailedInpections++;
			System.out.println("Number of unapporved Inpections: "+numberOfFailedInpections);
		}
	}
}
