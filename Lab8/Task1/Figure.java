import java.util.*;
import java.io.Serializable;

public abstract class Figure implements INT1, INT2, Serializable
{
	String nameOfShape;

	public Figure()
	{
		nameOfShape = "NONE";
	}

	public Figure(String newName)
	{
		nameOfShape = newName;
	}

	public String toString()
	{
		String line = ("The name of the shape is:" + nameOfShape);
		return line;
	}

	public abstract ArrayList<String> costToDraw() throws TooLargeCostException;
}
