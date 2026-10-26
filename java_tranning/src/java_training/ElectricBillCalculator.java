
package java_training;

import java.util.Scanner;

public class ElectricBillCalculator {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int billAmount;
		int noOfMonths = 6;
		int totalBill = 0;

		int i = 1;

		while (i <= noOfMonths) {

			System.out.printf("Enter the electricity bill amount for month %d: ", i);

			billAmount = sc.nextInt();

			totalBill += billAmount;

			i++;
		}

		System.out.printf("Your total bill for %d months is: %,d%n", noOfMonths, totalBill);
		System.out.println("Thank you!");

		sc.close();
	}
}
