package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// ---------------- CAR CLASS ----------------

class Car {

	private int carId;
	private String brand;
	private double rentPerDay;
	private boolean isAvailable;

	public Car(int carId, String brand, double rentPerDay) {

		if (carId <= 0) {
			throw new IllegalArgumentException("Invalid Car ID");
		}

		if (brand == null || brand.trim().isEmpty()) {
			throw new IllegalArgumentException("Brand cannot be empty");
		}

		if (!Double.isFinite(rentPerDay) || rentPerDay <= 0) {
			throw new IllegalArgumentException("Rent must be positive");
		}

		this.carId = carId;
		this.brand = brand.trim();
		this.rentPerDay = rentPerDay;
		this.isAvailable = true;
	}

	public int getCarId() {
		return carId;
	}

	public String getBrand() {
		return brand;
	}

	public double getRentPerDay() {
		return rentPerDay;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean available) {
		this.isAvailable = available;
	}
}

// ---------------- CUSTOMER CLASS ----------------

class Customer {

	private int customerId;
	private String name;

	public Customer(int customerId, String name) {

		if (customerId <= 0) {
			throw new IllegalArgumentException("Invalid Customer ID");
		}

		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}

		this.customerId = customerId;
		this.name = name.trim();
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}
}

// ---------------- RENTAL CLASS ----------------

class Rental {

	private Car car;
	private Customer customer;
	private int days;

	public Rental(Car car, Customer customer, int days) {

		if (car == null || customer == null) {
			throw new IllegalArgumentException("Car and Customer cannot be null");
		}

		if (days <= 0) {
			throw new IllegalArgumentException("Rental days must be positive");
		}

		this.car = car;
		this.customer = customer;
		this.days = days;
	}

	public Car getCar() {
		return car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getDays() {
		return days;
	}

	public double getTotalCost() {
		return days * car.getRentPerDay();
	}
}

// ---------------- MAIN CLASS ----------------

public class CarRentalSystem {

	static ArrayList<Car> cars = new ArrayList<>();
	static ArrayList<Rental> rentals = new ArrayList<>();

	static Scanner sc = new Scanner(System.in);

	static int customerIdCounter = 1;

	public static void main(String[] args) {

		// Sample cars
		cars.add(new Car(1, "Hyundai", 1500));
		cars.add(new Car(2, "Toyota", 2000));
		cars.add(new Car(3, "Honda", 1800));

		int choice;

		do {

			System.out.println("\n===== CAR RENTAL SYSTEM =====");
			System.out.println("1. View Available Cars");
			System.out.println("2. Rent Car");
			System.out.println("3. Return Car");
			System.out.println("4. View Active Rentals");
			System.out.println("5. Exit");

			choice = readInt("Enter your choice: ");

			switch (choice) {

			// VIEW AVAILABLE CARS
			case 1 -> showAvailableCars();

			// RENT CAR
			case 2 -> rentCar();

			// RETURN CAR
			case 3 -> returnCar();

			// VIEW ACTIVE RENTALS
			case 4 -> showActiveRentals();

			// EXIT
			case 5 -> System.out.println("Thank you! Bye Bye :)");

			default -> System.out.println("Invalid choice!");
			}

		} while (choice != 5);

		sc.close();
	}

	// ---------------- INPUT METHODS ----------------

	static int readInt(String message) {

		while (true) {

			System.out.print(message);
			String input = sc.nextLine();

			try {
				return Integer.parseInt(input.trim());

			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid integer!");
			}
		}
	}

	static double readDouble(String message) {

		while (true) {

			System.out.print(message);
			String input = sc.nextLine();

			try {
				double value = Double.parseDouble(input.trim());

				if (Double.isFinite(value)) {
					return value;
				}

				System.out.println("Please enter a finite number!");

			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number!");
			}
		}
	}

	// ---------------- FIND CAR ----------------

	static Car findCar(int id) {

		for (Car car : cars) {

			if (car.getCarId() == id) {
				return car;
			}
		}

		return null;
	}

	// ---------------- SHOW AVAILABLE CARS ----------------

	static void showAvailableCars() {

		boolean found = false;

		System.out.println("\n----- AVAILABLE CARS -----");

		for (Car car : cars) {

			if (car.isAvailable()) {

				System.out.println("ID: " + car.getCarId() + " | Brand: " + car.getBrand() + " | Rent: Rs."
						+ car.getRentPerDay() + "/day");

				found = true;
			}
		}

		if (!found) {
			System.out.println("No cars available!");
		}
	}

	// ---------------- RENT CAR ----------------

	static void rentCar() {

		showAvailableCars();

		System.out.println("\n----- RENT A CAR -----");

		int id = readInt("Enter Car ID: ");

		Car car = findCar(id);

		if (car == null || !car.isAvailable()) {

			System.out.println("Car not found or not available!");
			return;
		}

		System.out.print("Enter Customer Name: ");
		String name = sc.nextLine();

		if (name.trim().isEmpty()) {

			System.out.println("Customer name cannot be empty!");
			return;
		}

		int days = readInt("Enter rental days: ");

		if (days <= 0) {

			System.out.println("Rental days must be greater than zero!");
			return;
		}

		try {

			Customer customer = new Customer(customerIdCounter, name);

			Rental rental = new Rental(car, customer, days);

			rentals.add(rental);

			car.setAvailable(false);

			customerIdCounter++;

			System.out.println("\nCar rented successfully!");

			System.out.println("Customer ID: " + customer.getCustomerId());
			System.out.println("Customer Name: " + customer.getName());
			System.out.println("Car: " + car.getBrand());
			System.out.println("Rental Days: " + days);
			System.out.println("Total Cost: Rs." + rental.getTotalCost());

		} catch (IllegalArgumentException e) {

			System.out.println("Rental Failed: " + e.getMessage());
		}
	}

	// ---------------- RETURN CAR ----------------

	static void returnCar() {

		int id = readInt("Enter Car ID to return: ");

		Iterator<Rental> iterator = rentals.iterator();

		while (iterator.hasNext()) {

			Rental rental = iterator.next();

			if (rental.getCar().getCarId() == id) {

				rental.getCar().setAvailable(true);

				iterator.remove();

				System.out.println("Car returned successfully!");

				return;
			}
		}

		System.out.println("No active rental found for this Car ID!");
	}

	// ---------------- VIEW ACTIVE RENTALS ----------------

	static void showActiveRentals() {

		if (rentals.isEmpty()) {

			System.out.println("No active rentals found!");
			return;
		}

		System.out.println("\n----- ACTIVE RENTALS -----");

		for (Rental rental : rentals) {

			System.out.println("Car ID: " + rental.getCar().getCarId());

			System.out.println("Car Brand: " + rental.getCar().getBrand());

			System.out.println("Customer ID: " + rental.getCustomer().getCustomerId());

			System.out.println("Customer Name: " + rental.getCustomer().getName());

			System.out.println("Rental Days: " + rental.getDays());

			System.out.println("Total Cost: Rs." + rental.getTotalCost());

			System.out.println("--------------------------");
		}
	}
}
