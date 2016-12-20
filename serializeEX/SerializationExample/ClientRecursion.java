package client;

public class ClientRecursion
{
	//if i want fib(1) we get 0
	//if i want fib(4) we get 2
	//if i want fib(6) we get 5
	public static int fibonacci(int n)
	{
		//base case
		if(n == 0)
		{
			return 0;
		}
		else if(n == 1)
		{
			return 1;
		}
		else
		{
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static int binarySearch(int[] intArr, int value)
	{
		int middle = intArr.length/2;
		int beg = 0;
		int end = intArr.length - 1;
		if(intArr[middle] == value)
		{
			return middle;
		}
	}

	public static void main(String [] args)
	{
		System.out.println(fibonacci(7));
	}
}