package se.kth.ict.Inspection1.model;

public class Amount {
	private double costForAVehicleInspection = 1200.0;
	
	/**
	 * Creates a deposit for the cost of a vehicle inspection.
	 * @return
	 */
	
	public Amount(){}

	/**
	 * 
	 * @return the cost of a vehicle inspection
	 */
	
	public double getCost()
	{
		return costForAVehicleInspection;
	}

}
