
package java_tranning;

import java.util.Scanner;

public class ResortBooking {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int roomType;
		int roomOption;
		int nights;
		double price = 0;
		double total;

		System.out.println("===== RESORT ROOM BOOKING =====");
		System.out.println("1. Standard Room");
		System.out.println("2. Deluxe Room");
		System.out.println("3. Suite Room");

		System.out.print("Choose room type: ");
		roomType = sc.nextInt();

		switch (roomType) {

		case 1 -> {
			System.out.println("\nStandard Room Selected");
			System.out.println("1. AC - Rs.2000 per night");
			System.out.println("2. Non-AC - Rs.1500 per night");

			System.out.print("Choose room option: ");
			roomOption = sc.nextInt();

			switch (roomOption) {
			case 1 -> price = 2000;
			case 2 -> price = 1500;
			default -> System.out.println("Invalid room option!");
			}
		}

		case 2 -> {
			System.out.println("\nDeluxe Room Selected");
			System.out.println("1. AC - Rs.3500 per night");
			System.out.println("2. Non-AC - Rs.2800 per night");

			System.out.print("Choose room option: ");
			roomOption = sc.nextInt();

			switch (roomOption) {
			case 1 -> price = 3500;
			case 2 -> price = 2800;
			default -> System.out.println("Invalid room option!");
			}
		}

		case 3 -> {
			System.out.println("\nSuite Room Selected");
			System.out.println("1. AC - Rs.6000 per night");
			System.out.println("2. Non-AC - Rs.5000 per night");

			System.out.print("Choose room option: ");
			roomOption = sc.nextInt();

			switch (roomOption) {
			case 1 -> price = 6000;
			case 2 -> price = 5000;
			default -> System.out.println("Invalid room option!");
			}
		}

		default -> System.out.println("Invalid room type!");
		}

		if (price > 0) {
			System.out.print("Enter number of nights: ");
			nights = sc.nextInt();

			if (nights > 0) {
				total = price * nights;

				System.out.println("\n===== BOOKING DETAILS =====");
				System.out.println("Price per night: Rs." + price);
				System.out.println("Number of nights: " + nights);
				System.out.println("Total amount: Rs." + total);
				System.out.println("Room booking successful!");
			} else {
				System.out.println("Invalid number of nights!");
			}
		} else {
			System.out.println("Booking could not be completed.");
		}

		sc.close();
	}
}
