package Client;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.File;
import java.io.IOException;
import Client.Services.Worker;
import Client.Services.*;
import Client.Services.Enums.Jobs;

public class WorkerBenefits
{
	public static void main(String[] args) throws IOException
	{
		ArrayList<Worker> workerList = new ArrayList<Worker>();
		workerList = listOfWorkers();
		displayData(workerList);
	}
	public static ArrayList<Worker> listOfWorkers()
	{
		try
		{
			int lengthOfFile = 0;
		
			File file = new File("worker.txt");
		
			Scanner scan2 = new Scanner(file);
		
		
			ArrayList<Worker> workersList = new ArrayList<Worker>();
		
			while(scan2.hasNextLine())
			{
				String line = scan2.nextLine();
				StringTokenizer strngTknzr = new StringTokenizer(line, ",");
				String temp1 = strngTknzr.nextToken();
				Jobs job = Jobs.valueOf(temp1);
				String nameOfEmployee = strngTknzr.nextToken();
				String temp2 = strngTknzr.nextToken();
				int socialSecurity = Integer.parseInt(temp2);
				String temp3 = strngTknzr.nextToken();
				int yearsOfExp = Integer.parseInt(temp3);
			
				if(job == Jobs.ELECTRICAL_ENGINEER || job == Jobs.MECHANICAL_ENGINEER)
				{
					String temp5 = strngTknzr.nextToken();
					double weeklyBen = Double.parseDouble(temp5);		
						
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
			return workersList;
		
		}
		catch(IOException e)
		{
		    System.err.println("Caught IOException: " + e.getMessage());
		}
		
	}
	
	public static void displayData(ArrayList<Worker> ale) throws IOException
	{
		File file = new File("worker.txt");
		Scanner scan = new Scanner(file);
		int lengthOfFile = 0;
		while(scan.hasNextLine())
		{
			lengthOfFile++;
		}
		for(int i = 0; i < lengthOfFile; i++)
		{
			System.out.print(ale.get(i).toString());
		}
	}
	
	public double totalBenefits()
	{
		
	}
}
