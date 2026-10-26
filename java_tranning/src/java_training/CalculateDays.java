
package java_training;

import java.util.Scanner;

public class CalculateDays {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter month number (1-12): ");
		int month = sc.nextInt();

		char leapYear;

		switch (month) {

		case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("Number of days = 31");

		case 4, 6, 9, 11 -> System.out.println("Number of days = 30");

		case 2 -> {
			while (true) {
				System.out.print("Is this a leap year? (Y/N): ");
				leapYear = sc.next().charAt(0);

				if (leapYear == 'Y' || leapYear == 'y') {
					System.out.println("Number of days = 29");
					break;
				} else if (leapYear == 'N' || leapYear == 'n') {
					System.out.println("Number of days = 28");
					break;
				} else {
					System.out.println("Invalid input! Enter Y or N.");
				}
			}
		}

		default -> System.out.println("Invalid month number!");
		}

		sc.close();
	}
}
