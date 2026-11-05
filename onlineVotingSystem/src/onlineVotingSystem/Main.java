
package onlineVotingSystem;

import java.util.Scanner;

import onlineVotingSystem.model.User;
import onlineVotingSystem.services.ResultService;
import onlineVotingSystem.services.UserService;
import onlineVotingSystem.services.VotingService;
import onlineVotingSystem.exception.InvalidLoginException;
import onlineVotingSystem.exception.AlreadyVotedException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create service objects
        UserService userService = new UserService();
        VotingService votingService = new VotingService();
        ResultService resultService = new ResultService();

        // Predefined candidates
        votingService.addCandidate("101", "Sai Saran");
        votingService.addCandidate("102", "Sai Gowtham");
        votingService.addCandidate("103", "Sai Krishna");
        votingService.addCandidate("104", "Sai Kumar");

        // Predefined users
        userService.addPredefinedUser(
            "SK1", "Saisaran Kollareddy", "868@123Ks");

        userService.addPredefinedUser(
            "SG2", "Sai Gowtham", "868@123Ks");

        userService.addPredefinedUser(
            "SG3", "SivaCharan Gurram", "868@123Ks");

        userService.addPredefinedUser(
            "SS4", "Siva sai", "868@123Ks");

        userService.addPredefinedUser(
            "SC5", "Sai Charan", "868@123Ks");

        try {

            while (true) {

                System.out.println(
                    "\n----- Welcome to Online Voting System -----");

                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");

                System.out.print("Enter your choice: ");

                String choice = sc.nextLine();

                switch (choice) {

                    case "1" -> registerUser(sc, userService);

                    case "2" -> loginUser(
                        sc, userService, votingService, resultService);

                    case "3" -> {
                        System.out.println(
                            "Thank you for using the Voting System!");
                        return;
                    }

                    default -> System.out.println(
                        "Invalid choice! Please select 1, 2 or 3.");
                }
            }

        } finally {
            sc.close();
        }
    }

    // Registration
    public static void registerUser(
            Scanner sc, UserService userService) {

        while (true) {

            try {

                System.out.println("\n---- Registration ----");

                System.out.print("Enter your first name: ");
                String firstName = sc.nextLine();

                System.out.print("Enter your last name: ");
                String lastName = sc.nextLine();

                System.out.print("Enter your password: ");
                String password = sc.nextLine();

                String studentId = userService.registerUser(
                    firstName, lastName, password);

                System.out.println("\nRegistration successful!");

                System.out.println(
                    "Your Student ID: " + studentId);

                return;

            } catch (IllegalArgumentException e) {

                System.out.println("\nError: " + e.getMessage());

                System.out.println(
                    "Please enter your details again.");
            }
        }
    }

    // Login
    public static void loginUser(
            Scanner sc,
            UserService userService,
            VotingService votingService,
            ResultService resultService) {

        System.out.println("\n---- User Login ----");

        System.out.print("Enter your Student ID: ");
        String studentId = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        try {

            User user = userService.loginUser(studentId, password);

            System.out.println("\nLogin successful!");

            System.out.println(
                "Welcome, " + user.getStudentName());

            votingMenu(sc, user, votingService, resultService);

        } catch (InvalidLoginException e) {

            System.out.println("\nLogin Error: " + e.getMessage());

        }
    }

    // Voting Menu
    public static void votingMenu(
            Scanner sc,
            User user,
            VotingService votingService,
            ResultService resultService) {

        while (true) {

            System.out.println("\n----- Voting Menu -----");

            System.out.println("1. View Candidates");
            System.out.println("2. Cast Vote");
            System.out.println("3. Voting Results");
            System.out.println("4. Logout");

            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "1" -> votingService.displayCandidates();

                case "2" -> castVote(sc, user, votingService);

                case "3" -> resultService.displayResults(
                    votingService.getCandidates());

                case "4" -> {
                    System.out.println("Logged out successfully!");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // Cast Vote
    public static void castVote(
            Scanner sc,
            User user,
            VotingService votingService) {

        try {

            votingService.displayCandidates();

            System.out.print("\nEnter Candidate ID: ");

            String candidateId = sc.nextLine();

            votingService.castVote(user, candidateId);

            System.out.println(
                "\nYour vote has been recorded successfully!");

            System.out.println("Thank you for voting!");

        } catch (AlreadyVotedException |
                 IllegalArgumentException e) {

            System.out.println("\nVoting Error: " + e.getMessage());
        }
    }
}
