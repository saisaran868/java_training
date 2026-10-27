package array_task2;

import java.util.Scanner;

public class EmployeeSalarySystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int employees;

		while (true) {
			System.out.print("Enter number of employees: ");

			if (sc.hasNextInt()) {
				employees = sc.nextInt();

				if (employees > 0) {
					break;
				}
			} else {
				sc.next();
			}

			System.out.println("Invalid input! Enter a positive integer.");
		}

		int noOfMonths;

		while (true) {
			System.out.print("Enter number of salary months: ");

			if (sc.hasNextInt()) {
				noOfMonths = sc.nextInt();

				if (noOfMonths > 0) {
					break;
				}
			} else {
				sc.next();
			}

			System.out.println("Invalid input! Enter a positive integer.");
		}

		String[] empNames = new String[employees];

		int[][] salaries = new int[employees][noOfMonths];

		long[] totalSalaries = new long[employees];

		double[] averages = new double[employees];

		sc.nextLine();

		for (int i = 0; i < employees; i++) {

			while (true) {
				System.out.print("\nEnter name of Employee " + (i + 1) + ": ");

				empNames[i] = sc.nextLine().trim();

				if (!empNames[i].isEmpty()) {
					break;
				}

				System.out.println("Name cannot be empty!");
			}

			System.out.println("\nEnter monthly salaries for " + empNames[i] + ":");

			long total = 0;

			// Enter salary for each month
			for (int j = 0; j < noOfMonths; j++) {

				while (true) {

					System.out.print("Month " + (j + 1) + ": ");

					if (!sc.hasNextInt()) {
						System.out.println("Invalid input! Enter a whole number.");

						sc.next();
						continue;
					}

					int salary = sc.nextInt();

					if (salary >= 0) {
						salaries[i][j] = salary;
						total += salary;
						break;
					} else {
						System.out.println("Invalid salary! Enter zero or a positive amount.");
					}
				}
			}
			sc.nextLine();
			totalSalaries[i] = total;

			averages[i] = total / (double) noOfMonths;
		}

		int highestPaidIndex = 0;
		int lowestPaidIndex = 0;

		for (int i = 1; i < employees; i++) {

			if (totalSalaries[i] > totalSalaries[highestPaidIndex]) {
				highestPaidIndex = i;
			}

			if (totalSalaries[i] < totalSalaries[lowestPaidIndex]) {
				lowestPaidIndex = i;
			}
		}

		System.out.println("\n================ EMPLOYEE SALARY REPORT ================");

		System.out.printf("%-20s", "Employee");

		for (int j = 0; j < noOfMonths; j++) {
			System.out.printf("%-12s", "Month " + (j + 1));
		}

		System.out.printf("%-18s%-18s%n", "Total Salary", "Average Salary");

		System.out.println("--------------------------------------------------------------------------");

		for (int i = 0; i < employees; i++) {

			System.out.printf("%-20s", empNames[i]);

			for (int j = 0; j < noOfMonths; j++) {
				System.out.printf("%-12d", salaries[i][j]);
			}

			System.out.printf("%-18d%-18.2f%n", totalSalaries[i], averages[i]);
		}

		System.out.println("\n================ HIGHEST-PAID EMPLOYEE ================");

		System.out.println("Name: " + empNames[highestPaidIndex]);

		System.out.println("Total Salary: " + totalSalaries[highestPaidIndex]);

		System.out.printf("Average Monthly Salary: %.2f%n", averages[highestPaidIndex]);

		System.out.println("\n================ LOWEST-PAID EMPLOYEE =================");

		System.out.println("Name: " + empNames[lowestPaidIndex]);

		System.out.println("Total Salary: " + totalSalaries[lowestPaidIndex]);

		System.out.printf("Average Monthly Salary: %.2f%n", averages[lowestPaidIndex]);

		sc.close();
	}
}