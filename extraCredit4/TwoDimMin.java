public class TwoDimMin
{
	public static void main(String [] argv)
	{
		int twoDArray[][] = {{9,8,7,6}, {10,20,30,40}};
		int minimum = twoDArray[0][0];
		int row, column;
		for(row = 0; row < twoDArray.length; row++)
		{
			for(column = 0; column < twoDArray[row].length; column++)
			{
				if(twoDArray[row][column] < minimum)
				{
					minimum = twoDArray[row][column];
				}
				System.out.println(twoDArray[row][column]);
				
			}
			
		}
		System.out.println("The minimum is " + minimum);	
		  
	}
}
