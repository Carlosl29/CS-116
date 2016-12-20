package Daniel.MayaChavez;
import java.text.*;

public class Rod
{
	MaterialCategories materialtype = null;
	String materialname = " ";
	double area = 0.0;
	double length = 0.0;
	static int id = 0;
	int presentid = 0;
	int temperature = 0;
	
	public Rod()
	{
		temperature = 0;
		materialtype = null;
		materialname = "any";
		area = -0.1;
		length = -0.1;
		id++;
		presentid = id;
	}
	
	public Rod(int temp, String name, double areA, double lengtH)
	{
		temperature = temp;
		materialtype = null;
		materialname = name;
		area = areA;
		length = lengtH;
		id++;
		presentid = id;
	}
	
//Accesor and Mutator methods

	public MaterialCategories getMaterialType()
	{
		return materialtype;
	}
	public void setMaterialType(MaterialCategories material)
	{
		materialtype = material;
	}
	
	
	public String getMaterialName()
	{
		return materialname;
	}
	public void setMaterialName(String materialName)
	{
		materialname = materialName;
	}
	
	
	public double getArea()
	{
		return area;
	}
	public void setArea(double are)
	{
		area = are;
	}
	
	
	public double getLength()
	{
		return length;
	}
	public void setLength(double l)
	{
		length = l;
	}
	
	public int getTemp()
	{
		return temperature;
	}
	public void setTemp(int t)
	{
		temperature = t;
	}
	
//toString Method
	
	public String toString()
	{
		return "The material type is: " + materialtype + ". The material name is: " + materialname + ". The area of the rod is: " + area + ". The length is: " + length + ". The object id is: " + presentid + ". The temperature is " + temperature;
	}
	
//equals methods

	public boolean equals(Rod rd1)
	{
		if(this.getMaterialName().equals(rd1.getMaterialName()) && this.getMaterialType().equals(rd1.getMaterialType()))
			return true;
		else
			return false;
	}
	
//helper methods ... a = coefficient of thermal expansion
	
	public double calculateExpansion(double a)
	{
		double dl = a*this.getLength()*this.getTemp();
		DecimalFormat decimal = new DecimalFormat("0.0000");
		String newDL = decimal.format(dl);
		double changeinlength = Double.parseDouble(newDL);
		return changeinlength;
	}
	
	public double calculateForce(double y, double dL)
	{
		double f = y*this.getArea()*dL;
		int zero = -1;
		
		if(f > 0)
		{
			
			double force =  f/this.getLength();
			DecimalFormat decimal2 = new DecimalFormat("0.00");
			String newf = decimal2.format(force);
			double newforce = Double.parseDouble(newf);
			return newforce;
			
		}
		else
			return zero;
	}

}	