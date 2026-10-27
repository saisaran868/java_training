package array_task2;

import java.util.Scanner;

public class StudentResultSystem {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int students;

		while (true) {

			System.out.print("Enter no of students: ");
			if (sc.hasNextInt()) {
				students = sc.nextInt();

				if (students > 0) {
					break;
				}
			} else {
				sc.next();
			}

			System.out.println("Invalid input! Enter a positive integer.");
		}

		int subjects;

		while (true) {

			System.out.print("Enter no of subjects: ");
			if (sc.hasNextInt()) {
				subjects = sc.nextInt();

				if (subjects > 0) {
					break;
				}
			} else {
				sc.next();
			}

			System.out.println("Invalid input! Enter a positive integer.");
		}
        String[]  name = new String [students];
		int[][] marks = new int[students][subjects];
		int[] totals = new int[students];
		double[] averages = new double[students];
		char[] grades = new char[students];

		for (int i = 0; i < students; i++) {
			sc.nextLine();
			System.out.print("\nEnter Name for Student" + (i + 1) +": ");
			
			name[i] =sc.nextLine();

			System.out.println("\nEnter marks for "+name[i] +": ");
			int total = 0;

			for (int j = 0; j < subjects; j++) {

				while (true) {

					System.out.print(" Subject " + (j + 1) + ": ");

					if (!sc.hasNextInt()) {
						System.out.println("Invalid input! Enter a whole number.");
						sc.next();
						continue;
					}

					int mark = sc.nextInt();

					if (mark >= 0 && mark <= 100) {
						marks[i][j] = mark;
						total += mark;
						break;
					} else {
						System.out.println("Invalid! Enter marks between 0 and 100.");
					}

				}

			}
			
			totals[i]=total;
			averages[i]= total / (double) subjects;
			
			if (averages[i] >= 90) {
                grades[i] = 'A';
            } else if (averages[i] >= 75) {
                grades[i] = 'B';
            } else if (averages[i] >= 60) {
                grades[i] = 'C';
            } else if (averages[i] >= 50) {
                grades[i] = 'D';
            } else {
                grades[i] = 'F';
            }
		}
		
		 int topperIndex = 0;

	        for (int i = 1; i < students; i++) {
	            if (totals[i] > totals[topperIndex]) {
	                topperIndex = i;
	            }
	        }
	        
	     int leastIndex =0;
	     for(int i =1; i<students; i++) {
	    	 if (totals[i] < totals[leastIndex]) {
	                leastIndex = i;
	            }
	     }
	        
	        

	        // 6. Display the final report
	        System.out.println("\n========== FINAL REPORT ==========");

	        System.out.printf("%-10s", "Student");
	        
	        System.out.printf("%-10s", "Name");
	        
	        for (int j = 0; j < subjects; j++) {
	            System.out.printf("%-10s", "Sub" + (j + 1));
	        }

	        System.out.printf("%-10s%-12s%-8s%n",
	                          "Total", "Average", "Grade");

	        for (int i = 0; i < students; i++) {

	            System.out.printf("%-10s", "Student " + (i + 1));
	            
	            System.out.printf("%-10s",name[i]);

	            for (int j = 0; j < subjects; j++) {
	                System.out.printf("%-10d", marks[i][j]);
	            }

	            System.out.printf("%-10d%-12.2f%-8c%n",
	                              totals[i], averages[i], grades[i]);
	        }

	        // 7. Display topper details
	        System.out.println("\n========== TOPPER DETAILS ==========");

	        System.out.println("Topper:" + name[topperIndex]);
	        System.out.println("Total Marks: " + totals[topperIndex]);
	        System.out.printf("Average: %.2f%n", averages[topperIndex]);
	        System.out.println("Grade: " + grades[topperIndex]);
	        
	        System.out.println("\n========== Least Marks ==========");
	        
	        System.out.println("Student: " + name[leastIndex]);
	        System.out.println("Total Marks: " + totals[leastIndex]);
	        System.out.printf("Average: %.2f%n", averages[leastIndex]);
	        System.out.println("Grade: " + grades[leastIndex]);

	        sc.close();
	}

}
