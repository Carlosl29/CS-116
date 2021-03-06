package David.Arnold; 
import David.Arnold.Rod; 
import David.Arnold.MaterialCategories; 
import java.io.File; 
import java.io.IOException; 
import java.util.Scanner;
import java.util.StringTokenizer; 
import java.util.Vector; 
public class ReadData 
{
	public double [] coefficients = null; 
	public double [] Young = null; 
	
	public double [] getCoefficients() 
	{
		return coefficients;
	}
	
	public double [] getYoung()
	{
		return Young;
	}
	
	public Vector vectorData(String filename)
	{
		Rod [] rodArray = null; 
		int count = 0; 
		MaterialCategories mc = null; 
		String namMat = ""; 
		double csa = 0.0; 
		double length = 0.0; 
		int temp = 0; 
		int index = 0; 
		Vector v = new Vector();
		try 
		{
			File ifile = new File(filename);
			Scanner scan = new Scanner(ifile);
			while(scan.hasNextLine())
			{
				scan.nextLine();
				count++;
			}
			rodArray = new Rod [count]; 
			coefficients = new double [count];
			Young = new double [count]; 
			Scanner scan2 = new Scanner(ifile);
			while(scan2.hasNextLine())
			{
				String line = scan2.nextLine();
				StringTokenizer strtok = new StringTokenizer(line, ",");
				mc = MaterialCategories.valueOf(strtok.nextToken());
				namMat = strtok.nextToken();
				csa = Double.parseDouble(strtok.nextToken());
				length = Double.parseDouble(strtok.nextToken());
				coefficients [index] = Double.parseDouble(strtok.nextToken());
				//System.out.println(coefficients [index]);
				Young [index] = Double.parseDouble(strtok.nextToken());
				temp = Integer.parseInt(strtok.nextToken());
				Rod r1 = new Rod(temp, namMat, csa, length);
				r1.setMC(mc);
				rodArray [index] = r1; 
				v.addElement(rodArray[index]);
				index++; 
			}
		}
		catch (IOException ioe)
		{
			System.out.println("Something went wrong");
		}
		//System.out.println(coefficients.length);
		return v; 
	}
	
	public Vector sortVector(Vector v)
	{	
		//System.out.println(coefficients.length);
		Rod [] rodArray = new Rod [v.size()]; ;  
		
		for(int i = 0; i<v.size();i++)
		{
			Object myRodObject = v.elementAt(i);
			rodArray [i] = (Rod)myRodObject; 
			//System.out.println(rodArray[i].toString());
		}
		Vector vec = new Vector();
		//System.out.println(rodArray.length);
		int subarrayLength = 0; 
		int index = 0; 
		for(int j = 0; j<=rodArray.length-1; j++)
		{
			subarrayLength = (rodArray.length-j); 
			index = 0; 
			for(int k = 1; k<subarrayLength; k++)
			{
				if(rodArray[k].getTemp()<rodArray[index].getTemp())
				{
					index = k; 
				}
			}
			//System.out.println(subarrayLength);
			//System.out.println(index);
			double coetemp = coefficients [index]; 
			coefficients [index] = coefficients[rodArray.length-1-j];
			coefficients[rodArray.length-1-j] = coetemp;
			double Youngtemp = Young [index]; 
			Young [index] = Young [rodArray.length-1-j]; 
			Young [rodArray.length-1-j] = Youngtemp;
			Rod temp = rodArray [index]; 
			rodArray [index] = rodArray[rodArray.length-1-j];
			rodArray[rodArray.length-1-j] = temp;
		}
		for(int k = 0; k<=rodArray.length-1; k++)
		{
			vec.addElement(rodArray[k]);
		}
		return vec;
	}
	
	public int searchVector(Vector sv, int key)
	{
		Rod [] rodArray = new Rod[sv.size()];
		for(int i = 0; i<sv.size(); i++)
		{
			Object newRodObject = sv.elementAt(i);
			rodArray [i] = (Rod)newRodObject;
			//System.out.println(rodArray[i].getTemp());
		}
		int start = 0; 
		//System.out.println(key);
		int end = rodArray.length-1;
		while(end>=start)
		{
			int middle = (end+start)/2;
			//System.out.println(rodArray[middle].getTemp());
			if(rodArray[middle].getTemp() == key)
			{
				//System.out.println("Hey");
				return middle; 
			}
			else 
			{
				if(rodArray[middle].getTemp() < key)
				{
					end = middle-1; 
				}
				else
				{
					start = middle+1; 
				}
			}
		}
		return -1; 
	}
}
