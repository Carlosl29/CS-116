//George Koutsogiannakis
package Driverclass1;
import Driverclass1.Driverclass2.Drivers;
import Driverclass1.Driverclass2.DriverType;
import java.util.Vector;
public class MyVector 
{
	public static void main(String[] args) 
	{
		Vector v=new Vector();
		Drivers dr1=new Drivers("John", 24, 345,5.5,DriverType.Adult_Male_Driver);
		v.addElement(dr1);
		Drivers dr2=new Drivers("Mary", 18, 945,2.5,DriverType.Teenager_Female_Driver);
		v.addElement(dr2);
		Drivers dr3=new Drivers("John", 44, 345,15.5,DriverType.Adult_Male_Driver);
		v.addElement(dr3);
		System.out.println("FIRST DISPLAY");
		for(int i=0; i<=v.size()-1; i++)
			System.out.println(v.get(i).toString());
		Drivers dr4=new Drivers("John", 24, 345,5.5,DriverType.Adult_Male_Driver);
		v.add(1,dr4);
		Integer myint=new Integer(15);
		v.addElement(myint);
		//check the size of the vector now
		System.out.println(v.size());
		System.out.println("SECOND DISPLAY");
		for(int j=0; j<=v.size()-1;j++ )
		{
				System.out.println(v.get(j).toString());
		
		
		}

		//ALGORITHM FOR COMPARING ALL OBJECTS AGAINST EACH OTHER
		
		int index=0;
		int k=1;
		System.out.println("THIRD DISPLAY");
		for(int j=k; j<v.size()-1; j++)
		{   
			Drivers dr=(Drivers)v.get(index);
			Drivers drs=(Drivers)v.get(j);
			System.out.println(j);
			//System.out.println("index="+index+"j="+j);
			if(dr.equals(drs))
			{
				//System.out.println("Iteration"+j);
				
				//System.out.println("Index="+index);
				System.out.println("Object with id="+" "+((Drivers)v.get(index)).getPresentID()+"  "+"is equal with object of id="+" "+((Drivers)v.get(j)).getPresentID());
				//System.out.println(+index+" "+j);
			}
			if(j==v.size()-2)
			{
				index++;
				k=index;
				j=k;
				//System.out.println("j="+j+" "+"k="+k);
				
			}
		}//end of for loop
		v.clear();
		System.out.println("FOURTH DISPLAY");
		System.out.println("The size of the vector is now="+ " "+v.size());

	}
}

