import java.util.*;

public class Sphere extends Figure implements INT3
{
	double radius;

	public Sphere ( )
	{
		super ( );
		radius = 0.0;
	}

	public Sphere (String name, double rad)
	{
		super (name);
		radius = rad;
	}
	public double calculateArea( )throws TooLargeArea
	{
		double area =  4 * Math.PI * Math.pow(radius,2.00);
		if (area > 1000)
		{
			throw new TooLargeArea ( );
		}
		return area;
	}

	public double calculateVolume ( )throws TooLargeVolume
	{
		double volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3.00);
		if (volume > 1000)
		{
			throw new TooLargeVolume ( );
		}
		return volume;
	}

	public Vector secreatData ( )
	{
		Impl fd = new Impl ( );
		Vector customData = fd.secreatData ( );
		return customData;
	}

	public String toString( )
	{
		return super.toString ( ) + "The length of radius is" + radius;
	}

	public ArrayList<String> costToDraw( ) throws TooLargeCost
	{
		double cost = 0.0;
		
		String costDrawStr;

		Vector customData =  secreatData ( );
		
		ArrayList<String> stringData = new ArrayList<String> ( );

		for (int i = 0; i < customData.size ( ); i ++)
		{
			Customers temp = (Customers)customData.get(i);

			if(temp.getType ( ).equals ("Architect") && temp.getScore ( ) < 600)
			{
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 40 * calculateArea ( );
				}
				
				catch (TooLargeArea tlc)
				{
					System.out.println (tlc.getMessage ( ));
				}

				finally
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ();
					}
					costDrawStr = "The area drawing cost of Architects with lese then 600 score is " + cost;

					stringData.add (costDrawStr);
				}
			}

			if (temp.getType ( ).equals ("Architect")&& temp.getScore ( ) < 600)
			{
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 80 * calculateVolume ( );
				}
				catch (TooLargeVolume tlv)
				{
					System.out.println (tlv.getMessage ( ));
				}

				finally
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ( );
					}
					
					costDrawStr = "The volume drawing costof Architects with lese then 600 score is " + cost;

					stringData.add (costDrawStr);
				}
			}

			if(temp.getType ( ).equals ("Architect") && temp.getScore ( ) >= 600)
			{
				
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 20 * calculateArea ( );
				}
				
				catch (TooLargeArea tlc)
				{
					System.out.println (tlc.getMessage ( ));
				}

				finally
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ();
					}
					costDrawStr = "The area drawing cost of Architects with more then 600 score is " + cost;

					stringData.add (costDrawStr);
				}
			}	

			if (temp.getType ( ).equals ("Architect") && temp.getScore ( ) >= 600)
			{
				
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 40 * calculateVolume ( );
				}
				
				catch (TooLargeVolume tlv)
				{
					System.out.println (tlv.getMessage ( ));
				}

				finally
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ( );
					}
				
					costDrawStr = "The volume drawing costof Architects with more then 600 score is " + cost;
					stringData.add (costDrawStr);
				}
			}	

			if(temp.getType ( ).equals ("Other") && temp.getScore ( ) < 600)
			{
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 60 * calculateArea ( );
				}
				
				catch (TooLargeArea tlc)
				{
					System.out.println (tlc.getMessage ( ));
				}

				finally
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ( );
					}
					costDrawStr = "The area drawing cost of other with lese then 600 score is " + cost;
					
					stringData.add (costDrawStr);
				}
			}	

			if (temp.getType ( ).equals ("Other") && temp.getScore ( ) < 600)
			{
				
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 120 * calculateVolume ( );
				}
				
				catch (TooLargeVolume tlv)
				{
					System.out.println (tlv.getMessage ( ));
				}

				finally
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ( );
					}
				
					costDrawStr = "The volume drawing costof other with lese then 600 score is " + cost;
				
					stringData.add (costDrawStr);
				}

			}	

			if(temp.getType ( ).equals ("Other") && temp.getScore ( ) >= 600)
			{
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 40 * calculateArea ( );
				}
				
				catch (TooLargeArea tlc)
				{
					System.out.println (tlc.getMessage ( ));
				}

				finally
				{
					if (cost > 400000)
					{ 
						throw new TooLargeCost ( );
					}
					
					costDrawStr = "The area drawing cost of other with more then 600 score is " + cost;
					
					stringData.add (costDrawStr);
				}

			}	

			if (temp.getType ( ).equals ("Other") && temp.getScore ( )  >= 600)
			{
				try
				{
					System.out.println ("The Customers type is " + temp.toString ( ));
					cost = 100 * calculateVolume ( );
				}
				
				catch (TooLargeVolume tlv)
				{
					System.out.println (tlv.getMessage ( ));
				}

				finally
				{
					if (cost > 400000)
					{
						throw new TooLargeCost ( );
					}
					
					costDrawStr = "The volume drawing costof other with more then 600 score is " + cost;
					
					stringData.add (costDrawStr);
				}
			}	

		}

			return stringData;
	}


}
