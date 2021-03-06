import java.util.*;
import java.io.*;

public class FigureCost 
{
	public static void main (String [ ] args)
	{
	
		Cube first = new Cube ("Cube", 10.0, "area");
		Cube second = new Cube("Cube", 10.0, "volume");
		
		Sphere third = new Sphere("Sphere", 10.0, "area");
		Sphere fourth = new Sphere("Sphere", 10.0, "volume");
		
		System.out.println(first.toString());
		ArrayList<String> data = first.costToDraw();
		for (int i = 0; i < data.size();i++)
		{
			System.out.println(data.get(i));
		}
		
		System.out.println (second.toString());
		ArrayList<String> data2 = first.costToDraw();
		for (int j = 0; j < data.size();j++)
		{
			System.out.println(data2.get(j));
		}
		System.out.println(third.toString());
		ArrayList<String> data3 = third.costToDraw();
		for (int k = 0; k < data.size(); k++)
		{
			System.out.println(data3.get(k));
		}
		System.out.println(fourth.toString());
		ArrayList<String> data4 = fourth.costToDraw();
		for (int l = 0; l < data.size(); l++)
		{
			System.out.println(data4.get(l));
		}
		
		
		/*/////////////////////////////////////
		ArrayList<Figure> data = new ArrayList<Figure>();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the shape, length/radius, and asked(area or volume):\n(Separate by spaces or type 'done' to end program)");
		String line = input.nextLine();
		
		while(!line.equals("done"))
		{
			StringTokenizer st = new StringTokenizer(line, " ");
			String figure = st.nextToken();
			String temp = st.nextToken();
			double length = Double.parseDouble(temp);
			String volArea = st.nextToken();
			
			if(figure.equals("cube"))
			{
				Cube cube = new Cube(figure, length, volArea);
				data.add(cube);
			}
			else if(figure.equals("sphere"))
			{
				Sphere sphere = new Sphere(figure, length, volArea);
				data.add(sphere);
			}
			else
			{
				System.out.println("You entered something incorrect.");
			}
			System.out.println("Please enter the shape, length/radius, and asked(area or volume):\n(Separate by spaces or type 'done' to end program)");
			line = input.nextLine();	
		}
		
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < data.size(); i++)
		{
			try{
				Figure temp = data.get(i);
				list = temp.costToDraw();
				System.out.println("Cost of Object of given shape: " + data.get(i).toString());
					
			}
			catch(TooLargeCostException tlce)
			{
				tlce.getMessage();
			}
		}			
		
		for(int j = 0; j < list.size(); j++)
		{
			System.out.println(list.get(j));
		}*/
		
		

	}

}
