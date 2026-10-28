package exception_handiling;

public class Try_Catch {

    
    static void divide(int a, int b) throws ArithmeticException {

        if (b == 0) {
            
            throw new ArithmeticException("Cannot divide by zero!");
        }

        System.out.println("Result: " + (a / b));
    }
    
    

    public static void main(String[] args) {

        try {
           
            divide(100,0 );
        }
        catch (ArithmeticException e) {
          
            System.out.println("Error: " + e.getMessage());
        }
        finally {
           
            System.out.println("Finally block executed.");
        }

        System.out.println("Program continues...");
        
        
        
        try {
            int[] numbers = {10, 20, 30};

            System.out.println(numbers[5]);

            int result = 10 / 0;
            System.out.println(result);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is invalid!");
        }
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
        finally {
            System.out.println("Finished!");
        }
    }
}
