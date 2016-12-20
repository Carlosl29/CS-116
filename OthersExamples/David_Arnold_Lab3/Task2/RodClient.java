package David; 
import David.Arnold.Rod;
import David.Arnold.ReadData;
import David.Arnold.MaterialCategories; 
import java.util.Vector;

public class RodClient
{
	public static void main(String [] args)
	{
		String NAME = args[0];
		//System.out.println(NAME);
		ReadData rd = new ReadData();
		Vector v = new Vector(); 
		v = rd.vectorData(NAME);
		double [] coefficients = rd.getCoefficients();
		double [] Young = rd.getYoung();
		Vector sv = rd.sortVector(v);
		Rod [] rodArray = new Rod[v.size()];
		//System.out.println(coefficients.length);
		for(int i = 0; i<v.size(); i++)
		{
			Object myNewRodArray = sv.elementAt(i);
			rodArray [i] = (Rod)myNewRodArray;
			//System.out.println(coefficients[i]);
			Rod r1 = rodArray[i];
			//System.out.println(r1.toString());
			System.out.println(rodArray[i].toString());
			double expansion = r1.calculateExpansion(coefficients[i]);
			System.out.println("The expansion is: " + expansion);
			System.out.println("The force required is: " + r1.calculateForce(Young[i],expansion));
			System.out.println("");
		}
		
		if(rd.searchVector(sv, 89)!=-1)
		{
			System.out.println("The object was found and it is: " + rodArray[rd.searchVector(sv, 89)]);
		}
		else
		{
			System.out.println("Temperatrue 89 value was not found");
		}
		
		if(rd.searchVector(sv, 156)!=-1)
		{
			System.out.println("The object was found and it is: " + rodArray[rd.searchVector(sv, 156)]);
		}
		else
		{
			System.out.println("Temperature 156 value was not found");
		}
	}
}
