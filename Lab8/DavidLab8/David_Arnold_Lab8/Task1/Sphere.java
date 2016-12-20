/*	Written by David Arnold 
	A20347544
	CS 116-01
*/
import java.util.*;
import java.text.DecimalFormat;

public class Sphere extends Figure implements INT3
{
	double radius = 0.0; 
	String operation = "";
	public Sphere()
	{
		super("Sphere");
		radius = 0.0;
		operation = "";
	}
	
	public Sphere(double newRadius, String newOperation)
	{
		super("Sphere");
		radius = newRadius;
		operation = newOperation;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public void setRadius(double newRadius)
	{
		radius = newRadius;
	}
	
	public String getOperation()
	{
		return operation;
	}
	
	public void setOperation(String newOperation)
	{
		operation = newOperation;
	}
	
	public double calculateArea()
	{
		try
		{
			double area =  4*(Math.PI)*(Math.pow(radius,2));
			if(area>1000)
			{
				throw new TooLargeAreaException();
			}
			return area;
		}
		catch (TooLargeAreaException tlae)
		{
			System.out.println(tlae.getMessage());
		}
		return 0.0;
	}
	
	public double calculateVolume()
	{
		try 
		{
			double volume =  (4.0/3.0)*(Math.PI)*(Math.pow(radius,3));
			if(volume>10000)
			{
				throw new TooLargeVolumeException();
			}
			return volume; 
		}
		catch (TooLargeVolumeException tlve)
		{
			System.out.println(tlve.getMessage());
		}
		return 0.0;
	}
	
	public Vector secretData()
	{
		IMPL i = new IMPL();
		return i.secretData();
	}
	
	public ArrayList<String> costToDraw()
	{
		//Sphere sp1 = new Sphere(radius);
		//secretData();
		Vector v = secretData();
		//System.out.println("Hey there");
		double cost = 0.0; 
		//System.out.println(v.size());
		//System.out.println("The radius is " + radius);
		ArrayList<String> strings = new ArrayList<String>(8);
		for(int i = 0; i<v.size(); i++)
		{
			Object ob1 = v.get(i);
			Customers c1 = (Customers)ob1;
			if(c1.getType().equals("Architect"))
			{
				if(c1.getScore()<600)
				{
					if(operation.equals("area"))
					{
						try
						{
							cost = calculateArea()*40;
							if((cost)>400000)
							{
								throw new TooLargeCostException();
							}
							String op1 = ("The area drawing cost for an Architect with score <600 is: " + cost);
							strings.add(op1);
							//System.out.println(op1);
						}
						catch (TooLargeCostException tlce)
						{
							System.out.println(tlce.getMessage());
						}
					}
					else
					{
						if(operation.equals("volume"))
						{
							try
							{
								cost = calculateVolume()*80.00;
								if((cost)>400000)
								{
									throw new TooLargeCostException();
								}
								String op5 = ("The volume drawing cost for an Architect with score <600 is: " + cost);
								strings.add(op5);
								//System.out.println(op5);
							}
							catch (TooLargeCostException tlce)
							{
								System.out.println(tlce.getMessage());
							}
							/*System.out.println(sp1.calculateArea());
							System.out.println(sp1.calculateVolume());*/
						}
					}
					
				}
				else
				{
					if(operation.equals("area"))
					{
						try
						{
							cost = calculateArea()*20.00;
							if((cost)>400000)
							{
								throw new TooLargeCostException();
							}
							String op2 = ("The area drawing cost for an Architect with score >=600 is: " + cost);
							strings.add(op2);
							//System.out.println(op2);
						}
						catch (TooLargeCostException tlce)
						{
							System.out.println(tlce.getMessage());
						}
					}
					else
					{
						if(operation.equals("volume"))
						{
							try
							{
								cost = calculateVolume()*40.00;
								if((cost)>400000)
								{
									throw new TooLargeCostException();
								}
								String op6 = ("The volume drawing cost for an Architect with score >=600 is: " + cost);
								strings.add(op6);
								//System.out.println(op6);
							}
						catch (TooLargeCostException tlce)
							{
								System.out.println(tlce.getMessage());
							}
							/*System.out.println(sp1.calculateArea());
							System.out.println(sp1.calculateVolume());*/
						}
					}
				}
			}
			else
			{
				if(c1.getType().equals("Other"))
				{
					if(c1.getScore()<600)
					{
						if(operation.equals("area"))
						{
							try
							{
								cost = calculateArea()*60.00;
								if((cost)>400000)
								{
									throw new TooLargeCostException();
								}
								String op3 = ("The area drawing cost for an Other with score <600 is: " + cost);
								strings.add(op3);
								//System.out.println(op3);
							}
							catch (TooLargeCostException tlce)
							{
								System.out.println(tlce.getMessage());
							}
						}
						else
						{
							if(operation.equals("volume"))
							{
								try
								{
									cost = calculateVolume()*120.00;
									if((cost)>400000)
									{
										throw new TooLargeCostException();
									}
									String op7 = ("The volume drawing cost for an Other with score <600 is: " + cost);
									strings.add(op7);
									//System.out.println(op7);
								}
								catch (TooLargeCostException tlce)
								{
									System.out.println(tlce.getMessage());
								}
								/*System.out.println(sp1.calculateArea());
								System.out.println(sp1.calculateVolume());*/
							}
						}
						
					}
					else
					{
						if(operation.equals("area"))
						{
							try
							{
								cost = calculateArea()*40.00;
								if((cost)>400000)
								{
									throw new TooLargeCostException();
								}
								String op4 = ("The area drawing cost for an Other with score >=600 is: " + cost);
								strings.add(op4);
								//System.out.println(op4);
							}
							catch (TooLargeCostException tlce)
							{
								System.out.println(tlce.getMessage());
							}
						}
						else
						{
							if(operation.equals("volume"))
							{
								try
								{
									cost = calculateVolume()*100.00;
									if((cost)>400000)
									{
										throw new TooLargeCostException();
									}
									String op8 = ("The volume drawing cost for an Other with score >=600 is: " + cost);
									strings.add(op8);
									//System.out.println(op8);
								}
								catch (TooLargeCostException tlce)
								{
									System.out.println(tlce.getMessage());
								}
								/*System.out.println(sp1.calculateArea());
								System.out.println(sp1.calculateVolume());*/
							}
						}
					}
				}
			}
		}
		return strings;
	}
	
	public String toString()
	{
		String original = super.toString();
		String part1 = (" The radius is " + radius);
		String part2 = (" And the parameter asked for is " + operation);
		String total = original + part1 + part2; 
		return total; 
	}
}