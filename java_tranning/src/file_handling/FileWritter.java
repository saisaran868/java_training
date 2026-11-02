package file_handling;

import java.io.FileWriter;
import java.io.IOException;

public class FileWritter {
	public static void main(String[]args) {
		
		try {
			
			FileWriter  writer = new FileWriter ("newFile.txt");
			
			writer.write("Sai saran:85\n");
			writer.write("Sai saran:85\n");
			writer.write("Sai saran:85\n");
			System.out.println("Data written successfully.");
			writer.close();
		}catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

}
