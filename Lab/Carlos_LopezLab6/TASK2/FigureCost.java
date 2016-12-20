import java.util.*;
import java.io.*;

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

		OutputStreamWriter filestream;
		
		FileOutputStream file;
		
		String filename="output.txt ";

		try
		{
			file = new FileOutputStream(filename, true);
			
			filestream= new OutputStreamWriter(new BufferedOutputStream(file));

			for (int a = 0; a < figureData.size ( ); a ++)
			{
			
				try
				{
					Figure temp = (Figure)figureData.get(a);
					
					cost = temp.costToDraw ( );
					
					System.out.println ("Calculating Cost of Obejct is " + figureData.get(a).toString ( ));
					
					System.out.println ( );
					
					filestream.write("Calculating Cost of Obejct is " + figureData.get(a).toString ( ));
					
					filestream.write("\n");
				
				}
				catch (TooLargeCost tlC)
				{
					System.out.println (tlC.getMessage ( ));
				}

			
				for (int i = 0; i < cost.size ( ); i ++)
				{
					System.out.println (cost.get(i));
					filestream.write(cost.get(i));
					filestream.write("\n");
				}

			
			}
				
			filestream.flush();
			file.close();

		}

		catch(IOException ioe)
		{
			System.out.println("Something is wrong");
		}

		Scanner scan1 = new Scanner (System.in);
		System.out.println ("Please enter readfile if you want to print what is in the file");
		String read = scan1.nextLine ( );

		if (read.equals("readfile"))
		{
			try
			{
				FileInputStream file1=new FileInputStream(filename);
				BufferedReader filereader1=new BufferedReader(new InputStreamReader(file1));         
				
				
				String reading=" ";
				
				
				while((reading=filereader1.readLine())!=null) 
				{
					
				 
					System.out.println(reading);
	
					
					
				}
				
				file1.close();
			
				filereader1.close();
			}

			catch(FileNotFoundException fnf)
			{	
				System.out.println("The file was not found");
			}
			
			catch(IOException ioe)
			{
					System.out.println(ioe.toString()); 
			}
			
		}
		else 
			System.out.println ("You did not pick file to print");
	}
}