package Client;

import Client.Services.BillsType;
import Client.Services.Classes.MyBills;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.IOException;

public class MyBillsClient
{
	public static void main(String[] args)
	{
	try
	{
		File dataFile = new File("myexpenses.txt");
		Scanner scan = new Scanner(dataFile);
		
		while(scan.hasNextLine())
		{
			String line1 = scan.nextLine();
			StringTokenizer stringToken = new StringTokenizer(line1, ":");
			String skip1 = stringToken.nextToken();
			String currentMonth = stringToken.nextToken();
			String skip2 = stringToken.nextToken();
			String b = stringToken.nextToken();
			BillsType billType = BillsType.valueOf(b);
			String line2 = scan.nextLine();
			StringTokenizer stringToken1 = new StringTokenizer(line2, ",");
			int index = 0;
			double[] dayE = null;
			int numOfDays = 0;
            
			while(stringToken1.hasMoreTokens())
			{
				numOfDays++;
                
			}
			dayE = new double[numOfDays];
			while(stringToken1.hasMoreTokens())
			{
				index++;
				String temp = stringToken1.nextToken();
				double dayEx = Double.parseDouble(temp);
				dayE[index] = dayEx;
                System.out.println("Made it");
			}
			MyBills mb1 = new MyBills(currentMonth, billType, dayE, numOfDays);
			
		}
	}
		catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
	}
	
	public String[] totalExpensesPerMonth(MyBills[] exp)
	{
//		File file = new File("myexpenses.txt");
		Scanner scanner1 = new Scanner("myexpenses.txt");
		MyBills[] thisMonthBills = null;
		String[] arrayOfMonthlyTotals = null;
		double monthExpenseTotal;
		while(scanner1.hasNextLine())
		{
			//The first line VVVVVVVVVVV
			String line = scanner1.nextLine();
			StringTokenizer strngtokn = new StringTokenizer(line, ":");
			String category1 = strngtokn.nextToken();
			String month = strngtokn.nextToken();
			String category2 = strngtokn.nextToken();
			String btype = strngtokn.nextToken();
			BillsType bt = BillsType.valueOf(btype);
			scanner1.nextLine();
			
			double[] dailyExpense = null;
			monthExpenseTotal = 0;
			int numberOfDays = 0;
			for(int i = 0; strngtokn.hasMoreTokens(); i++)
			{
				String doubles = strngtokn.nextToken();
				double dayExpens = Double.parseDouble(doubles);
				dailyExpense[i] = dayExpens;
				numberOfDays++;
			}			
			MyBills bill1 = new MyBills(month, bt, dailyExpense, numberOfDays);
						
			thisMonthBills = new MyBills[numberOfDays];
			
		}
		
			return arrayOfMonthlyTotals;
	}
		
}


