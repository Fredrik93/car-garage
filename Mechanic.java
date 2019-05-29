package assignment2;

public class Mechanic {
	private String name, type;

	public Mechanic(String name, String speciality) {
		this.name = name;
		this.type = speciality;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toString() {
		String finalMechanic = "Your registerd mechanic is " + this.name + ", speciaized in " + this.type;
		return finalMechanic;
	}
	
	public String toStringAll() {
		String finalMechanic = this.name + ", speciaized in " + this.type + System.lineSeparator();
		return finalMechanic;
	}
		
	

}
