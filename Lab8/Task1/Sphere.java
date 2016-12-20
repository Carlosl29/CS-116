import java.util.*;
import java.text.*;

public class Sphere extends Figure  implements INT3
{
	public double radius = 0.0;
	String ask;
	static int count = 0;
	static Vector data = new Vector();
	public Sphere()
	{
		super();
		radius = 2.0;
	}
	public Sphere(String x, double y, String z)
	{
		super(x);
		radius = y;
		ask = z;
	}

	public double calculateArea() throws TooLargeAreaException
	{
		double areaOfSphere = 4 * Math.PI * (radius * radius);

		if(areaOfSphere > 1000)
			throw new TooLargeAreaException();
	
		return areaOfSphere;
	}

	public double calculateVolume() throws TooLargeVolumeException
	{
		double volumeOfSphere = (4/3) * Math.PI * (radius * radius * radius);

		if(volumeOfSphere > 10000)			
			throw new TooLargeVolumeException();
	
		return volumeOfSphere;
	}

	public String toString()
	{
		 String line;
		 line = (super.toString() + "\nMesurement: " + radius + " Calculation:" + ask);
		 return line;
	}

	
	public Vector secretData()
	{
		 Impl impl = new Impl();
		 Vector secretD = impl.secretData();
		 return secretD;
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
					 		cost = 40 * calculateArea();
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
							cost = 80 * calculateVolume();
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

							line = ("The area drawing cost for an Architect withscore >= 600 is" + cost);
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
							cost = 60 * calculateArea();
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
							cost = 120 * calculateVolume();
						}
						catch (TooLargeVolumeException tlve)
						{
							tlve.getMessage();
						}
						finally
						{
							if(cost > 400000)
								throw new TooLargeCostException();

							line = ("The volume drawing cost for an Other with score < 600 is" + cost);
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
							cost = 40 * calculateArea();
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
							cost = 100 * calculateVolume();
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
