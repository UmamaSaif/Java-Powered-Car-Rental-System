import java.util.ArrayList;

public class RegularRenter implements Renter {
    int renterID;
    String renterName;
    String renterEmail;
    ArrayList<Car> rentedCars; //array List of cars rented by the renter
    double totalRentalFee;
    long renterPhoneNo;
    String renterAddress;
    
    RegularRenter(){
    	rentedCars=new ArrayList<Car>(); //initializing the arrayList in the constructor
    }
	@Override
	public int getRenterID() {
		// TODO Auto-generated method stub
		return renterID;
	}

	@Override
	public String getRenterName() {
		// TODO Auto-generated method stub
		return renterName;
	}

	@Override
	public String getRenterEmail() {
		// TODO Auto-generated method stub
		return renterEmail;
	}

	@Override
	public ArrayList<Car> getRentedCars() {
		// TODO Auto-generated method stub
		return rentedCars;
	}

	@Override
	public double calculateTotalRentalFee() { //total rent of all cars rented
		// TODO Auto-generated method stub
		totalRentalFee=0;
		for(int i=0;i<rentedCars.size();i++) {
			totalRentalFee+=rentedCars.get(i).calculateRentalFee(); 
		}
		return totalRentalFee;
	}

	@Override
	public long getRenterPhoneNumber() {
		// TODO Auto-generated method stub
		return renterPhoneNo;
	}

	@Override
	public String getRenterAddress() {
		// TODO Auto-generated method stub
		return renterAddress;
	}
	
	public String getRenterType() {
		return "Regular";
	}
	public void setRenterID(int id) {
		renterID=id;
	}
	
	public void setRenterName(String name) {
		renterName=name;
	}
	
	public void setRenterEmail(String email) {
		renterEmail=email;
	}
	
	public void addRentedCar(Car car) {
		
		if(!car.getCarRentalStatus()) {
			rentedCars.add(car);
			car.setCarRentalStatus(true);
		}
		else {
			System.out.println("Car "+car.getCarID()+" is already on rent.");
		}
	}
	
	public void setRenterPhoneNo(long phoneNo) {
		renterPhoneNo=phoneNo;
	}
	
	public void setRenterAddress(String address) {
		renterAddress=address;
	}
	
	public double calculateTotalRentalFeeWithInsaurance() { //total with insurance
		totalRentalFee=0;
		boolean insauranceAdded=false;
		for(int i=0;i<rentedCars.size();i++) {
			if(rentedCars.get(i).isInsaurable()) {
				totalRentalFee+=rentedCars.get(i).calculateRentalFee();
				totalRentalFee+=rentedCars.get(i).getInsaurance();
				insauranceAdded=true;
			}
			else {
				totalRentalFee+=rentedCars.get(i).calculateRentalFee();
			}
			
		}
		if(!insauranceAdded) {
			
			System.out.println("Car is not insaurable.");
		}
		return totalRentalFee;
	}

}
