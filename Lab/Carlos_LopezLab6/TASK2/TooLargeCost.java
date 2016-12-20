public class TooLargeCost extends Exception 
{
	public TooLargeCost ( )
	{
		super ( );
	}

	public String getMessage ( )
	{
		return "The cost calculated exceeds the limits";
	}

	public String toString ( )
	{
		return "TooLargeCostExxception occurred";
	}


}