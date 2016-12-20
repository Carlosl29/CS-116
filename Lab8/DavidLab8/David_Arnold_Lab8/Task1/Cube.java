/*	Written by David Arnold 
	A20347544
	CS 116-01
*/
import java.util.*;

public class Cube extends Figure implements INT3
{
	double length = 0.0; 
	String operation = "";
	
	public Cube()
	{
		super("Cube");
		length = 0.0;
		operation = "";
	}
	
	public Cube(double newLength, String newOperation)
	{
		super("Cube");
		length = newLength;
		operation = newOperation;
	}
	
	public double getLength()
	{
		return length;
	}
	
	public void setLength(double newLength)
	{
		length = newLength;
	}
	
	public String getOperation()
	{
		return operation; 
	}
	
	public void SetOperation(String newOperation)
	{
		operation = newOperation;
	}
	
	public double calculateArea()
	{
		try
		{
			double Area = 6*length*length;
			if(Area>1000)
			{
				throw new TooLargeAreaException();
			}
			return Area;
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
			double Volume = length*length*length;
			if(Volume>10000)
			{
				throw new TooLargeVolumeException();
			}
			return Volume;
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
		//Cube cu1 = new Cube(length);
		Vector v = secretData();
		//System.out.println(v.size());
		//System.out.println(" The length is " + length);
		double cost = 0.0; 
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
							cost = calculateArea()*20.00;
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
								cost = calculateVolume()*40.00;
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
						}
					}
					
				}
				else
				{
					if(operation.equals("area"))
					{
						try 
						{
							cost = calculateArea()*10.00;
							if((cost)>400000)
							{
								throw new TooLargeCostException();
							}
							String op2 = ("The area drawing cost for an Architect with score >=600 is: " + cost);
							strings.add(op2);
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
								cost = calculateVolume()*20.00;
								if((cost)>400000)
								{
									throw new TooLargeCostException();
								}
								String op6 = ("The volume drawing cost for an Architect with score >=600 is: " + cost);
								strings.add(op6);
							}
							catch (TooLargeCostException tlce)
							{
								System.out.println(tlce.getMessage());
							}	
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
								cost = calculateArea()*30.00;
								if((cost)>400000)
								{
									throw new TooLargeCostException();
								}
								String op3 = ("The area drawing cost for an Other with score <600 is: " + cost);
								strings.add(op3);
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
									cost = calculateVolume()*60.00;
									if((cost)>400000)
									{
										throw new TooLargeCostException();
									}
									String op7 = ("The volume drawing cost for an Other with score <600 is: " + cost);
									strings.add(op7);
								}
								catch (TooLargeCostException tlce)
								{
									System.out.println(tlce.getMessage());
								}	
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
								String op4 = ("The area drawing cost for an Other with score >=600 is: " + cost);
								strings.add(op4);
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
									cost = calculateVolume()*50.00;
									if((cost)>400000)
									{
										throw new TooLargeCostException();
									}
									String op8 = ("The volume drawing cost for an Other with score >=600 is: " + cost);
									strings.add(op8);
								}
								catch (TooLargeCostException tlce)
								{
									System.out.println(tlce.getMessage());
								}			
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
		String part1 = (" The length is " + length);
		String part2 = (" And the parameter asked for is " + operation);
		String total = original + part1 + part2; 
		return total; 
	}
}