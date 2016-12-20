
public class Persons 
{
	PersonType pt;
	String firstName;
	static int id;
	int currentid;

	public Persons()
	{
	 firstName="John";
	 id++;
	 currentid=id;
	}

	public void method1()
	{
		int currentid;
		currentid=this.currentid*2;
		System.out.println("The local value of currentid is"+" "+currentid);
		System.out.println("The class scope of variable currentid is"+" "+this.currentid);
	}
	 
	public void setPersonType(PersonType pertyp)
	{
		this.pt=pertyp;
	}

	public PersonType getPersonType()
	{

		return pt;
	}

}
