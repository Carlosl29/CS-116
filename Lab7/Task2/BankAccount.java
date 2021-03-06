package records;
public class BankAccount
{
	int Bank_Account_Num;
	char First_Name;
	char Last_Name;
	double Balance;
	boolean Fees_Apply;
	String Password;
	
	public BankAccount()
	{
		Bank_Account_Num = 0000;
		First_Name = 'a';
		Last_Name = 'a';
		Balance = 0.0;
		Fees_Apply = true;
		Password = " ";
	}
	public BankAccount(int a, char b, char c, double d, boolean e, String f)
	{
		Bank_Account_Num = a;
		First_Name = b;
		Last_Name = c;
		Balance = d;
		Fees_Apply = e;
		Password = f;
	}
	
	public int getAccountNum()
	{
		return Bank_Account_Num;
	}	
	public char getFirst()
	{
		return First_Name;
	}
	public char getLast()
	{
		return Last_Name;
	}
	public double getBalance()
	{
		return Balance;
	}
	public boolean getFees()
	{
		return Fees_Apply;
	}
	public String getPassword()
	{
		return Password;
	}
	
	public void setAccountNum(int newNum)
	{
		Bank_Account_Num = newNum;
	}
	public void setFirst(char newFirst)
	{
		First_Name = newFirst;
	}
	public void setLast(char newLast)
	{
		Last_Name = newLast;
	}
	public void setBalance(double newBal)
	{
		Balance = newBal;
	}
	public void setFees(boolean newFees)
	{
		Fees_Apply = newFees;
	}
	public void setPassword(String newPassword)
	{
		Password = newPassword;
	}
}	
