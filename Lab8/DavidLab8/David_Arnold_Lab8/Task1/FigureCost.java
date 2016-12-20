	/*	Written by David Arnold 
	A20347544
	CS 116-01
*/
import java.util.*;
import java.io.*;

public class FigureCost
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		boolean done = false; 
		String userInput = "";
		String nameOfShape = "";
		double length = 0.0;
		String value = "";
		int counter = 0; 
		//Vector v = new Vector();
		ArrayList<Figure> figures = new ArrayList<Figure>();
		while(!done)
		{
			System.out.println("Please enter the shape the length (or radius) and the asked value separated by space or type done");
			userInput = scan.nextLine();
			if(userInput.equals("done"))
			{
				done = true;
			}
			else
			{
				StringTokenizer strtok = new StringTokenizer(userInput, " ");
				nameOfShape = strtok.nextToken();
				String tok1 = strtok.nextToken();
				length = Double.parseDouble(tok1);
				value = strtok.nextToken();
				if(nameOfShape.equals("sphere"))
				{
					Figure f = null; 
					Sphere sp = new Sphere (length,value);
					f = sp; 
					figures.add(sp);
				}
				else
				{
					if(nameOfShape.equals("cube"))
					{
						Figure f = null; 
						Cube cu = new Cube (length,value);
						f = cu;
						figures.add(cu);
					}
				}
				counter++;
			}
		}
		System.out.println("I am ready to create the file figures.ser");
		System.out.println("I am ready to create the file customers.ser");
		try
		{
			FileOutputStream fos = new FileOutputStream("figures.ser",false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(int i = 0; i<figures.size();i++)
			{
				oos.writeObject(figures.get(i));
			}
			oos.close();
		}
		catch(IOException ioe)
		{
			System.out.println("Error writing into file");
			ioe.printStackTrace();
		}
		//System.out.println(figures.get(1).toString());
		Customers c = new Customers();
		Vector v = c.createData();
		ArrayList<Customers> customers = new ArrayList<Customers>();
		for(int i = 0; i<v.size();i++)
		{
			Object obj = v.get(i);
			Customers c1 = (Customers)obj;
			customers.add(c1);
		}
		
		try
		{
			FileOutputStream fos = new FileOutputStream("customers.ser",false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(int i = 0; i<customers.size();i++)
			{
				oos.writeObject(customers.get(i));
			}
			oos.close();
		}
		catch(IOException ioe)
		{
			System.out.println("Error writing into file");
			ioe.printStackTrace();
		}
	
		
		System.out.println("I am ready to create the file cost.ser");
		System.out.println("If you want the file figures.ser read type the word read otherwise type anything else to stop the program");
		String input = scan.nextLine();
		//ArrayList<Figure> figures1 = new ArrayList<Figure>;
		
		
		if(input.equals("read"))
		{
			try
			{
				FileInputStream fis = new FileInputStream("figures.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				try
				{
					while(true)
					{
						Figure f1 = (Figure)ois.readObject();
						System.out.println(f1.toString());
					}
				}
				catch(EOFException eof)
				{
					System.out.println("null");
				}
				ois.close();
				System.out.println("Closing the file");
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
			catch(ClassNotFoundException cnfe)
			{
				cnfe.printStackTrace();
			}
		}
		else
		{
			System.out.println("Program ending");
			System.exit(0);
		}
		
		
		System.out.println("If you want the file customers.ser read type the word read otherwise type anything else to stop the program");
		input = scan.nextLine();
		if(input.equals("read"))
		{
			try 
			{
				FileInputStream fis = new FileInputStream("customers.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				try
				{
					while(true)
					{
						Customers c2 = (Customers)ois.readObject();
						System.out.println(c2.toString());
					}
				}
				catch(EOFException eof)
				{
					System.out.println("null");
				}
				ois.close();
				System.out.println("Closing the file");
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
			catch(ClassNotFoundException cnfe)
			{
				cnfe.printStackTrace();
			}
		}
		else
		{
			System.out.println("Program ending");
			System.exit(0);
		}
		
		ArrayList<String> outputs = c.Output();
		c.customerData();
		try
		{
			FileOutputStream fos = new FileOutputStream("cost.ser",false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(int i = 0; i<figures.size();i++)
			{
				Figure f1 = figures.get(i);
				ArrayList<String> outputs1 = f1.costToDraw();
				for(int j = 0; j<outputs1.size();j++)
				{
					oos.writeObject(outputs1.get(j));
				}
			}
			oos.close();
		}
		catch(IOException ioe)
		{
			System.out.println("Error writing into file");
			ioe.printStackTrace();
		}
		
		
		System.out.println("If you want the file cost.ser read type the word read otherwise type anything else to stop the program");
		input = scan.nextLine();
		if(input.equals("read"))
		{
			try
			{
				FileInputStream fis = new FileInputStream("cost.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				try
				{
					while(true)
					{
						//System.out.println("Hello");
						String str = (String)ois.readObject();
						System.out.println(str);
					}
				}
				catch(EOFException eof)
				{
					System.out.println("null");
				}
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
			catch(ClassNotFoundException cnfe)
			{
				cnfe.printStackTrace();
			}
		}
		else
		{
			System.out.println("Program ending");
			System.exit(0);
		}
		
		System.out.println("Exiting the program");
		/*System.out.println(outputs.size());
		System.out.println(v.size());
		for(int i = 0; i<outputs.size(); i++)
		{
			//ArrayList<String> outputs = c.Output();
			System.out.println(outputs.get(i));
		}
		OutputStreamWriter filestream; 
		FileOutputStream file; 
		String filename = "output.txt";
		try 
		{
			file = new FileOutputStream(filename, false);
			filestream= new OutputStreamWriter(new BufferedOutputStream(file));
			for(int i = 0; i<counter; i++)
			{
				Figure f1 = figures.get(i);
				System.out.println(f1.toString().substring(26,32));
				System.out.println(f1.toString());
				if(f1.toString().substring(26,32).equals("Sphere"))
				{
				
					ArrayList<String> spheres = f1.costToDraw();
					System.out.println("Calculating cost for shape object: " + f1.toString());
					filestream.write("Calculating cost for shape object: " + f1.toString());
					filestream.write('\n');
					//System.out.println(spheres.size());
					for(int j = 0; j<spheres.size(); j++)
					{
						System.out.println(spheres.get(j));
						filestream.write(spheres.get(j));
						filestream.write('\n');
						
					}
				}
				else
				{
					//System.out.println(f1.toString().substring(26,30));
					if(f1.toString().substring(26,30).equals("Cube"))
					{
						
						ArrayList<String> cubes = f1.costToDraw();
						System.out.println("Calculating cost for shape object: " + f1.toString());
						filestream.write("Calculating cost for shape object: " + f1.toString());
						filestream.write('\n');
						for(int j = 0; j<cubes.size(); j++)
						{
							System.out.println(cubes.get(j));
							filestream.write(cubes.get(j));
							filestream.write('\n');
						}
					}
				}
			}
			filestream.flush();
			file.close();
		}
		catch (IOException ioe)
		{
			System.out.println("Something went wrong");
		}
		
		System.out.print("Type readfile if you want to have the text file read and displayed or type no if you want the program terminated: ");
		String str1 = scan.next();
		System.out.println('\n');
		if(str1.equals("readfile"))
		{
			try 
			{
				FileInputStream file1 = new FileInputStream("output.txt");
				BufferedReader filereader1 = new BufferedReader(new InputStreamReader(file1));
				
				String reader = " ";
				while((reader=filereader1.readLine())!=null)
				{
					System.out.println(reader);
				}
				file1.close();
				filereader1.close();
			}
			catch(FileNotFoundException fnfe)
			{
				System.out.println("The file was not found");
			}
			catch(IOException ioe)
			{
				System.out.println(ioe.toString());
			}
		}*/
		
		
		/*	Please ignore the following
		for(int i = 0; i<counter;i++)
		{
			for(int j = 0; j<v.size();j++)
			{
				Object obj = v.get(j);
				Customers c1 = (Customers)obj;
				System.out.println("The Customer is: type = " + c1.getType() + " score= " + c1.getScore());
			}
			Figure f1 = figures.get(i);
			//System.out.println(figures.get(i).toString());
			
			if(figures.get(i).toString().equals("The name of the shape is: Sphere"))
			{
				System.out.print("Calculating the cost for shape object: " + figures.get(i).toString());
				ArrayList<String> sphereCosts = f1.costToDraw(v);
				//System.out.println(f1.getRadius());
				if(types.get(i).equals("area"))
				{
					System.out.println("The parameter asked for is: " + types.get(i));
					for(int k = 0; k<sphereCosts.size(); k++)
					{
						//System.out.println(sphereCosts.get(k));
						if((k%2)==0)
						{
							System.out.println(sphereCosts.get(k));
						}
					}
				}
				else
				{
					if(types.get(i).equals("volume"))
					{
						System.out.println("The parameter asked for is: " + types.get(i));
						for(int k = 0; k<sphereCosts.size(); k++)
						{
							if((k%2)==1)
							{
								System.out.println(sphereCosts.get(k));
							}
						}
					}
				}
			}
			else
			{
				if(figures.get(i).toString().equals("The name of the shape is: Cube"))
				{
					System.out.print("Calculating the cost for shape object: " + figures.get(i).toString());
					ArrayList<String> cubeCosts = f1.costToDraw(v);
					//Figure f1 = figures.get(i);
					if(types.get(i).equals("area"))
					{
						System.out.println("The parameter asked for is: " + types.get(i));
						for(int k = 0; k<cubeCosts.size();k++)
						{
							if((k%2)==0)
							{
								System.out.println(cubeCosts.get(k));
							}
						}
					}
					else
					{
						if(types.get(i).equals("volume"))
						{
							System.out.println("The parameter asked for is: " + types.get(i));
							for(int k = 0; k<cubeCosts.size();k++)
							{
								if((k%2)==1)
								{
									System.out.println(cubeCosts.get(k));
								}
							}
						}
					}
				}
			}
		}*/
	}
}
