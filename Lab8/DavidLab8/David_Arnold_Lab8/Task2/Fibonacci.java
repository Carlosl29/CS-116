/*	David Arnold
	A20347544
	CS 116-01
*/
public class Fibonacci
{
	public static void main(String [] args)
	{
		Fibonacci f = new Fibonacci();
		for(int i = 0; i<11;i++)
		{
			System.out.println("Fibonacci of " + i + " is: " + f.Fibonacci(i));
		}
	}
	
	public int Fibonacci(int n)
	{
		if(n == 0)
		{
			return 0;
		}
		else
		{
			if(n == 1)
			{
				return 1;
			}
			else
			{
				return (Fibonacci(n-1) + Fibonacci(n-2));
			}
		}
	}
}