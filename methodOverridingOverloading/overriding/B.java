public class B extends A
{		
	    public boolean z=false;

		public B()
	   {
			super();
			z=false;
	   }

	   public B(int x4, double y4, boolean z1)
	   {
		    super(x4,y4);
			z=z1;
	   }

	   public boolean getZ()
	   { 
		   return z;
	   }

	   

	   public  void setZ(boolean z2)
	   {
			z=z2;
	   }

	 

	   public String toString()
	   {
		   String out;
		   out=super.toString()+"The value of z = "+z;
		   return out;
	   }

	   public String m(int x3)
	   {
		      if(z==true&&x3==20)
			   return "This is the B version with true and argument for m=20";
		   else
			   return "this is the B version with false and argument of m is not equal to 20";
	   }

	   public String someMethod(double d)
           {
 		String s=super.someMethod(2.3);
                return s+"\n"+"I am executing next the subclass B additional code";  
	   }
	    
}
