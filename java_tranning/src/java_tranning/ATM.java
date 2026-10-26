
package java_tranning;

import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double balance = 5000;
		int choice;
		double amount;

		while (true) {

			System.out.println("\n===== ATM MENU =====");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Exit");

			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1 -> {
				System.out.println("Your balance is: ₹" + balance);
			}

			case 2 -> {
				System.out.print("Enter amount to deposit: ₹");
				amount = sc.nextDouble();

				if (amount > 0) {
					balance = balance + amount;
					System.out.println("Money deposited successfully!");
					System.out.println("Updated balance: ₹" + balance);
//                        System.out.println("Thank you for using our ATM!");
//                        return;
				} else {
					System.out.println("Invalid amount!");
				}
			}

			case 3 -> {
				System.out.print("Enter amount to withdraw: ₹");
				amount = sc.nextDouble();

				if (amount <= 0) {
					System.out.println("Invalid amount!");
				} else if (amount > balance) {
					System.out.println("Insufficient balance!");
				} else {
					balance = balance - amount;
					System.out.println("Please collect your cash.");
					System.out.println("Remaining balance: ₹" + balance);
//                        System.out.println("Thank you for using our ATM!");
//                        return;
				}
			}

			case 4 -> {
				System.out.println("Thank you for using our ATM!");
				sc.close();
				return;
			}

			default -> {
				System.out.println("Invalid choice! Please select 1 to 4.");
			}
			}
		}
	}
}
