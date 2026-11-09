package inventorySystem.model;

import inventorySystem.enums.Category;

public class Product {

    private String productName;
    private Category category;
    private double price;
    private int stock;

    public Product(String productName, Category category,
                   double price, int stock) {

        setProductName(productName);
        setCategory(category);
        setPrice(price);
        setStock(stock);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {

        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Product Name should not be empty.");
        }

        if (productName.matches(".*[@#$%^&+=!].*")) {
            throw new IllegalArgumentException(
                "Product name should not have special characters.");
        }

        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException(
                "Category cannot be null.");
        }

        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        if (price <= 0) {
            throw new IllegalArgumentException(
                "Price cannot be 0 or less than 0.");
        }

        this.price = price;
    }

    public void updatePrice(double price) {
        setPrice(price);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {

        if (stock < 0) {
            throw new IllegalArgumentException(
                "Stock cannot be less than 0.");
        }

        this.stock = stock;
    }

    public void addStock(int stock) {

        if (stock <= 0) {
            throw new IllegalArgumentException(
                "Stock quantity must be greater than 0.");
        }

        this.stock += stock;
    }


    public void sellProduct(int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                "Selling quantity must be greater than 0.");
        }

        if (quantity > stock) {
            throw new IllegalArgumentException(
                "Insufficient stock available.");
        }

        this.stock -= quantity;
    }
}