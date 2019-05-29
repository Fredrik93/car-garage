package assignment2; //this is a class for the Cars objects

public class Cars {
	private String rgn;
	private int modelYear, price;
	private double qualityValue;
	private double weight, gasLvl, mileAge;
	private String status = "good";
	private String carClass = "";
    
	
	public Cars(String rgn, int modelYear, double weight, int price,double gasLvl, double mileAge, double qualityValue ) {
		this.rgn = rgn;
		this.modelYear = modelYear;
		this.weight = weight;
		this.price = price;
		this.gasLvl = gasLvl;
		this.mileAge = mileAge;
		this.qualityValue =getQualityValue();
		this.status = "good";
	}
	
	public Cars(String rgn, int modelYear, double weight, int price,double gasLvl, double mileAge, String status, double qualityValue ) {
		this.rgn = rgn;
		this.modelYear = modelYear;
		this.weight = weight;
		this.price = price;
		this.gasLvl = gasLvl;
		this.mileAge = mileAge;
		this.qualityValue =getQualityValue();
		this.status = status;
		this.qualityValue = qualityValue;
	}
	
	public void Fillin(double gas) {
		this.gasLvl = this.gasLvl + gas;
	}
	
	public void setGasLvl(double gas) {
		this.gasLvl = this.gasLvl - gas;
	}
	
	public String classification() {
		String carClass;
	
		if (this.weight <= 1500) 
		{
			
			carClass = "Light car";
		} else if(this.weight <= 2500) 
		{
			
			carClass = "Medium car";			
		} else 
		{
			
			carClass = "Heavy car";
		}
		this.carClass =carClass;
		return this.carClass;
	}

	public String getRgn() 
	{
		return this.rgn;
	}
	
	public int getModelYear () 
	{
		return this.modelYear;
	}
	
	public double getWeight () 
	{
		return this.weight;
	}
	
	public int getPrice () 
	{
		return this.price;
	}
	
	public double getGasLvl() 
	{
		return this.gasLvl;
	}
	
	public double getMileAge() 
	{
		return this.mileAge;
	}
	
	public double getQualityValue() 
	{
		
		return this.qualityValue;
	}
	
	public String getStatus() 
	{
		return this.status;
	}
	
	public String toString() 
	{
		final double mileToKm = 1.6;
		final double gallonToLiter = 3.78;
		String End_Of_Line = System.lineSeparator();
		String carFinal = this.rgn 			+ ": "		    + this.classification() + End_Of_Line + "Model year: "	    
						+ this.modelYear    + End_Of_Line   + "Weight: " 		      + this.weight + " kg." 			
						+ End_Of_Line 		+ "Price: "     + this.price + "$." 	  + End_Of_Line + "Gas level: " 
						+ this.gasLvl 		+ " gallons, (" + ((int)this.gasLvl * gallonToLiter) + " L.)" + End_Of_Line 
						+ "Mile age: " 		+ this.mileAge  + "miles, (" 	+ (this.mileAge * mileToKm)   
						+ " km.)"			+ End_Of_Line   + "Quality value: "     + this.qualityValue 
						+ "status: "        + this.status;
		return carFinal;
	}
	
	public void setStatus(String Status) 
	{
		this.status = Status;
	}
	
	public void setValue() 
	{
		final double decreaseInQuality = 0.1;
		
		this.qualityValue = this.qualityValue - decreaseInQuality;
	}

	public void setMileAge(double miles) {
		this.mileAge = this.mileAge + miles;
	}
}







