package Daniel.MayaChavez;
import Daniel.MayaChavez.MaterialCategories;
import java.util.*;
import java.text.*;
import java.io.*;

public class ReadData
{
	public double [] thermalexparray = null;
	public double [] modulusarray = null;
	
	public ReadData()
	{
		thermalexparray = null;
		modulusarray = null;
	}
	
	public ReadData(double [] ther, double [] mod)
	{
		thermalexparray = ther;
		modulusarray = mod;
	}
	
//Mutator and Accessor Methods	
	public double [] getThermalExpArray()
	{
		return thermalexparray;
	}
	public void setThermalExpArray(double [] thermal)
	{
		thermalexparray = thermal;
	}
	
	public double [] getModulusArray()
	{
		return modulusarray;
	}
	public void setModulusArray(double [] modu)
	{
		modulusarray = modu;
	}

//This method takes a String with the name of the file, reads it, and takenizes it to make a Vector of Rod Objects. Returns the Vector.	
	public Vector vectorData(String filename)
	{
		Vector rodvector = new Vector();		
		MaterialCategories type = null;
		Rod rod = null;
		int count1 = 0;
		int count2 = 0;
		
		try
		{
			File text = new File(filename); 		
			Scanner file1 = new Scanner(text);
			
			while(file1.hasNextLine())		//this first loop is too count the number of lines the text has. The Vector does not need it, but the double [] do.
			{
				file1.nextLine();
				count1++;
			}
			
			thermalexparray = new double[count1]; 	//setting the size of the array to count1 (number of lines).
			modulusarray = new double[count1];  	//the modulus will be the same size.
			StringTokenizer filetoken = null;
			Scanner file2 = new Scanner(text);		//will read the text from the beginning to create the arrays and vector.
			
			while(file2.hasNextLine())
			{
				String textline = file2.nextLine();		//capturing the first line as a String to tokenize it
				filetoken = new StringTokenizer(textline, ",");	
				String material = filetoken.nextToken();		//reading first toke, the material type.
				type = MaterialCategories.valueOf(material);	//using the enumarator to set it to the corresponding value
				String materialname = filetoken.nextToken();	// second token is the material name
				String area = filetoken.nextToken();			//cross area which is parsed on the next line
				double crossarea = Double.parseDouble(area);
				String l = filetoken.nextToken();				//length, parsed on next line
				double length = Double.parseDouble(l);
				String coefficient = filetoken.nextToken();		//coefficient, this one will be parsed and saved on the double [] created
				double thermalexp = Double.parseDouble(coefficient);
				String young = filetoken.nextToken();			//young's modulus will be saved on the other double []
				double modulus = Double.parseDouble(young);
				String t = filetoken.nextToken();
				int temp = Integer.parseInt(t);
				
				rod = new Rod(temp, materialname, crossarea, length);	//creating the object with the values captured above
				rod.setMaterialType(type);			//calling the mutator to set the enumarator 
				rodvector.add(rod);					//adding the object on to the next index
				
				thermalexparray[count2] = thermalexp;	//adding the thermal coefficient to the double []
				modulusarray[count2] = modulus;			//adding modulus to the other []
				count2++;
				
			}
		}
		
		catch(IOException ioe)
		{
			System.out.println("File missing or corrupted.");		
		}
		
		return rodvector;
	}


//Method to sort the vector with Rod Objects from largest to smallest according to temperature.
	public Vector sortVector(Vector unsorted)
	{
		Vector sortrodvec = new Vector();
		
		for(int i = 0; i < unsorted.size(); i++)	//copying our original vector onto the one that will be sorted
		{
			Rod rodobj = (Rod)unsorted.get(i);
			sortrodvec.add(rodobj);
		}
		
		int arraylength = 0;
		int index = 0;
		
		for(int j = 0; j < sortrodvec.size(); j++)	//this is the sorting algorithm
		{
			int newarraylength = sortrodvec.size()-j;	//the arraylength will be changing since we dont want to modify the indexes already sorted
			index = 0;
			
			for(int j2 = 1; j2 < newarraylength; j2++)	//this loop is used to compared one index with all the indexes left on the vector
			{
				Rod rod1 = (Rod)sortrodvec.get(j2);		//capturing the index as an object to be able to compare it
				Rod rod2 = (Rod)sortrodvec.get(index);	//captuing the second object 
				
				if(rod1.getTemp() < rod2.getTemp())		//if object 2 is greater, we set the index to the value object 1 is currently on
				{
					index = j2;
				}
			}
			
			Rod temp = (Rod)sortrodvec.get(index);			//creating a temporary Rod object to save the address being hold on the index value
			Rod largest = (Rod)sortrodvec.get(sortrodvec.size() - j - 1);	//capturing the largest object located at the end of the vector
			sortrodvec.set(index,largest);								//setting the largest value to the index value
			sortrodvec.set(sortrodvec.size() - j -1, temp);			//setting the object hold in the temporary object to the end of the vector
		}
		
		return sortrodvec;
		
	}
	
//Method that will search for a key and return it if it exist. If it doesn't, it will return -1.
	public int searchVector(Vector sv, int key)
	{
		int start = 0, end = sv.size()-1;
		int keyindex = 0;
		
		while(end >= start)
		{
			int middle = (start + end) / 2;
			Rod keyrod = (Rod)sv.get(middle);
			
			if(keyrod.getTemp() == key)
			{
				keyindex = middle;				 //setting the index to where the key is located.
				return keyindex;   				 //returning the index where the key is located.
			}
			else if(keyrod.getTemp() < key)
			{
				end = middle - 1;       		//Search left
			}
			if(keyrod.getTemp() > key)
			{
				start = middle + 1;				//Search right 
			}
		}
		
		return -1; 							    //key not found 
	}
}
