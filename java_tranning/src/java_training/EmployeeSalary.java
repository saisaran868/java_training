
package java_tranning;

import java.util.Scanner;

public class EmployeeSalary {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Employee Name: ");
		String empName = sc.nextLine();

		System.out.print("Enter Employee ID: ");
		String empId = sc.nextLine();

		System.out.print("Enter Employee Department: ");
		String empDept = sc.nextLine();

		System.out.print("Enter Years of Experience: ");
		int empYoe = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Employee Designation: ");
		String empDesign = sc.nextLine();

		System.out.print("Enter Basic Salary: ");
		double basicSalary = sc.nextDouble();

		// Salary calculation
		double hra = basicSalary * 0.20;
		double da = basicSalary * 0.10;

		double grossPay = basicSalary + hra + da;

		double pf = basicSalary * 0.12;
		double tax = grossPay * 0.05;

		double netPay = grossPay - pf - tax;

		// Increment based on experience and department
		double incrementRate;

		if (empDept.equalsIgnoreCase("HR") && empYoe >= 5) {
			incrementRate = 0.10;
		} else if (empDept.equalsIgnoreCase("HR") && empYoe >= 2) {
			incrementRate = 0.07;
		} else if (empDept.equalsIgnoreCase("IT") && empYoe >= 5) {
			incrementRate = 0.15;
		} else if (empDept.equalsIgnoreCase("IT") && empYoe >= 2) {
			incrementRate = 0.10;
		} else if (empDept.equalsIgnoreCase("Sales") && empYoe >= 5) {
			incrementRate = 0.12;
		} else if (empDept.equalsIgnoreCase("Sales") && empYoe >= 2) {
			incrementRate = 0.08;
		} else if (empYoe >= 5) {
			incrementRate = 0.05;
		} else {
			incrementRate = 0.02;
		}

		double increment = basicSalary * incrementRate;

		// Bonus based on designation
		double bonus;

		if (empDesign.equalsIgnoreCase("Manager")) {
			bonus = 15000;
		} else if (empDesign.equalsIgnoreCase("Team Lead")) {
			bonus = 10000;
		} else if (empDesign.equalsIgnoreCase("Senior Developer")) {
			bonus = 8000;
		} else if (empDesign.equalsIgnoreCase("Developer")) {
			bonus = 5000;
		} else {
			bonus = 2000;
		}

		// Final salary
		double finalSalary = netPay + increment + bonus;

		// Employee report
		System.out.println("\n========== EMPLOYEE SALARY REPORT ==========");

		System.out.printf("+----------------------+------------------+%n");
		System.out.printf("| %-20s | %16s |%n", "DETAIL", "VALUE");
		System.out.printf("+----------------------+------------------+%n");

		System.out.printf("| %-20s | %16s |%n", "Employee ID", empId);
		System.out.printf("| %-20s | %16s |%n", "Employee Name", empName);
		System.out.printf("| %-20s | %16s |%n", "Department", empDept);
		System.out.printf("| %-20s | %16s |%n", "Designation", empDesign);
		System.out.printf("| %-20s | %16d |%n", "Experience (Years)", empYoe);

		System.out.printf("+----------------------+------------------+%n");
		System.out.printf("| %-20s | %16.2f |%n", "Net Salary", netPay);
		//System.out.printf("| %-20s | %15.2f%% |%n", "Increment Rate", incrementRate * 100);
		System.out.printf("| %-20s | %16.2f |%n", "Increment", increment);
		System.out.printf("| %-20s | %16.2f |%n", "Bonus", bonus);

		System.out.printf("+----------------------+------------------+%n");
		System.out.printf("| %-20s | %16.2f |%n", "Final Salary", finalSalary);
		System.out.printf("+----------------------+------------------+%n");

		sc.close();
	}
}
