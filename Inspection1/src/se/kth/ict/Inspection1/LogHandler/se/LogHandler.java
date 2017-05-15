package se.kth.ict.Inspection1.LogHandler.se;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import se.kth.ict.Inspection1.integration.Date;

public class LogHandler {
	private static final String LOG_FILE_NAME = "VehicleInspection-log.txt";
	
	private PrintWriter logFile;
	
	public LogHandler() throws IOException
	{
		logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
	}
	
	public void logException(Exception exception)
	{
		StringBuilder logMsgBuilder = new StringBuilder();
		logMsgBuilder.append(createDate());
		logMsgBuilder.append(", an exception was thrown, ");
		logMsgBuilder.append(exception.getMessage());
		logFile.println(logMsgBuilder);
		exception.printStackTrace(logFile);
	}
	
	private Date createDate()
	{
		return new Date();
	}

}