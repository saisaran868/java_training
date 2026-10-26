
package java_training;

import java.util.Scanner;

public class Loan_Eligibility {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Get salaried status
		String salaried;

		while (true) {
			System.out.print("Are you salaried? (Yes/No): ");
			salaried = sc.next();

			if (salaried.equalsIgnoreCase("yes") || salaried.equalsIgnoreCase("no")) {
				break;
			} else {
				System.out.println("Invalid input! Enter Yes or No.");
			}
		}

		// Get annual income
		int annualIncome;

		while (true) {
			System.out.print("Enter your annual income: ");

			if (sc.hasNextInt()) {
				annualIncome = sc.nextInt();

				if (annualIncome > 0) {
					break;
				} else {
					System.out.println("Income must be greater than 0.");
				}
			} else {
				System.out.println("Enter a valid whole number.");
				sc.next();
			}
		}

		// Get CIBIL score
		int cibilScore;

		while (true) {
			System.out.print("Enter your CIBIL score (0 or 300-900): ");

			if (sc.hasNextInt()) {
				cibilScore = sc.nextInt();

				if (cibilScore == 0 || (cibilScore >= 300 && cibilScore <= 900)) {
					break;
				} else {
					System.out.println("Invalid CIBIL score!");
				}
			} else {
				System.out.println("Enter a valid whole number.");
				sc.next();
			}
		}

		// Check loan eligibility
		String status;
		String reason;

		if (cibilScore == 0) {
			status = "Manual Review";
			reason = "CIBIL score unavailable";
		} else if (salaried.equalsIgnoreCase("yes") && annualIncome >= 300000 && cibilScore >= 750) {
			status = "Eligible";
			reason = "Excellent credit profile";
		} else if (salaried.equalsIgnoreCase("yes") && annualIncome >= 300000 && cibilScore >= 650) {
			status = "Eligible";
			reason = "Eligibility criteria met";
		} else if (salaried.equalsIgnoreCase("yes") && annualIncome >= 300000 && cibilScore >= 550) {
			status = "Manual Review";
			reason = "CIBIL score needs review";
		} else if (salaried.equalsIgnoreCase("no") && annualIncome >= 500000 && cibilScore >= 750) {
			status = "Eligible";
			reason = "Eligibility criteria met";
		} else if (salaried.equalsIgnoreCase("no") && annualIncome >= 500000 && cibilScore >= 650) {
			status = "Manual Review";
			reason = "CIBIL score needs review";
		} else {
			status = "Rejected";
			reason = "Eligibility criteria not met";
		}

		// Display details in table
		System.out.println("\n========== LOAN DETAILS ==========");

		System.out.printf("+----------------------+------------------------+%n");
		System.out.printf("| %-20s | %-22s |%n", "DETAIL", "VALUE");
		System.out.printf("+----------------------+------------------------+%n");
		System.out.printf("| %-20s | %22s |%n", "Salaried", salaried);
		System.out.printf("| %-20s | %22d |%n", "Annual Income", annualIncome);
		System.out.printf("| %-20s | %22d |%n", "CIBIL Score", cibilScore);
		System.out.printf("| %-20s | %22s |%n", "Loan Status", status);
		System.out.printf("| %-20s | %22s |%n", "Reason", reason);
		System.out.printf("+----------------------+------------------------+%n");

		sc.close();
	}
}
