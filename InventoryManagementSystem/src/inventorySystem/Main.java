package inventorySystem;

import java.util.NoSuchElementException;
import java.util.Scanner;

import inventorySystem.enums.Category;
import inventorySystem.model.Product;
import inventorySystem.services.BillingService;
import inventorySystem.services.ProductServices;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ProductServices productServices = new ProductServices();

		BillingService billingService = new BillingService(productServices);

		productServices.defaultInventory();

		while (true) {

			System.out.println("\n----- Welcome to Inventory Management System -----");

			System.out.println("1. Add Product");
			System.out.println("2. Search Product by ID");
			System.out.println("3. Update Product Price");
			System.out.println("4. Add Stock");
			System.out.println("5. Sell Product");
			System.out.println("6. Show All Products");
			System.out.println("7. Display Products With Stock Below 5");
			System.out.println("8. Calculate Bill / Checkout");
			System.out.println("9. Delete Product");
			System.out.println("10. Exit");

			System.out.print("Enter your choice: ");

			String choice = sc.nextLine();

			switch (choice) {

			case "1" -> addProduct(sc, productServices);

			case "2" -> searchProductById(sc, productServices);

			case "3" -> updateProductPrice(sc, productServices);

			case "4" -> addStock(sc, productServices);

			case "5" -> sellProduct(sc, productServices);

			case "6" -> productServices.printProducts();

			case "7" -> productServices.printLowStockProducts();

			case "8" -> createBill(sc, billingService);

			case "9" -> deleteProduct(sc, productServices);

			case "10" -> {
				System.out.println("Thank You!");
				sc.close();
				return;
			}

			default -> System.out.println("Invalid choice!");
			}
		}
	}

	// Read integer safely
	public static int readInt(Scanner sc, String message) {

		while (true) {

			try {
				System.out.print(message);

				return Integer.parseInt(sc.nextLine());

			} catch (NumberFormatException e) {

				System.out.println("Please enter a valid number.");
			}
		}
	}

	// Read double safely
	public static double readDouble(Scanner sc, String message) {

		while (true) {

			try {
				System.out.print(message);

				return Double.parseDouble(sc.nextLine());

			} catch (NumberFormatException e) {

				System.out.println("Please enter a valid price.");
			}
		}
	}

	// Add product
	public static void addProduct(Scanner sc, ProductServices productServices) {

		try {

			System.out.println("\n---- ADD PRODUCT ----");

			System.out.print("Enter product name: ");

			String name = sc.nextLine();

			Category category = null;

			while (category == null) {

				System.out.println("\nSelect Category");

				System.out.println("1. Laptop");
				System.out.println("2. Mobile");
				System.out.println("3. Accessories");
				System.out.println("4. Home Appliances");

				int choice = readInt(sc, "Enter category: ");

				switch (choice) {

				case 1 -> category = Category.LAPTOP;

				case 2 -> category = Category.MOBILE;

				case 3 -> category = Category.ACCESSORY;

				case 4 -> category = Category.HOME_APPLIANCE;

				default -> System.out.println("Invalid category!");
				}
			}

			double price = readDouble(sc, "Enter product price: ");

			int stock = readInt(sc, "Enter available stock: ");

			String id = productServices.addProducts(name, category, price, stock);

			System.out.println("Product added successfully! Product ID: " + id);

		} catch (IllegalArgumentException e) {

			System.out.println("Error: " + e.getMessage());
		}
	}

	// Search product
	public static void searchProductById(Scanner sc, ProductServices productServices) {

		try {

			System.out.println("\n---- SEARCH PRODUCT ----");

			System.out.print("Enter product ID: ");

			String id = sc.nextLine().trim().toUpperCase();

			productServices.printProducts(id);

		} catch (NoSuchElementException e) {

			System.out.println("Error: " + e.getMessage());
		}
	}

	// Update price
	public static void updateProductPrice(Scanner sc, ProductServices productServices) {

		try {

			System.out.println("\n---- UPDATE PRODUCT PRICE ----");

			System.out.print("Enter product ID: ");

			String id = sc.nextLine().trim().toUpperCase();

			productServices.searchById(id);

			double price = readDouble(sc, "Enter updated price: ");

			productServices.updateProductPrice(price, id);

			System.out.println("Price updated successfully!");

			productServices.printProducts(id);

		} catch (IllegalArgumentException | NoSuchElementException e) {

			System.out.println("Error: " + e.getMessage());
		}
	}

	// Add stock
	public static void addStock(Scanner sc, ProductServices productServices) {

		try {

			System.out.println("\n---- ADD STOCK ----");

			System.out.print("Enter product ID: ");

			String id = sc.nextLine().trim().toUpperCase();

			productServices.searchById(id);

			int quantity = readInt(sc, "Enter quantity to add: ");

			productServices.updateProductStock(quantity, id);

			System.out.println("Stock updated successfully!");

			productServices.printProducts(id);

		} catch (IllegalArgumentException | NoSuchElementException e) {

			System.out.println("Error: " + e.getMessage());
		}
	}

	// Sell product individually
	public static void sellProduct(Scanner sc, ProductServices productServices) {

		try {

			System.out.println("\n---- SELL PRODUCT ----");

			System.out.print("Enter product ID: ");

			String id = sc.nextLine().trim().toUpperCase();

			int quantity = readInt(sc, "Enter quantity to sell: ");

			productServices.sellProducts(id, quantity);

			System.out.println("Product sold successfully!");

			productServices.printProducts(id);

		} catch (IllegalArgumentException | NoSuchElementException e) {

			System.out.println("Error: " + e.getMessage());
		}
	}

	// Delete product
	public static void deleteProduct(Scanner sc, ProductServices productServices) {

		try {

			System.out.println("\n---- DELETE PRODUCT ----");

			System.out.print("Enter product ID: ");

			String id = sc.nextLine().trim().toUpperCase();

			Product product = productServices.searchById(id);

			System.out.println("Product Name: " + product.getProductName());

			System.out.print("Are you sure you want to delete? (Y/N): ");

			String confirm = sc.nextLine();

			if (confirm.equalsIgnoreCase("Y")) {

				productServices.deleteProduct(id);

				System.out.println("Product deleted successfully!");

			} else {

				System.out.println("Deletion cancelled.");
			}

		} catch (NoSuchElementException e) {

			System.out.println("Error: " + e.getMessage());
		}
	}

	
	public static void createBill(Scanner sc, BillingService billingService) {

		System.out.println("\n========== CUSTOMER BILLING ==========");

		System.out.println("Enter product ID to add products to cart.");

		System.out.println("Enter DONE when you have finished adding products.");

		while (true) {

			System.out.print("\nEnter Product ID (or DONE): ");

			String id = sc.nextLine().trim().toUpperCase();

			if (id.equals("DONE")) {
				break;
			}

			try {

				int quantity = readInt(sc, "Enter quantity: ");

				billingService.addToCart(id, quantity);

			} catch (IllegalArgumentException | NoSuchElementException e) {

				System.out.println("Error: " + e.getMessage());
			}
		}

		if (billingService.isCartEmpty()) {

			System.out.println("No products added to cart.");

			return;
		}

		billingService.printBill();

		System.out.print("\nConfirm purchase? (Y/N): ");

		String confirm = sc.nextLine();

		if (confirm.equalsIgnoreCase("Y")) {

			try {

				double total = billingService.checkout();

				System.out.println("\nPayment successful!");

				System.out.printf("Total amount paid: Rs. %.2f%n", total);

				System.out.println("Thank you for shopping with us!");

			} catch (IllegalArgumentException e) {

				System.out.println("Checkout failed: " + e.getMessage());

			}

		} else {

			billingService.clearCart();

			System.out.println("Purchase cancelled. Cart cleared.");
		}
	}
}