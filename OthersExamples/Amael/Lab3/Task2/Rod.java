package Amaael.Antonini;
import java.text.DecimalFormat;
public class Rod{
	private int temperature;
	private MaterialCategories category;
	private String material_name;
	private double area;
	private double rod_length;
	private static int current_id = 0;
	private int id;
	
	public Rod(){
		this(0, "any", -0.1, -0.1);
	}
	
	public Rod(int temp, String material_type, double cross_sect_area, double length){
		temperature = temp;
		this.category = null;
		material_name = material_type;
		area = cross_sect_area;
		rod_length = length;
		current_id ++;
		id = current_id;
		}
					
	public int getTemperature(){
		return temperature;
	}
		
	public MaterialCategories getCategory(){
		return category;
	}
			
	public String getMaterial_name(){
		return material_name;
	}		
	public double getArea(){
		return area;
	}		
	public double getRod_length(){
		return rod_length;
	}		
	public int getCurrent_id(){
		return current_id;
	}		
	public int getId(){
		return id;
	}
	public void setTemperature(int temp){
		temperature = temp;
	}
	public void setCategory(MaterialCategories material_type){
		this.category = material_type;
	}
	public void setName(String change_name){
		material_name = change_name;
	}
	public void setArea(double cross_sect_area){
		area = cross_sect_area;
	}
	public void setRod_length(double length){
		rod_length = length;
	}
	public void setCurrent_id(int id_set){
		current_id = id_set;
	}
	public void setId(int new_id){
		id = new_id;
	}
	public String toString(){
		return String.format("The category is: %s, the material is: %s, the temperature is: %d, cross sectional area: %f, rod length: %f, rod id: %d", category, material_name, temperature, area, rod_length, id);
	}
	public boolean equals(Rod other){
		return (this.category.equals(other.category) && this.material_name.equals(other.material_name));
	}
	public double calculateExpansion(double termal_exp){
		DecimalFormat formater = new DecimalFormat("0.0000");
		return Double.parseDouble(formater.format(this.rod_length * this.temperature * termal_exp));
	}
	public double calculateForce(double length_change, double Young){
		double force = -1.0;
		DecimalFormat formater = new DecimalFormat("0.00");
		if(this.rod_length > 0){
			force = this.area / this.rod_length * Young * length_change;
		}
		return Double.parseDouble(formater.format(force));
	}
	
	
	
	
	
	
	
}