
public interface Car {
	public static final double BASE_RENT= 100; //set the base rent for all cars
    public int getCarID();
    public String getCarBrand();
    public String getCarModel();
    public int getCarYear();
    public boolean getCarRentalStatus();
    public double calculateRentalFee();
    public String getCarPlateNo();
    public double getDistanceCovered();
    public double getInsaurance();
    public void setCarID(int id);
    public void setCarRentalStatus(boolean status);
    public void setDistanceCovered(double distance);
    public boolean isInsaurable();
    public double getDamageCost();
}
