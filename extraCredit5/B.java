public class B extends A
{
	public String s;
	
	//The constructor of this class calls on 
	//the constructor of A, which is the super
	public B()
	{
		super();
		s = "Hi";
		System.out.println("Default Constructor for B in use...");
	}
	public B(String x)
	{
		super();
		s = x;
		System.out.println("Non-Default Constructor for B in use...");
	}

	//This class has it's own implementation of m1
	//that is different from the one that (A) has
	public int m1()
	{
		double c = super.getAA();
		int i1 = 5 * a + (int)c;
		System.out.println("m1 implementation of B is now running...");
		return i1;
	}
		
	public String getS()
	{
		return s;
	}
	public void setS(String newS)
	{
		s = newS;
	}

	public String toString()
	{
		super.toString();
		String out = "S:\t" + s;
		return out;
	}
}
