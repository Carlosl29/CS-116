package Daniel;
import java.text.*;
import java.util.*;
import java.io.*;
import Daniel.MayaChavez.MaterialCategories;
import Daniel.MayaChavez.Rod;
import Daniel.MayaChavez.ReadData;


public class RodClient
{
	public static void main(String [] args)
	{
		String execution = args[0];				//capturing the name of the text file	
		ReadData reading = new ReadData();		
		Vector unsortervec = reading.vectorData(execution);			//capturing the vector with the data
		double [] thermalexparray = reading.getThermalExpArray();	//capturing the array with the thermal expansion values
		double [] modulusarray = reading.getModulusArray();			//capturing the array with the modulus values
		Vector sortedvec = reading.sortVector(unsortervec);			//sorting the vector array
		
		int checkszero = -1;
		for(int i = 0; i < sortedvec.size(); i++)					//loop to display the sorted array, expansion and force after having calculated the latter two.
		{															
			System.out.println(sortedvec.get(i).toString());		//Printing out the attributes for each object 
		
			Rod temporary = (Rod)sortedvec.get(i);					//this is a temporary Rod object to retrieve the obeject of the Vector and calculate the change in length and the force.
			int temperature = temporary.getTemp();					//retrieving the temperature of the object
			double changeinlength = temporary.calculateExpansion(thermalexparray[i]);   //calculating its change in lenth using the thermal expansion value
			double force = temporary.calculateForce(modulusarray[i],changeinlength);	//calculating the force using the change in length gotten from the previous instruction and the young's modulus saved in our double []
			
			System.out.println("The expansion is: " + changeinlength);			//printing out the change in length
			if(checkszero == force)				//checking if the force is not -1, if it is, then a message that the force can't be calculated will be displayed.
			{
				System.out.println("This force could not be calculated because the length was zero or less");
			}
			else
				System.out.println("The force is = " + force + "\n");		//otherwise, it will print out the force and move on to the next object.
		}
		
		
//Code to find a key 
		System.out.println("____________________________________Find Temperature Output____________________________________________\n");
		
		int key1 = reading.searchVector(sortedvec, 89);				//finding the index where the key is located, if it exists
		if(key1 != -1)
			System.out.println(sortedvec.get(key1).toString());		//if it does, it will output the attributes of the Rod object
		else
			System.out.println("Temperature 89 was not found");			//else, it will return the latter statement
		
		
		int key2 = reading.searchVector(sortedvec, 156);				//finding the index where the key is located, if it exists
		
		if(key2 != -1)
			System.out.println(sortedvec.get(key2).toString());		//if it does, it will output the attributes of the Rod object
		else
			System.out.println("\nTemperature 156 was not found");			//else, it will return the latter statement
		
				
	}
}
