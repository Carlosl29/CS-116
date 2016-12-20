public class TooLargeAreaException extends Exception
{
	public TooLargeAreaException()
	{
		super();
	}

	public String getMessage()
	{
		System.out.println("Area is Too Large");
		return ("Area Is Too Large");
	}

	public String toString()
	{
		return "TooLargeAreaException occurred";
	}
}
