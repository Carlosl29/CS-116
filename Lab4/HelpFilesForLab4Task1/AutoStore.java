package main.service;

// enter import statements for needed classes
import main.service.enums.Stores;
import main.service.enums.CarType;


public class AutoStore
{
	//enter enum Store attribute 
	public Stores storeType;
	// enter cross references attribute for Auto
	Auto auto1 = new Auto();
	
	double sale = 0.0; //THIS IS THE PRICE OF EACH AUTO 
	static int id = 0;
	int currentID = 0;


	public AutoStore()
	{
		sale=0.0;
		storeType = null;
		auto1 = null;//----- initialize remaining attrubutes to null
		id++;
		currentID=id;
	}

	public AutoStore(double s)
	{
		sale=s;
		storeType = null;
		auto1 = null;//---initialize remaining attributes to null
		id++;
		currentID=id;
	}

	public Stores getStoreType()//-- accessor method for the enum attribute
	{
		return storeType;
	}

	public double getSale()
	{
		return sale;
	}

	public Auto getAuto()
	{
		return auto1;
	}//------accessor method for the cross referenced attribute of Auto 


	public int getCurrentID()
	{
		return currentID;
	}

	public void setStoreType(Stores newStoreType)//-----mutator method for the enum attribute
	{
		storeType = newStoreType;
	}

	public void setSale(double sa)
	{
		sale=sa;
	}

	public void setAuto(Auto newAuto)//---set method for the cross rferenced attribute of Auto
	{
		auto1 = newAuto;
	}

	public void setCurrentID(int cid)
	{
		currentID=cid;
	}

	public String toString()
	{
		String out="The store is: \t"+/*--------+*/"The sale price of the car is: "+sale+"The car is: "+/*-------+*/"The auto store object id is: "+currentID+"The auto is"/*+......*/;
		return out;
	}
}
