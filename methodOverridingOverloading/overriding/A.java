
public abstract class A 
{
		private int x=0;
	    public double y=0.0;

		public A()
	   {
			x=10;
			y=100.00;
	   }

	   public A(int x1, double y1)
	   {
		    x=x1;
			y=y1;
	   }

	   public int getX()
	   { 
		   return x;
	   }

	   public double getY()
	   {
			return y;
	   }

	   public  void setX(int x2)
	   {
			x=x2;
	   }

	   public void setY(double y2)
	   {
			y=y2;
	   }

	   public String toString()
	   {
		   String out;
		   out="The value of x = "+x+" "+"The value of y = "+y;
		   return out;
	   }

	   public abstract String m(int x3);
	
	   //THE METHOD someMethod IS OVERRIDEN IN SUB CLASSES B AND C (TWO NEW VERSIONS ARE CREATED)
          
	   public String someMethod(double a)
	   { 
		String out="I Am executing the super class version with argument: "+a;
		return out;
           }

           //THE METHOD M1 IS OVERLAODED IN THIS CLASS

	   public double m1()
           {
             double d=10.0;
             return d;
	   }

 	   public double m1(double d1)
          {
		double d2=d1+10.0;
		return d2;
	  }
}
