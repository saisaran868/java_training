package polymorphism;

class LoginProgram {

    
    String login(String userName, String password) {

        if (userName.equals("sai8680") && password.equals("Ksai123")) {
            return "Login successful using username and password";
        } else {
            return "Invalid username or password";
        }
    }

    
    String login(int id, String password) {

        if (id == 86812433 && password.equals("super12343")) {
            return "Login successful using ID and password";
        } else {
            return "Invalid ID or password";
        }
    }

    
    String login(String password, long mobileNumber) {

        if (password.equals("Password123") && mobileNumber == 8008000737L) {
            return "Login successful using mobile number and password";
        } else {
            return "Invalid mobile number or password";
        }
    }
}

public class Login {

    public static void main(String[] args) {

        LoginProgram loginProgram = new LoginProgram();

        String message1 = loginProgram.login("sai8680", "Ksai123");

        String message2 = loginProgram.login(86812433, "super12343");

        String message3 = loginProgram.login("Password123", 8008000737L);

        System.out.println(message1);
        System.out.println(message2);
        System.out.println(message3);
    }
}
