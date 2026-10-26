package java_training.arrays;

import java.util.Scanner;

public class Duplicate_Elements {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int length = 0;

		while (length <= 0) {
			System.out.print("Enter the length of the array: ");
			length = sc.nextInt();

			if (length <= 0) {
				System.out.println("Invalid length! Please enter a positive number.");
			}
		}

		int[] array = new int[length];

		for (int i = 0; i < length; i++) {
			System.out.print("Enter the number: ");
			int value = sc.nextInt();
			array[i] = value;
		}
		
		System.out.print("Duplicate numbers are : ");
		
		 for (int i = 0; i < array.length; i++) {

		        for (int j = i + 1; j < array.length; j++) {

		            if (array[i] == array[j]) {
		                System.out.print(array[i] + " ");
		                break;
		            }
		        }}
		 
		 sc.close();
	}

}
