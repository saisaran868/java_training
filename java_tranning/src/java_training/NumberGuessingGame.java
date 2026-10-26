package java_tranning;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int attempts = 0;
		int randomNumber;
		int guessedNumber = 0;

		int min = 1;
		int max = 10;

		Random random = new Random();
		randomNumber = random.nextInt(min, max + 1);

		boolean won = false;

		while (attempts < 3) {

			System.out.printf("Enter a number between %d and %d: ", min, max);

			guessedNumber = sc.nextInt();
			attempts++;

			if (randomNumber == guessedNumber) {
				System.out.println("Congratulations! You guessed correctly!");
				won = true;
				break;
			} else {
				System.out.println("Wrong guess! Try again.");
				
				if (attempts < 3) {
					if (guessedNumber > randomNumber) {
						System.out.println("^^ Too High ^^");
					} else if (guessedNumber < randomNumber) {
						System.out.println("!! Too Low !!");
					}
					System.out.printf("Attempts remaining: %d%n", 3 - attempts);
				}
			}
		}

		if (!won) {
			System.out.println("Game over! You've used all 3 attempts.");
			System.out.println("The correct number was: " + randomNumber);
		}

		sc.close();
	}
}
