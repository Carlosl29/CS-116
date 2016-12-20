package Client.Services;

import Client.Services.Enums.Jobs;
import Client.Services.Worker;

public class AdministrativePersonnel extends Worker
{
	private double rate;
	private double hours;
	double benefits;
	
	public AdministrativePersonnel()
	{
		super();
		rate = 10.0;
		hours = 10.0;
	}
	
	public AdministrativePersonnel(String incomingName, int incomingSS, int incomingYears, Jobs incomingJobs, double rate, double hours)
	{
		super(incomingName, incomingSS, incomingYears,incomingJobs);
		setRate(rate);
		setHours(hours);		
	}
	
	public double getRate()
	{
		return rate;
	}
	public double getHours()
	{
		return hours;
	}
	
	public void setRate(double newRate)
	{
		rate = newRate;
	}
	public void setHours(double newHours)
	{
		hours = newHours;
	}
	
	
	public double benifitsCalculation(Jobs incomingJob)
	{
		if(incomingJob == Jobs.ADMINISTRATIVE_SECRETARY)
		{
			benefits = rate * hours + super.getYears() * 15.00;
		}
		else if(incomingJob == Jobs.ADMINISTRATIVE_ASSISTANT)
		{
			benefits = rate * hours + super.getYears() * 25.00;
		}
		else
		{
			benefits = 0;
		}
		
		return benefits;
	}
	
	public String toString()
	{
		String out = super.toString() + "\nRate: " + rate + "\nHours: " + hours;
		return out;
	}
	
}
