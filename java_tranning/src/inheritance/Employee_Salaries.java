package inheritance;

import java.util.Scanner;

class Employee {
	String empId;
	String empName;
	int basicSalary;

	Employee(String empId, String empName, int basicSalary) {
		this.empId = empId;
		this.empName = empName;
		this.basicSalary = basicSalary;
	}

	double calculateSalary() {
		return basicSalary;
	}

	void displaySalary() {
		System.out.println("Employee ID: " + empId);
		System.out.println("Employee Name: " + empName);
		System.out.println("Basic Salary: " + basicSalary);
		System.out.println("Total Salary: " + calculateSalary());
		System.out.println("--------------------------");
	}
}

class Manager extends Employee {

	Manager(String empId, String empName, int basicSalary) {
		super(empId, empName, basicSalary);
	}

	double calculateSalary() {
		double allowance = basicSalary * 0.30;
		double bonus = basicSalary * 0.20;

		return basicSalary + allowance + bonus;
	}
}

class Developer extends Employee {

	Developer(String empId, String empName, int basicSalary) {
		super(empId, empName, basicSalary);
	}

	double calculateSalary() {
		double allowance = basicSalary * 0.20;
		double bonus = basicSalary * 0.15;

		return basicSalary + allowance + bonus;
	}
}

class Intern extends Employee {
	Intern(String empId, String empName, int basicSalary) {
		super(empId, empName, basicSalary);
	}

	double calculateSalary() {
		double allowance = basicSalary * 0.05;
		

		return basicSalary + allowance ;
	}

}

public class Employee_Salaries {
	 public static void main(String[]args) {
		 
		 Scanner sc = new Scanner(System.in);
		 Manager manager = new Manager("M101", "Rahul", 50000);

	     Developer developer = new Developer("D101", "Priya", 40000);
	     
	     System.out.print("Enter your Employee-ID: ");
	     String empId = sc.nextLine();
	     System.out.print("Enter your Name: ");
	     String empName = sc.nextLine();
	     System.out.print("Enter your Basic-Salary: ");
	     int basicSalary = sc.nextInt();
	     

	     Intern intern = new Intern(empId, empName, basicSalary);
	     
	     manager.displaySalary();
	     developer.displaySalary();
	     intern.displaySalary();
	     
	     sc.close();
	 }
     
    

}
