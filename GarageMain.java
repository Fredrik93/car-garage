package assignment2; 

import assignment3.Scanners;

public class GarageMain {
	
	
	
	private static final int REGISTER_CAR = 1; 
	private static final int PRINT_CARS = 2;
	private static final int PRINT_CAR = 3;
	private static final int PRINT_CHEAPEST_CAR = 4;
	private static final int DRIVE_CAR = 5;
	private static final int FILL_GAS = 6; 
	private static final int REGISTER_MACHANIC = 7;
	private static final int REPAIR_CAR = 8;
	private static final int PRINT_MECHANICS = 9;
	private static final int QUIT = 10;
	
	private static final String INVALID_INPUT = "Invalid input, enter valid input type ";
	private static final String GENERAL_NOT_FOUND = "Please register a car/mechanic to use this service";
	private static final String SPECIFIC_NOT_FOUND = "A car/mechanic of the required classification is not found";

	private Cars[] cars;
	private Mechanic[] mechanics;
	private final int MAX_GAS_LEVEL = 10;  
	private int registeredCars;
	private int registeredMechanics;
    	
  public GarageMain() { //
		final int MAX_CARS = 5;
		this.cars = new Cars[MAX_CARS];
		this.registeredCars = 0;
				
		final int MAX_MECHANICS = 5;
		this.mechanics = new Mechanic [MAX_MECHANICS];
		this.registeredMechanics = 0;
		
	}

  public Cars retrieveCar(String carRgn) {
		for (int i = 0; i < this.cars.length; i++) {
			if(cars[i] != null && cars[i].getRgn().equals(carRgn)) {
				return cars[i];
			}
		}
		System.out.println(GENERAL_NOT_FOUND);
		return null;
	}
	
  public void createCar() {        	
		
	  	
	  	
	  	
	  	
	  	final int mileAgeMin = 0;

	  	System.out.println("Enter the registration number:");		
		String rgn = Scanners.scanLine();
		
						
		System.out.println("Enter the car year model:");		
		int modelYear = Scanners.scanInt();
		
		
		
		System.out.println("Enter the weight of the car in kg:");		
		double weight = Scanners.scanDouble();		
		
		
		System.out.println("Enter the price of the car:");		
		int price = Scanners.scanInt();
		
		
		System.out.println("Enter the gas level in gallons:");		
		double gasLvl = Scanners.scanDouble();
		
		
		System.out.println("Enter the distance crossed by the car:");		
		double mileAge = Scanners.scanDouble();
		while (mileAge < mileAgeMin) {
			System.out.println(INVALID_INPUT);
			System.out.println("please type the mile age again");
			mileAge = Scanners.scanDouble();
		}
				
		String status = "good";
		int statusLevel = 4; 
		System.out.println("Please describe select a fit discribtion for the status of the car:");
		System.out.println("--------------------");
		System.out.println("1. Good");
		System.out.println("2. Ok");
		System.out.println("3. Bad");
		System.out.println("4. I don't know");
		System.out.println("--------------------");
		while (!(statusLevel == 1 || statusLevel == 2 || statusLevel == 3 || statusLevel == 4 )) {
			System.out.println(INVALID_INPUT );
			System.out.println("please enter one of the valid options above");
		}
		statusLevel = Scanners.scanInt();
		if ( (statusLevel == 1  || statusLevel == 2 || statusLevel == 3)) 
		{
			if (statusLevel == 1) 
			{
				status = "Good";
			} 
			else if( statusLevel == 2)
			{
				status = "Ok";				
			} 
			else 
			{
				status = "Bad";
			}	
		}
		
		double milesRating, modelRating;
		if ( mileAge > 100000 ) 
		{
			milesRating = 0.0;
		} else if ( mileAge > 80000)
		{
			milesRating = 0.1;
		} else if ( mileAge > 60000)
		{
			milesRating = 0.2;
		} else if ( mileAge > 40000)
		{
			milesRating = 0.3;
		} else if ( mileAge > 20000)
		{
			milesRating = 0.4;
		} else 
		{		
			milesRating = 0.5;
		}
		
		if ( modelYear > 2013 ) 
		{
			modelRating = 0.5;
		} else if ( modelYear > 2009)
		{
			modelRating = 0.4;
		} else if ( modelYear > 2005)
		{
			modelRating = 0.3;
		} else if ( modelYear > 2001)
		{
			modelRating = 0.2;
		} else if ( modelYear > 1997)
		{
			modelRating = 0.1;
		} else 
		{
			modelRating = 0.0;
		}
		
		double qualityValue = modelRating + milesRating;
		if ( statusLevel == 4) 
		{
				this.cars[this.registeredCars] = new Cars( rgn, modelYear, weight, price, gasLvl, mileAge, qualityValue);
		} 
		else 
		{ 
				this.cars[this.registeredCars] = new Cars( rgn, modelYear, weight, price, gasLvl, mileAge, status, qualityValue);				
		}		  			
  }
  
