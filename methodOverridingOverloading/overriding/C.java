public class C extends A
{		
	    public double s=0.0;

		public C()
	   {
			super();
			s=200;
	   }

	   public C(int x4, double y4, double s1)
	   {
		    super(x4,y4);
			s=s1;
	   }

	   public double getS()
	   { 
		   return s;
	   }

	   

	   public  void setS(double s2)
	   {
			s=s2;
	   }

	 

	   public String toString()
	   {
		   String out;
		   out=super.toString()+"The value of s = "+s;
		   return out;
	   }

	   public String m(int x3)
	   {
		   if(x3==30)
		   {
			   double d=getX()+y+s;
			   return "This value of x+y+s= "+d;
		   }
		   else
			   return "No sum is calculated";
	   }
		
	   public String someMethod(double d1)
           {
		String s=super.someMethod(10.4);
		return s+"\n"+"The version of class C is executed now";
	  }

}
