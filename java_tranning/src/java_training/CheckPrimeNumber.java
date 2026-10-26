package java_training;

import java.util.Scanner;

public class CheckPrimeNumber {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Enter a number: ");
			int num = sc.nextInt();

			int i = 2;
			boolean isPrime = true;

			if (num <= 1) {
				isPrime = false;
			} else {
				while (i < num) {
					if (num % i == 0) {
						isPrime = false;
						break;
					}
					i++;
				}
			}

			if (isPrime) {
				System.out.println(num + " is a prime number.");
			} else {
				System.out.println(num + " is not a prime number.");
			}
			System.out.println();
			System.out.print("Want to check again: (Y/N):");
			char choice = sc.next().charAt(0);
			if (choice != 'y' && choice != 'Y') {
				break;
			}

		}
		System.out.println("Thank you!");
		sc.close();

	}
}
