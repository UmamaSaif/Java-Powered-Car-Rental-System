import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class CRMS {
    ArrayList<Car> cars=new ArrayList<Car>();
    ArrayList<Renter> renters=new ArrayList<Renter>();
    private static Set<String> generatedPlateNumbers = new HashSet<>();
    Scanner input=new Scanner(System.in);
    private static Random random=new Random();
    private static int carID=0;
    private static int renterID=0;
    String[] compactBrands = {"Mehran", "Cultus", "Ford", "Volkswagen", "Mazda"}; //Example brands
    String[] suvBrands = {"Toyota", "Honda", "Ford", "Jeep", "Subaru"};
    String[] luxuryBrands = {"BMW", "Mercedes-Benz", "Audi", "Lexus", "Jaguar"};
    
    String[] models = {"Model1", "Model2", "Model3"}; // Example models
    
    
    public void additionOfCars() { //hard coding cars in the system to demonstrate functionality
    	for(int i=0;i<10;i++) {
    		
    	    String compactBrand=compactBrands[random.nextInt(compactBrands.length)];
    	    String model = models[random.nextInt(models.length)];
    	    
    	    String suvBrand=suvBrands[random.nextInt(suvBrands.length)];
    	    String luxuryBrand=luxuryBrands[random.nextInt(luxuryBrands.length)];
    	  
    	    int randomYear=random.nextInt(25)+2000; //using random number to assign random years to the hard coded car
    	    
    		Compact compactCar=new Compact();
    		compactCar.setCarID(++carID);
    		compactCar.setCarBrand(compactBrand);
    		compactCar.setCarModel(model);
    		compactCar.setCarPlateNo(generatePlateNo());
    		compactCar.setCarYear(randomYear);
    		compactCar.setCarRentalStatus(false);
    		cars.add(compactCar);
    		
    		SUV suvCar=new SUV();
    		suvCar.setCarID(++carID);
    		suvCar.setCarBrand(suvBrand);
    		suvCar.setCarModel(model);
    		suvCar.setCarPlateNo(generatePlateNo());
    		suvCar.setCarYear(randomYear);
    		suvCar.setCarRentalStatus(false);
    		cars.add(suvCar);
    		
    		Luxury luxuryCar=new Luxury();
    		luxuryCar.setCarID(++carID);
    		luxuryCar.setCarBrand(luxuryBrand);
    		luxuryCar.setCarModel(model);
    		luxuryCar.setCarPlateNo(generatePlateNo());
    		luxuryCar.setCarYear(randomYear);
    		luxuryCar.setCarRentalStatus(false);
    		cars.add(luxuryCar);
    	}
    }
    
    public void displayAvailabeCars() { //displays cars which are currently available 
    	for(int i=0;i<cars.size();i++) {
    		if(!cars.get(i).getCarRentalStatus()) {
    			System.out.println("Car ID: "+cars.get(i).getCarID());
        		System.out.println("Car Brand: "+cars.get(i).getCarBrand());
        		System.out.println("Car Model: "+cars.get(i).getCarModel());
        		System.out.println("Car Year: "+cars.get(i).getCarYear());
        		System.out.println("Car Plate No: "+cars.get(i).getCarPlateNo());
    		}
    	}
    }
    
    public String generatePlateNo() { //generates random and unique plate numbers for hard coded cars
    	String plateNo;
    	
    	do {
    		int randomNo=random.nextInt(900)+100;
        	plateNo="AAA"+String.valueOf(randomNo);
    	}while(!generatedPlateNumbers.add(plateNo)); //continue generating until unique number is generated
    	

    	return plateNo;
    }
    
    public void addCar(Car car) { //add cars by taking input from user
    	car.setCarID(++carID);
    	cars.add(car);
    	System.out.println("Car with id \""+carID+"\" is successfully added in the system.");
    }
    
    public void removeCar(String plateNo) { //remove car by taking input from user
    	boolean found=false;
    	for(int i=0;i<cars.size();i++) {
    		if(cars.get(i).getCarPlateNo().equals(plateNo) && !cars.get(i).getCarRentalStatus()) {
    			found=true;
    			cars.remove(i);
    			System.out.println("Car with plate No \"" + plateNo + "\" removed successfully.");
    			break;
    		}
    	}
    	if(!found) {
    		System.out.println("No car with this plate No OR cannot remove because car is currently on rent.");
    	}
    	
    }
    
    public void additionOfRenters() { //hard coding renters in the system to demonstrate functionality
    	RegularRenter regularRenter=new RegularRenter();
    	regularRenter.setRenterID(++renterID);
    	regularRenter.setRenterName("Renter 1");
    	regularRenter.setRenterPhoneNo(331123456);
    	regularRenter.setRenterEmail("renter1@CRMS.com");
    	regularRenter.setRenterAddress("Sector 1, Islamabad");
    	regularRenter.addRentedCar(cars.get(0));
    	cars.get(0).setDistanceCovered(4);//hard coding it to demonstrate the functionality
    	regularRenter.addRentedCar(cars.get(11));
    	cars.get(11).setDistanceCovered(2.3);
    	regularRenter.calculateTotalRentalFee();
    	renters.add(regularRenter);
    	
    	FrequentRenter frequentRenter=new FrequentRenter();
    	frequentRenter.setRenterID(++renterID);
    	frequentRenter.setRenterName("Renter 2");
    	frequentRenter.setRenterPhoneNo(341123456);
    	frequentRenter.setRenterEmail("renter2@CRMS.com");
    	frequentRenter.setRenterAddress("Sector 2, Islamabad");
    	frequentRenter.setRenterType("Weekly");
    	frequentRenter.addRentedCar(cars.get(2));
    	cars.get(2).setDistanceCovered(5);
    	frequentRenter.addRentedCar(cars.get(3));
    	cars.get(3).setDistanceCovered(10);
    	frequentRenter.calculateTotalRentalFee();
    	renters.add(frequentRenter);
    	
    	CorporateRenter corporateRenter=new CorporateRenter();
    	corporateRenter.setRenterID(++renterID);
    	corporateRenter.setRenterName("Renter 3");
    	corporateRenter.setRenterPhoneNo(321123456);
    	corporateRenter.setRenterEmail("renter3@CRMS.com");
    	corporateRenter.setRenterAddress("Sector 3, Islamabad");
    	corporateRenter.setNumOfCars(1);
    	corporateRenter.addRentedCar(cars.get(4));
    	cars.get(4).setDistanceCovered(5.6);
    	corporateRenter.addRentedCar(cars.get(25));
    	cars.get(25).setDistanceCovered(6.1);
    	corporateRenter.addRentedCar(cars.get(6));
    	cars.get(6).setDistanceCovered(2.6);
    	corporateRenter.addRentedCar(cars.get(17));
    	cars.get(17).setDistanceCovered(4.5);
    	corporateRenter.addRentedCar(cars.get(8));
    	cars.get(8).setDistanceCovered(6.1);
    	corporateRenter.calculateTotalRentalFee();
    	renters.add(corporateRenter);
    	
    }
    
    public void addRenter(Renter renter) { //add renter by taking input from the user
    	renter.setRenterID(++renterID);
    	renters.add(renter);
    	System.out.println("Renter "+renterID+" is successfully added in the system.");
    }
    
    public void displayRenterDetails() { //display details of all renters currently added in the system
    	for(int i=0;i<renters.size();i++) {
    		System.out.println("Renter ID: "+renters.get(i).getRenterID());
    		System.out.println("Renter Name: "+renters.get(i).getRenterName());
    		System.out.println("Renter phone No: "+renters.get(i).getRenterPhoneNumber());
    		System.out.println("Renter Email: "+renters.get(i).getRenterEmail());
    		System.out.println("Rented Cars: ");
    		for (int j = 0; j < renters.get(i).getRentedCars().size(); j++) {
    	        System.out.println("Car ID: " + renters.get(i).getRentedCars().get(j).getCarID());
    	        System.out.println("Car Brand: " + renters.get(i).getRentedCars().get(j).getCarBrand());
    	        System.out.println("Car Model: " + renters.get(i).getRentedCars().get(j).getCarModel());
    	        System.out.println("Car Year: " + renters.get(i).getRentedCars().get(j).getCarYear());
    	        System.out.println("Car Plate No: " + renters.get(i).getRentedCars().get(j).getCarPlateNo());
    	    }
   		
    		System.out.println("Renter Bill: $"+renters.get(i).calculateTotalRentalFee());
    	}
    }
    
    public void removeRenter(int renterID) { //remove renter by taking input from the user
    	boolean removed=false;
    	for(int i=0;i<renters.size();i++) {
    		if(renters.get(i).getRenterID()==renterID && renters.get(i).getRentedCars().isEmpty()) {
    			renters.remove(i);
    			removed=true;
    			System.out.println("Renter with ID \""+renterID+"\" removed successfully.");
    			return;
    		}
    	}
    	if(!removed) {
    		System.out.println("Renter not found OR Renter has not returned the cars yet.");
    	}
    }
    
    public void rentCar(String plateNo, int renterID) { //rent car to a renter 
    	boolean rented=false;
    	
    	for (Car car : cars) {
            if (car.getCarPlateNo().equals(plateNo) && car.getCarRentalStatus()) {
                System.out.println("Car with plate No " + plateNo + " is already on rent.");
                return; 
            }
        }
    	
    	for(int i=0;i<renters.size();i++) {
    		if(renters.get(i).getRenterID()==renterID) {
    		for(int j=0;j<cars.size();j++) {
    			if(cars.get(j).getCarPlateNo().equals(plateNo) && !cars.get(j).getCarRentalStatus()) {
    				renters.get(i).addRentedCar(cars.get(j));
    				rented=true;
    				System.out.println("Car with plate No "+plateNo+" is rented to renter "+renterID);
    				break;
    			    }
    			
    		    }
    		
    	    }
    		if(rented) {
    			break;
    		}
    	
   	    }
    	if(!rented) {
    		System.out.println("Car with plate No "+plateNo+" is not found OR is already on rent.");
    	}
    	
    }
    
    public void returnCar(String plateNo,int renterID,double distance) { //take car back from the renter
    	boolean returned=false;
    	for(Renter renter:renters) {
    		if(renter.getRenterID()==renterID) {
    			for(Car car:renter.getRentedCars()) {
    				if(car.getCarPlateNo().equals(plateNo)) {
    					car.setDistanceCovered(distance);
    					car.setCarRentalStatus(false);
    					renter.getRentedCars().remove(car); //remove car from the rented cars of that renter
    					returned=true;
    					System.out.println("Car with plate No "+plateNo+" is returned from renter "+renterID);
    					break;
    				}
    			}
    		}
    	}
    	if(!returned) {
    		System.out.println("Car with plate No "+plateNo+" is not found OR Renter "+renterID+" is not found.");
    	}
    }
    
    public void setDistancesCovered(int renterID) { //setting distances covered for cars because it is needed for rental calculation
    	for(Renter renter:renters) {
    		if(renter.getRenterID()==renterID) {
    			for(Car car:renter.getRentedCars()) {
    				if(car.getCarRentalStatus()) {
    					System.out.println("Enter distance covered for car "+car.getCarBrand()+" "+car.getCarModel()+" with plate No "+car.getCarPlateNo()+" (in miles)");
    					car.setDistanceCovered(input.nextDouble());
    				}
    			}
    		}
    	}
    }
    
    public void addInsaurance(String plateNo,int renterID) { //adding insurance to insurable cars
    	double cost=0;
    	boolean insauranceAdded=false;
    	for(Renter renter: renters) {
    		if(renter.getRenterID()==renterID) {
    			for(Car car: renter.getRentedCars()) {
    				if(car.getCarPlateNo().equals(plateNo) && car.isInsaurable()) {
    					cost+=car.getInsaurance();
    					insauranceAdded=true;
    					System.out.println("Insaurance Added Successfully.");
    					System.out.println("Total insaurance cost is: $"+ cost);
    				}
    			}
    		}
    	}
    	if(!insauranceAdded) {
    		System.out.println("Car OR renter is not found OR Car is not insaurable");
    	}
    }
    
    public void calculateDamageCost(String plateNo, int renterID) { //calculating damage cost for a car
    	boolean calculated=false;
    	for(Renter renter: renters) {
    		if(renter.getRenterID()==renterID) {
    			for(Car car: renter.getRentedCars()) {
    				if(car.getCarPlateNo().equals(plateNo)) {
    					System.out.println("Enter distance covered for car "+car.getCarBrand()+" "+car.getCarModel()+" with plate No "+car.getCarPlateNo());
    					car.setDistanceCovered(input.nextDouble());
    					calculated=true;
    					System.out.println("Damage Cost for car "+car.getCarBrand()+" "+car.getCarModel()+" with plate No "+car.getCarPlateNo()+" is $"+car.getDamageCost());
    				}
    			}
    		}
    	}
    	if(!calculated) {
    		System.out.println("Car OR renter is not found.");
    	}
    }
}
