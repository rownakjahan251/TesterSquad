package testersquad;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class WarehouseTest {

    private Product createProduct(int id, String name, double price, int quantity) {
        return new Product(id, name, price, quantity, "Electronics", LocalDate.of(2026, 12, 31));
    }

    @Test
    public void testAddProductAndAvailableQuantity() {
        Warehouse warehouse = new Warehouse();
        Product product = createProduct(1, "Keyboard", 500.0, 10);

        warehouse.addProduct(product, 10);

        assertEquals(10, warehouse.getAvailableQuantity(product));
        assertEquals(1, warehouse.getTotalProductCategories());
    }

    @Test
    public void testAddExistingProductIncreasesQuantity() {
        Warehouse warehouse = new Warehouse();
        Product product = createProduct(1, "Keyboard", 500.0, 10);

        warehouse.addProduct(product, 10);
        warehouse.addProduct(product, 5);

        assertEquals(15, warehouse.getAvailableQuantity(product));
    }

    @Test
    public void testRemoveProductPartially() {
        Warehouse warehouse = new Warehouse();
        Product product = createProduct(2, "Mouse", 300.0, 10);

        warehouse.addProduct(product, 10);
        boolean removed = warehouse.removeProduct(product, 4);

        assertTrue(removed);
        assertEquals(6, warehouse.getAvailableQuantity(product));
    }

    @Test
    public void testRemoveProductCompletely() {
        Warehouse warehouse = new Warehouse();
        Product product = createProduct(3, "Monitor", 8000.0, 5);

        warehouse.addProduct(product, 5);
        boolean removed = warehouse.removeProduct(product, 5);

        assertTrue(removed);
        assertEquals(0, warehouse.getAvailableQuantity(product));
        assertEquals(0, warehouse.getTotalProductCategories());
    }

    @Test
    public void testRemoveNonExistingProduct() {
        Warehouse warehouse = new Warehouse();
        Product product = createProduct(4, "Speaker", 1200.0, 3);

        assertFalse(warehouse.removeProduct(product, 1));
    }

    @Test
    public void testCalculateInventoryValue() {
        Warehouse warehouse = new Warehouse();
        Product keyboard = createProduct(5, "Keyboard", 500.0, 10);
        Product mouse = createProduct(6, "Mouse", 300.0, 5);

        warehouse.addProduct(keyboard, 10);
        warehouse.addProduct(mouse, 5);

        assertEquals(6500.0, warehouse.calculateInventoryValue(), 0.001);
    }

    @Test
    public void testContainsExpensiveProductsTrue() {
        Warehouse warehouse = new Warehouse();
        Product monitor = createProduct(7, "Monitor", 8000.0, 2);

        warehouse.addProduct(monitor, 2);

        assertTrue(warehouse.containsExpensiveProducts(5000.0));
    }

    @Test
    public void testContainsExpensiveProductsFalse() {
        Warehouse warehouse = new Warehouse();
        Product mouse = createProduct(8, "Mouse", 300.0, 5);

        warehouse.addProduct(mouse, 5);

        assertFalse(warehouse.containsExpensiveProducts(1000.0));
    }

    @Test
    public void testUpdateProductPrice() {
        Warehouse warehouse = new Warehouse();
        Product product = createProduct(9, "Keyboard", 500.0, 10);

        warehouse.addProduct(product, 10);
        boolean updated = warehouse.updateProductPrice(9, 700.0);

        assertTrue(updated);
        assertEquals(700.0, warehouse.getInventory().get(9).getPrice(), 0.001);
    }

    @Test
    public void testUpdateNonExistingProductPrice() {
        Warehouse warehouse = new Warehouse();
        assertFalse(warehouse.updateProductPrice(999, 700.0));
    }
}
