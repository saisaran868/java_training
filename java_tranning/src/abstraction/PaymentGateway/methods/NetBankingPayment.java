package abstraction.PaymentGateway.methods;

import javax.security.sasl.AuthenticationException;

import abstraction.PaymentGateway.payment.Payment;

public class NetBankingPayment extends Payment {
	
	private String netBankingUsername;
	public String getNetBankingUsername() {
		return netBankingUsername;
	}

	public String getNetBankingPassword() {
		return netBankingPassword;
	}

	private String netBankingPassword;
	

	public NetBankingPayment(
			String customerName,
			double amount ,
			String netBankingUsername,
			String netBankingPassword
			) throws AuthenticationException {
		super(customerName, amount);
		if(netBankingUsername != "Sai868") {
			throw new AuthenticationException("Invalid Username");
		}
		if(netBankingPassword != "Password@123") {
			throw new AuthenticationException("Invalid Password");
		}
		
		this.netBankingUsername = netBankingUsername;
		this.netBankingPassword = netBankingPassword;
	}

	@Override
	public void makePayment() {

        System.out.println("Processing Netbanking payment...");

        System.out.println(
                "Payment successful for amount: ₹" + getAmount());
    }

	@Override
	public void showPaymentDetails() {
		System.out.println("\n----- Card Payment Details -----");

        System.out.println("Customer Name: " + getCustomerName());

        System.out.println("Netbanking Username: *****" + getNetBankingUsername().substring(4));

        System.out.println("Netbanking Password: *****" + getNetBankingPassword().substring(4));

        System.out.println("Amount: ₹" + getAmount());

        System.out.println("--------------------------------");
		
	}

}