public class Client
{
	public static void main(String args[])
	{
		System.out.println("First Output");
		B b = new B();
		C c = new C();
	
		A a;
	
		a = b;
		a.m1();	
	
		a = c;
		a.m1();
		
		System.out.println("\nSecond Output");
		D d = new D();
		c = d;
		
		System.out.println("\nThird Output");
		d.m2('e');
		d.m2('s');

		
	}
}
