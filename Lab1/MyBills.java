package Client.Services.Classes;
import Client.Services.BillsType;

public class MyBills
{
	String currentMonth;
	BillsType billType;
	double [] dailyExpense;
	int numOfDays;
	static int id;
	int currentId;
	
	public MyBills()
	{
		currentMonth = "Any Month";
		billType = null;
		dailyExpense = null;
		numOfDays = 0;
		id++;
	}
	
	public MyBills(String cM, BillsType bT,double[] dE, int nD)
	{
		currentMonth = cM;
		billType = bT;
		numOfDays = nD;
		dailyExpense = dE;
		currentId = id;
		id++;
	
	}
	
	public String getCurrentMonth()
	{
		return currentMonth;
	}
	public BillsType getBillType()
	{
		return billType;
	}
	public int getNumOfDays()
	{
		return numOfDays;
	}
	public double[] getDailyExpense()
	{
		return dailyExpense;
	}
	public int getId()
	{
		return id;
	}
	public int getCurrentId()
	{
		return currentId;
	}
	
	public void setCurrentMonth(String month)
	{
		currentMonth = month;
	}
	public void setBillType(BillsType bType)
	{
		this.billType = bType;
	}
	public void setNumOfDays(int nDays)
	{
		numOfDays = nDays;
	}
	public void setDailyExpense(double[] dExp)
	{
		dailyExpense = dExp;
	}
	
	public boolean equals(MyBills mBill)
	{
		if(this.getCurrentMonth().equals(mBill.getCurrentMonth()) && this.getNumOfDays() == mBill.getNumOfDays())
			return true;
		else
			return false;
	}
	
	public String toString()
	{
		String info = "Current Month: " + currentMonth + " Bill Type: " + billType + " Daily Expense: " + dailyExpense + " Number of Days: " + numOfDays + " ID: " + id + " Current ID: " + currentId; 
		return info;
	}
}
