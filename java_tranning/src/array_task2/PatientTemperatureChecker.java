package array_task2;
import java.util.Scanner;

public class PatientTemperatureChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int patients;

        
        while (true) {
            System.out.print("Enter number of patients: ");

            if (sc.hasNextInt()) {
                patients = sc.nextInt();

                if (patients > 0) {
                    break;
                }
            } else {
                sc.next();
            }

            System.out.println("Invalid input! Enter a positive integer.");
        }

        
        char unit;

        while (true) {
            System.out.print("Enter temperature unit (C/F): ");
            String input = sc.next().toUpperCase();

            if (input.length() == 1 &&
                    (input.charAt(0) == 'C' || input.charAt(0) == 'F')) {
                unit = input.charAt(0);
                break;
            }

            System.out.println("Invalid unit! Enter C or F.");
        }

        String[] names = new String[patients];
        double[] temperaturesC = new double[patients];
        double[] temperaturesF = new double[patients];
        String[] status = new String[patients];

        
        for (int i = 0; i < patients; i++) {

            System.out.print("Enter name of patient " + (i + 1) + ": ");
            names[i] = sc.next();

            while (true) {
                System.out.print("Enter temperature for "
                        + names[i] + " (" + unit + "): ");

                if (!sc.hasNextDouble()) {
                    System.out.println("Invalid input! Enter a number.");
                    sc.next();
                    continue;
                }

                double temperature = sc.nextDouble();

               
                if (unit == 'C') {
                    temperaturesC[i] = temperature;
                    temperaturesF[i] = (temperature * 9 / 5) + 32;
                } else {
                    temperaturesF[i] = temperature;
                    temperaturesC[i] = (temperature - 32) * 5 / 9;
                }

                
                if (temperaturesC[i] >= 38.0) {
                    status[i] = "Fever - Medical assessment may be needed";
                } else {
                    status[i] = "Below fever threshold";
                }

                break;
            }
        }

       
        System.out.println("\n========== PATIENT TEMPERATURE REPORT ==========");

        System.out.printf("%-15s %-18s %-18s %s%n",
                "Patient", "Celsius", "Fahrenheit", "Status");

        System.out.println(
                "--------------------------------------------------------------------------"
        );

        for (int i = 0; i < patients; i++) {

            System.out.printf("%-15s %-18.1f %-18.1f %s%n",
                    names[i],
                    temperaturesC[i],
                    temperaturesF[i],
                    status[i]);
        }

        sc.close();
    }
}
