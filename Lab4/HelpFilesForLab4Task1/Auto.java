
//George Koutsogiannakis
package main.service;



// Enter import statements needed for other classes packaged.
import main.service.enums.Stores;
import main.service.enums.CarType;
//end of addition
import java.text.DecimalFormat;

public class Auto 
{
	private String owners_name;
	private double acceleration;
	private int time;
	private CarType ve;
	private static int vehicleID;
	private int currentID;

	private char soldStatus;//------enter attribute to mark an auto as sold when sold.
	private AutoStore autoShop = new AutoStore();//------enter attribute for AutoStore object

	public Auto()
	{
		owners_name=" ";

		acceleration=0.0;
		time=0;
		
		ve = null;//----initialize the enum attributes to null
		
		vehicleID++;
		currentID=vehicleID;
		
	}

	public Auto(double a, int t, String on, CarType eng)
	{
		vehicleID++;
		currentID=vehicleID;
		
		acceleration=a;
		time=t;
		owners_name=on;
		ve=eng;
	
	}

	public String getOwnersName()
	{
		return owners_name;
	}

	public double getAcceleration()
	{

		return acceleration;
	}


	public int getTime()
	{
		return time;
	}

	public int getVehicleID()
	{
		return vehicleID;
	}

	public int getCurrentID()
	{

		return currentID;
	}

	

	//Enter accessor method for the CarType enum
	
	public CarType getCarType()
	{
		return ve;
	}

	public char getSoldStatus()//-------enter accessor method to mark autos as sold
	{
		return soldStatus;
	}
	
	
	public void setOwnersName(String name)
	{
		owners_name=name;
	}

	public void setTime(int t)
	{
		time=t;
	}

	public void setAcceleration(double ac)
	{

		acceleration=ac;

	}



	// enter set method for CarType enum
	public void setVE(CarType newVE)
	{
		ve = newVE;
	} 

	// enter the set method for the AutoStore attribute
	public void setAutoShop(AutoStore newAutoShop)
	{
		autoShop = newAutoShop;
	}
	
	public void setAutoID(int sid)
	{
		vehicleID=sid;
	}

	public void setCurrentID(int cid)
	{
		currentID=cid;
	}

	public void setSoldStatus(char newStatus)
	{
		soldStatus = newStatus;
	}//------enter mutator method to mark auto as sold
	
  // Complete the toString method to add the new attributes

	public String toString()
	{

		String str="The auto ID is: "+currentID+"\nThe name of the owner is: " + owners_name + "\nThe acceleration is: " + acceleration +
		"m/sec"+"\nThe car type is:" + ve + "\nThe traveling time is:"+ time +"\nThe price of the vehicle is"+ autoShop +"\nThe store is: "+ autoShop + "\nSold status = "+ soldStatus;
		return str;
	}

	public double calculateV(double i)
	{
      DecimalFormat nf = new DecimalFormat("0.00");
		double velocity = acceleration*time+i;
		String vel = nf.format(velocity);
		double velform = Double.parseDouble(vel);
		return velform;
	}

	public double calculateD(double i, double d)
	{
		DecimalFormat nf = new DecimalFormat("0.00");
		double timed = (double)time;
		double t = Math.pow(timed, 2.0);
		double distance = 0.5*acceleration*t+i*time+d;
		String dist = nf.format(distance);
		double distform = Double.parseDouble(dist);
		return distform;
	}

	public double calculateF(int m, double sd)
	{
		DecimalFormat nf=new DecimalFormat("0.00");
		double force=m*Math.pow(calculateV(0.0),2)/(2*sd);
		String forc=nf.format(force);
		double forceform=Double.parseDouble(forc);
		return forceform;
	}

	public boolean equals(Auto v)
	{
		if((this.getAcceleration()==v.getAcceleration())&&(this.getCarType().equals(v.getCarType())))
		   return true;
		else
		    return false;
	}

	
}
