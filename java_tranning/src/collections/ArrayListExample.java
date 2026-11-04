package collections;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
	public static void main (String[]args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> foods = new ArrayList<>();
		
		System.out.print("Enter no of food items u want to store: ");
		
		int noOfFoodItems = sc.nextInt();
		
		sc.nextLine();
		
		for(int i =1; i<=noOfFoodItems; i++) {
			
			System.out.print("Enter the food name: ");
			
			foods.add(sc.nextLine());
		}
		
		for(String food : foods) {
			
			System.out.println(food);
		}
		
		
		sc.close();
	}

}
