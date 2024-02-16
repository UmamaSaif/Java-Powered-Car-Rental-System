
public class SUV implements Car {
	private static final double ONE_MILE_COST=7.5;
	private static final boolean IS_INSAURABLE=true;
	private static final double INSAURANCE_PERCENTAGE= 3;
	private static final double DAMAGE_COST_PERCENTAGE=6.5/100;
	private static final double MINIMUM_DAMAGE=3.5;
	int carID;
    String carBrand;
    String carModel;
    int carYear;
    boolean carRentalStatus;
    double carRentalFee;
    String carPlateNo;
    double distanceCovered;//distance traveled by a car (in miles)
    
	@Override
	public int getCarID() {
		// TODO Auto-generated method stub
		return carID;
	}

	@Override
	public String getCarBrand() {
		// TODO Auto-generated method stub
		return carBrand;
	}

	@Override
	public String getCarModel() {
		// TODO Auto-generated method stub
		return carModel;
	}

	@Override
	public int getCarYear() {
		// TODO Auto-generated method stub
		return carYear;
	}

	@Override
	public boolean getCarRentalStatus() {
		// TODO Auto-generated method stub
		return carRentalStatus;
	}

	@Override
	public double calculateRentalFee() {
		// TODO Auto-generated method stub
		carRentalFee=BASE_RENT+(distanceCovered*ONE_MILE_COST);
		return carRentalFee;
	}

	@Override
	public String getCarPlateNo() {
		// TODO Auto-generated method stub
		return carPlateNo;
	}
	
	public double getDistanceCovered() {
		return distanceCovered;
	}
	
	
	
	public void setCarID(int id) {
		carID=id;
	}
	
	public void setCarBrand(String brand) {
		carBrand=brand;
	}
	
	public void setCarModel(String model) {
		carModel=model;
	}
	
	public void setCarYear(int year) {
		carYear=year;
	}
	
	public void setCarRentalStatus(boolean status) {
		carRentalStatus=status;
	}
	
	public void setCarPlateNo(String plateNo) {
		carPlateNo=plateNo;
	}
	
	public void setDistanceCovered(double distance) {
		distanceCovered=distance;
	}
	
	public boolean isInsaurable() {
		return IS_INSAURABLE;
	}
	
	public double getInsaurance() {
		return (BASE_RENT*(INSAURANCE_PERCENTAGE/100));
	}
	
	public double getDamageCost() {
		double damageCost=0;
		damageCost=Math.max(MINIMUM_DAMAGE,(DAMAGE_COST_PERCENTAGE*calculateRentalFee())-getInsaurance());
		return damageCost;
	}
}
