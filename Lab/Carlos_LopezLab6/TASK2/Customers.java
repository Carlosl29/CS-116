import java.util.*;
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
		
		Scanner scan = new Scanner (System.in);

		System.out.println ("Please enter Customer type and Customer credit score or enter done for quit ");
		String userInput = scan.nextLine ( );

		while (!userInput.equals("done"))
		{	
			Customers cust = new Customers ( );
			StringTokenizer take = new StringTokenizer (userInput, " "); 
			String first = take.nextToken ( );
			cust.setType (first);
			String second = take.nextToken ( );
			cust.setScore (Integer.parseInt (second));

			v.add(cust);

			System.out.println ("Please enter Customer type and Customer credit score or enter done for quit ");
			userInput = scan.nextLine ( );


		}

		return v;
	}

	public String toString ( )
	{
		return "The type of customer is " + type + "The customer credit score is " + score;
	}
}
