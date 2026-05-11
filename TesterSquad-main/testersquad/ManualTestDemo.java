package testersquad;

import java.time.LocalDate;

public class ManualTestDemo {
    public static void main(String[] args) {

        System.out.println("MANUAL TESTING: INVENTORY MANAGEMENT SYSTEM");
        System.out.println("===========================================");

        Inventory inventory = new Inventory();
        Product keyboard = new Product(1, "Keyboard", 500.0, 10, "Electronics",
                LocalDate.of(2026, 12, 31));

        // TC-01 Product Creation
        System.out.println("\nTC-01: Product Creation");
        System.out.println("Expected: Product name = Keyboard");
        System.out.println("Actual: " + keyboard.getName());
        System.out.println("Status: " + (keyboard.getName().equals("Keyboard") ? "PASS" : "FAIL"));

        // TC-02 Add Product
        inventory.addProduct(keyboard);
        System.out.println("\nTC-02: Add Product to Inventory");
        System.out.println("Expected: Inventory size = 1");
        System.out.println("Actual: " + inventory.getProducts().size());
        System.out.println("Status: " + (inventory.getProducts().size() == 1 ? "PASS" : "FAIL"));

        // TC-03 Search Product
        Product found = inventory.findProductById(1);
        System.out.println("\nTC-03: Search Product by ID");
        System.out.println("Expected: Product found");
        System.out.println("Actual: " + (found != null ? found.getName() : "Not found"));
        System.out.println("Status: " + (found != null ? "PASS" : "FAIL"));

        // TC-04 Check Availability
        boolean available = inventory.checkProductAvailability(1, 5);
        System.out.println("\nTC-04: Check Product Availability");
        System.out.println("Expected: true");
        System.out.println("Actual: " + available);
        System.out.println("Status: " + (available ? "PASS" : "FAIL"));

        // TC-05 Remove Product
        inventory.removeProduct(1);
        System.out.println("\nTC-05: Remove Product");
        System.out.println("Expected: Inventory size = 0");
        System.out.println("Actual: " + inventory.getProducts().size());
        System.out.println("Status: " + (inventory.getProducts().size() == 0 ? "PASS" : "FAIL"));

        // TC-06 Invalid Quantity
        Product invalidQty = new Product(2, "Mouse", 300.0, -5, "Electronics",
                LocalDate.of(2026, 12, 31));
        System.out.println("\nTC-06: Invalid Quantity");
        System.out.println("Expected: System should reject negative quantity");
        System.out.println("Actual: Quantity accepted = " + invalidQty.getQuantity());
        System.out.println("Status: FAIL / Validation Missing");

        // TC-07 Invalid Price
        Product invalidPrice = new Product(3, "Monitor", -1000.0, 5, "Electronics",
                LocalDate.of(2026, 12, 31));
        System.out.println("\nTC-07: Invalid Price");
        System.out.println("Expected: System should reject negative price");
        System.out.println("Actual: Price accepted = " + invalidPrice.getPrice());
        System.out.println("Status: FAIL / Validation Missing");

        // TC-08 Empty Inventory
        Inventory emptyInventory = new Inventory();
        System.out.println("\nTC-08: Empty Inventory");
        System.out.println("Expected: Inventory size = 0");
        System.out.println("Actual: " + emptyInventory.getProducts().size());
        System.out.println("Status: " + (emptyInventory.getProducts().size() == 0 ? "PASS" : "FAIL"));

        // TC-09 Shopping Cart Add
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(keyboard, 2);
        System.out.println("\nTC-09: Add Product to Shopping Cart");
        System.out.println("Expected: Cart contains Keyboard");
        System.out.println("Actual: " + cart.containsProduct(keyboard));
        System.out.println("Status: " + (cart.containsProduct(keyboard) ? "PASS" : "FAIL"));

        // TC-10 Calculate Cart Total
        double total = cart.calculateTotalPrice();
        System.out.println("\nTC-10: Calculate Cart Total");
        System.out.println("Expected: 1000.0");
        System.out.println("Actual: " + total);
        System.out.println("Status: " + (total == 1000.0 ? "PASS" : "FAIL"));

        // TC-11 Customer Purchase
        Customer customer = new Customer(101, "Rahim", "rahim@gmail.com", "Dhaka");
        customer.purchaseItem(keyboard, 2);
        System.out.println("\nTC-11: Customer Purchase");
        System.out.println("Expected: Total purchased items = 2");
        System.out.println("Actual: " + customer.getTotalItemsPurchased());
        System.out.println("Status: " + (customer.getTotalItemsPurchased() == 2 ? "PASS" : "FAIL"));

        // TC-12 Order Status
        Order order = new Order(501, 101, "2026-04-30", "Cash");
        order.setStatus(OrderStatus.SHIPPED);
        System.out.println("\nTC-12: Order Status Update");
        System.out.println("Expected: SHIPPED");
        System.out.println("Actual: " + order.getStatus());
        System.out.println("Status: " + (order.getStatus() == OrderStatus.SHIPPED ? "PASS" : "FAIL"));
    }
}