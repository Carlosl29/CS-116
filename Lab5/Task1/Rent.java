package Client.Services.Enum.Help;

public class Rent
{
	String location;
	int yearOfLeasing;
	int buildingNumber;
	static double rentcostforallobjects;
	
	public Rent()
	{
		location = "Chicago";
		yearOfLeasing = 0000;
		buildingNumber = 0;
		rentcostforallobjects = 0.0;		
	}
	public Rent(String newLocation, int newYearLease, int newBuildNum)
	{
		location = newLocation;
		yearOfLeasing = newYearLease;
		buildingNumber = newBuildNum;
	}
	
	public String getLocation()
	{
		return location;
	}
	public int getLeaseYear()
	{
		return yearOfLeasing;	
	}
	public int getBuildNum()
	{
		return buildingNumber;
	}
	
	public void setLocation(String newLocation)
	{
		location = newLocation;
	}
	public void setLeaseYear(int newYear)
	{
		yearOfLeasing = newYear;
	}
	public void setBuildNum(int newBuildNum)
	{
		buildingNumber = newBuildNum;
	}
	
	public String toString()
	{	
		String line;
		line = ("Location: " + location + "\nYear of Leasing: " + yearOfLeasing + "\nBuilding Number: " + buildingNumber);
		
		return line;
	}
		
	public double getRentForAll()
	{
		return rentcostforallobjects;
	}
	
	public double rent()
	{
		double locationDouble;
		locationDouble = Double.parseDouble(location);
		
		double buildingRent = locationDouble*yearOfLeasing*150/buildingNumber;
		rentcostforallobjects += buildingRent;
		System.out.println("Rent for 1 Building: " + buildingRent);
		System.out.println("Rent for All Buildings Total: " + rentcostforallobjects);
		
		return buildingRent;
	}
}
