package Amaael.Antonini;
import Amaael.Antonini.Rod;
import Amaael.Antonini.MaterialCategories;
import java.util.*;
import java.io.IOException;
import java.io.File;
import java.text.DecimalFormat;
public class ReadData{
	public double [] coefficients;
	public double [] young;

	public double [] getCoefficients(){
		return coefficients;
	}
	public double [] getYoung(){
		return young;
	}
	public void setCoefficients(double [] c){
		coefficients = c;
	}
		public void setYoung(double [] y){
		young = y;
	}
	public String toString(){
		return String.format("This class is to retrieve arrays of thermal expanssion and Young's modulus values");
	}
	
	public Vector vectorData(String name){
		Vector rods = new Vector();
		double [] thermal_exp;
		double [] young_modules;
		
		try{
			File rods_file = new File(name);
			Scanner scan = new Scanner(rods_file);
			int ind = 0;
			String str;
			MaterialCategories category = null;
			String material_name;
			double rod_area;
			double rod_lenght;
			Double thermal;
			Double module;
			int temperature;
			while (scan.hasNextLine()){
				str = scan.nextLine();
				StringTokenizer tok = new StringTokenizer(str, ",");
				str = space_remover(tok.nextToken());
				material_name = space_remover(tok.nextToken());
				rod_area = Double.parseDouble(space_remover(tok.nextToken()));
				rod_lenght = Double.parseDouble(space_remover(tok.nextToken()));
				thermal = Double.parseDouble(space_remover(tok.nextToken()));
				module = Double.parseDouble(space_remover(tok.nextToken()));
				temperature = Integer.parseInt(space_remover(tok.nextToken()));
				Rod nextRod = new Rod(temperature, material_name, rod_area, rod_lenght);
				nextRod.setCategory(MaterialCategories.valueOf(str));
				rods.add(nextRod);
				rods.add(thermal);
				rods.add(module);
				
			}
			scan.close();		
		}
		catch(IOException except){
			System.out.printf("File error: %s\n", except);
		}
		catch(NullPointerException pointer){
			System.out.printf("NullPointerException: %s\n", pointer);
		}
		catch(IllegalArgumentException argument){
			System.out.printf("IllegalArgumentException: %s\n", argument);
		}
		int size = rods.size() / 3;
		thermal_exp = new double[size];
		young_modules = new double[size];
		for(int i = 0; i < rods.size(); i++){
			thermal_exp[i] = (double) rods.get(i + 1);
			young_modules[i] = (double) rods.get(i + 2);
			rods.remove(i + 1);
			rods.remove(i + 1);
		}
		this.coefficients = thermal_exp;
		this.young = young_modules;
		return rods;
	}
	public void sortVector(Vector v){
		double holdC;
		double holdY;
		int max = 0;
		Object maxV = (v.get(0));
		int maxTemp = 0;
		for(int i = 0; i < v.size(); i ++){
			maxTemp = ((Rod) v.get(i)).getTemperature();
			max = i;
			for(int j = i; j < v.size(); j ++){
				if(((Rod) v.get(j)).getTemperature() > maxTemp){
					max = j;
					maxTemp = ((Rod) v.get(j)).getTemperature();
				}
			}
			maxV = (v.get(max));
			holdC = this.coefficients[max];
			holdY = this.young[max];
			v.set(max, v.get(i));
			this.coefficients[max] = this.coefficients[i];
			this.young[max] = this.young[i];
			v.set(i, maxV);
			this.coefficients[i] = holdC;
			this.young[i] = holdY;
		}
	}
	public int searchVector(Vector v, int t){
		int last = v.size() -1;
		int first = 0;	
		int middle = (last + first) / 2;
		if(((Rod) v.get(middle)).getTemperature() == t)
			return middle;
		else if(((Rod) v.get(middle)).getTemperature() > t)
			return searchVector2(v, t, middle + 1, last);
		else
			return searchVector2(v, t, first, middle -1);		
	}
	public int searchVector2(Vector v, int t, int start, int end){
		int middle = (start + end) / 2;
		if(((Rod) v.get(middle)).getTemperature() == t)
			return middle;
		else if(start == end)
			return -1;
		else if(((Rod) v.get(middle)).getTemperature() > t)
			return searchVector2(v, t, middle + 1, end);
		else
			return searchVector2(v, t, start, middle -1);	
	}
	public static String space_remover(String str){
		while(str.charAt(0) == ' ')
			str = str.substring(1, str.length());
		while(str.charAt(str.length() - 1) == ' ')
			str = str.substring(0, str.length() - 1);
		return str;
	}
	
}