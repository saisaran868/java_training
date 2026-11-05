package stream;


import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
import java.util.stream.Stream;

public class ListStream {
	public static void main(String[]args) {
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Sai");
		names.add("Sai Gowtham");
		names.add("Sai Saran");
		
		
//		List<String> names = Arrays.asList("Ram","Sai","Gowtham","Siva","Charan");
		
		Stream<String > stream = names.stream();
		
		stream.forEach(System.out::println);
		
	}

}
