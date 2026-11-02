package file_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchWord {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the word to search: ");

		String searchWord = sc.nextLine();
		sc.close();

		int lineNumber = 0;
		int count = 0;

		try {

			BufferedReader read = new BufferedReader(new FileReader("newFile.txt"));

			String line;

			while ((line = read.readLine()) != null) {

				lineNumber++;

				String[] words = line.split("\\s+");

				for (String word : words) {

					if (word.equalsIgnoreCase(searchWord)) {

						count++;

						System.out.println(

								searchWord + " found in line " + lineNumber

						);

					}
				}
			}
			read.close();

			System.out.println("Total occurrences: " + count);
		} catch (IOException e) {

		}

	}

}
