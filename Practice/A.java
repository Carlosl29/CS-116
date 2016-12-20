//George Koutsogiannakis
//Example of  classes inheriting from each other
//A is a superclass
public class A
{
	public int d;
	private String s;
	
	public A()
	{
		System.out.println("Default Constructor of A");
	}

	public A(int a, String b)
	{
		d=a;
		s=b;
		System.out.println("Non default constructor of A");
	}
	
	public void method1()
	{
		System.out.println("method1 of A executed");
	}
}
