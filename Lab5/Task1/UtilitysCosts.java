package Client.Services.Enum.Help;

public class UtilitysCosts
{
	double electricity;
	double gas;
	double water;
	static double utilcostsforallobjects;
	
	public UtilitysCosts()
	{
		electricity = 0.0;
		gas = 0.0;
		water = 0.0;
	}
	
	public UtilitysCosts(double newElect,double newGas,double newWater)
	{
		electricity = newElect;
		gas = newGas;
		water = newWater;
	}
	
	public double getWater()
	{
		return water;
	}
	public double getGas()
	{
		return gas;
	}
	public double getElectric()
	{
		return electricity;
	}
	
	public void setWater(double newWater)
	{
		water = newWater;
	}
	public void setGas(double newGas)
	{
		gas = newGas;
	}
	public void setElectric(double newElectricity)
	{
		electricity = newElectricity;
	}
	
	public String toString()
	{	
		String line;
		line = ("Water: " + water + "\nGas: " + gas + "\nElectricity: " + electricity);
		
		return line;
	}
	
	public double getutilcostsforallobjects()
	{
		return utilcostsforallobjects;
	}
	
	public double totalUtilCosts()
	{
		double sumOfUtilities = electricity + gas + water;
		System.out.println("Total Cost for 1 Object: " + sumOfUtilities);
		utilcostsforallobjects += sumOfUtilities;
		System.out.println("Total Cost for all Objects: " + utilcostsforallobjects);			
		return sumOfUtilities;
	}
}
