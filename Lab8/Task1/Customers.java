import java.util.*;
public class  Customers
{	
	String type;
	int score = 0;

	public void setType(String newType)
	{
		type = newType;
	}

	public void setScore(int newScore)
   {
		score = newScore;
	}

	public String getType()
	{
		return type;
	}

	public int getScore()
	{
		return score;
	}
	
	public String toString()
	{
		String line = ("Type: " + type + "\tScore: " + score);
		return line;
	}
	
	public Vector customerData()
	{
		Vector data = new Vector();
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Type and Score for Object:(Seperate with spaces; Type 'done') ");
		String line = input.nextLine();
		while(!line.equals("done"))
		{
			Customers cust1 = new Customers();
		   StringTokenizer st = new StringTokenizer(line);
		   
		   String type = st.nextToken();
			String temp = st.nextToken();
			int score = Integer.parseInt(temp);
			
			cust1.setType(type);
			cust1.setScore(score);
			data.add(cust1);
			
			System.out.print("\tEnter Type and Score for Object:(Seperate with spaces; Type 'done') ");
			line = input.nextLine();
		}
		return data;
	}
}
