package java_training.arrays;

import java.util.Scanner;

public class Largest_Number {
	public static void main(String[]args) {
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
		
		int largestNumber =0;
		
		for(int i =0; i<length; i++) {
			
			if(array[i]>largestNumber) {
				largestNumber = array[i];
			}
		}
		
		System.out.printf("Largest number : %d",largestNumber);
		
		sc.close();
	}

}
