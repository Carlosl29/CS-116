public class Client
{
	public static void main(String[] args) 
	{
		A a=null;
		B b=new B(50,200.0,true);
		a=b;
		String str=a.m(20);
		System.out.println(str);

                //calling the overriden method of B
		String strofB=a.someMethod(3.4);
		System.out.println(strofB);
		//end of method overriding example
		
		//CALLING THE OVERLOADED METHODS OF CLASS A
                
		double y1=a.m1();
                System.out.println("Output of First version of m1= "+y1);

		double y2=a.m1(20.0);
		System.out.println("Output of Second version of m1= "+y2);
         	//END OF METHOD OVERLAODING EXAMPLE
		C c=new C(100,500.0,1000.0);
		a=c;
		String str1=a.m(30);
		System.out.println(str1);
		//Calling the overriden method of C
		String strofC=a.someMethod(0.5);
		System.out.println(strofC);     
	}
}
/*CLIENT OUTPUT
---------- Java Interpreter ----------
//Frpm Previous example output (example of polymorphism)
This is the B version with true and argument for m=20

//Overriden version of m in class B
I Am executing the super class version with argument: 2.3
I am executing next the subclass B additional code

//Overloded versions of m
Output of First version of m1= 10.0
Output of Second version of m1= 30.0

//Previous example output
This value of x+y+s= 1600.0

//OVerriden version of m in C
I Am executing the super class version with argument: 10.4
The version of class C is executed now

Output completed (0 sec consumed) - Normal Termination

*/
