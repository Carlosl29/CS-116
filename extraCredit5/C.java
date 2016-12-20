public class C extends A
{
	public double c;
	
	public C()
	{
		super();
		c = 1.0;
		System.out.println("Default Constructor of C in use...");
	}
	public C(double x)
	{
		super();
		c = x;
		System.out.println("Non-default Constructor of C in use...");
	}
	
	public double getC()
	{
		return c;
	}
	public void setC(double x)
	{
		c = x;
	}
	
	public String toString()
	{
		super.toString();
		String out = "C:\t";
		return out;
	}
	
	public int m1()
	{
		int i2 = a + (int) (c / 2);
		System.out.println("m1 implementation of C is executing now");
		
		return i2;
	}	
}
