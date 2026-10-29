package abstraction.PaymentGateway.payment;

import abstraction.PaymentGateway.gateway.PaymentGateway;

public abstract class Payment implements PaymentGateway {

    private final String customerName;
    private final double amount;

    public Payment(String customerName, double amount) {

        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }

        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        this.customerName = customerName;
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }
}