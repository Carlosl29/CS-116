//CS116 Exam 1
//George Koutsogiannakis

//package folder1.folder2;
import java.text.DecimalFormat;
public class Car  
{
	private int cylindernum=0;
	public String type;
	private static int ID=0;
	private int currentID=0;

	public Car()
	{
		
		setCylinderNum(0);
		setCarTypes("OTHER");
	    
		
	}

	public Car(int cn, String ct)
	{
		setCylinderNum(cn);
		setCarTypes(ct);
		
		
		ID++;
		currentID=ID;
	}

	public int getCylinderNum()
	{
		return cylindernum;
	}

	public void setCylinderNum(int cynum)
	{
		cylindernum=cynum;
	}

	public String getCarTypes()
	{
		return type;
	}

	public void setCarTypes(String carty)
	{
		type=carty;
	}

	
	public int getID()
	{
		return ID;
	}

	
	public void setID(int pid)
	{
		ID=pid;
	}

	public int getCurrentID()
	{
	   return currentID;
	 }

	 public void setCurrentID(int cid)
	 {
	     currentID=cid;
	}

	public double calculatePrice()
	{
		
		double price=0;
		DecimalFormat df= new DecimalFormat("##.##");
		if(type.equals("TWODOORSSPORTS"))
		{
			price=cylindernum*2800.00*1.5234;
		}
		else if(type.equals("FOURDOORSSEDAN"))
		{
			price=cylindernum*2800.00*1.0567;
		}
		else if(type.equals("HEAVYTRACK"))
		{
			price=cylindernum*2800.00*2.3;
		}
		else if(type.equals("LIGHTTRUCK"))
		{
			price=cylindernum*2800.00*1.2;
		}
		else if(type.equals("OTHER"))
		{
		
			price=cylindernum*2800.00*0.8888;
		}

		String strprice=df.format(price);
		
		double priceformatted=Double.parseDouble(strprice);
			
			return priceformatted;
		
	}
    public boolean equals(Car c)
	{
		if((this.getCarTypes().equals(c.getCarTypes())&&(this.getCylinderNum()==c.getCylinderNum())))
		{
				return true;
		}
		else
				return false;
	}

	public String toString()
	{
	 String output;
	 output="Number of cylinders is"+" "+cylindernum+" "+"Car Type="+" "+type+" "+"Car ID="+" "+currentID;
	 return output;

	 }

	 public Car[] selectionSort(Car[] unsorted)
	{
		 Car[] sorted=new Car[unsorted.length];
		 for(int i=0; i<unsorted.length; i++)
			 sorted[i]=unsorted[i];
		int subarraylength=0;
		int index=0;
		for (int j=0; j<=sorted.length-1; j++ )
		{
					subarraylength=sorted.length-j;
							  //find index of largest element in subarray
					index=0;
					for (int k=1; k<subarraylength; k++)
					{
						if (sorted[k].getCylinderNum() > sorted[index].getCylinderNum())
						{
							index=k;	
							
						}
					}
					Car temp=sorted[index];
					sorted[index]=sorted[sorted.length-j-1];
					sorted[sorted.length-j-1]=temp;
			}//end top for

			return sorted;

	   }		     


}



	
	

