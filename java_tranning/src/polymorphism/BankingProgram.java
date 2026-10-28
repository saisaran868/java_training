package polymorphism;

class Banking {

    
    String deposit(double amount) {

        if (amount <= 0) {
            return "Invalid deposit amount";
        }

        return "Successfully deposited Rs. " + amount + " using cash";
    }

  
    String deposit(double amount, int checkNo) {

        if (amount <= 0 || checkNo <= 0) {
            return "Invalid amount or cheque number";
        }

        return "Successfully deposited Rs. " + amount
                + " using cheque number " + checkNo;
    }

    
    String deposit(double amount, String upiId, String bankName) {

        if (amount <= 0 || upiId == null || upiId.isBlank()
                || bankName == null || bankName.isBlank()) {
            return "Invalid deposit details";
        }

        return "Successfully deposited Rs. " + amount
                + " using UPI ID " + upiId
                + " through " + bankName;
    }
}

public class BankingProgram {

    public static void main(String[] args) {

        Banking bank = new Banking();

        String message1 = bank.deposit(5000);

        String message2 = bank.deposit(10000, 12345);

        String message3 = bank.deposit(
                2000, "sai@upi", "SBI"
        );

        System.out.println(message1);
        System.out.println(message2);
        System.out.println(message3);
    }
}
