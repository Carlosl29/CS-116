import java.util.Vector;
public class  Customers
{
	
	public String type=" ";
	public int score=0;

	public void setType(String ty)
	{
		type=ty;
	}

	public void setScore(int sc)
    {
		score=sc;
	}

	public String getType()
	{
		return type;
	}

	public int getScore()
	{
		return score;
	}
	
	public Vector customerData()
	{
		Vector v=new Vector();
		//Customer 1
		Customers c1=new Customers();
		c1.setType("Architect");
		c1.setScore(500);
		v.add(c1);
		//Customer 2
		Customers c2=new Customers();
		c2.setType("Other");
		c2.setScore(500);
		v.add(c2);
		//Customer 3
		Customers c3=new Customers();
		c3.setType("Architect");
		c3.setScore(800);
		v.add(c3);
		//Customer 4
		Customers c4=new Customers();
		c4.setType("Other");
		c4.setScore(700);
		v.add(c4);
		
		return v;
	}
}
