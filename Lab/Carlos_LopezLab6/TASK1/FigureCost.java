import java.util.*;

public class FigureCost 
{
	public static void main (String [ ] args)
	{
		ArrayList<Figure> figureData = new ArrayList<Figure> ( );

		Scanner scan = new Scanner (System.in);

		System.out.println ("Please entry object type and Shape the length or redius or enter done for quit");

		String userData = scan.nextLine ( );

		while (!userData.equals ("done"))
		{
			StringTokenizer data = new StringTokenizer (userData);
			String first = data.nextToken ( );
			String second = data.nextToken ( );
			double redius_Length = Double.parseDouble (second);

			if (first.equals("cube"))
			{
				Cube tr = new Cube (first, redius_Length);
				figureData.add(tr);
			}

			else if (first.equals ("sphere"))
			{
				Sphere trr = new Sphere (first,redius_Length);
				figureData.add(trr);
			}

			System.out.println ("Please entry object type and Shape the length or redius or enter done for quit");

			userData = scan.nextLine ( );
		}

		ArrayList<String> cost = new ArrayList ( );

		for (int a = 0; a < figureData.size ( ); a ++)
		{
			
			try
			{
				Figure temp = (Figure)figureData.get(a);
				cost = temp.costToDraw ( );
				System.out.println ("Calculating Cost of Obejct is " + figureData.get(a).toString ( ));
				System.out.println ( );
			}
			catch (TooLargeCost tlC)
			{
				System.out.println (tlC.getMessage ( ));
			}

			
			for (int i = 0; i < cost.size ( ); i ++)
			{
				System.out.println (cost.get(i));
			}

			
		}



	}

}