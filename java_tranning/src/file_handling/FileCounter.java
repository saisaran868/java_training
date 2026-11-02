package file_handling;

import java.io.FileReader;
import java.io.IOException;

public class FileCounter {
	public static void main(String[]args) {
		
		try {
			
			int characters =0;
			int space = 0;
			int digits = 0;
			
			FileReader reader = new FileReader("newFile.txt");
			
			int ch;
			while((ch = reader.read())!=-1) {
				
				characters++;
				if(ch ==' ') {
					space++;
				}
				if(Character.isDigit(ch)) {
					digits++;
				}
				
			}
			reader.close();
			System.out.println("Characters: " + characters);

			System.out.println("Spaces: " + space);

			System.out.println("Digits: " + digits);
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
