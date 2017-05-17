package se.kth.ict.Inspection1.integration;

public class InspectionCheckList {
	private boolean tiresChecked = false;
	private boolean engineChecked = false;
	private boolean windowsChecked = false;
	
	public InspectionCheckList(){}
	
	public String toString()
	{
		StringBuilder outPutForPrintout = new StringBuilder();
		outPutForPrintout.append("1. Tires\n");
		outPutForPrintout.append("2. engine\n");
		outPutForPrintout.append("3. windowsChecked\n");
		return outPutForPrintout.toString();
	}

}
