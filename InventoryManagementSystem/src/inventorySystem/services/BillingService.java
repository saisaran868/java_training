package inventorySystem.services;

import java.util.LinkedHashMap;
import java.util.Map;

import inventorySystem.model.Product;

public class BillingService {

    private ProductServices productServices;

    private Map<String, Integer> cart = new LinkedHashMap<>();

    public BillingService(ProductServices productServices) {
        this.productServices = productServices;
    }

    // Add product to cart
    public void addToCart(String id, int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                "Quantity must be greater than 0.");
        }

        Product product = productServices.searchById(id);

        int existingQuantity = cart.getOrDefault(id, 0);

        int totalQuantity = existingQuantity + quantity;

        if (totalQuantity > product.getStock()) {
            throw new IllegalArgumentException(
                "Insufficient stock! Available stock: "
                + product.getStock()
                + ", Already in cart: "
                + existingQuantity);
        }

        cart.put(id, totalQuantity);

        System.out.println("Product added to cart successfully!");
    }

    // Calculate total bill
    public double calculateBillTotal() {

        double grandTotal = 0;

        for (Map.Entry<String, Integer> entry : cart.entrySet()) {

            String id = entry.getKey();

            int quantity = entry.getValue();

            Product product = productServices.searchById(id);

            double itemTotal = product.getPrice() * quantity;

            grandTotal += itemTotal;
        }

        return grandTotal;
    }

    // Display bill
    public void printBill() {

        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty!");
        }

        System.out.println(
            "\n========================= CUSTOMER BILL =========================");

        System.out.printf("%-12s %-25s %-12s %-10s %-15s%n",
            "Product ID",
            "Product Name",
            "Price",
            "Quantity",
            "Total");

        System.out.println(
            "--------------------------------------------------------------------------");

        for (Map.Entry<String, Integer> entry : cart.entrySet()) {

            String id = entry.getKey();

            int quantity = entry.getValue();

            Product product = productServices.searchById(id);

            double itemTotal = product.getPrice() * quantity;

            System.out.printf("%-12s %-25s %-12.2f %-10d %-15.2f%n",
                id,
                product.getProductName(),
                product.getPrice(),
                quantity,
                itemTotal);
        }

        System.out.println(
            "--------------------------------------------------------------------------");

        System.out.printf("%-59s %.2f%n",
            "GRAND TOTAL (Rs.):",
            calculateBillTotal());

        System.out.println(
            "=========================================================================");
    }

    // Complete checkout and update inventory
    public double checkout() {

        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty!");
        }

        // First validate all products before deducting any stock
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {

            Product product =
                productServices.searchById(entry.getKey());

            if (entry.getValue() > product.getStock()) {
                throw new IllegalArgumentException(
                    "Insufficient stock for "
                    + product.getProductName());
            }
        }

        // Calculate total before checkout
        double grandTotal = calculateBillTotal();

        // Deduct stock only after all products pass validation
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {

            productServices.sellProducts(
                entry.getKey(),
                entry.getValue());
        }

        // Clear cart after successful checkout
        cart.clear();

        return grandTotal;
    }

    // Clear cart without purchasing
    public void clearCart() {
        cart.clear();
    }

    public boolean isCartEmpty() {
        return cart.isEmpty();
    }
}