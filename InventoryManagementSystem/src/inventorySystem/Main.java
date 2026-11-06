package inventorySystem;

import java.util.NoSuchElementException;
import java.util.Scanner;

import inventorySystem.exception.StockOutOfBoundException;
import inventorySystem.model.Product;
import inventorySystem.services.ProductServices;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ProductServices productServices = new ProductServices();

		productServices.defaultInventory();

		try {
			while (true) {
				System.out.println("\n----- Welcome to Inventory Management System -----");

				System.out.println("1. Add Product");
				System.out.println("2. Search product by ID");
				System.out.println("3. Update product price");
				System.out.println("4. Add Stock");
				System.out.println("5. Sell Products");
				System.out.println("3. Exit");

				System.out.print("Enter your choice: ");

				String choice = sc.nextLine();

				switch (choice) {
				case "1" -> addProduct(sc, productServices);
				case "2" -> searchProductById(sc, productServices);
				case "3" -> updateProdcutPrice(sc, productServices);
				case "4" -> addStock(sc, productServices);
				case "5" -> sellProdcut(sc, productServices);

				default -> System.out.println("Invalid choice!!!!!");
				}
			}

		} finally {
			sc.close();
		}

	}

	public static void addProduct(Scanner sc, ProductServices productServices) {

		while (true) {
			try {
				System.out.println("----ADD PRODUCT----");
				System.out.println();
				System.out.print("Enter product name: ");
				String name = sc.nextLine();
				inventorySystem.enums.Category c;

				while (true) {

					System.out.println("Please select the category");
					System.out.println("1. Laptop");
					System.out.println("2. Mobile");
					System.out.println("3. Accessories");
					System.out.println("4. Home appliances");
					System.out.print("Enter the Category no:");

					int choice = sc.nextInt();

					switch (choice) {
					case 1 -> {
						c = inventorySystem.enums.Category.LAPTOP;
						break;
					}
					case 2 -> {
						c = inventorySystem.enums.Category.MOBILE;
						break;
					}
					case 3 -> {
						c = inventorySystem.enums.Category.ACCESSORY;
						break;
					}
					case 4 -> {
						c = inventorySystem.enums.Category.HOME_APPLIANCE;
						break;
					}
					default -> {
						System.out.println("Invalid choice, try again");
						continue;
					}
					}

					break;
				}

				System.out.println("Selected category is " + c);
				System.out.println();
				System.out.print("Enter the price of the product: ");
				double price = sc.nextDouble();
				System.out.print("Enter the stock avaliable: ");
				int stock = sc.nextInt();
				sc.nextLine();

				String id = productServices.addProducts(name, c, price, stock);

				System.out.println("Product added sucessfully, ID: " + id);

				return;

			} catch (IllegalArgumentException e) {
				System.out.println("\nError: " + e.getMessage());

				System.out.println("Please enter product details again.");
			}
		}

	}

	public static void searchProductById(Scanner sc, ProductServices productServices) {
		while (true) {

			try {
				System.out.println("----Search Product By ID----");
				System.out.print("Enter the product ID: ");
				String id = sc.nextLine();
				productServices.printProducts(id);
				return;
			} catch (IllegalArgumentException e) {
				System.out.println("\nError: " + e.getMessage());

				System.out.println("Please enter product details again.");

			} catch (NoSuchElementException e) {
				System.out.println("\nError: " + e.getMessage());

				System.out.println("Please enter product details again.");
			}

		}

	}

	public static void updateProdcutPrice(Scanner sc, ProductServices productServices) {
		while (true) {

			try {
				System.out.println("-----Update product price-----");
				System.out.println();
				System.out.print("Enter product id: ");
				String productId = sc.nextLine();
				productServices.searchById(productId);
				System.out.print("Enter updated price: ");
				double price = sc.nextDouble();
				sc.nextLine();
				productServices.updateProductPrice(price, productId);
				System.out.println("Price Updated Sucessfully");
				System.out.println();
				productServices.printProducts(productId);
				return;

			} catch (IllegalArgumentException e) {

				System.out.println("\nError: " + e.getMessage());

				System.out.println("Please enter product details again.");
			} catch (NoSuchElementException e) {
				System.out.println("\nError: " + e.getMessage());

				System.out.println("Please enter product details again.");
			}
		}
	}

	public static void addStock(Scanner sc, ProductServices productServices) {

		while (true) {

			try {
				System.out.println("-----Add Stock-----");
				System.out.println();
				System.out.print("Enter product id: ");
				String productId = sc.nextLine();
				productServices.searchById(productId);
				System.out.print("Enter Quantity: ");
				int quantity = sc.nextInt();
				productServices.updateProductStock(quantity, productId);
				System.out.println("Stock Updated Sucessfully");
				System.out.println();
				productServices.printProducts(productId);
				return;
			} catch (IllegalArgumentException e) {

				System.out.println("\nError: " + e.getMessage());

				System.out.println("Please enter product details again.");
			} catch (NoSuchElementException e) {
				System.out.println("\nError: " + e.getMessage());

				System.out.println("Please enter product details again.");
			}
		}

	}

	public static void sellProdcut(Scanner sc, ProductServices productServices) {

		while (true) {

			try {
				System.out.println("-----Sell Product-----");
				System.out.println();
				System.out.print("Enter product id: ");
				String productId = sc.nextLine();
				productServices.searchById(productId);
				productServices.sellProducts(productId);
				System.out.println("Product sold successfully");
				System.out.println("-----Available Stock-----");
				System.out.println();
				productServices.printProducts(productId);

				return;
			} catch (IllegalArgumentException e) {
				System.out.println("\nError1: " + e.getMessage());

				System.out.println("Please enter product details again.");
			} catch (StockOutOfBoundException e) {
				System.out.println("\nError2: " + e.getMessage());
				return;
			} catch (NoSuchElementException e) {
				System.out.println("\nError3: " + e.getMessage());

				System.out.println("Please enter product details again.");
			}
		}

	}

}