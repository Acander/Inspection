package se.kth.ict.Inspection1.view;

import se.kth.ict.Inspection1.integration.Date;

public class ErrorMessageHandler 
{
	public ErrorMessageHandler(){}
	
	public void showErrorMsg(String msg)
	{
		StringBuilder errorMsgBuilder = new StringBuilder();
		errorMsgBuilder.append(CreateDate());
		errorMsgBuilder.append(", ERROR, ");
		errorMsgBuilder.append(msg);
		System.out.println(errorMsgBuilder);
	}
	
	private Date CreateDate()
	{
		return new Date();
	}
}
