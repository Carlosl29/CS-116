package Client.Services.Enum.Help;
public class Material
{
	String materialName;
	double unitPrice;
	int quantity;
	static double materialcostforallobjects;

	public Material()
	{
		materialName = "Default";
		unitPrice = 0.0;
		quantity = 0;
	}
	public Material(String newName, double newPrice, int newQuantity)
	{
		materialName = newName;
		unitPrice = newPrice;
		quantity = newQuantity;
	}
	
	public String getName()
	{
		return materialName;
	}
	public double getPrice()
	{
		return unitPrice;
	}
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setName(String newName)
	{
		materialName = newName;
	}
	public void setPrice(double newPrice)
	{
		unitPrice = newPrice;
	}
	public void setQuantity(int newQuantity)
	{
		quantity = newQuantity;
	}
	
	public String toString()
	{	
		String line;
		line = ("Material Name: " + materialName + "\nUnit Price: " + unitPrice + "\nQuantity: " + quantity);
		
		return line;
	}
	
	public double getmaterialcostforallobjects()
	{
		return materialcostforallobjects;
	}
	
	public double materialPrice()
	{
		double totalPrice = unitPrice * quantity;
		if(quantity >= 100)
		{
			totalPrice = totalPrice - (totalPrice * .2);
		}
		else
		{
			totalPrice = totalPrice - (totalPrice * .1);
		}
		materialcostforallobjects += totalPrice;
		System.out.println("Total Price for 1 object: " + totalPrice);
		System.out.println("Total Price for all objects: " + materialcostforallobjects);
		
		return totalPrice;
	}
}
