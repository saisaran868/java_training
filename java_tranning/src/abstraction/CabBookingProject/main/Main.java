package abstraction.CabBookingProject.main;

import abstraction.CabBookingProject.Cab.AutoCab;
import abstraction.CabBookingProject.Cab.MiniCab;
import abstraction.CabBookingProject.Cab.Sedan;

public class Main {

    public static void main(String[] args) {

        // Book a MiniCab
        MiniCab mini = new MiniCab("Rahul", 10);

        mini.bookRide();
        System.out.println("Fare: ₹" + mini.calculateFare());

        System.out.println("--------------------");

        // Book an AutoCab
        AutoCab auto = new AutoCab("Priya", 10);

        auto.bookRide();
        System.out.println("Fare: ₹" + auto.calculateFare());

        System.out.println("--------------------");

        // Book a Sedan
        Sedan sedan = new Sedan("Arun", 10);

        sedan.bookRide();
        System.out.println("Fare: ₹" + sedan.calculateFare());
    }
}