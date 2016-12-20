package Client;

import java.util.*;
import java.io.File;
import java.io.IOException;
import Client.Services.Worker;
import Client.Services.*;
import Client.Services.Enums.Jobs;

public class WorkerBenefits
{
	/*public static void main(String[] args) throws IOException
	{
		ArrayList<Worker> workerList = new ArrayList<Worker>();
		workerList = listOfWorkers();
		displayData(workerList);
	}*/
	public static ArrayList<Worker> listOfWorkers()
	{
		//Creates a new arraylist of type Worker
		ArrayList<Worker> workersList = new ArrayList<Worker>();
		//Try/catch block to catch ioexception
		try
		{
			int lengthOfFile = 0;
			File file = new File("worker.txt");
			Scanner scan2 = new Scanner(file);
			
			//This while loop is take each line in the file
			//named above and break it into pieces, tokens,
			//with string tokenizer
			while(scan2.hasNextLine())
			{	
				//Line of data is read and stored
				String line = scan2.nextLine();
				//A new stringTokenizer is created, 
				//given the line of data scanned,
				//and the symbol in which each token
				//ends in a line
				StringTokenizer strngTknzr = new StringTokenizer(line, ",");
				//First token is read and stored
				String temp1 = strngTknzr.nextToken();
				//The temporary storage of the first token is
				//used to create a enum variable of type job
				//and the valueOf the first token
				Jobs job = Jobs.valueOf(temp1);
				//The second token is read and stored
				String nameOfEmployee = strngTknzr.nextToken();
				//The third token is read and stored into a temp
				String temp2 = strngTknzr.nextToken();
				//The value of the third token is parsed into 
				//an int so as to be able to add it later on 
				//to the object
				int socialSecurity = Integer.parseInt(temp2);
				//The fourth token is read and stored into a temp
				String temp3 = strngTknzr.nextToken();
				//The value of the fourth token is also parsed
				//into an int
				int yearsOfExp = Integer.parseInt(temp3);
				
				//If else statments used in order to add job specific attributes
				//to the new object 
				if(job == Jobs.ELECTRICAL_ENGINEER || job == Jobs.MECHANICAL_ENGINEER)
				{
					//The fifth token is read and stored into a temp
					//This token is the job/enum of the object to be
					//created, and in this if statement it's an engineer
					String temp5 = strngTknzr.nextToken();
					double weeklyBen = Double.parseDouble(temp5);		
					//The object/worker is created with the parameters
					//being the tokens that were scanned above and 
					//then added to the arraylist
					Engineer newWorker = new Engineer(nameOfEmployee, socialSecurity, yearsOfExp, job, weeklyBen);
					workersList.add(newWorker);
			
				}
				else if(job == Jobs.ADMINISTRATIVE_SECRETARY || job == Jobs.ADMINISTRATIVE_ASSISTANT)
				{
					String temp6 = strngTknzr.nextToken();
					double rate = Double.parseDouble(temp6);
					String temp7 = strngTknzr.nextToken();
					double hours = Double.parseDouble(temp7);
				
					AdministrativePersonnel newWorker = new AdministrativePersonnel(nameOfEmployee, socialSecurity, yearsOfExp, job, rate, hours);
					workersList.add(newWorker);
				}
				else if(job == Jobs.ENGINEER_MANAGER || job == Jobs.ADMINISTRATIVE_MANAGER)
				{
					String temp8 = strngTknzr.nextToken();
					double weeklyBen2 = Double.parseDouble(temp8);
					String temp9 = strngTknzr.nextToken();
					double bonus = Double.parseDouble(temp9);
				
					Management newWorker = new Management(nameOfEmployee, socialSecurity, yearsOfExp, job, weeklyBen2, bonus);
					workersList.add(newWorker);
				}
			
						
			}
		}
		//If an exception is thrown
		//then print out the ioe 
		//default exception message
		catch(IOException ioe)
		{
			ioe.getMessage();
		}
		//After scanning all the data and 
		//using it to create workers to be
		//added into an arraylist, that
		//arraylist is returned
		return workersList;
	}
	//Method to display the data of the arraylist
	public static void displayData(ArrayList<Worker> ale) throws IOException
	{	
		//File is created and scanner is pointed to it
		File file = new File("worker.txt");
		Scanner scan = new Scanner(file);
		int lengthOfFile = 0;
		//While loop to find the length of the file
		while(scan.hasNextLine())
		{
			lengthOfFile++;
		}
		//For loop that runs for the length of the file
		//and everytime prints out the toString() of 
		//each object
		for(int i = 0; i < lengthOfFile; i++)
		{
			System.out.print(ale.get(i).toString());
		}
	}
	//Method to calculate all the benefits
	//given to all the employees
	public double totalBenefits(ArrayList<Worker> incomingList)
	{
		double totalBenefits = 0.0;
		//For loop that runs for the length the 
		//recieved arraylist		
		
		for(int i = 0; i < incomingList.size(); i++)
		{
			Object ob1 = incomingList.get(i);
			Worker wrkr1 = (Worker)ob1;
			
			switch(incomingList.get(i).getET())
			{
				case ELECTRICAL_ENGINEER: 
																totalBenefits += wrkr1.benifitsCalculation(Jobs.ELECTRICAL_ENGINEER);
																break;
				case MECHANICAL_ENGINEER: 
																totalBenefits += wrkr1.benifitsCalculation(Jobs.MECHANICAL_ENGINEER);
																break;																
				case ADMINISTRATIVE_SECRETARY: 
																totalBenefits += wrkr1.benifitsCalculation(Jobs.ADMINISTRATIVE_SECRETARY);
																break;
				case ADMINISTRATIVE_ASSISTANT: 
																totalBenefits += wrkr1.benifitsCalculation(Jobs.ADMINISTRATIVE_ASSISTANT);
																break;
				case ENGINEER_MANAGER: 
																totalBenefits += wrkr1.benifitsCalculation(Jobs.ENGINEER_MANAGER);
																break;
				case ADMINISTRATIVE_MANAGER: 
																totalBenefits += wrkr1.benifitsCalculation(Jobs.ADMINISTRATIVE_MANAGER);
																break;
				case NONE: 
																totalBenefits += wrkr1.benifitsCalculation(Jobs.NONE);
																break;	
				default:
																totalBenefits = totalBenefits + 0;
																break;
			}
		}
		
		return totalBenefits;
	}
}
