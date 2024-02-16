import java.util.ArrayList;

public interface Renter {
    public int getRenterID();
    public String getRenterName();
    public String getRenterEmail();
    public ArrayList<Car> getRentedCars();
    public double calculateTotalRentalFee();
    public long getRenterPhoneNumber();
    public String getRenterAddress();
    public String getRenterType();
    public void setRenterID(int id);
    public void addRentedCar(Car car);
    public double calculateTotalRentalFeeWithInsaurance();
}
