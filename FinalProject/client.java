import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.Math;
import java.text.DecimalFormat;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.EOFException;


public class client
{
	public static void main(String[] args)
	{	
		/*
		DecimalFormat df = new DecimalFormat("###.##");

		charge ch1 = new charge(2,-1,-0.00000003);
		charge ch2 = new charge(2,-3,+0.00000003);
		poi point1 = new poi(0,-2);

		plane xy = new plane();
		//System.out.println(" ch1 x: "+ ch1.getX());
		//System.out.println(" ch1 y: "+ ch1.getY());

		//Just remember that the xy plane is flipped upside down
		//the origin is (50,50) anything greater is positive
		//anything less is negative.
		xy.addCharge(ch1.getX(), ch1.getY(), ch1);
		xy.addCharge(ch2.getX(), ch2.getY(), ch2);
		xy.addPoi(point1.getX(), point1.getY(), point1);

		
		electricField ef11 = new electricField();
		double dist11 = point1.distance(ch1);

		//System.out.println("Distance " + dist11);
		//Problem:  I cant get the id/number that each point and charge are
		//			The ones being used.
		//Magnitude being calculate: send the points 
		// being used to the function of electric field
		////////////////////////////////////////////
		//Info for Point of interest 1 and charge 1
		double ef11Mag = ef11.calcMagnitude(point1, ch1);
		System.out.println("The magnitude of electric field at point: P" + point1.getID() +
			" due to charge #: " + ch1.id + " is: " + df.format(ef11Mag));
		//Charge is from function of charge
		System.out.println("The charge is: " + ch1.getCharge());
		//Angle is calculated by function in electric field
		double ef11Angle = ef11.calcAngle(point1, ch1);
		//System.out.println("The angle: " + Math.toDegrees(ef11Angle));
		//Cosine is calculate by function in electric field
		double ef11Cos = ef11.calcCos(ef11Angle);
		System.out.println("The cosine of the angle = " + ef11Cos);
		//X component of a vector is the cos * the magnitude
		//cos => x-comp
		double ef11XComp = ef11Cos * ef11Mag;
		System.out.println("The value of the x component of the electric field at point: P" + point1.getID() +
			" due to point charge #: " + ch1.id + " is: " + df.format(ef11XComp));
		//sin=> y-comp
		double ef11Sin = ef11.calcSin(ef11Angle);
		System.out.println("sine of the agle = " + ef11Sin);
		//For some strange reason the absolute value has to be taken 
		//of the magnitude to find the y-comp
		double ef11YComp = ef11Sin * Math.abs(ef11Mag);
		System.out.println("The value of the y component of the Electric field at point: P3" +
			"due to charge point #: 1 is " + df.format(ef11YComp));
		///////////////////////
		////////////////////////
		electricField ef12 = new electricField();
		double ef12Mag = ef12.calcMagnitude(point1, ch2);
		System.out.println("The magnitude of electric field at point: P" + point1.getID() +
			" due to charge #: " + ch2.id + " is: " + df.format(ef12Mag));
		System.out.println("The charge is: " + ch2.getCharge());
		double ef12Angle = ef12.calcAngle(point1, ch2);
		//System.out.println("The angle: " + Math.toDegrees(ef12Angle));
		double ef12Cos = ef12.calcCos(ef12Angle);
		System.out.println("The cosine of the angle = " + ef12Cos);
		//System.out.println("Angle: " + Math.toDegrees(ef12Angle));
		double ef12XComp = ef12Cos * ef12Mag;
		System.out.println("The value of the x component of the electric field at point: P" + point1.getID() +
			" due to point charge #: " + ch2.id + " is: " + df.format(ef12XComp));
		double ef12Sin = ef12.calcSin(ef12Angle);
		System.out.println("sine of the agle = " + ef12Sin);
		double ef12YComp = ef12Sin * ef12Mag;		
		System.out.println("The value of the y component of the Electric field at point: P3" + 
			"due to charge point #: 2 is " + df.format(ef12YComp));
		///////////////////////////
		///////////////////////////
		double efRXComp = ef11XComp + ef12XComp;
		//System.out.println("efRXComp: " + efRXComp);
		double efRYComp = ef11YComp + ef12YComp;
		//System.out.println("efRYComp: " + efRYComp);
		double efRTotal = Math.sqrt(Math.pow(efRXComp, 2) + Math.pow(efRYComp, 2));
		System.out.println("The magnitude of the resultant field is: " + df.format(efRTotal) + "for point: P3");
		*/
		
		String fileName;
		int amountOfCharges = 0;
		//Plane that contains all the charges
		plane chargesPlane = new plane();
		//Plane that contains all the poi's
		plane poiPlane = new plane();
		ArrayList<electricField> arrayEF = new ArrayList<electricField>();

		Scanner input = new Scanner(System.in);
		Scanner fileScanner;
		StringTokenizer st;
		DecimalFormat df = new DecimalFormat("###.##");



		System.out.println("Please enter name of file that contains data: ");
		fileName = input.nextLine();
		try{

			fileScanner = new Scanner(new FileInputStream(fileName));

			//Streams for serialization
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;

			try{
				System.out.println("FileName entered: " + fileName);
				while(fileScanner.hasNext())
				{
					String line = fileScanner.nextLine();
					String [] firstSplit = line.split(":");
					if(firstSplit[0].equals("Q"))
					{
						String [] secondSplit = firstSplit[1].split(",");
						int x = Integer.parseInt(secondSplit[0]);
						int y = Integer.parseInt(secondSplit[1]);
						double charge = Double.parseDouble(secondSplit[2]);
						charge c1 = new charge(x, y, charge);
						amountOfCharges++;
						chargesPlane.addCharge(c1.getX(), c1);
						//System.out.println("Charge add: " + chargesPlane.getPoint(c1.getX()).toString());
						//chargesPlane.printPoints();
					}
					else if(firstSplit[0].equals("P"))
					{
						String [] secondSplit = firstSplit[1].split(",");
						String name = secondSplit[0];
						int x = Integer.parseInt(secondSplit[1]);
						int y = Integer.parseInt(secondSplit[2]);
						poi p1 = new poi(name, x, y);
						poiPlane.addPoi(p1.getX(), p1);
						//poiPlane.printPoints();
					}
					else if(!firstSplit[0].equals("Q") || !firstSplit[0].equals("P"))
					{
						throw new TypeOfPointException("Incorrect type of point found...");
					}

				}
				chargesPlane.printPoints();
				for(int i = 0; i < amountOfCharges; i++)
				{
					//An electric field vector is created for each 
					//charge that was created above
					for(int j = 0; j < amountOfCharges; j++)
					{
						electricField ef = new electricField();
						//j is the poi
						//i is the charge
						double efMag = ef.calcMagnitude((poi)poiPlane.getPoint(j),(charge)chargesPlane.getPoint(i));
						System.out.println("The magnitude of electric field at point: P" + poiPlane.getPoint(j).id +
						" due to charge #: " + chargesPlane.getPoint(i).id + " is: " + df.format(efMag));
						//Charge is from function of charge
						System.out.println("The charge is: " + ((charge)chargesPlane.getPoint(i)).getCharge());
						//Angle is calculated by function in electric field
						double efAngle = ef.calcAngle(poiPlane.getPoint(i), chargesPlane.getPoint(i));
						//System.out.println("The angle: " + Math.toDegrees(efAngle));
						//Cosine is calculate by function in electric field
						double efCos = ef.calcCos(efAngle);
						System.out.println("The cosine of the angle = " + efCos);
						//X component of a vector is the cos * the magnitude
						//cos => x-comp
						double efXComp = efCos * efMag;
						System.out.println("The value of the x component of the electric field at point: P" + poiPlane.getPoint(i).id +
						" due to point charge #: " + chargesPlane.getPoint(i).id + " is: " + df.format(efXComp));
						//sin=> y-comp
						double efSin = ef.calcSin(efAngle);
						System.out.println("sine of the agle = " + efSin);
						//For some strange reason the absolute value has to be taken 
						//of the magnitude to find the y-comp
						double efYComp = efSin * Math.abs(efMag);
						arrayEF.add(ef);
					}
				}
				fos = new FileOutputStream("output.ser", false);
				oos = new ObjectOutputStream(fos);

				for(int i = 0; i < arrayEF.size(); i++)
				{
					oos.writeObject(arrayEF.get(i));
				}
				oos.close();
			}
			catch(IOException ioe)
			{
				System.out.println(ioe.getMessage());
			}
			catch(TypeOfPointException e)
			{
				System.out.println(e.getMessage());
			}
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getMessage());
		}

		Scanner inputReader = new Scanner(System.in);
		System.out.println("Do you want to have the .ser binary coded file read?");
		String answer = inputReader.nextLine();

		if(answer.equals("Yes") || answer.equals("yes"))
		{
			try 
			{
				FileInputStream fis = new FileInputStream("output.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				try
				{
					while(true)
					{
						electricField ef3 = (electricField)ois.readObject();
						System.out.println(ef3.toString());
					}
				}
				catch(EOFException eof)
				{
					System.out.println("null");
				}
				ois.close();
				System.out.println("Closing the file");
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
			catch(ClassNotFoundException cnfe)
			{
				cnfe.printStackTrace();
			}
		}
		else
		{
			System.out.println("Program is terminating...");
		}
		
	}
}