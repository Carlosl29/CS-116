public class TooLargeArea extends Exception
{
	public TooLargeArea ( )
	{
		super ();
	}

	public String getMessage ( )
	{
		return "The area calculated exceeds the limits";
	}

	public String toString ( )
	{
		return "TooLargeAreaException occurred";
	}
}