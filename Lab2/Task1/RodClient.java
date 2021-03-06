package Carlos;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.IOException;
import Carlos.Lopez.MaterialCategories;
import Carlos.Lopez.Rod;

public class RodClient
{
	public static void main(String[] args) throws IOException
	{
		if(args[0].equals("textready"))
		{
			//Needs to read data from coefficients.txt
			File file = new File("coefficients.txt");
			Scanner scanFile2 = new Scanner(file);
			//Making array of object type rod
			Rod [] rodArray;
			
			//Counting how many lines in the data file
			int lineCounter = 0;
			while(scanFile2.hasNextLine())
			{
				//Originally forgot to advance the scanner.
				//Also forgot to use a different scanner for this 
				//and the while loop below.
				scanFile2.nextLine();
				lineCounter++;
			}
			
			rodArray = new Rod[lineCounter];
			//The two arrays for the last two pieces of data
			//from the line from the data file
			double [] thermalCoArray = new double[lineCounter];
			double [] youngsCoArray = new double[lineCounter];
			int index = 0;

			
			//Seperate scanner for reading the file
			Scanner scanFile = new Scanner(file);
			while(scanFile.hasNextLine())
			{
				//String tokenizer being used to read file
				String line = scanFile.nextLine();		
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
				
				//Creation of the rod object with the above scanned variables
				Rod newRod = new Rod(nameOfMaterial, crossSectionArea, lengthOfRod);
				//Must use a method to add this, not just pass it as a Rod(attribute)
				newRod.setCategoryOfMaterial(materialCat);
				//Adding the last two bits of info from the data file
				thermalCoArray[index] = aCoefficientThermal;
				youngsCoArray[index] = yCoefficient;
				rodArray[index] = newRod;
				index++;
						
			}

			
			//User inputed data
			int usrIndex = 0;
			Scanner userInput = new Scanner(System.in);
			DecimalFormat df4 = new DecimalFormat("#.#");
			double [] tempChange = new double[index];
			double [] expansionCalculated = new double[index];
			double [] forceCalculated = new double[index];
			while(usrIndex < lineCounter)
			{
				System.out.println("Please enter the change in temperature for material " + rodArray[usrIndex].getRodName() + ": ");
				tempChange[usrIndex] = userInput.nextDouble();
				System.out.println("\n");
				expansionCalculated[usrIndex] = rodArray[usrIndex].calculateExpansion(tempChange[usrIndex], thermalCoArray[usrIndex]);
				System.out.println("The Expansion is: " + expansionCalculated[usrIndex]);
				forceCalculated[usrIndex] = rodArray[usrIndex].calculateExpansion(expansionCalculated[usrIndex], youngsCoArray[usrIndex]);
				System.out.println("The Force is: " + forceCalculated[usrIndex]);
				System.out.println("\n");
				

				
				usrIndex++;
			}
			
			int allIndex = 0;
			while(allIndex < lineCounter)
			{
				System.out.println(rodArray[allIndex].toString());
				allIndex++;
			}
			
			
		}	
		else
			System.out.println("I can't provide data unless text file is ready");
	}
}
