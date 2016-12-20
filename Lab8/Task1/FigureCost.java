import java.util.*;
import java.io.*;

public class FigureCost
{
	public static void main(String[] args) 
	{
		
		ArrayList<Figure> figureData = new ArrayList<Figure>();
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter start to begin the program: ");
		String line = input.nextLine();
		
		String file = "figures.ser";
		try{
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));
		
			while(!line.equals("done"))
			{
				System.out.print("Enter shape, length/radius, and calculation (Separate with spaces): ");
				line = input.nextLine();
				StringTokenizer st = new StringTokenizer(line);
				String figure = st.nextToken();
				String temp = st.nextToken();
				double length = Double.parseDouble(temp);
				String ask = st.nextToken();
				if(figure.equals("cube"))
				{
					Cube cube = new Cube(figure, length, ask);
					oos.writeObject(cube);
					figureData.add(cube);
				}
				else if(figure.equals("sphere"))
				{
					Sphere sphere = new Sphere(figure, length,ask);
					oos.writeObject(sphere);
					figureData.add(sphere);
				}
				System.out.print("Enter 'done' to finish adding, enter anything else to add more: ");
				line = input.nextLine();	
			}
			oos.flush();
			fos.close();
			oos.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
				
		ArrayList<String> costData = new ArrayList<String>();
		
    //try{       
			for(int i = 0; i < figureData.size(); i++)
			{		 
				try{			
					Figure figure = figureData.get(i);
					
					costData = figure.costToDraw();
					System.out.println("Calculating the cost for shape object: " + figureData.get(i).toString() + "\n");		
				}
				catch (TooLargeCostException tlc)
				{
					System.out.println(tlc.getMessage());
				}
				for(int j = 0; j < costData.size(); j++)
				{
					System.out.println(costData.get(j));
				}
			}
		//}
		/*catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}*/
		Scanner input1 = new Scanner(System.in);
		System.out.print("Do you want to read the text file?(read/noread) ");
		String line2 = input1.nextLine();
		if(line2.equals("read"))
		{
			try{
				System.out.println("Enter read again");
				line2 = input2.nextLine();
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Scanner input3 = new Scanner(file);
				Figure temp;
				
				while(input.hasNextLine())  
				{	
					temp = (Figure)ois.readObject();
					System.out.println(temp);
					System.out.println(temp.costToDraw());			
				}
				fis.close();
				ois.close();
			}
			catch(FileNotFoundException fnfe)
			{
				System.out.println("The file not found...");
			}
			catch(IOException ioe)
			{
					System.out.println(ioe.toString()); 
			}
			catch(ClassNotFoundException cnfe)
			{
				System.out.println("Hello " + cnfe.getMessage());
			}
			
		}
		else
		    System.out.println("Exiting without reading...");
	}
}
