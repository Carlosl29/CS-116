import java.lang.Math;

//This class is a point of interest(poi)
//Which are the points that don't have
//any attributes just location
public class poi extends point
{
	public int counter;
	public static int id = 1;
	private String name;

	public poi()
	{
		super();
		name = "No Name";
		id = counter;
		counter++;
	}
	public poi(String newName, int x, int y)
	{
		super(x,y);
		name = newName;
		id = counter;
		counter++;
	}
	public String getName()
	{
		return name;
	}
	public int getX()
	{
		return super.getX();
	}
	public int getY()
	{
		return super.getY();
	}
	public String toString()
	{
		String line = ("Point " + counter + "X: " + super.getX() + "Y: " + super.getY());
		return line;
	}
	
	//d = sqrt((x2-x1)^2 + (y2-y1)^2)
	public double distance(point c)
	{
		double dist = 0.0;
		dist = Math.sqrt(Math.pow((this.getX() - c.getX()),2) + Math.pow((this.getY() - c.getY()), 2) );
		return dist;
	}

	public int getID()
	{
		return id;
	}
}