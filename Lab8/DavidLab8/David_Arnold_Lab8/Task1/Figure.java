/*	Written by David Arnold 
	A20347544
	CS 116-01
*/
import java.util.*;
import java.io.Serializable;

public abstract class Figure implements INT1, INT2, Serializable  
{
	public String nameOfShape=" ";
	
	public Figure()
	{
		nameOfShape="NONE";
	}

	public Figure(String f)
	{
		nameOfShape=f;
	}

	public String toString()
	{
		String out="The name of the shape is:"+" "+nameOfShape;
		return out;
	}

	public abstract ArrayList<String> costToDraw();
}
