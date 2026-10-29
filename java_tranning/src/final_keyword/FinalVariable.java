package final_keyword;

//The final keyword in Java restricts reassignment of variables, overriding of methods, and inheritance of classes.

//A final variable is a variable whose value can be assigned only once. After it has been initialized,
//you cannot assign it a new value.

//final double PI = 3.14159;

public class FinalVariable {

    public static void main(String[] args) {

        // WITHOUT final
        // We can change the value of a variable.

        int num = 10;
        num = 20;

        System.out.println("Without final: " + num);
        // Output: 20


        // WITH final
        // We cannot reassign a final variable.

        final int n = 100;

        System.out.println("With final: " + n);
        // Output: 100

        // n = 200; // Compilation error!
        // Because n is declared as final.
    }
}

