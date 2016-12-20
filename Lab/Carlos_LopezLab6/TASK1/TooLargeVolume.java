public class TooLargeVolume extends Exception 
{	
	public TooLargeVolume ()
	{
		super ( );
	}

	public String getMessage ( )
	{
		return "The volume calculated exceeds the limits";
	}

	public String toString ( )
	{
		return "TooLargeVolumeException occurred";
	}

	
}