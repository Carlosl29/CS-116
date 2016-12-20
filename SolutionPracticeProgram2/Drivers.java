//George Koutsogiannakis
package Driverclass1.Driverclass2;
import Driverclass1.Driverclass2.DriverType;
public class Drivers
{
	
	String name=" ";
	int age=0;
	int license=0;
	double years=0.0;
	static int id=0;
	int presentID=0;
	DriverType DriverType = null;
	

	public Drivers()
	{
		id++;
		presentID=id;
		name="No name";
		age=16;
		license=11111;
		years=0.5;
		DriverType = None;
	}

	public Drivers(String n, int a, int l, double y, DriverType dT)
	{
		id++;
		presentID=id;
		name=n;
		age=a;
		license=l;
		years=y;
		DriverType = dT;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
	public int getLicenses()
	{
		return license;
	}

	public double getYears()
	{
		return years;
	}
	public DriverType getDriverType()
	{
		return driverType;
	}

	public void setName(String na)
	{
		name=na;
	}

	public void setAge(int ag)
	{
		age=ag;
	}
	public void setLicenses(int li)
	{
		license=li;
	}

	public void setYears(double ye)
	{
		years=ye;
	}
	
	public void setYears(DriverType newDT)
	{
		driverType = newDT;
	}
	public String toString()
	{
		String out="The name of the driver is:"+" "+name+" "+"The age is:"+" "+age+" "+"The license number is:"+" "+license+" "+"The years of driving is:"+" "+years;
		return out;
	}

	public boolean equals(Drivers dr)
	{
		if(this.getName().equals(dr.getName())&&this.getLicenses()==dr.getLicenses())
			return true;
		else
			return false;
	}

	


}
