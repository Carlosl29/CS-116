//George Koutsogiannakis
package Driverclass1;
import Driverclass1.Driverclass2.Drivers;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
public class DriversClient  
{
	public static void main(String[] args) 
	{
		String na=args[0];
		String agstr=args[1];
		int ag=Integer.parseInt(agstr);
		String licstr=args[2];
		int lic=Integer.parseInt(licstr);
		String yeastr=args[3];
		double yea=Double.parseDouble(yeastr);
		
		Drivers dr1=new Drivers(na,ag,lic,yea);
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter the name of the driver");
        String nam=scan.next();
		System.out.println("Please enter the age of teh driver");
		int age2=scan.nextInt();
		System.out.println("please enter the license number");
		int licenses2=scan.nextInt();
		System.out.println("Please enter the years of driving");
		double years2=scan.nextDouble();


		
		Drivers dr2=new Drivers(nam,age2,licenses2,years2);
		
		
		DriversClient drcl=new DriversClient();
		
		System.out.println(dr1.toString());

		int f1=drcl.licenseFee(dr1);
		System.out.println("The fee for the first object is"+" "+f1);
		
		System.out.println(dr2.toString());
		
		int f2=drcl.licenseFee(dr2);
		System.out.println("The fee for the second object is"+" "+f2);
		if(dr1.equals(dr2))
			System.out.println("The command line object is equal to the keyboard object");
		else
			System.out.println("The command line object is not equal to the keyboard obkect");
		
		//ADDITION FOR EXTRA CREDIT # 2

		Drivers[] drar=null;
		try
		{
			File file=new File("Data.txt");
			Scanner scanner=new Scanner(file);
			int count=0;
			while(scanner.hasNextLine())
			{
				scanner.nextLine();
				count++;
			}
			drar=new Drivers[count];
			Scanner scanner1=new Scanner(file);
			int index=0;
			while(scanner1.hasNextLine())
			{
				String line=scanner1.nextLine();
				StringTokenizer strtok=new StringTokenizer(line, "!");
				String name=strtok.nextToken();
				String age=strtok.nextToken();
				int agint=Integer.parseInt(age);
				String l=strtok.nextToken();
				int lint=Integer.parseInt(l);
				String ye=strtok.nextToken();
				double yed=Double.parseDouble(ye);
				Drivers dr=new Drivers(name,agint,lint,yed);
				drar[index]=dr;
				index++;
			}

		}
		catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
		double max=drar[0].getLicenses();
		int num=0;
		for(int i=0; i<=drar.length-1; i++)
		{
		   System.out.println(drar[i]);
		   if(drar[i].getLicenses()>max)
			{
			   max=drar[i].getLicenses();
			   num=i;
			}
		}
		System.out.println("The auto with the highest mileage is:"+"\n"+drar[num].toString());


	}
	
	public int licenseFee(Drivers dr)
	{
		double calc=dr.getAge()*dr.getLicenses()/10000+50;

		int fee=(int)Math.min(100.0, calc);
		return fee;
	}


}
/*OUTPUT
---------- Java Interpreter ----------
The name of the driver is: No name The age is: 16 The license number is: 11111 The years of driving is: 0.5
67
The name of the driver is: Smith The age is: 45 The license number is: 12345 The years of driving is: 6.3
100

Output completed (0 sec consumed) - Normal Termination */
