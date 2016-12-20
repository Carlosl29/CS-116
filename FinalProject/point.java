//Super class for charges and points of interest
public abstract class point
{
	private int x;
	private int y;
	private String name;
	public int id;

	public point()
	{
		x = 0;
		y = 0;
		id++;
	}
	public point(int x, int y)
	{
		this.x = x;
		this.y = y;
		name = "default";
		id++;
	}

	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setX()
	{
		this.x = x;
	}
	public void setY()
	{
		this.y = y;
	}
	//Abstract class that both charge and point will use
	abstract double distance(point c);
}