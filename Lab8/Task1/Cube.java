import java.util.*;

public class Cube extends Figure  implements INT3
{
	public double length = 0.0;
	String ask;
	static int count = 0;
	static Vector data = new Vector();

	public Cube()
	{
		super();
		length = 2.0;
	}
	public Cube(String x, double y, String z)
	{
		super(x);
		length = y;
		ask = z;		
	}

	public double calculateArea() throws TooLargeAreaException
	{
		double areaOfCube = 6 * (length * length);

		if(areaOfCube > 1000)
			throw new TooLargeAreaException();
		
		return areaOfCube;
	}

	public double calculateVolume() throws TooLargeVolumeException
	{
		double volumeOfCube = (length * length * length);

		if(volumeOfCube > 10000)
			throw new TooLargeVolumeException();		
		
		return volumeOfCube;
	}

	public String toString()
	{
		String line = (super.toString() + "\nMeasurment: " + length + " Calculation: " + ask);
		return line;
	}
	
	public Vector secretData()
	{
		 Impl impl = new Impl();
		 Vector data2 = impl.secretData();
		 return data2;
	}

	public ArrayList<String> costToDraw() throws TooLargeCostException
	{			
		count++;
		double cost = 0.0;
		String line;
		ArrayList<String> arrayC = new ArrayList<String>();
		
		if((count == 1) && (Cube.count == 0))
		{
			data = secretData();
		}
		else if((count == 1) && (Cube.count > 0))
		{
			data = Cube.data;
		}
		
		for(int i = 0; i < data.size(); i++)
		{
			Object obj1 = data.get(i);
			Customers cust1 = (Customers)obj1;
			
			if((cust1.getType().equals("Architect")))
			{
				if(cust1.getScore() < 600)
				{
					if(ask.equals("area"))
					{
						try{
							System.out.println("Customer: " + cust1.toString());
					 		cost = 20 * calculateArea();
						}
						catch (TooLargeAreaException tlae)
						{
				  			tlae.getMessage();				
						}
						finally
						{
						if(cost > 400000)
							 throw new TooLargeCostException();
					
						line = ("The area drawing cost for an Architect with score < 600 is"+ cost);
						arrayC.add(line);
						}		
					}
					else if(ask.equals("volume"))
					{
						try{
							System.out.println("Customer: " + cust1.toString());
							cost = 40 * calculateVolume();
						}
						catch (TooLargeVolumeException tlve)
						{
							tlve.getMessage();
						}
						finally
						{
						
							if(cost > 400000)					 
								throw new TooLargeCostException();

							line = ("The volume drawing cost for an Architect with score < 600 is" + cost);
							arrayC.add(line);
						}
					}
				}
				else if(cust1.getScore() >= 600)
				{
					if(ask.equals("area"))
					{
						try{
							System.out.println("Customer: " + cust1.toString());
							cost = 10 * calculateArea();
						}
						catch (TooLargeAreaException tlae)
						{
							tlae.getMessage();
						}
						finally
						{
							if(cost > 400000)						
								throw new TooLargeCostException();

							line = ("The area drawing cost for an Architect withscore >= 600 is" + cost);
							arrayC.add(line);
						}
					}
					else if(ask.equals("volume"))
					{
						try{
							System.out.println("Customer: " + cust1.toString());
							cost = 20 * calculateVolume();
						}
						catch (TooLargeVolumeException tlve)
						{
							tlve.getMessage();
						}
						finally
						{
							if(cost > 400000)
								throw new TooLargeCostException();

							line = ("The volume drawing cost for an Architect with score >= 600 is" + cost);
							arrayC.add(line);
						}
					}
				}
				
			}
			else if(cust1.getType().equals("Other"))
			{
				if(cust1.getScore() < 600)
				{
					if(ask.equals("area"))
					{
						try{
							System.out.println("Customer: " + cust1.toString());
							cost = 30 * calculateArea();
						}
						catch (TooLargeAreaException tlae)
						{
							tlae.getMessage();
						}
						finally
						{
							if(cost > 400000)
							{
								cost = 400000;
								throw new TooLargeCostException();
							}
						
							line = ("The area drawing cost for an Other with score < 600 is" + cost);
							arrayC.add(line);
						}
					}
					else if(ask.equals("volume"))	
					{
						try{
							System.out.println("Customer: " + cust1.toString());
							cost = 60 * calculateVolume();
						}
						catch (TooLargeVolumeException tlve)
						{
							tlve.getMessage();
						}
						finally
						{
							if(cost > 400000)
								throw new TooLargeCostException();

							line = ("The volume drawing cost for an Other with score <600 is" + cost);
							arrayC.add(line);
						}
					}
				}
				else if(cust1.getScore() >= 600)
				{
					if(ask.equals("area"))
					{
						try
						{
							System.out.println("Customer: " + cust1.toString());
							cost = 20 * calculateArea();
						}
						catch (TooLargeAreaException tlae)
						{
							tlae.getMessage();
						}
						finally
						{
							if(cost > 400000)
								throw new TooLargeCostException();

							line = ("The area drawing cost for an Other with score >= 600 is" + cost);
							arrayC.add(line);	
						}
					}
					else if(ask.equals("volume"))	
					{
						try
						{
							System.out.println("Customer: " + cust1.toString());
							cost = 50 * calculateVolume();
						}
						catch (TooLargeVolumeException tlve)
						{
							tlve.getMessage();
						}
						finally
						{
							if(cost > 400000)
								throw new TooLargeCostException();

							line = ("The volume drawing cost for an Other with score >= 600 is" + cost);
							arrayC.add(line);
						}
					}
				}
			}
		}
		return arrayC;
	}
}
