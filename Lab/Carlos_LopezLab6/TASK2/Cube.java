import java.util.*;

public class Cube extends Figure implements INT3
{
	double length;

	public Cube ( )
	{
		super ( );
		length = 0.0;
	}

	public Cube (String name, double len)
	{
		super (name);
		length = len;
	}


	public double calculateArea ( ) throws TooLargeArea
	{
		double area;

		area = 6 * Math.pow(length,2.0);

		if (area > 1000)
		{
			throw new TooLargeArea ( );
		}
		return area;
	}

	public double calculateVolume ( ) throws TooLargeVolume
	{
		double volume;
		volume = Math.pow(length,3.0);
		if (volume > 1000)
		{
			throw new TooLargeVolume ( );
		}
		return volume;
	}

	public Vector secreatData ( )
	{
		Impl ne = new Impl ( );
		Vector data = ne.secreatData ( );
		return data; 

	}

	public ArrayList<String> costToDraw( ) throws TooLargeCost
	{
		double cost = 0.0;
		
		String costDrawStr;

		ArrayList<String> costString = new ArrayList<String>  ( );
		
		Vector data = secreatData ( );


 		for (int i = 0; i < data.size (); i ++) 
		{
			Customers temp = (Customers)data.get(i);
			

			if (temp.getType ( ).equals ("Architect") && temp.getScore ( ) < 600)
			{
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 20 * calculateArea ( );	
					
				}
				catch (TooLargeArea tla)
				{
					System.out.println (tla.getMessage ( ));
				}

				finally 
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ( );
					}

					costDrawStr = "The area drawing cost of Architects with lese then 600 score is " + cost;
					
					costString.add (costDrawStr);

				}
				
			}

			if (temp.getType ( ).equals ("Architect") && temp.getScore ( ) < 600)
			{
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 40 * calculateVolume ( );
				}
				catch (TooLargeVolume tlv)
				{	
					System.out.println (tlv.getMessage ( ) );
				}	
	
				finally
				{
					if (cost > 400000)
					{
						
						throw new TooLargeCost ( );
					
					}
					costDrawStr = "The volume drawing cost of Architects with lese then 600 score is " + cost;

					costString.add (costDrawStr);
				}	
			}

			if(temp.getType ( ).equals ("Architect") && temp.getScore ( ) >= 600)
			{

				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 10 * calculateArea ( );	
					
				}
				catch (TooLargeArea tla)
				{
					System.out.println (tla.getMessage ( ));
				}

				finally 
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ( );
					}


					costDrawStr = "The area drawing cost of Architects with more then 600 score is " + cost;

					costString.add (costDrawStr);
				
				}	
			}	

			if (temp.getType ( ).equals ("Architect") && temp.getScore ( ) >= 600)
			{
				
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 20 * calculateVolume ( );
				}
				catch (TooLargeVolume tlv)
				{	
					System.out.println (tlv.getMessage ( ) );
				}	
	
				finally
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ( );
					}

					costDrawStr = "The volume drawing cost of Architects with more then 600 score is " + cost;
					costString.add (costDrawStr);
				}

			}	

			if(temp.getType ( ).equals ("Other") && temp.getScore ( ) < 600)
			{
				
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 30 * calculateArea ( );	
					
				}
				catch (TooLargeArea tla)
				{
					System.out.println (tla.getMessage ( ));
				}

				finally 
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ( );
					}
					
					costDrawStr = "The area drawing cost of other with lese then 600 score is " + cost;
					
					costString.add (costDrawStr);
				}

			}	

			if (temp.getType ( ).equals ("Other") && temp.getScore ( ) < 600)
			{
								
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 60 * calculateVolume ( );
				}
				catch (TooLargeVolume tlv)
				{	
					System.out.println (tlv.getMessage ( ) );
				}	
	
				finally
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ( );
					}
					
					costDrawStr = "The volume drawing costof other with lese then 600 score is " + cost;
					
					costString.add (costDrawStr);
				}

			}

			if(temp.getType ( ).equals ("Other") && temp.getScore ( ) >= 600)
			{
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 20 * calculateArea ( );	
					
				}
				catch (TooLargeArea tla)
				{
					System.out.println (tla.getMessage ( ));
				}

				finally 
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ( );
					}

					costDrawStr = "The area drawing cost of other with more then 600 score is " + cost;
					
					costString.add (costDrawStr);
				}

			}	

			if (temp.getType ( ).equals ("Other") && temp.getScore ( )  >= 600)
			{
				
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 50 * calculateVolume ( );
				}
				catch (TooLargeVolume tlv)
				{	
					System.out.println (tlv.getMessage ( ) );
				}	
	
				finally
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ( );
					}
					costDrawStr = "The volume drawing costof other with more then 600 score is " + cost;
					
					costString.add (costDrawStr);
				}

			}
		}

			return costString;
	}
	public String toString()

	{
		return super.toString ( ) + " " + "The length of object is " + length;
	}
	
}