import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.EOFException;

public class Binarypractice
{
	public static void main(String[] args)
	{		
		String fileName = null;
		Scanner input = new Scanner(System.in);
		try{
			
			//int double character
			System.out.println("Please Enter Name of File to be Created: ");
			fileName = input.nextLine();
			String more = " ";
		
			FileOutputStream fos = new FileOutputStream(new File(fileName));
			DataOutputStream dos = new DataOutputStream(fos);		
			
			
			while(!more.equals("!"))
			{
				System.out.println("Please Enter a line of data (1 int, 1 double, 1 character, seperated by spaces)");
				String line = input.nextLine();
				StringTokenizer sT = new StringTokenizer(line," ");
				int var1 = Integer.parseInt(sT.nextToken());
				double var2 = Double.parseDouble(sT.nextToken());
				char var3 = sT.nextToken().charAt(0);
			
				dos.writeInt(var1);
				dos.writeDouble(var2);
				dos.writeChar(var3);
			
				System.out.println("Would you like to enter more data(Enter \"!\" to quit): ");
				more = input.nextLine();
			}
			dos.close();
			fos.close();
		}
		catch(IOException ioe)
		{
			System.out.println("File was not found");
		}
		
		System.out.println("Would you like to read the file(enter read for yes): ");
		String line2 = input.nextLine();
		
		if(line2.equals("read"))
		{
			try{
				FileInputStream fis = new FileInputStream(fileName);
				DataInputStream dis = new DataInputStream(fis);
			
				int var1;
				double var2;
				char var3;

				
				while(true)
				{
					try{
					
					var1 = dis.readInt();
					var2 = dis.readDouble();
					var3 = dis.readChar();

					System.out.println("You entered: " + var1 + " " + var2 + " " + var3);
					}
					catch(EOFException e)
					{
						System.out.println("End of File Exception");
						break;
					}
					dis.close();
				}
			}
			catch(IOException ioe)
			{
				System.out.println("IO Exception =: " + ioe);
			}
		}
		
	
	}
}
