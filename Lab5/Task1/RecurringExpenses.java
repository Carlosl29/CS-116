package Client.Services.Enum.Help;

//Keeps track of all expenses: Utilities, Rent, Materials, etc.
public class RecurringExpenses extends Rent implements MaterialCostsInterface, UtilityCostsInterface
{
	UtilImpl uImp = new UtilImpl();
	MaterialsImpl mImp = new MaterialsImpl();
	Rent rImp = new Rent();
	
	public double totalRecurringExpenses()
	{
		double sum;
		
		sum = (uImp.getUtilityExpenses() + mImp.getMaterialExpenses() + super.getRentForAll());
		System.out.println("Total Recurring Expense: " + sum);
		return sum;	
	}
	public void createExpense()
	{
		UtilitysCosts utility1 = new UtilitysCosts(100.00, 100.00, 100.00);
		utility1.totalUtilCosts();
		UtilitysCosts utility2 = new UtilitysCosts(150.00, 150.00, 150.00);
		utility2.totalUtilCosts();
		
		Rent rent1 = new Rent("2", 3, 4);
		rent1.rent();
		Rent rent2 = new Rent("4", 1, 1);
		rent2.rent();
		
		Material mat1 = new Material("Paper", 3.0, 1000);
		mat1.materialPrice();
		Material mat2 = new Material("Ink", 2.0, 200);
		mat2.materialPrice();
	}
	
	public double getMaterialExpenses()
	{
		Material mat3 = new Material();
		return mat3.getmaterialcostforallobjects();
	}
	
	public double getUtilityExpenses()
	{	
		UtilitysCosts utility3 = new UtilitysCosts();
		return utility3.getutilcostsforallobjects();
	}	
	
}
