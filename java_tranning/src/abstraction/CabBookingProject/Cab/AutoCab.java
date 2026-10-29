package abstraction.CabBookingProject.Cab;


public class AutoCab extends Cab {

    public AutoCab(String customerName, double distance) {
        super(customerName, distance);
    }

    @Override
    public void bookRide() {
        System.out.println("AutoCab booked for " + customerName);
    }

    @Override
    public double calculateFare() {
        return distance * 8;
    }
}