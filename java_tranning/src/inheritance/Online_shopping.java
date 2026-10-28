package inheritance;

class Product {

	String productId;
	String ProductName;
	String ProductPrice;

	Product(String productId, String ProductName, String ProductPrice) {
		this.productId = productId;
		this.ProductName = ProductName;
		this.ProductPrice = ProductPrice;

	}

	void displayProduct() {
		System.out.println("Product ID: " + productId);
		System.out.println("Product Name: " + ProductName);
		System.out.println("Product Price: " + ProductPrice);
	}
}

class Electronics extends Product {
	String warranty;

	Electronics(String productId, String ProductName, String ProductPrice, String warranty) {
		super(productId, ProductName, ProductPrice);
		this.warranty = warranty;

	}

	void displayProduct() {
		super.displayProduct();
		System.out.println("Warranty: " + warranty);
		System.out.println("----------------------");
	}

}

class Clothing extends Product {
	String size;

	Clothing(String productId, String ProductName, String ProductPrice, String size) {
		super(productId, ProductName, ProductPrice);
		this.size = size;

	}

	void displayProduct() {
		super.displayProduct();
		System.out.println("Size: " + size);
		System.out.println("----------------------");
	}

}

class Food extends Product {
	String expireDate;

	Food(String productId, String ProductName, String ProductPrice, String expireDate) {
		super(productId, ProductName, ProductPrice);
		this.expireDate = expireDate;
	}

	void displayProduct() {
		super.displayProduct();
		System.out.println("Expiry Date: " + expireDate);
		System.out.println("----------------------");
	}

}

public class Online_shopping {
	public static void main(String[] args) {

		Electronics e = new Electronics("E101", "Laptop", "50000", "2 Years");

		Clothing c = new Clothing("C101", "T-Shirt", "800", "L");

		Food f = new Food("F101", "Biscuits", "50", "30-12-2026");

		System.out.println("=== Electronics ===");
		e.displayProduct();

		System.out.println("=== Clothing ===");
		c.displayProduct();

		System.out.println("=== Food ===");
		f.displayProduct();

	}

}
