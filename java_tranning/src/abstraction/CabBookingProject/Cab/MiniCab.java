package abstraction.CabBookingProject.Cab;



public class MiniCab extends Cab {

    public MiniCab(String customerName, double distance) {
        super(customerName, distance);
    }

    @Override
    public void bookRide() {
        System.out.println("MiniCab booked for " + customerName);
    }

    @Override
    public double calculateFare() {
        return distance * 12;
    }
}