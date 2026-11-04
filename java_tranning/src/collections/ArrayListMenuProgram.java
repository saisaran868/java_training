
package collections;

import java.util.ArrayList;
import java.util.Scanner;

class Student {

	private int id;
	private String name;
	private double marks;
	private int age;

	// Constructor
	public Student(int id, String name, double marks, int age) {

		setId(id);
		setName(name);
		setMarks(marks);
		setAge(age);
	}

	// Setters with validation
	public void setId(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID must be positive");
		}
		this.id = id;
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}
		this.name = name.trim();
	}

	public void setMarks(double marks) {
		if (!Double.isFinite(marks) || marks < 0 || marks > 100) {
			throw new IllegalArgumentException("Marks must be between 0 and 100");
		}
		this.marks = marks;
	}

	public void setAge(int age) {
		if (age < 5 || age > 100) {
			throw new IllegalArgumentException("Invalid age");
		}
		this.age = age;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getMarks() {
		return marks;
	}

	public int getAge() {
		return age;
	}

	// Display student details
	public void display() {

		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Marks: " + marks);
		System.out.println("Age: " + age);
		System.out.println("-------------------");
	}
}

public class ArrayListMenuProgram {

	public static void main(String[] args) {

		ArrayList<Student> students = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("\n===== STUDENT MENU =====");
			System.out.println("1. Add Student");
			System.out.println("2. View Students");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");

			System.out.print("Enter your choice: ");

			try {

				int choice = sc.nextInt();

				switch (choice) {

				// ADD STUDENT
				case 1 -> {

					try {

						System.out.println("------ Enter Student Details ------");

						System.out.print("Enter Student ID: ");
						int id = sc.nextInt();
						sc.nextLine();

						// Check duplicate ID
						boolean exists = false;

						for (Student s : students) {
							if (s.getId() == id) {
								exists = true;
								break;
							}
						}

						if (exists) {
							System.out.println("Student ID already exists!");
							break;
						}

						System.out.print("Enter Student Name: ");
						String name = sc.nextLine();

						System.out.print("Enter Student Marks: ");
						double marks = sc.nextDouble();

						System.out.print("Enter Student Age: ");
						int age = sc.nextInt();

						Student student = new Student(id, name, marks, age);

						students.add(student);

						System.out.println("Student Added Successfully!");

					} catch (IllegalArgumentException e) {
						System.out.println("Invalid Details: " + e.getMessage());
					}
				}

				// VIEW STUDENTS
				case 2 -> {

					if (students.isEmpty()) {

						System.out.println("No records found!");

					} else {

						System.out.println("----- Student Details -----");

						for (Student s : students) {
							s.display();
						}
					}
				}

				// UPDATE STUDENT
				case 3 -> {

					System.out.print("Enter Student ID to update: ");

					int updateId = sc.nextInt();
					sc.nextLine();

					Student found = null;

					for (Student s : students) {
						if (s.getId() == updateId) {
							found = s;
							break;
						}
					}

					if (found == null) {

						System.out.println("Student ID Not Found!");

					} else {

						try {

							System.out.print("Enter Updated Name: ");
							String name = sc.nextLine();

							System.out.print("Enter Updated Marks: ");
							double marks = sc.nextDouble();

							System.out.print("Enter Updated Age: ");
							int age = sc.nextInt();

							// Validate all values first
							Student temp = new Student(found.getId(), name, marks, age);

							// Update only after successful validation
							found.setName(temp.getName());
							found.setMarks(temp.getMarks());
							found.setAge(temp.getAge());

							System.out.println("Student Updated Successfully!");

						} catch (IllegalArgumentException e) {

							System.out.println("Update Failed: " + e.getMessage());
						}
					}
				}

				// DELETE STUDENT
				case 4 -> {

					System.out.print("Enter Student ID to Delete: ");

					int deleteId = sc.nextInt();

					boolean deleted = students.removeIf(s -> s.getId() == deleteId);

					if (deleted) {

						System.out.println("Record Deleted Successfully!");

					} else {

						System.out.println("Student ID Not Found!");
					}
				}

				// EXIT
				case 5 -> {

					System.out.println("Thank you! Bye Bye :)");

					sc.close();
					return;
				}

				default -> System.out.println("Invalid Choice!");
				}

			} catch (java.util.InputMismatchException e) {

				System.out.println("Please enter a valid input!");

				sc.nextLine();
			}
		}
	}
}
