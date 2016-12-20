//CS116 
//Exam # 1
//George Koutsogiannakis
//package folder1;
//import folder1.folder2.Car;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.text.NumberFormat;
public class CarClient
{
	public static void main(String[] args) 
	{
		
		Car [] carsarray=null;
		//int [] cylinders=null;
		try
		{
				File file=new File("cars.txt");
				Scanner scan=new Scanner(file);
				int count=0;
				while(scan.hasNextLine())
				{
					
			
					scan.nextLine();
					count++;
				}
				carsarray=new Car[count];
				//cylinders=new int[count];
				Scanner scan1=new Scanner(file);
				int index=0;
				while(scan1.hasNextLine())
				{
					String line=scan1.nextLine();
					StringTokenizer tok=new StringTokenizer(line, ",");
					String str1=tok.nextToken();
					int cylnum=Integer.parseInt(str1);
					//cylinders[index]=cylnum;
					String str2=tok.nextToken();
					System.out.println(str2);
					
					 Car auto=new Car(cylnum, str2);
					 carsarray[index]=auto;
					 index++;
				}
			}//END OF TRY BLOCK
			catch(IOException ioe)
			{  
				System.out.println("Something is wrong");
			}
			System.out.println(carsarray[2]);
			System.out.println(carsarray[6]);
			if(carsarray[2].equals(carsarray[6]))
			    System.out.println("cars  3 and 7 are equal");
			else
			    System.out.println("cars 3 and 7 are not equal");
			double totalmoney=0;
			for(int i=0; i<=carsarray.length-1; i++)
			{
					double price=carsarray[i].calculatePrice();
					System.out.println("The price of the car with id"+" "+carsarray[i].getCurrentID()+
					" "+"is"+" "+price);
				    totalmoney=totalmoney+price;
					System.out.println(carsarray[i].toString());
			}
			NumberFormat nf=NumberFormat.getCurrencyInstance();
			String out=nf.format(totalmoney);
			
		    System.out.println("The total money is"+" "+out);
			
			Car c=new Car();
			Car [] cyl=c.selectionSort(carsarray);

			for(int h=0; h<carsarray.length; h++)
				System.out.println(cyl[h]);

			int x=c.binarySearch(cyl,6);
			if(x!=-1)
			{
				System.out.println("The first car object with 6 cylinders is the object with id:"+" "+cyl[x].getCurrentID());
				System.out.println("The price of that car is:"+" "+cyl[x].calculatePrice());
			}
			else
				System.out.println("The object was not found");
	}// end of main
}
