import java.util.*;
import java.text.*;
public class Sphere extends Figure  implements INT3
{
	public double radius=0.0;
	String asked=" ";
	static int count=0;
	static Vector v4=new Vector();
	public Sphere()
	{
		super();
		radius=2.0;
	}
	public Sphere(String n, double r, String a)
	{
		super(n);
		radius=r;
		asked=a;
		
	}

	public double calculateArea() throws TooLargeAreaException
	{
		double area=4*Math.PI*Math.pow(radius,2.0);
		if(area>1000)
		{
			
			throw new TooLargeAreaException();
		}
		return area;
	}

	public double calculateVolume() throws TooLargeVolumeException
	{
		double volume=(4/3)*Math.PI*Math.pow(radius,3);
		if(volume>10000)
		{ 
			
			throw new TooLargeVolumeException();
		}
		return volume;
	}

	
	public Vector secretData()
	{
		 Impl i=new Impl();
		 Vector v3=i.secretData();
		 return v3;
	}

	public ArrayList<String> costToDraw() throws TooLargeCostException
	{
		count++;
		double cost=0.0;
		String str=" ";
		ArrayList<String> strcost=new ArrayList<String>();
		if(count==1&&Cube.count==0)
		{
			v4=secretData();
		}
		else if(count==1&&Cube.count>0)
			v4=Cube.v4;
		
		for(int i=0; i<v4.size(); i++)
		{
			Object o=v4.get(i);
			Customers c=(Customers)o;
			
			if(c.getType().equals("Architect")&&c.getScore()<600&&asked.equals("area"))
			{
				 try
				{
					 System.out.println("The Customer is:"+" "+c.toString());
					 cost=40*calculateArea();
				}
				catch (TooLargeAreaException tla)
				{
				
				  System.out.println(tla.getMessage());
				
				
				}
				finally
				{
					if(cost>400000)
					{
						 
						 throw new TooLargeCostException();
					}
					str="The area drawing cost for an Architect with score <600 is"+" "+(new DecimalFormat("#.##")).format(cost);
					strcost.add(str);
				}
			}
			else if(c.getType().equals("Architect")&&c.getScore()<600&&asked.equals("volume"))
			{
				try
				{
					System.out.println("The Customer is:"+" "+c.toString());
					cost=80*calculateVolume();
				}
				catch (TooLargeVolumeException tlv)
				{
					 System.out.println(tlv.getMessage());
				}
				finally
				{
					if(cost>400000)
					{
					 
					 throw new TooLargeCostException();
					}
					str="The volume drawing cost for an Architect with score <600 is"+" "+(new DecimalFormat("#.##")).format(cost);
					strcost.add(str);
				}
			}
			else if(c.getType().equals("Architect")&&c.getScore()>=600&&asked.equals("area"))
		    {  
				try
				{
					System.out.println("The Customer is:"+" "+c.toString());
					cost=20*calculateArea();
				}
				catch (TooLargeAreaException tla)
				{
						System.out.println(tla.getMessage());
				}
				finally
				{
					if(cost>400000)
					{
						
						 throw new TooLargeCostException();
					}
					str="The area drawing cost for an Architect withscore >=600 is"+" "+(new DecimalFormat("#.##")).format(cost);
					 strcost.add(str);
				}
			}
			else if(c.getType().equals("Architect")&&c.getScore()>=600&&asked.equals("volume"))
		    {  
				try
				{
					System.out.println("The Customer is:"+" "+c.toString());
					cost=40*calculateVolume();
				}
				catch (TooLargeVolumeException tlv)
				{
					System.out.println(tlv.getMessage());
				}
				finally
				{
					if(cost>400000)
					{
						 
						 throw new TooLargeCostException();
					}
					str="The volume drawing cost for an Architect with score >=600 is"+" "+(new DecimalFormat("#.##")).format(cost);
					 strcost.add(str);
				}
			}
			else if(c.getType().equals("Other")&&c.getScore()<600&&asked.equals("area"))
		    {  
				try
				{
					System.out.println("The Customer is:"+" "+c.toString());
					cost=60*calculateArea();
				}
				catch (TooLargeAreaException tla)
				{
					System.out.println(tla.getMessage());
				}
				finally
				{
					if(cost>400000)
					{
						 cost=400000;
						 throw new TooLargeCostException();
					}
					str="The area drawing cost for an Other with score <600 is"+" "+(new DecimalFormat("#.##")).format(cost);
					 strcost.add(str);
				}
			}
			else if(c.getType().equals("Other")&&c.getScore()<600&&asked.equals("volume"))
		    {  
				try
				{
					System.out.println("The Customer is:"+" "+c.toString());
					cost=120*calculateVolume();
				}
				catch (TooLargeVolumeException tlv)
				{
					System.out.println(tlv.getMessage());
				
				}
				finally
				{
					if(cost>400000)
					{
						 
						 throw new TooLargeCostException();
					}
					str="The volume drawing cost for an Other with score <600 is"+" "+(new DecimalFormat("#.##")).format(cost);
					 strcost.add(str);
				}
			}
			else if(c.getType().equals("Other")&&c.getScore()>=600&&asked.equals("area"))
		    {  
				try
				{
					System.out.println("The Customer is:"+" "+c.toString());
					cost=40*calculateArea();
				}
				catch (TooLargeAreaException tla)
				{
					System.out.println(tla.getMessage());
				}
				finally
				{
					if(cost>400000)
					{
						
						 throw new TooLargeCostException();
					}
					str="The area drawing cost for an Other with score >=600 is"+" "+(new DecimalFormat("#.##")).format(cost);
					 strcost.add(str);	
				}
			}
			else if(c.getType().equals("Other")&&c.getScore()>=600&&asked.equals("volume"))
		    {  
				try
				{
					System.out.println("The Customer is:"+" "+c.toString());
					cost=100*calculateVolume();
				}
				catch (TooLargeVolumeException tlv)
				{
					
					System.out.println(tlv.getMessage());
				}
				finally
				{
					if(cost>400000)
					{
						
						 throw new TooLargeCostException();
					}
					str="The volume drawing cost for an Other with score>=600 is"+" "+(new DecimalFormat("#.##")).format(cost);
					 strcost.add(str);
				}
			}

        }
		return strcost;
	}

	public String toString()
	{
		 String out=super.toString()+"The radius is"+" "+radius+" "+"And the parameter asked for is:"+" "+asked;
		 return out;
	}
}
