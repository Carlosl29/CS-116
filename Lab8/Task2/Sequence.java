import java.util.*;
public class Sequence
{
	
	public static void main(String[] args)
	{
		for(int i = 0; i <= 10; i++)
		{
			System.out.println("Fibonaci of " + i + " terms: " + Fibonaci(i));
		}
	}
	public static int Fibonaci(int x)
	{
		//0, 0 + 1 = 1, 0 + 1 + 1 = 2, 0 + 1 + 1 + 2 = 3,
		if(x == 0)
		{
			return 0;
		}
		else if(x == 1)
		{
			return 1;
		}
		else
		{
			return (Fibonaci(x - 2) + Fibonaci(x - 1));
		}
	}

}
