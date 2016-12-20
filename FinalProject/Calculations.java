public interface Calculations
{
	//All possible functions that will be
	//used on the electric field
	public double calcAngle(point p, point c);
	public double calcMagnitude(poi p, charge c);
	public double calcDirection();
	public double calcCos(double angle);
	public double calcSin(double angle);
}