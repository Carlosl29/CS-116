package records;
import java.io.*;
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
		
		File file = new File("data.txt");
		FileOutputStream fos;
		OutputStream os;
		OutputStreamWriter osw;
		
		try{
		
			fos = new FileOutputStream(file);
//			os = new OutputStream(fos);
			osw = new OutputStreamWriter(fos);
			
			for(int i = 0; i < bankAA.length; i++)
			{
				osw.write(String.valueOf(bankAA[i].getAccountNum()));
				osw.write('\t');
				osw.write(String.valueOf(bankAA[i].getFirst()));
				osw.write('\t');
				osw.write(String.valueOf(bankAA[i].getLast()));
				osw.write('\t');
				osw.write(String.valueOf(bankAA[i].getBalance()));
				osw.write('\t');
				osw.write(String.valueOf(bankAA[i].getFees()));
				osw.write('\t');
				osw.write(String.valueOf(bankAA[i].getPassword()));
				osw.write('\n');
			}
			osw.close();
		}
		catch(IOException ioe)
		{
			ioe.getMessage();
		}
		
		Scanner input2 = new Scanner(System.in);
		String answer;
		
		String var1;
		String var2;
		String var3;
		String var4;
		String var5;
		String var6;
		
		System.out.println("Would you like to read the text file created?(yes/no) ");
		answer = input2.nextLine();
		
		BufferedReader br;
		
		if(!answer.equals("no"));
		{
			try{
				FileInputStream fis = new FileInputStream(file);
				br = new BufferedReader(new FileReader(file));
				String sCurrentLine;
				while((sCurrentLine = br.readLine()) != null)
				{
					try{
						System.out.println(sCurrentLine + " "/*+ var2 + " " + var3 + " " + var4 + " " + var5 + " " + var6*/);
						var1 = Integer.toString(br.read());
						/*Integer.toString(isr.read());
						var2 = Integer.toString(isr.read());
						Integer.toString(isr.read());
						var3 = Integer.toString(isr.read());
						Integer.toString(isr.read());
						var4 = Integer.toString(isr.read());
						Integer.toString(isr.read());
						var5 = Integer.toString(isr.read());
						Integer.toString(isr.read());
						var6 = Integer.toString(isr.read());*/
					}
					catch (EOFException eofe)
					{
						System.out.println("End of File Reached...");
						break;
					}
				}		
			}
			catch(IOException ioe)
			{
				ioe.getMessage();
			}
			
		}
			
			
		
	}

}

