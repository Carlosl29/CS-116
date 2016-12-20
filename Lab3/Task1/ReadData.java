package Carlos.Lopez;

import Carlos.Lopez.MaterialCategories;
import Carlos.Lopez.Rod;
import java.util.*;//Scanner,String tokenizer, vector
import java.io.File;
import java.io.IOException;

public class ReadData
{
	public double [] coefficients;
	public double [] youngModulus;
	
	public Vector vectorData(String fileName)
	{
		Vector v = new Vector();
		
		try
		{
			File file = new File("data.txt");
			Scanner scan = new Scanner(file);
			Scanner scanFile2 = new Scanner(file);
			
			int lineCounter = 0;
			while(scanFile2.hasNextLine())
			{
				//Originally forgot to advance the scanner.
				//Also forgot to use a different scanner for this 
				//and the while loop below.
				scanFile2.nextLine();
				lineCounter++;
			}
			double [] thermalCoArray = new double[lineCounter];
			double [] youngsCoArray = new double[lineCounter];
			int index = 0;
			////////////////////////////////////////
			//This reads data line by line
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();		
				StringTokenizer strngToknzr = new StringTokenizer(line, ",");
				String temp = strngToknzr.nextToken();
				MaterialCategories materialCat = MaterialCategories.valueOf(temp);
				String nameOfMaterial = strngToknzr.nextToken();
				String temp2 = strngToknzr.nextToken();
				double crossSectionArea = Double.parseDouble(temp2);
				String temp3 = strngToknzr.nextToken();
				double lengthOfRod = Double.parseDouble(temp3);
				String temp4 = strngToknzr.nextToken();
				double aCoefficientThermal = Double.parseDouble(temp4);
				String temp5 = strngToknzr.nextToken();
				double yCoefficient = Double.parseDouble(temp5);	
				String temp6 = strngToknzr.nextToken();
				int tempr = Integer.parseInt(temp6);

				//Creation of rod object
				Rod newRod = new Rod(nameOfMaterial, crossSectionArea, lengthOfRod, tempr);
				//Must use a method to add this, not just pass it as a Rod(attribute)
				newRod.setCategoryOfMaterial(materialCat);
				//Adding the last two bits of info from the data file
				thermalCoArray[index] = aCoefficientThermal;
				youngsCoArray[index] = yCoefficient;
				//Adding object into vector
				v.add(newRod);
				index++;
			}
			//////////////////////////////////////////
		
		}
		catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}	
		return v;
	}
	
	public Vector sortVector(Vector incomingV)
	{
		Vector sortedV = new Vector();
		
		for(int i = 0; i < incomingV.size(); i++)
		{
			for(int j = 0; i < incomingV.size()-1; i++)
			{
				Object o1 = incomingV.get(i);
				Rod aRod = (Rod)o1;
				
				Object o2 = incomingV.get(j);
				Rod bRod = (Rod)o2;
				
				if(aRod.getTemperature() > bRod.getTemperature())
				{
					sortedV.set(i, aRod);
				}
			}
		}
		return sortedV;
	}
	public int searchVector(Vector sv, int Key)
	{
		
		int indexOfV = -1;
		for(int c = 0; c < sv.size(); c++)
		{
			Object o1 = sv.get(c);
			Rod aRod = (Rod)o1;
			
			if(Key == aRod.getTemperature())
			{
				indexOfV = c;
			}
		}
		return indexOfV;
	}
}
