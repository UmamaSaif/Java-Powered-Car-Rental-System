import java.util.ArrayList;

public class CorporateRenter implements Renter {
	int renterID;
    String renterName;
    String renterEmail;
    ArrayList<Car> rentedCars; //array List of cars rented by the renter
    double totalRentalFee;
    long renterPhoneNo;
    String renterAddress;
    int numOfCars;//number of cars rented at a time/ in package
    
    CorporateRenter(){
    	rentedCars=new ArrayList<Car>();
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
	public double calculateTotalRentalFee() {
		// TODO Auto-generated method stub
		totalRentalFee=0;
		for(int i=0;i<rentedCars.size();i++) {
			totalRentalFee+=rentedCars.get(i).calculateRentalFee()*discountMultiplier();
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
		return "Corporate";
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
	
	public void setNumOfCars(int num) { //in package
		numOfCars=num;
	}
	
	private double discountMultiplier() { //discount based on package
		if(numOfCars<5 && numOfCars>0) {
			return 1.0;//no discount
		}
		else if(numOfCars==5) {
			return (5/100);//5% discount
		}
		else if(numOfCars>5 && numOfCars<10) {
			return(numOfCars/100);//num% discount
		}
		else if(numOfCars==10) {
			return (10/100);//10% discount
		}
		else if(numOfCars>10) {
			return ((numOfCars*0.5)/100);//num/2% discount
		}
		return 1;//default value
	}
	
	public double calculateTotalRentalFeeWithInsaurance() {
		totalRentalFee=0;
		boolean insauranceAdded=false;
		for(int i=0;i<rentedCars.size();i++) {
			if(rentedCars.get(i).isInsaurable()) {
				totalRentalFee+=rentedCars.get(i).calculateRentalFee();
				totalRentalFee+=rentedCars.get(i).getInsaurance();
				insauranceAdded=true;
			}
			
		}
		if(!insauranceAdded) {
			System.out.println("Car is not insaurable.");
		}
		return totalRentalFee;
	}

}
