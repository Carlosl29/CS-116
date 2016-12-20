package Driverclass1;

import Driverclass1.Driverclass2.Drivers;
import Driverclass1.Driverclass2.DriverType;
import java.util.*;

public class MyVector
{
	public static void main(String [] args)
	{
	
		//////////////////////////////
		//Display 1
		Vector v = new Vector();
		Drivers d1 = new Drivers("John", 24,345,5.5, DriverType.Adult_Male_Driver);
		Drivers d2 = new Drivers("Mary", 18, 945, 2.5, DriverType.Teenager_Female_Driver);
		Drivers d3 = new Drivers("John", 44, 345, 15.5, DriverType.Adult_Male_Driver);
		
		v.add(d1);
		v.add(d2);
		v.add(d3);
		for(int i = 0; i < v.size(); i++)
		{
			System.out.println(v.get(i).toString());	
		}
		
		//Display 1
		//////////////////////////////
		
		//////////////////////////////
		//Display 2
		System.out.println("\nSecond Display");
		Drivers d4 = new Drivers("Carlos", 24, 345, 5.5, DriverType.Adult_Male_Driver);
		
		v.add(1, d4);
		
		Integer number = new Integer(15);
		v.addElement(number);
		
		for(int j = 0; j < v.size(); j++)
		{
			System.out.println(v.get(j).toString());
		}
		//Display 2
		//////////////////////////////
		
		//////////////////////////////
		//Display 3
		System.out.println("\nThird Display");
		Vector v2 = new Vector();
		v2 = v;
		for(int k = 0; k < (v.size() - 1); k++)
		{
			for(int a = 0; a < (v.size() - 1); a++)
			{
				Object o1 = v.get(k);
				Drivers aDriver = (Drivers)o1;
				
				Object o2 = v2.get(a);
				Drivers bDriver = (Drivers)o2;

				if(aDriver.getPresentID() == bDriver.getPresentID())
				{
					
					//int id2 = v2.get(a).getPresentID();
					
					System.out.println("Object with id = " + aDriver.getPresentID() + " is equal with the object of id = " + bDriver.getPresentID());
				}
							
			}			
			
		}
		//Display 3
		//////////////////////////////
		
		//////////////////////////////
		//Display 4
		System.out.println("\nFourth Display");
		v.clear();
		System.out.println("The size of the vector is = " + v.size());
		
		
		//Display 4
		//////////////////////////////
	
	}
}
