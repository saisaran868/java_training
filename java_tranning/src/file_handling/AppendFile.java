package file_handling;

import java.io.FileWriter;
import java.io.IOException;

public class AppendFile {
	public static void main(String[]args) {
		
		try {
			FileWriter writer = new FileWriter("newFile.txt",true);
			
			writer.write("Gowtham:69\n");
			writer.write("Siva charan:23\n");
			writer.close();
			
			System.out.println("Data appened suscessfully");
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
