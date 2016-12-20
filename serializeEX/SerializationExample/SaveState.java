//George Koutsogiannakis
//Example   of Serializable Object 
//Saving the object's state

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveState
{
	String filename="student.ser";
	FileOutputStream fos=null;
	ObjectOutputStream out=null;
	
	public SaveState()
	{

		try
		{

			fos=new FileOutputStream(filename, true);
			out=new ObjectOutputStream(fos);
			
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public void writeState(Student st)
	{

		Student temp=st;
		try
		{

			
			out.writeObject(temp);
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	

	}
	
	public void closeStream()
	{
		try
		{
 			out.close();
		}
		catch(IOException ioex)
		{
			System.out.println(ioex.getMessage());	
		}
	}

}
