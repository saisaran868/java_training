package abstraction.PaymentGateway.main;

import java.util.Scanner;
import javax.security.sasl.AuthenticationException;

import abstraction.PaymentGateway.gateway.PaymentGateway;
import abstraction.PaymentGateway.methods.CardPayment;
import abstraction.PaymentGateway.methods.NetBankingPayment;
import abstraction.PaymentGateway.methods.UPIPayment;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== PAYMENT GATEWAY =====");
        System.out.println("1. Card Payment");
        System.out.println("2. Net Banking");
        System.out.println("3. UPI Payment");
        System.out.print("Choose your payment method: ");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline

        try {

            PaymentGateway payment;

            switch (choice) {

                case 1:
                    System.out.print("Enter customer name: ");
                    String cardCustomer = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double cardAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter name as per card: ");
                    String cardHolder = sc.nextLine();

                    System.out.print("Enter card number: ");
                    String cardNumber = sc.nextLine();

                    System.out.print("Enter expiry date (MM/YY): ");
                    String expiryDate = sc.nextLine();

                    payment = new CardPayment(
                            cardCustomer,
                            cardAmount,
                            cardHolder,
                            cardNumber,
                            expiryDate
                    );
                    break;

                case 2:
                    System.out.print("Enter customer name: ");
                    String bankCustomer = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double bankAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter net banking username: ");
                    String username = sc.nextLine();

                    System.out.print("Enter net banking password: ");
                    String password = sc.nextLine();

                    payment = new NetBankingPayment(
                            bankCustomer,
                            bankAmount,
                            username,
                            password
                    );
                    break;

                case 3:
                    System.out.print("Enter customer name: ");
                    String upiCustomer = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double upiAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter UPI ID: ");
                    String upiId = sc.nextLine();

                    payment = new UPIPayment(
                            upiCustomer,
                            upiAmount,
                            upiId
                    );
                    break;

                default:
                    System.out.println("Invalid payment choice!");
                    return;
            }

            System.out.println("\n===== PAYMENT DETAILS =====");
            payment.showPaymentDetails();

            System.out.println("\n===== PROCESSING PAYMENT =====");
            payment.makePayment();

        } catch (IllegalArgumentException e) {

            System.out.println("Payment Error: " + e.getMessage());

        } catch (AuthenticationException e) {

            System.out.println("Authentication Error: " + e.getMessage());

        } finally {
            sc.close();
        }
    }
}
