public class D extends C
{
	public String str;
	
	public D()
	{
		super();
		str = "Hello";
		System.out.println("Default Constructor of C in use...");
	}
	public D(String x)
	{
		super();
		str = x;
		System.out.println("Non-Default Constructor of C in use...");
	}
	
	public String getStr()
	{
		return str;
	}
	public void setStr(String x)
	{
		str = x;
	}
	
	public void m3()
	{
		super.m3();
			
		
		System.out.println("I am executing m3 as implemented in class D");
	}
	
	public int m2(char c)
	{
		int x;
		if(c == 'e')
		{
			x = super.m2('e');
			System.out.println("The m2(char c) version of D is executing now with returned value = " + x);
		}
		else
		{
			x = super.m2(100);
			System.out.println("The m2(int x1) version of D is executing now with returned value = " + x);
		}
		return x;
	}
}
