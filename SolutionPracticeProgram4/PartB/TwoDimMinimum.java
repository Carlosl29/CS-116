//exercise 61 from text page 640
//Find the minimum in a two dimensional array!
//Practice Program 4
import java.util.ArrayList;
public class TwoDimMinimum 
{
	public static void main(String[] args) 
	{
		int [][] ar= { { 9, 8, 7, 6}, {10,20,30,40}};
		int min=ar[0][0];
		//we need to start the iterations with row 0 not raw 1
		//as the text suggests!
		for(int i=0; i<ar.length; i++)
		{
			for (int j=0; j<ar[i].length; j++ )
			{
					if(ar[i][j]<min)
						min=ar[i][j];
			}
		}
		System.out.println("The minimum is"+" "+min);
	
	
	
	
  	}
}
