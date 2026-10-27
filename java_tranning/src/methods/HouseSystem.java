package methods;

import java.util.Scanner;

public class HouseSystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n;

		while (true) {
			System.out.print("Enter number of houses: ");

			if (sc.hasNextInt()) {
				n = sc.nextInt();

				if (n > 0) {
					break;
				}
			} else {
				sc.next();
			}

			System.out.println("Invalid input! Enter a positive integer.");
		}

		String[] owners = new String[n];
		String[] bhkTypes = new String[n];
		String[] dealTypes = new String[n];

		double[] monthlyRents = new double[n];
		int[] months = new int[n];
		double[] totalAmounts = new double[n];

		sc.nextLine();

		for (int i = 0; i < n; i++) {

			System.out.println("\n===== HOUSE " + (i + 1) + " =====");

			while (true) {
				System.out.print("Enter owner name: ");
				owners[i] = sc.nextLine().trim();

				if (!owners[i].isEmpty()) {
					break;
				}

				System.out.println("Owner name cannot be empty!");
			}

			while (true) {
				System.out.print("Enter house type (1BHK/2BHK/3BHK): ");

				bhkTypes[i] = sc.next().toUpperCase();

				monthlyRents[i] = calculateMonthlyRent(bhkTypes[i]);

				if (monthlyRents[i] != -1) {
					break;
				}

				System.out.println("Invalid house type! Choose 1BHK, 2BHK, or 3BHK.");
			}

			// Select rent or lease
			while (true) {
				System.out.print("Enter deal type (rent/lease): ");

				dealTypes[i] = sc.next().toLowerCase();

				if (dealTypes[i].equals("rent") || dealTypes[i].equals("lease")) {
					break;
				}

				System.out.println("Invalid deal type! Enter rent or lease.");
			}

			// Calculate rent or lease
			if (dealTypes[i].equals("rent")) {

				while (true) {
					System.out.print("Enter number of months: ");

					if (sc.hasNextInt()) {
						months[i] = sc.nextInt();

						if (months[i] > 0) {
							break;
						}
					} else {
						sc.next();
					}

					System.out.println("Invalid input! Enter a positive number of months.");
				}

				totalAmounts[i] = calculateRent(monthlyRents[i], months[i]);

			} else {

				double leaseAmount;

				while (true) {
					System.out.print("Enter lease amount: ₹");

					if (sc.hasNextDouble()) {
						leaseAmount = sc.nextDouble();

						if (leaseAmount > 0) {
							break;
						}
					} else {
						sc.next();
					}

					System.out.println("Invalid amount! Enter a positive amount.");
				}

				totalAmounts[i] = calculateLease(leaseAmount);
				months[i] = 0;
			}

			// Consume newline before the next owner's name
			sc.nextLine();
		}

		// Display report for all houses
		System.out.println("\n========== HOUSE REPORT ==========");

		for (int i = 0; i < n; i++) {

			display(owners[i], bhkTypes[i], dealTypes[i], monthlyRents[i], months[i], totalAmounts[i]);
		}

		sc.close();
	}

	static double calculateMonthlyRent(String bhk) {

		if (bhk.equalsIgnoreCase("1BHK")) {
			return 8000;
		} else if (bhk.equalsIgnoreCase("2BHK")) {
			return 12000;
		} else if (bhk.equalsIgnoreCase("3BHK")) {
			return 18000;
		} else {
			return -1;
		}
	}

	static double calculateRent(double monthlyRent, int months) {
		return monthlyRent * months;
	}

	static double calculateLease(double leaseAmount) {
		return leaseAmount;
	}

	static void display(String owner, String bhk, String dealType, double monthlyRent, int months, double totalAmount) {

		System.out.println("\n--------------------------------");
		System.out.println("Owner Name   : " + owner);
		System.out.println("House Type   : " + bhk);
		System.out.println("Deal Type    : " + dealType);

		if (dealType.equalsIgnoreCase("rent")) {
			System.out.printf("Monthly Rent : ₹%.2f%n", monthlyRent);
			System.out.println("Duration     : " + months + " months");
		}

		System.out.printf("Total Amount : ₹%.2f%n", totalAmount);
		System.out.println("--------------------------------");
	}
}
