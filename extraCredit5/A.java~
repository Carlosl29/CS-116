public abstract class A
{
	public int a;
	private double aa;
	
	public A()
	{
		a = 1;
		aa = 1.0;
		System.out.println("Default Constructor Used");
	}
	public A(int newA, double newAA)
	{
		a = newA;
		aa = newAA;
		System.out.println("Non-Default Constructor Used");
	}
	
	public int getA()
	{
		return a;
	}
	public double getAA()
	{
		return aa;
	}
	
	public void setA(int newa)
	{
		a = newa;
	}
	public void setAA(double newaa)
	{
		aa = newaa;
	}
	
	
	
	public int m2(char a)
	{
		int x = (int)a;
		System.out.println("m2 of A is execution now...");
		return x;
	}
	public int m2(int x1)
	{
		//Get the returned value from the first version and add x1
		int y = 10 + x1;
		System.out.println("Second version of m2 in A is executing now...");
		return y;
	}
	
	public void m3()
	{
		System.out.println("m3 of A is executing now...");
	}
	
	public abstract int m1();
	
	
	public String toString()
	{
		String out = "A:\t" + a + "\nAA:\t" + aa;
		return out;	
	}	
}

