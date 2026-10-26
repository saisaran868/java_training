package java_tranning;

import java.util.Scanner;

public class StudentMarks {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your name: ");
		String name = sc.nextLine();

		System.out.print("Enter class: ");
		int studentClass = sc.nextInt();

		System.out.print("Enter Maths marks: ");
		int maths = sc.nextInt();
		System.out.print("Enter English marks: ");
		int english = sc.nextInt();
		System.out.print("Enter Telugu marks: ");
		int telugu = sc.nextInt();

		int total = maths + english + telugu;
		double average = total / 3.0;
		String grade;
		if (average > 90) {
			grade = "O";
		} else if (average > 75 && average <= 90) {
			grade = "A";
		} else if (average > 50 && average <= 75) {
			grade = "B";
		} else if (average >= 35) {
			grade = "Pass";
		} else {
			grade = "Fail";
		}

		System.out.println("\n================ STUDENT REPORT ================");

		System.out.printf("+----------------+----------------------+\n");
		System.out.printf("| %-14s | %-20s |\n", "DETAIL", "VALUE");
		System.out.printf("+----------------+----------------------+\n");

		System.out.printf("| %-14s | %-20s |\n", "Name", name);
		System.out.printf("| %-14s | %-20d |\n", "Class", studentClass);

		System.out.printf("+----------------+----------------------+\n");
		System.out.printf("| %-14s | %-20s |\n", "Subject", "Marks");
		System.out.printf("+----------------+----------------------+\n");

		System.out.printf("| %-14s | %-20d |\n", "Maths", maths);
		System.out.printf("| %-14s | %-20d |\n", "English", english);
		System.out.printf("| %-14s | %-20d |\n", "Telugu", telugu);

		System.out.printf("+----------------+----------------------+\n");
		System.out.printf("| %-14s | %-20d |\n", "Total Marks", total);
		System.out.printf("| %-14s | %-20.2f |\n", "Average", average);
		System.out.printf("| %-14s | %-20s |\n", "Grade", grade);
		System.out.printf("+----------------+----------------------+\n");

		sc.close();

	}

}
