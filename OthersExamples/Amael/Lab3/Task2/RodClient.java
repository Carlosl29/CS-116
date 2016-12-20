package Amaael;
import Amaael.Antonini.*;
import java.util.Vector;
public class RodClient{
	public static void main (String args[]){
		String str = args[0];
		ReadData builder = new ReadData();
		Vector RodVector = builder.vectorData(str);
		double [] coefficients = builder.coefficients;
		double [] young = builder.young;
		builder.sortVector(RodVector);
		double expanssion = 0;
		for(int i = 0; i < RodVector.size(); i++){
			System.out.println(RodVector.get(i));
			expanssion = ((Rod) RodVector.get(i)).calculateExpansion(coefficients[i]);
			System.out.println("The expansion is: " + expanssion);
			System.out.println("The force is: " + ((Rod) RodVector.get(i)).calculateForce(expanssion, young[i]));
		}
		int [] list = {89, 156};
		int index = 0;
		for(int x: list){
			index = builder.searchVector(RodVector, x);
			if (index >= 0){
				System.out.println(RodVector.get(index));
			}
			else
				System.out.printf("The temperature: %d, was not found\n", x);
		}
	}
}