import java.io.*;

public class Client
{
	public static void main(String[] args)
	{
		/*
		try
		{
			FileOutputStream fos = new FileOutputStream("serialData.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for(Animal a: animalList)
			{
				oos.writeObject(a);
			}
			oos.close();
		}*/
		try
		{
			FileInputStream fis = new FileInputStream("serializedData.ser");
			ObjectInputStream ois = ne ObjectInputStream(fis);
			Animal an2;

			while(true)
			{
				try
				{
					if(ois.readObject instanceof Fox)
						an2 = (Animal)ois.readObject();

					System.out.println(an2.toString());
				}
			}
			ois.close();
		}
	}
}