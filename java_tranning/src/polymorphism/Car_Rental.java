package polymorphism;

class CarRental {

	double calculateRent(int hours) {
		return hours * 200;
	}

	double calculateRent(String carType, int noOfDays) {

	    double perDayAmount;

	    if (carType.equalsIgnoreCase("Economy")) {
	        perDayAmount = 1500;
	    } else if (carType.equalsIgnoreCase("SUV")) {
	        perDayAmount = 3000;
	    } else if (carType.equalsIgnoreCase("Luxury")) {
	        perDayAmount = 5000;
	    } else {
	        System.out.println("Invalid car type!");
	        return 0;
	    }

	    return noOfDays * perDayAmount;
	}

	double calculateRent(int noOfDays, double perDayAmount, boolean isDriverRequired) {

		double total = noOfDays * perDayAmount;

		if (isDriverRequired) {
			total = total + (noOfDays * 500);
		}

		return total;
	}
}

public class Car_Rental {
	public static void main(String[] args) {

		CarRental car = new CarRental();

		double hourlyRent = car.calculateRent(5);

		double dailyRent = car.calculateRent("suv", 3);

		double driverRent = car.calculateRent(3, 2000, true);

		System.out.println("Hourly Rental: Rs. " + hourlyRent);

		System.out.println("Daily Rental: Rs. " + dailyRent);

		System.out.println("Rental With Driver: Rs. " + driverRent);

	}

}
