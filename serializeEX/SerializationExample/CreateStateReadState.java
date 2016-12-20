//George Koutsogiannakis
//Example   of Serializable Object 
//Read the object's state


import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;

public class CreateStateReadState
{


	public static void main(String[] args) 
	{
		
		Student st1=new Student("George", 2, 90.5, "Sophomore");

		
		

		Student st2=new Student("Nick", 3,88, "Junior");
		SaveState ss1=new SaveState();

		ss1.writeState(st1);
		ss1.writeState(st2);
		ss1.closeStream();
        //Let us read the .ser file created with the student objects data

		String filename="student.ser";
		Student stread=null;
		ObjectInputStream in=null;
		FileInputStream fis=null;
		try
		{
			
		
			fis=new FileInputStream(filename);
			in=new ObjectInputStream(fis);
			
			while(true)
			{
				try
				{

						stread=(Student)in.readObject();
						
						System.out.println("The student's name is"+stread.getName());
						System.out.println("The student' s year is"+stread.getYear());
						System.out.println("The student' s grade is"+stread.getGrade_Average());
						System.out.println("The student 's rank is"+stread.getRank());
						System.out.println("The student ' sid is"+stread.getID());
				
				}
				
				catch(EOFException eof)
				{
					System.out.println(eof.getMessage());
					break;
				}

				

			}
		}
		catch(IOException ioe)
		{
				  ioe.printStackTrace();
				 
		}
		catch(ClassNotFoundException cnf)
		{
					cnf.printStackTrace();
		}
		
	}
}
