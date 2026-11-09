package inventorySystem.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import inventorySystem.enums.Category;
import inventorySystem.model.Product;

public class ProductServices {

	private Map<String, Product> products = new HashMap<>();

	public String addProducts(String productName, Category category, double price, int stock) {

		String cleanName = productName.replaceAll("\\s+", "");

		if (cleanName.length() < 3) {
			throw new IllegalArgumentException("Product name must contain at least 3 characters.");
		}

		String id = cleanName.substring(0, 3).toUpperCase() + products.size();

		while (products.containsKey(id)) {
			id = cleanName.substring(0, 3).toUpperCase() + (Integer.parseInt(id.substring(3)) + 1);
		}

		products.put(id, new Product(productName, category, price, stock));

		return id;
	}

	public Product searchById(String id) {

		Product product = products.get(id);

		if (product == null) {
			throw new NoSuchElementException("Product with ID " + id + " doesn't exist.");
		}

		return product;
	}

	public void updateProductPrice(double newPrice, String id) {

		Product product = searchById(id);

		product.updatePrice(newPrice);
	}

	public void updateProductStock(int newStock, String id) {

		Product product = searchById(id);

		product.addStock(newStock);
	}

	public void sellProducts(String id, int quantity) {

		Product product = searchById(id);

		product.sellProduct(quantity);
	}

	public void deleteProduct(String id) {

		Product removedProduct = products.remove(id);

		if (removedProduct == null) {
			throw new NoSuchElementException("Product with ID " + id + " doesn't exist.");
		}
	}

	public void printProducts(String id) {

		Product product = searchById(id);

		System.out.println("\n---------------- PRODUCT DETAILS ----------------");

		System.out.printf("%-15s %-25s %-25s %-15s %-15s%n", "Product ID", "Product Name", "Category", "Price (Rs.)",
				"Stock");

		System.out.println("--------------------------------------------------------------------------");

		System.out.printf("%-15s %-25s %-25s %-15.2f %-15d%n", id, product.getProductName(), product.getCategory(),
				product.getPrice(), product.getStock());

		System.out.println("--------------------------------------------------------------------------");
	}

	public void printProducts() {

		System.out.println("\n---------------- INVENTORY DETAILS ----------------");

		for (Category category : Category.values()) {

			System.out.println("\n========== " + category + " ==========");

			System.out.printf("%-15s %-25s %-15s %-15s%n", "Product ID", "Product Name", "Price (Rs.)", "Stock");

			System.out.println("---------------------------------------------------------------------");

			Iterator<Map.Entry<String, Product>> iterator = products.entrySet().iterator();

			boolean found = false;

			while (iterator.hasNext()) {

				Map.Entry<String, Product> entry = iterator.next();

				String id = entry.getKey();
				Product product = entry.getValue();

				if (product.getCategory() == category) {

					found = true;

					System.out.printf("%-15s %-25s %-15.2f %-15d%n", id, product.getProductName(), product.getPrice(),
							product.getStock());
				}
			}

			if (!found) {
				System.out.println("No products available in this category.");
			}

			System.out.println("---------------------------------------------------------------------");
		}
	}

	public void printLowStockProducts() {

		System.out.println("\n---------------- LOW STOCK PRODUCTS ----------------");

		for (Category category : Category.values()) {

			System.out.println("\n========== " + category + " ==========");

			System.out.printf("%-15s %-25s %-15s %-15s%n", "Product ID", "Product Name", "Price (Rs.)", "Stock");

			System.out.println("---------------------------------------------------------------------");

			Iterator<Map.Entry<String, Product>> iterator = products.entrySet().iterator();

			boolean found = false;

			while (iterator.hasNext()) {

				Map.Entry<String, Product> entry = iterator.next();

				String id = entry.getKey();
				Product product = entry.getValue();

				if (product.getCategory() == category && product.getStock() < 5) {

					found = true;

					System.out.printf("%-15s %-25s %-15.2f %-15d%n", id, product.getProductName(), product.getPrice(),
							product.getStock());
				}
			}

			if (!found) {
				System.out.println("No low-stock products in this category.");
			}

			System.out.println("---------------------------------------------------------------------");
		}
	}

	public void defaultInventory() {

		// LAPTOPS
		addProducts("HP Pavilion 15", Category.LAPTOP, 55000, 4);
		addProducts("Lenovo IdeaPad Slim 3", Category.LAPTOP, 48000, 6);
		addProducts("ASUS VivoBook 15", Category.LAPTOP, 45000, 3);

		// MOBILES
		addProducts("Samsung Galaxy S24", Category.MOBILE, 65000, 5);
		addProducts("Apple iPhone 15", Category.MOBILE, 60000, 2);
		addProducts("OnePlus Nord CE 4", Category.MOBILE, 25000, 8);

		// ACCESSORIES
		addProducts("Logitech Wireless Mouse", Category.ACCESSORY, 799, 15);
		addProducts("HP Wired Keyboard", Category.ACCESSORY, 599, 10);
		addProducts("boAt Rockerz Headphones", Category.ACCESSORY, 1499, 7);

		// HOME APPLIANCES
		addProducts("LG Refrigerator", Category.HOME_APPLIANCE, 28000, 3);
		addProducts("Samsung Washing Machine", Category.HOME_APPLIANCE, 22000, 4);
		addProducts("Philips Air Fryer", Category.HOME_APPLIANCE, 8000, 6);
	}
}