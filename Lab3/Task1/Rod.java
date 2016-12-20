package Carlos.Lopez;

import Carlos.Lopez.MaterialCategories;
import java.text.DecimalFormat;

public class Rod
{
	MaterialCategories categoryOfMaterial;
	String rodName;
	double crossSectionArea;
	double lengthOfRod;
	static int id;
	int currentId;	
	//new
	int temperature;
	
	public Rod()
	{
		categoryOfMaterial = null;
		rodName = "any";
		crossSectionArea = -0.1 ;
		lengthOfRod = -0.1;
		id++;
		//new
		temperature = 0;
	}
	
	public Rod(String mN, double cSA, double lR,int tempr)
	{
		rodName = mN;
		crossSectionArea = cSA;
		lengthOfRod = lR;
	}
	
	public MaterialCategories getCategoryOfMaterial()
	{
		return categoryOfMaterial;
	}
	public void setCategoryOfMaterial(MaterialCategories incomingCM)
	{
		categoryOfMaterial = incomingCM;
	}
	
	public String getRodName()
	{
		return rodName;
	}
	public void setRodName(String incomingMN)
	{
		rodName = incomingMN;
	}
	
	public double getCrossSectionArea()
	{
		return crossSectionArea;
	}
	public void setCrossSectionArea(int incomingCSA)
	{
		crossSectionArea = incomingCSA;
	}
	
	public double getLengthOfRod()
	{
		return lengthOfRod;
	}
	public void setLengthOfRod(int incomingLR)
	{
		lengthOfRod = incomingLR;
	}
	
	public int getTemperature()
	{
		return temperature;
	}
	public void setTemperature(int incomingTemp)
	{
		temperature = incomingTemp;
	}
	
	public String toString()
	{
		String rodInfo = "The Category of Material: " + categoryOfMaterial + "\nThe Rod Name: " + rodName + "\nThe Cross Section Area: " +
		+ crossSectionArea + "\nThe Length of the Rod: " + lengthOfRod + "\nThe Temperature is: " + temperature + "\n\n";
		return rodInfo;
	}
	
	public boolean equals(Rod incomingRod)
	{
		if(this.getRodName().equals(incomingRod.getRodName()) && this.getCategoryOfMaterial() == incomingRod.getCategoryOfMaterial())
			return true;
		else
			return false;
	}
	
	public double calculateExpansion(double coThrmlExp)
	{
		double thrmlExp = 0.0;
		return thrmlExp;
	}
	
	public double calculateForce(double youngConstant, double incomingDL)
	{
		DecimalFormat df2 = new DecimalFormat("#.##");
		double neededForce;
		
		if(lengthOfRod == 0 || lengthOfRod < 0)
			return -1.0;
		else
		{	
			
			neededForce = (youngConstant * crossSectionArea * (incomingDL/lengthOfRod));
		}	
		return neededForce;
	}
	

	
	


}
