package se.kth.ict.Inspection1.integration;

/**
 * The CreditCard Class is a sort of DTO for all the information that belongs to the
 * Card. It is created by the view for simplicity reasons and then sent through the controller
 * @author Adrian
 *
 */

public class CreditCard {
	private int pin;
	private String number;
	private String holder;
	private Date date;
	private int cVC;
	
	public CreditCard(int pin, String number, String holder, Date date, int cVC)
	{
		this.pin = pin;
		this.number = number;
		this.holder = holder;
		this.date = date;
		this.cVC = cVC;
	}
	
	public int getPin()
	{
		return pin;
	}
	
	public String getNumber()
	{
		return number;
	}
	
	public String getHolder()
	{
		return holder;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public int getCVC()
	{
		return cVC;
	}

}
