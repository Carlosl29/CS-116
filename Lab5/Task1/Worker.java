package Client.Services;

import Client.Services.Enums.Jobs;

public abstract class Worker
{
	public String name;
	public int socialSecurity;
	private int yearsExperience;
	public Jobs et;
	public static int id;
	public int currentID;

	
	public Worker()
	{
		name = "AnyName";
		socialSecurity = 12345;
		yearsExperience = 0;
		et = Jobs.NONE;
		id++;
		currentID = id;
	}
	
	public Worker(String incomingName, int incomingSS, int incomingYears, Jobs incomingJobs)
	{
		id++;
		currentID = id;
	}
	
	public String getName()
	{
		return name;
	}
	public int getSS()
	{
		return socialSecurity;
	}
	public int getYears()
	{
		return yearsExperience;
	}
	public Jobs getET()
	{
		return et;
	}
	
	
	public void setName(String newName)
	{
		name = newName;
	}
	public void setSS(int newSS)
	{
		socialSecurity = newSS;
	}
	public void setYears(int newYears)
	{
		yearsExperience = newYears;
	}
	public void setET(Jobs newJobs)
	{
		et = newJobs;		
	}

	public abstract double benifitsCalculation(Jobs jobs);
}
