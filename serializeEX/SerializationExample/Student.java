//Author: George Koutsogiannakis
//Date: 9/11/06
//George Koutsogiannakis
//Example of serializable object

import java.io.Serializable;
public class Student implements Serializable
  
{

	String name;
	int year;
	double grade_average;
	String rank;
	static int id;
	int currentID;

	public Student()
	{
	  
	   name="Unknown";
	   year=0;
	   grade_average=0.0;
	   rank="No rank yet";
	   id++;
	   currentID=id;
	}

	public Student(String nm, int yr, double gr, String rk)
	{
	    name=nm;
		year=yr;
		grade_average=gr;
		rank=rk;
		id++;
		currentID=id;
	}

	public String getName()
	{
	  return name;
	}

	public int getYear()
	{
	  return year;
	}
	
	public double getGrade_Average()
	{

	   return grade_average;
	 }

	 public String getRank()
	 {
	   
	    return rank;
	 }

	 public int getID()
	 {
		return currentID;

	}

	 public void setName(String n)
	 {
		name=n;
	 }

	 public void setYear(int y)
	 {
	   year=y;
	  }

	  public void setGrade_Average(double ga)
	  {

	      grade_average=ga;

	 }

	 public void setRank(String r)
     {

	      rank=r;

	}

	public void setID(int idsf)
	{

		id=idsf;

	}

	public void promote()
	{

	   year++;
	 }

	 public void graduate()
	 {

	    rank="Graduated";
	 }

}




	   
	
	

