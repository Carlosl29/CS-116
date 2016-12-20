package David.Arnold;
import David.Arnold.MaterialCategories;
import java.text.DecimalFormat;
public class Rod 
{
	private MaterialCategories mc = null;
	private String matNam = "";
	private double csa = 0.0; 
	private double length = 0.0; 
	int temp = 0; 
	private static int ID = 0; 
	private int currentID = 0; 
	
	public Rod ()
	{ 
		temp = 0; 
		matNam = "any";
		csa = -0.1;
		length = -0.1;
		ID++; 
		currentID = ID; 
	}
	
	public Rod (int newTemp, String newMatName, double newCSA, double newLength)
	{
		temp = newTemp;
		matNam = newMatName; 
		csa = newCSA; 
		length = newLength;
		ID++;
		currentID = ID; 
	}
	
	public int getTemp()
	{
		return temp; 
	}
	
	public MaterialCategories getMC()
	{
		return this.mc;
	}
	
	public String getMatNam()
	{
		return this.matNam; 
	}
	
	public double getCSA()
	{
		return this.csa;
	}
	
	public double getLength()
	{
		return this.length;
	}
	
	public int getCurrentID()
	{
		return currentID;
	}
	
	public void setTemp(int newTemp)
	{
		temp = newTemp; 
	}
	
	public void setMC(MaterialCategories mc1)
	{
		this.mc = mc1;
	}
	
	public void setMatNam(String newMatName)
	{
		this.matNam = newMatName;
	}
	
	public void setCSA(double newCSA)
	{
		this.csa = newCSA;
	}
	
	public void setLength(double newLength)
	{
		this.length = newLength;
	}
	
	public String toString()
	{
		String Part1 = ("The category is: " + mc);
		String Part2 = (" The name of the material is " + matNam);
		String Part3 = (" The length is " + length);
		String Part4 = (" The cross area is " + csa);
		String Part5 = (" The temperature is: " + temp);
		String Part6 = (" The object ID is " + currentID);
		String AllParts = Part1 + Part2 + Part3 + Part4 + Part5 + Part6; 
		return AllParts; 
	}
	
	public boolean equals(Rod c)
	{
		if((mc.compareTo(c.getMC())==0)&&(matNam.equals(c.getMatNam())))
		{
			return true; 
		}
		else 
		{
			return false; 
		}
	}

	public double calculateExpansion(double a)
	{
		DecimalFormat df = new DecimalFormat("0.0000");
		double DL;
		DL = temp*length*a;
		double newMyDouble = Double.parseDouble(df.format(DL));
		return newMyDouble;
	}
	
	public double calculateForce(double Y, double newMyDouble)
	{
		DecimalFormat df = new DecimalFormat("0.00");
		double DL = newMyDouble;
		double F; 
		double A = csa;
		if(length<=0)
		{
			return -1.0; 
		}
		else
		{
			F = Y*A*DL/length;
			double force = Double.parseDouble(df.format(F));
			return force; 
		}
	}
}