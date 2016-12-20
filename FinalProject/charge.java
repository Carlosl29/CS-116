import java.lang.Math;

//Simply a point with a charge also
public class charge extends point
{
	private double charge;
	public int counter;
	//Some how use this to keep track 
	// of which charge is which
	public static int id = 1;
	public String newName = "noName";

	public charge()
	{
		super();
		charge = 0.0;
		id = counter;
		counter++;
	}
	public charge(int x, int y, double z)
	{
		super(x, y);
		charge = z;
		id = counter;
		counter++;
	}

	public double getCharge()
	{
		return charge;
	}
	public void setCharge(double newCharge)
	{
		charge = newCharge;
	}

	public String toString()
	{
		String line = ("X: " + super.getX() + "Y: " + super.getY());
		return line;
	}

	//Function to calculate distance
	//d = sqrt((x2 - x1) ^ 2 + (y2 -y1) ^ 2)
	//Recieves a point in order to input
	//both a charge and a poi
	public double distance(point c)
	{
		double dist = 0.0;
		dist = Math.sqrt(Math.pow((this.getX() - c.getX()),2) + Math.pow((this.getY() - c.getY()), 2) );
		return dist;
	}
}