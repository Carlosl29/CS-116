package Client.Services;

import Client.Services.Enums.Jobs;
import Client.Services.Worker;

public class Engineer extends Worker
{
	private double weeklyBenefits;
	double benefits = 0.0;
	
	public Engineer(String incomingName, int incomingSS, int incomingYears, Jobs incomingJobs, double incomingWeekBen)
	{
		super(incomingName, incomingSS, incomingYears,incomingJobs);
		setWeekBenefits(incomingWeekBen);
		
	}
	
	public Engineer()
	{
		super();
		weeklyBenefits = 400.00;
	}
	
	public double benifitsCalculation(Jobs jobs)
	{
		
		if(jobs == Jobs.ELECTRICAL_ENGINEER)
		{
			benefits = weeklyBenefits + super.getYears() * 80.00;
		}
		else if(jobs == Jobs.MECHANICAL_ENGINEER)
		{
			benefits = weeklyBenefits / 2 + super.getYears() * 120.00;
		}
		else
		{
			benefits = 0.0;
		}
		
		return benefits;
	}
	
	public double getWeekBenefits()
	{
		return weeklyBenefits;
	}
	public void setWeekBenefits(double incomingBenefits)
	{
		weeklyBenefits = incomingBenefits;
	}
	
	public String toString()
	{
		String out = super.toString() + "Weekly benefits: " + weeklyBenefits + "\nBenefits: " + benefits;
		
		return out;
	}
	
	
}
