import java.lang.Math;
import java.io.Serializable;
//One of the more important classes
//most of the calculations for the electric
//field are done here
public class electricField implements Calculations, Serializable
{
	private double xcomp;
	private double ycomp;
	private double angle;
	private double mag;
	private double cos;
	private double sin;
	//Constant used for electric field 
	// equation
	final double K = (8.99 * Math.pow(10,9));

	public electricField()
	{
		xcomp = 0.0;
		ycomp = 0.0;
		angle = 0.0;
	}
	public electricField(double x, double y)
	{
		xcomp = x;
		ycomp = y;
	}
	//Function to get the angle between poi and charge
	public double calcAngle(point p, point c)
	{
		//Calculate the angle by 
		//arctan(differenceY/differenceX)
		//in reference of the poi
		//and the charge
		double diffX;
		double diffY;
		//Absolute value is taken since distance 
		//can't be negative
		diffX = Math.abs(p.getX() - c.getX());
		//System.out.println("The diffx " + diffX);
		diffY = Math.abs(p.getY() - c.getY());
		//System.out.println("The diffY " + diffY);

		//arctan is taken because of a triangle and the pythagorean thereom
		angle = Math.atan(diffY/diffX);
		//System.out.println("Angle is :" + Math.toDegrees(angle));
		return angle;
	}
	//Function to calculate magnitude of ef(electric Field)
	public double calcMagnitude(poi p, charge c)
	{
		double magnitude;
		//E = k * q / d^2
		if(p.distance(c) != 0)
		{
			magnitude = K * ((c).getCharge()/ Math.pow(p.distance(c), 2));
		}
		else
			magnitude = 0;
		mag = magnitude;
		return magnitude;
	}
	//Stub function
	//Maybe will use to format angle
	public double calcDirection()
	{
		double direction = 0.0;
		return direction;
	}
	//Function to cleaning calculate cosine
	public double calcCos(double angle)
	{
		if(angle < 0)
		{
			double cosOfAngle = Math.cos(angle);
			//Redundant but just to make sure in degrees
			angle = Math.toDegrees(angle);
			
			//If the an angle is 90 the cosine is 1
			if(Math.abs(angle) == 90)
				cosOfAngle = 0;
			cos = cosOfAngle;
			return (cosOfAngle);
		}
		else
		{
			double cosOfAngle = Math.cos(angle);
			angle = Math.toDegrees(angle);
			
			if(Math.abs(angle) == 90)
				cosOfAngle = 0;
			cos = (-1) * cosOfAngle;
			return (-1) * cosOfAngle;
		}
	}
	public double calcSin(double angle)
	{
		/*
		double sinOfAngle = Math.sin(angle);
		angle = Math.toDegrees(angle);
		if(Math.abs(angle) == 90)
			sinOfAngle = 1;
		return ((-1) * sinOfAngle);
		*/
		if(angle < 0)
		{
			double sinOfAngle = Math.sin(angle);
			angle = Math.toDegrees(angle);
			
			//if the angle is 90 sine is 0
			if(Math.abs(angle) == 90)
				sinOfAngle = 0;
			sin = (-1) * sinOfAngle;
			return ((-1) * sinOfAngle);
		}
		else
		{
			double sinOfAngle = Math.sin(angle);
			angle = Math.toDegrees(angle);
			
			if(Math.abs(angle) == 90)
				sinOfAngle = 0;
			sin = sinOfAngle;
			return (sinOfAngle);
		}
	}

}