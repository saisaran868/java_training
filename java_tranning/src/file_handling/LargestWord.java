package file_handling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LargestWord {
	public static void main (String[]args) {
		
		String largestWord ="";
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("newFile.txt"));
			
			String line;
			while((line = br.readLine())!=null) {
				String words[] = line.split("\\s+");
				
				for(String word:words) {
					if(word.length() > largestWord.length()) {
						largestWord = word;
					}
				}
			}
			
			br.close();
			System.out.println("Largest word is: "+ largestWord);
			System.out.println("Largest word length is: " + largestWord.length());
			
		
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
