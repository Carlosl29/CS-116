/*	Written by David Arnold 
	A20347544
	CS 116-01
*/
public class TooLargeAreaException extends Exception
{
	public TooLargeAreaException()
	{
		super();
	}
	
	public String getMessage()
	{
		return ("The area calculated exceeds the limits");
	}
	
	public String toString()
	{
		return ("TooLargeAreaException occured");
	}
}