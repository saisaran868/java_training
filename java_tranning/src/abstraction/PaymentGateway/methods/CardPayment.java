package abstraction.PaymentGateway.methods;

import abstraction.PaymentGateway.payment.Payment;

public class CardPayment extends Payment {

    private final String nameAsPerCard;
    private final String cardNumber;
    private final String expiryDate;

    public CardPayment(
            String customerName,
            double amount,
            String nameAsPerCard,
            String cardNumber,
            String expiryDate) {

        super(customerName, amount);

        if (nameAsPerCard == null || nameAsPerCard.isBlank()) {
            throw new IllegalArgumentException(
                    "Cardholder name cannot be empty");
        }

        if (cardNumber == null || !cardNumber.matches("\\d{16}")) {
            throw new IllegalArgumentException(
                    "Card number must contain exactly 16 digits");
        }

        if (expiryDate == null ||
                !expiryDate.matches("(0[1-9]|1[0-2])/\\d{2}")) {
            throw new IllegalArgumentException(
                    "Expiry date must be in MM/YY format");
        }

        this.nameAsPerCard = nameAsPerCard;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public void makePayment() {

        System.out.println("Processing card payment...");

        System.out.println(
                "Payment successful for amount: ₹" + getAmount());
    }

    @Override
    public void showPaymentDetails() {

        System.out.println("\n----- Card Payment Details -----");

        System.out.println("Customer Name: " + getCustomerName());

        System.out.println("Cardholder Name: " + nameAsPerCard);

        System.out.println("Card Number: **** **** **** "
                + cardNumber.substring(12));

        System.out.println("Expiry Date: " + expiryDate);

        System.out.println("Amount: ₹" + getAmount());

        System.out.println("--------------------------------");
    }
}