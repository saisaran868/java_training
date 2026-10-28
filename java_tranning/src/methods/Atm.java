package methods;

import java.util.Scanner;

public class Atm {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);    

		double balance = 5000;
		int choice;

		while (true) {

			displayMenu();

			if (!sc.hasNextInt()) {
				System.out.println("Invalid input! Enter a number from 1 to 4.");
				sc.next();
				continue;
			}

			choice = sc.nextInt();

			switch (choice) {

			case 1:
				checkBalance(balance);
				break;

			case 2:
				balance = deposit(sc, balance);
				break;

			case 3:
				balance = withdraw(sc, balance);
				break;

			case 4:
				System.out.println("Thank you for using our ATM!");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice! Please select 1 to 4.");
			}
		}
	}

	public static void displayMenu() {

		System.out.println("\n===== ATM MENU =====");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit Money");
		System.out.println("3. Withdraw Money");
		System.out.println("4. Exit");
		System.out.print("Enter your choice: ");
	}

	public static void checkBalance(double balance) {

		System.out.printf("Your balance is: ₹%.2f%n", balance);
	}

	public static double deposit(Scanner sc, double balance) {

		System.out.print("Enter amount to deposit: ₹");

		if (!sc.hasNextDouble()) {
			System.out.println("Invalid input! Enter a numeric amount.");
			sc.next();
			return balance;
		}

		double amount = sc.nextDouble();

		if (amount <= 0) {

			System.out.println("Invalid amount!");

		} else {

			balance = balance + amount;

			System.out.println("Money deposited successfully!");

			System.out.printf("Updated balance: ₹%.2f%n", balance);
		}

		return balance;
	}

	public static double withdraw(Scanner sc, double balance) {

		System.out.print("Enter amount to withdraw: ₹");

		if (!sc.hasNextDouble()) {
			System.out.println("Invalid input! Enter a numeric amount.");
			sc.next();
			return balance;
		}

		double amount = sc.nextDouble();

		if (amount <= 0) {

			System.out.println("Invalid amount!");

		} else if (amount > balance) {

			System.out.println("Insufficient balance!");

		} else {

			balance = balance - amount;

			System.out.println("Please collect your cash.");

			System.out.printf("Remaining balance: ₹%.2f%n", balance);
		}

		return balance;
	}
}
