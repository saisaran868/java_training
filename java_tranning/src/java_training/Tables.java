package java_tranning;

import java.util.Scanner;

public class Tables {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int num = sc.nextInt();

		for (int i = 1; i <= 10; i++) {
			System.out.println(num + " x " + i + " = " + (num * i));
		}

//        for (int num1 = 1; num1 <= 10; num1++) {
//
//            System.out.println("\nMultiplication table of " + num1);
//
//            for (int i = 1; i <= 10; i++) {
//                System.out.println(num1 + " x " + i + " = " + (num1 * i));
//            }
//        }

		sc.close();
	}
}
