/*	Written by David Arnold 
	A20347544
	CS 116-01
*/
public class TooLargeCostException extends Exception
{
	public TooLargeCostException()
	{
		super();
	}
	
	public String getMessage()
	{
		return ("The cost exceeds the limits");
	}
	
	public String toString()
	{
		return ("TooLargeCostException occurred");
	}
}