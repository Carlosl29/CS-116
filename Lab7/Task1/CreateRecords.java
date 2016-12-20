package records;
import java.io.*;//Import FileOutputStream, DataOutputStream, IOException
import java.util.*;

public class CreateRecords
{
	public static void main(String[] args)
	{
		BankAccount [] bankAA = new BankAccount[4];
		BankAccount bA1 = new BankAccount(1234, 'A', 'M', 1000.30, true, "Mypassword");
		BankAccount bA2 = new BankAccount(3456, 'G', 'L', 300.23, false, "helenB");
		BankAccount bA3 = new BankAccount(7890, 'H', 'J', 1290.00, true, "jwer");
		BankAccount bA4 = new BankAccount(6781, 'F','D', 260.60, true, "hgfdw");
		bankAA[0] = bA1;
		bankAA[1] = bA2;
		bankAA[2] = bA3;
		bankAA[3] = bA4;
		
		File file = new File("records.dat");
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try{ 			
			//The Writing of each attribute for bank account ba1
			//Bank account 1
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			for(int i = 0; i < bankAA.length; i++)
			{
				dos.writeInt(bankAA[i].getAccountNum());
				dos.writeChar('\t');
				dos.writeChar(bankAA[i].getFirst());
				dos.writeChar('\t');
				dos.writeChar(bankAA[i].getLast());
				dos.writeChar('\t');
				dos.writeDouble(bankAA[i].getBalance());
				dos.writeChar('\t');
				dos.writeBoolean(bankAA[i].getFees());
				dos.writeChar('\t');
				dos.writeChars(bankAA[i].getPassword());
				dos.writeChar('\n');
			}
			dos.close();
		}
		catch(IOException ioe)
		{
			System.out.println("IOException thrown..." + ioe.getMessage());
		}
		
		Scanner input2 = new Scanner(System.in);
		String answer;

		int int1;
		char var2;
		char var3;
		double var4;
		boolean var5;
		String var6;
		
		System.out.println("Would you like to read the file data?(yes/no) ");
		answer = input2.nextLine();
		
		if(answer.equals("yes")) 
		{
			try{
				FileInputStream fis = new FileInputStream(file);
				DataInputStream dis = new DataInputStream(fis);
				
				while(true)
				{
					try
					{
						int1 = dis.readInt();
						dis.readChar();
						var2 = dis.readChar();
						dis.readChar();
						var3 = dis.readChar();
						dis.readChar();
						var4 = dis.readDouble();
						dis.readChar();
						var5 = dis.readBoolean();
						dis.readChar();
						var6 = dis.readLine();
					}
					catch(EOFException eofe)
					{
						System.out.printf("End of File...");
						break;
					}
					System.out.println (int1 + " "+ var2 + " " + var3 + " " + var4 + " " + var5 + " " + var6);
				}	
				
			}
			catch(IOException ioe)
			{
				System.out.println("IOException thrown =: " + ioe + "...");
			}
			
			
		}
	}
}
