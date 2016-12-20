//George Koutsogiannakis
//Example of  classes inheriting from each other
//B is a subclass of A
public class B extends A
{
	public double g;
	private int r;
	public B()
	{
		super();
		System.out.println("The default constructor of B was executed");

	}

	public B(int na, String ns, double ng)
	{
		super(na,ns);
		g=ng;
		System.out.println("The non default constructor of B was executed");
	}

	public int method2(int h)
	{
		 System.out.println("method 2 of B was executed");
		 return h*2;
	}
		
}