  public Mechanic createMechanic() 
  {
		System.out.println("Write down the name of your mechanic:");
		String name = Scanners.scanLine();
		String mechClass = classChoice();
		Mechanic newMechanic = new Mechanic( name, mechClass);
		return newMechanic;
  }
	
  public void run() 
  {    
      int option;
      do 
      {
    	  printMenuOptions();
    	  System.out.print(" Type the option number: ");
          
          option = Scanners.scanInt();
                          
          switch (option) 
          {
			case REGISTER_CAR:
				if(this.registeredCars > 4)
					System.out.println("There are no more spaces to register a car");
				else
				{
					createCar();
					this.registeredCars = this.registeredCars + 1;
					System.out.println("The car has been created");
				}
				break;
	
			case PRINT_CARS:
				printAllCars();
				break;
	
			case PRINT_CAR:
				printOneCar();				
				break;
						
			case PRINT_CHEAPEST_CAR:
				printCheapest();
				break;
				
			case DRIVE_CAR:
				drive();
				break;
	
			case FILL_GAS:
				fillGas();
				break;

			case REGISTER_MACHANIC:
				
				if(this.registeredMechanics > 4)
				{
					System.out.println("There are no more spaces to register a mechaninc");
				}else 
				{
				Mechanic newMechanic = createMechanic();
				this.mechanics[registeredMechanics] =newMechanic;
				this.registeredMechanics = this.registeredMechanics + 1;
				System.out.println("The mechanic has been registered");	
				}
				break;

			case REPAIR_CAR:
				repairCar();
				break;
				
			case PRINT_MECHANICS:
				printAllMechanics();
				break;
			case QUIT:
				System.out.println("Thanks for visiting the Garage.");
				System.out.println();
				break;
	
			default:
				System.out.println("Option "+option+" is not valid.");
				System.out.println();
				break;
          }
      } while (option != QUIT);
  }

  private void printMenuOptions() 
  {
      System.out.println(" === Welcome to DIT042 Garage === ");
      System.out.println(" Choose an option below: ");
      System.out.println(" ");
      System.out.println(" 1. Register a car. ");
      System.out.println(" 2. Print all cars. ");
      System.out.println(" 3. Print a car's information. ");
      System.out.println(" 4. Print the cheapest car's information. ");
      System.out.println(" 5. Test-drive a car. ");
      System.out.println(" 6. Fill a car's gas tank. ");
      System.out.println(" 7. Hire a mechanic. ");
      System.out.println(" 8. Repair a car. ");
      System.out.println(" 9. Print Mechanics registered. ");
      System.out.println(" 10. Quit this program. ");
      System.out.println();
  }
  
  public void printAllCars() 
  {
	  
	  String print;
	  for (int i=0;i < this.registeredCars;i++) 
	  {
		  if(this.cars[i]!=null)
		  {
			  print = this.cars[i].toString();
			  System.out.println(print);
			  
		  }        
	  }	  
  }
  
  public void printOneCar() 
  {     
      String carRgn = readCarRgn();
      
      Cars foundCar = retrieveCar(carRgn);
      if (foundCar.getRgn().equals(carRgn))
      {
    	  String PRINT = foundCar.toString();
		  System.out.println(PRINT);
		  
	  }
    	  
  }             
	
  public void printCheapest() 
	{
	  	String mechClass = classChoice();
		double price = 2147483647; 
		String cheapest = SPECIFIC_NOT_FOUND;
		for (int i=0;i < this.registeredCars; i++) 
		{
			String searchClasses = cars[i].classification();
			if (mechClass.equals(searchClasses) &&  cars[i].getPrice() < price)
			{
				price = cars[i].getPrice(); 
				cheapest = cars[i].toString();
				
			} 
			 
		}
		System.out.println(cheapest);
	}
    
