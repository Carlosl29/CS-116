import java.util.*;
import java.lang.Math;

public class Sphere extends Figure implements INT3
{
	double radius;
	String ask;
	
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
	
	
	public double calculateArea()
	{
		double areaOfSphere;
		areaOfSphere = 4 * Math.PI * (radius*radius);
		return areaOfSphere;
	}
	
	public double calculateVolume()
	{
		double volumeOfSphere;
		volumeOfSphere = (4/3) * Math.PI * (radius*radius*radius);
		return volumeOfSphere;
	}
	
	public String toString()
	{
		String line = (super.toString() + "Radius: " + radius + " Calculation: " + ask);
		return line;
	}
	
	public Vector secretData()
	{
		Impl impl = new Impl();
		Vector data = impl.secretData();
		return data;		
	}
	
	public ArrayList<String> costToDraw()
	{
		double cost = 0.0;
		String line = " ";
		ArrayList<String> acost = new ArrayList<String>();
		Vector data = secretData();
		for(int i=0; i < data.size(); i++)
		{
			Object obj1 = data.get(i);
			Customers cust1 = (Customers)obj1;
			
			if((cust1.getType().equals("Architect")) && (cust1.getScore()<600) && (ask.equals("area")))
			{
				cost = 40 * calculateArea();
				line = "The area drawing cost for an Architect with score <600 is " + cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Architect")) && (cust1.getScore()<600) && (ask.equals("volume")))
			{
				cost = 80 * calculateVolume();
				line = "The volume drawing cost for an Architect with score<600 is "+cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Architect")) && (cust1.getScore()>=600) && (ask.equals("area")))
			{  
				cost = 20 * calculateArea();
				line = "The area drawing cost for an Architect with score >=600 is " + cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Architect")) && (cust1.getScore()>=600) && (ask.equals("volume")))
			{  
				cost = 40 * calculateVolume();
				line = "The volume drawing cost for an Architect with score >=600 is " + cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Other")) && (cust1.getScore()<600) && (ask.equals("area")))
			{  
				cost = 60 * calculateArea();
				line = "The area drawing cost for an Other with score <600 is " + cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Other")) && (cust1.getScore()<600) && (ask.equals("volume")))
			{  
				cost = 120 * calculateVolume();
				line = "The volume drawing cost for an Other with score <600 is " + cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Other")) && (cust1.getScore()>=600) && (ask.equals("area")))
			{  
				cost = 40 * calculateArea();
				line = "The area  drawing cost for an Other with score >=600 is " + cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Other")) && (cust1.getScore()>=600) && (ask.equals("volume")))
			{  
				cost = 100 * calculateVolume();
				line = "The volume drawing cost for an Other with score>=600 is " + cost;
				acost.add(line);
			}

		}
		return acost;
	}
}
