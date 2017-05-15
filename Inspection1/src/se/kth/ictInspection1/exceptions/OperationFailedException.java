package se.kth.ictInspection1.exceptions;

public class OperationFailedException extends Exception
{
	public OperationFailedException()
	{
		super("System operation has failed");
	}
	
	public String getMessage()
	{
		return "System operation has failed";
	}
}
