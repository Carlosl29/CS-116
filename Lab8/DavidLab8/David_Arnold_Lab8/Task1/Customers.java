/*	Written by David Arnold 
	A20347544
	CS 116-01
*/
import java.io.*;
import java.util.*;

public class Customers implements Serializable
{
	
	public String type=" ";
	public int score=0;
	public static Vector v = new Vector ();
	
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
	
	public Vector getV()
	{
		return v;
	}
	
	public void setV(Vector v2)
	{
		v = v2;
	}
	
	public Vector createData()
	{
		boolean done = false; 
		Scanner scan = new Scanner(System.in);
		int counter = 0; 
		Vector v1 = new Vector();
		String types = "";
		int scores = 0; 
		while(!done)
		{
			System.out.println("Please enter the 2 pieces of information for type and score for a customer object separated by space or type done");
			String userInput = scan.nextLine();
			if(userInput.equals("done"))
			{
				done = true;
			}
			else
			{
				Customers c1 = new Customers();
				StringTokenizer strtok = new StringTokenizer(userInput, " ");
				types = strtok.nextToken();
				String tok1 = strtok.nextToken();
				scores = Integer.parseInt(tok1);
				c1.setType(types);
				c1.setScore(scores);
				v1.add(c1);	
				counter++;
				/*System.out.println(types);
				System.out.println(scores);*/
			}
		}
		setV(v1);
		/*for(int i = 0; i<v.size();i++)
		{
			Object obj = v.get(i);
			Customers c1 = (Customers)obj; 
			String part1 = ("The customer is: ");
			String part2 = (" type = " + c1.getType());
			String part3 = (" score= " + c1.getScore());
			String total = part1 + part2 + part3; 
			System.out.println(total);
		}*/
		return v1; 
	}
	
	public Vector customerData()
	{
		//System.out.println(v.size());
		ArrayList<String> outputs = Output();
		for(int i = 0; i<outputs.size(); i++)
		{
			//System.out.println(outputs.get(i));
		}
		return v;
	}
	
	public String toString()
	{
		String out = ("type= " + type + " score = " + score);
		return out;
	}
	public ArrayList<String> Output()
	{
		ArrayList<String> strings = new ArrayList<String>();
		//System.out.println(v.size());
		//Vector v3 = customerData();
		for(int i = 0; i<v.size();i++)
		{
			Object obj = v.get(i);
			Customers c1 = (Customers)obj; 
			String part1 = ("The customer is: ");
			String part2 = ("type = " + c1.getType());
			String part3 = (" score= " + c1.getScore());
			String total = part1 + part2 + part3; 
			strings.add(total);
			//System.out.println(total);
		}
		return strings;
	}
}
