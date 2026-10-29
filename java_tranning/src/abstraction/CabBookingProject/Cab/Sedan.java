package abstraction.CabBookingProject.Cab;


public class Sedan extends Cab {

    public Sedan(String customerName, double distance) {
        super(customerName, distance);
    }

    @Override
    public void bookRide() {
        System.out.println("Sedan booked for " + customerName);
    }

    @Override
    public double calculateFare() {
        return distance * 18;
    }
}