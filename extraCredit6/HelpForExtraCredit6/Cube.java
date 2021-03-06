import java.util.*;

public class Cube extends Figure implements INT3
{
	double length;
	String ask = " ";
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
	
	public double calculateArea()
	{
		double areaOfCube;
		areaOfCube = 6 * (length * length);
		return areaOfCube;
	}
	
	public double calculateVolume()
	{
		double volumeOfCube;
		volumeOfCube = ((length * length) * length);
		return volumeOfCube;	
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
				cost = 20 * calculateArea();
				line = "The area drawing cost for an Architect with score <600 is " + cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Architect")) && (cust1.getScore()<600) && (ask.equals("volume")))
			{
				cost = 40 * calculateVolume();
				line = "The volume drawing cost for an Architect with score<600 is "+cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Architect")) && (cust1.getScore()>=600) && (ask.equals("area")))
			{  
				cost = 10 * calculateArea();
				line = "The area drawing cost for an Architect with score >=600 is " + cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Architect")) && (cust1.getScore()>=600) && (ask.equals("volume")))
			{  
				cost = 20 * calculateVolume();
				line = "The volume drawing cost for an Architect with score >=600 is " + cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Other")) && (cust1.getScore()<600) && (ask.equals("area")))
			{  
				cost = 30 * calculateArea();
				line = "The area drawing cost for an Other with score <600 is " + cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Other")) && (cust1.getScore()<600) && (ask.equals("volume")))
			{  
				cost = 60 * calculateVolume();
				line = "The volume drawing cost for an Other with score <600 is " + cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Other")) && (cust1.getScore()>=600) && (ask.equals("area")))
			{  
				cost = 20 * calculateArea();
				line = "The area  drawing cost for an Other with score >=600 is " + cost;
				acost.add(line);
			}
			else if((cust1.getType().equals("Other")) && (cust1.getScore()>=600) && (ask.equals("volume")))
			{  
				cost = 50 * calculateVolume();
				line = "The volume drawing cost for an Other with score>=600 is " + cost;
				acost.add(line);
			}

		}
		return acost;
	}
}
