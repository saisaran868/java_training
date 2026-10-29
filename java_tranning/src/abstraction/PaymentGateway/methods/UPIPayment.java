package abstraction.PaymentGateway.methods;

import abstraction.PaymentGateway.payment.Payment;

public class UPIPayment extends Payment {

    private final String upiId;

    public UPIPayment(String customerName, double amount, String upiId) {

        super(customerName, amount);

        if (upiId == null || upiId.isBlank()) {
            throw new IllegalArgumentException("UPI ID cannot be empty");
        }

        if (!upiId.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Invalid UPI ID format");
        }

        this.upiId = upiId;
    }

    public String getUpiId() {
        return upiId;
    }

    @Override
    public void makePayment() {

        System.out.println("Processing UPI payment...");

        System.out.println("UPI ID: " + upiId);

        System.out.println(
                "Payment successful for amount: ₹" + getAmount());
    }

    @Override
    public void showPaymentDetails() {

        System.out.println("\n----- UPI Payment Details -----");

        System.out.println("Customer Name: " + getCustomerName());

        System.out.println("UPI ID: " + upiId);

        System.out.println("Amount: ₹" + getAmount());

        System.out.println("--------------------------------");
    }
}