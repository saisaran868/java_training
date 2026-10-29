package abstraction.CabBookingProject.Cab;

import abstraction.CabBookingProject.Booking.CabBooking;

public abstract class Cab implements CabBooking {

    protected String customerName;
    protected double distance;

    public Cab(String customerName, double distance) {

        this.customerName = customerName;
        this.distance = distance;
    }
}