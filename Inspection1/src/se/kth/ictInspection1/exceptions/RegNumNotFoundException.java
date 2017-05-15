package se.kth.ictInspection1.exceptions;

import se.kth.ict.Inspection1.model.Vehicle;

public class RegNumNotFoundException extends Exception
{
	private Vehicle carThatIsNotToBeInspected;
	
	public RegNumNotFoundException(Vehicle carThatIsNotToBeInspected)
	{
		super("The vehicle with registration number "+ carThatIsNotToBeInspected.getRegNum()+ " is not to be inspected");
		this.carThatIsNotToBeInspected = carThatIsNotToBeInspected;
	}
	
	public Vehicle getCarThatIsNotToBeInspected()
	{
		return carThatIsNotToBeInspected;
	}
}
