
package java_tranning;

import java.util.Scanner;

public class Login_Details {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User name validation
        String username;

        while (true) {
            System.out.print("Enter username (minimum 3 characters): ");
            username = sc.nextLine();

            if (username.length() >= 3) {
                break;
            } else {
                System.out.println("Invalid username! Try again.");
            }
        }

        // Email validation
        String email;

        while (true) {
            System.out.print("Enter email address: ");
            email = sc.nextLine();

            if (email.contains("@") && email.contains(".")) {
                break;
            } else {
                System.out.println("Invalid email! Try again.");
            }
        }

        // Phone number validation
        String phone;

        while (true) {
            System.out.print("Enter 10-digit phone number: ");
            phone = sc.nextLine();

            if (phone.length() == 10) {
                if (phone.matches("[0-9]+")) {
                    break;
                } else {
                    System.out.println("Enter numbers only!");
                }
            } else {
                System.out.println("Phone number must contain 10 digits!");
            }
        }

        // Display details
        System.out.println("\n======= LOGIN DETAILS =======");

        System.out.printf("%-15s : %s%n", "Username", username);
        System.out.printf("%-15s : %s%n", "Email", email);
        System.out.printf("%-15s : %s%n", "Phone", phone);

        System.out.println("\nYou are eligible to login!");

        sc.close();
    }
}