  public String readCarRgn() 
  {
      System.out.print("Type the rgn of the car: ");
      String carRgn = Scanners.scanLine();
      return carRgn;
  }
  
  public void drive() 
  {
     final int milesPerGallon = 25;
	 String carRgn = readCarRgn();     
     Cars foundCar = retrieveCar(carRgn);
     double gasReq =0;
     if (foundCar !=null)
     { 
	      System.out.println("Please Enter the miles your want to travel");
	      double miles = Scanners.scanDouble();
	      double gasLevel = foundCar.getGasLvl();
	      if (miles < 0)
	      {
	    	  System.out.println("Error when driving car " + carRgn +", Miles cannot be negative.");
	      }
	      if (gasLevel == 0)
	      {
					System.out.println("Error when driving car "+ carRgn + ", Gas tank is empty");
	      } else 
		  {
	    	  		foundCar.setMileAge(miles);
					gasReq = (miles/milesPerGallon);		
					
					if ( gasReq > gasLevel )
					{
							System.out.println("you do not have gas to drive that amount of miles, you need more gas");
					}else 
					{
						System.out.println("Done");
						foundCar.setGasLvl(gasReq);
					}
		  }
     }
			
  }
  
  public void fillGas() 
  {

      String carRgn = readCarRgn();     
      Cars foundCar = retrieveCar(carRgn);
      System.out.println("Please enter amount of gas you want to fill in ");
      double gallons = Scanners.scanDouble();
      double sum = foundCar.getGasLvl() + gallons;
      if (foundCar.getGasLvl() == MAX_GAS_LEVEL) 
		{
			System.out.println("Error when filling car " + carRgn+ " with gas." + "Gas tank is full");
			
		}
		if (gallons < 0)
			{ 
			System.out.println("Error when filling car " + carRgn+ " with gas." + "Amount of gallons cannot be negative");
			return;
		}
		if ((sum > MAX_GAS_LEVEL) )
		{
			System.out.println("you do not have enough volume in the tank to fill gas");
			
		} else
		{
			foundCar.Fillin(gallons);
			System.out.println("Car refilled with " + gallons);
		}
    
  }
  
  public void repairCar() 
  {
      String carRgn = readCarRgn();     
      Cars foundCar = retrieveCar(carRgn);
      //boolean Found = false;
      System.out.println("Type in the name of the mchaninc to use:");
      String mechanicName = Scanners.scanLine();
      String mechanicType = null;
      for (int i=0;i < this.registeredMechanics; i++) 
      {
			if (mechanicName.equals(mechanics[i].getName())) 
			{
				mechanicType = mechanics[i].getType();
			}
      }
      		if (mechanicType.equals(null))
      			return;
      		if (mechanicType.equals(foundCar.classification()) ) 
			{
				if(foundCar.getQualityValue()!=0.0) 
				{
					foundCar.setStatus("good");
				  	System.out.println("Car " + carRgn + " Repaired by " + mechanicName + "!"); 
					foundCar.setValue();
				}
			}
  }
	 
  public void printAllMechanics() 
  {	  
	  String print; 
	  if(registeredMechanics == 0) 
	  {
		  System.out.println(GENERAL_NOT_FOUND);
	  } else
	  {
		  System.out.println("Your mechanics are:");
		  for (int i=0;i < this.registeredMechanics;i++) 
		  {
			  if(this.mechanics[i]!=null)
			  {			  
				  print = this.mechanics[i].toStringAll();
				 
				  System.out.println(print);
				  
			  }
		  }		  
	  }	  
  }
   
  public static void main(String[] args) 
  {        
      GarageMain program = new GarageMain();
      
      program.run();      
  }

  public String classChoice() 
  {
  	String mechClass = "";
	String magicWord = "";
	while (! magicWord.equals("hi")) 
	{
	  	System.out.println("choose on of the specialities:");
		System.out.println("1. Light car");
		System.out.println("2. Medium car");
		System.out.println("3. Heavy car");
		int mechClassNum = Scanners.scanInt();
		
	
		switch (mechClassNum) 
		{
		case 1:
			mechClass = "Light car";
			magicWord = "hi";
			break;
		case 2:
			mechClass = "Medium car";
			magicWord = "hi";
			break;
		case 3:
			mechClass = "Heavy car";
			magicWord = "hi";
			break;
		default:
			System.out.println(INVALID_INPUT);
			
		}
		
	}return mechClass;
  }
}