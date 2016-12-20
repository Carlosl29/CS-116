//The plane method is a 2d array where
//all the objects(in this case points)
//will be stored
public class plane{
	public point[]plane;
	public int id;

	public plane()
	{
		//The dimension of the array
		//are just extremes of where
		//the points will be located
		plane = new point[100];
		for(int i = 0; i < 100; i++)
		{
			//Set every space to null
			//so that all the indexes 
			//not null are objects
			plane[i] = null;
		}
	}
	//Function to add a point of interest
	public void addPoi(int x, point p)
	{
		//System.out.println("Adding poi");
		plane[x + 50] = p; 
		id++;
	}
	//Function to add a charge
	public void addCharge(int x, charge c)
	{
		//System.out.println("Adding charge");
		plane[x + 50] = c;
		id++;
	}
	//Function to print out all the non-null
	//indexes
	public void printPoints()
	{
		for(int i = 0; i < 100; i++)
		{
			if(plane[i] != null)
			{
				System.out.println("Point: " + id + " " + plane[i].toString() + "\n");
			}
		}
	}
	public point getPoint(int x)
	{
		return plane[x];
	}
}