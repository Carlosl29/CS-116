package Client.Services;

import Client.Services.Enums.Jobs;
import Client.Services.Worker;

public class Management extends Worker
{
	private double weeklyBenefits;
	private double bonus;
	double benefits;
	
	public Management()
	{
		super();
		weeklyBenefits = 400.00;
	}
	
	public Management(String incomingName, int incomingSS, int incomingYears, Jobs incomingJobs, double incomingWeekBen, double incomingBonus)
	{
		super(incomingName, incomingSS, incomingYears,incomingJobs);
		setWeekBenefits(incomingWeekBen);
		setBonus(incomingBonus);		
	}
	
	public double getWeekBenefits()
	{
		return weeklyBenefits;
	}
	public double getBonus()
	{
		return bonus;
	}
	
	public void setWeekBenefits(double newWeekBen)
	{
		weeklyBenefits = newWeekBen;
	}
	public void setBonus(double newBonus)
	{
		bonus = newBonus;
	}
	
	
	public double benifitsCalculation(Jobs jobs)
	{
		
		if(jobs == Jobs.ENGINEER_MANAGER)
		{
			benefits = weeklyBenefits + bonus;
		}
		else if(jobs == Jobs.ADMINISTRATIVE_MANAGER)
		{
			benefits = weeklyBenefits + 0.5 * bonus;
		}
		else
		{
			benefits = 0;
		}
		
		return benefits;
	}
	
	public String toString()
	{
		String out = super.toString() + "\nWeekly benefit: " + weeklyBenefits + "\nBonus: " + bonus;
		return out;
	}
	
}
