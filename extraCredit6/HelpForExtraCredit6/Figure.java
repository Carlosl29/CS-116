import java.util.*;
public abstract class Figure implements INT1, INT2  
{
	public String nameOfShape;

	public Figure()
	{
		nameOfShape = "NONE";
	}

	public Figure(String name)
	{
		nameOfShape = name;
	}

	public String toString()
	{
		String line = "The name of the shape is: " + nameOfShape;
		return line;
	}
	
	//No arguments for costToDraw
	public abstract ArrayList<String> costToDraw();
}
