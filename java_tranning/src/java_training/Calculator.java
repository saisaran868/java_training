
package java_training;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		double num1;
		double num2;
		double result = 0;
		char operator;
		char choice;
		boolean valid;

		while (true) {

			valid = true;

			System.out.println("\n--- Calculator ---");

			System.out.print("Enter the first number: ");
			num1 = scanner.nextDouble();

			System.out.print("Enter an operator (+, -, *, /, %, ^): ");
			operator = scanner.next().charAt(0);

			System.out.print("Enter the second number: ");
			num2 = scanner.nextDouble();

			switch (operator) {

			case '+' -> result = num1 + num2;

			case '-' -> result = num1 - num2;

			case '*' -> result = num1 * num2;

			case '/' -> {
				if (num2 == 0) {
					System.out.println("Cannot divide by zero!");
					valid = false;
				} else {
					result = num1 / num2;
				}
			}

			case '%' -> {
				if (num2 == 0) {
					System.out.println("Cannot calculate modulo by zero!");
					valid = false;
				} else {
					result = num1 % num2;
				}
			}

			case '^' -> result = Math.pow(num1, num2);

			default -> {
				System.out.println("Invalid operator!");
				valid = false;
			}
			}

			if (valid) {
				System.out.printf("%.2f %c %.2f = %.2f%n", num1, operator, num2, result);
			}

			System.out.print("\nDo you want to calculate again? (Y/N): ");
			choice = scanner.next().charAt(0);

			if (choice == 'N' || choice == 'n') {
				break;
			}
		}

		System.out.println("Calculator closed. Thank you!");
		scanner.close();
	}
}
