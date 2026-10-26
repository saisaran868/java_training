package java_training;

import java.util.Scanner;

public class CheckPalindrome {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Enter a number: ");
			int num = sc.nextInt();

			String original = String.valueOf(num);
			String reversed = new StringBuilder(original).reverse().toString();

			System.out.println("Original number: " + original);
			System.out.println("Reversed number: " + reversed);

			if (original.equals(reversed)) {
				System.out.println("It is a palindrome number.");
			} else {
				System.out.println("It is not a palindrome number.");
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