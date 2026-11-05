package stream;

import java.util.*;
import java.util.stream.*;

public class StreamOperations {

	public static void main(String[] args) {

		// Calling all Stream methods

		filterEvenAndOdd();
		squareNumbers();
		sortList();
		collectList();
		countList();
		limitList();
		distinctList();
		findFirstElement();
		reduceSum();
	}

	// 1. FILTER - Print Even and Odd Numbers
	public static void filterEvenAndOdd() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println("\n--- Even Numbers ---");
		numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

		System.out.println("--- Odd Numbers ---");
		numbers.stream().filter(n -> n % 2 != 0).forEach(System.out::println);
	}

	// 2. MAP - Square Each Number
	public static void squareNumbers() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		System.out.println("\n--- Square Numbers ---");
		numbers.stream().map(n -> n * n).forEach(System.out::println);
	}

	// 3. SORTED - Sort Numbers in Ascending Order
	public static void sortList() {

		List<Integer> numbers = Arrays.asList(40, 10, 30, 20);

		System.out.println("\n--- Sorted Numbers ---");
		numbers.stream().sorted().forEach(System.out::println);
	}

	// 4. COLLECT - Collect Filtered Names into a List
	public static void collectList() {

		List<String> names = Arrays.asList("Sai saran", "Gowtham", "Siva Charan");

		List<String> collectedNames = names.stream().filter(name -> name.startsWith("S")).collect(Collectors.toList());

		System.out.println("\n--- Collected Names ---");
		System.out.println(collectedNames);
	}

	// 5. COUNT - Count Total Elements
	public static void countList() {

		List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

		long count = numbers.stream().count();

		System.out.println("\n--- Total Count ---");
		System.out.println(count);
	}

	// 6. LIMIT - Print Only First 3 Elements
	public static void limitList() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		System.out.println("\n--- Limit (First 3 Elements) ---");
		numbers.stream().limit(3).forEach(System.out::println);
	}

	// 7. DISTINCT - Remove Duplicate Elements
	public static void distinctList() {

		List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 4);

		System.out.println("\n--- Distinct Numbers ---");
		numbers.stream().distinct().forEach(System.out::println);
	}

	// 8. FIND FIRST - Get First Element
	public static void findFirstElement() {

		List<String> names = Arrays.asList("Ram", "John", "Arun");

		String first = names.stream().findFirst().get();

		System.out.println("\n--- First Element ---");
		System.out.println(first);
	}

	// 9. REDUCE - Calculate Sum of All Numbers
	public static void reduceSum() {

		List<Integer> numbers = Arrays.asList(10, 20, 30);

		int sum = numbers.stream().reduce(0, (a, b) -> a + b);

		System.out.println("\n--- Sum Using Reduce ---");
		System.out.println(sum);
	}
}
