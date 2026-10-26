package java_training.arrays;

import java.util.Scanner;

public class Finding_index {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		int num[]= {10,20,30,40,50,60};
		
		System.out.print("Enter the number to find its index: ");
		       int number = sc.nextInt();
		       
		       for(int i=0; i<num.length; i++) {
		    	   
		    	   if(number == num[i]) {
		    		   
		    		   System.out.printf("Index of '%d' is %d",number,i);
		    	   }
		       }
		
		sc.close();
	}

}
