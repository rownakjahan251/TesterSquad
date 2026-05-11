package testersquad;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class TestProduct {

    @Test
    public void testProductConstructorAndGetters() {
        LocalDate expiry = LocalDate.of(2026, 12, 31);
        Product product = new Product(1, "Keyboard", 500.0, 10, "Electronics", expiry);

        assertEquals(1, product.getId());
        assertEquals("Keyboard", product.getName());
        assertEquals(500.0, product.getPrice(), 0.001);
        assertEquals(10, product.getQuantity());
        assertEquals("Electronics", product.getType());
        assertEquals(expiry, product.getExpiryDate());
    }

    @Test
    public void testSetPrice() {
        Product product = new Product(2, "Mouse", 300.0, 5, "Electronics", LocalDate.of(2026, 1, 1));
        product.setPrice(350.0);
        assertEquals(350.0, product.getPrice(), 0.001);
    }

    @Test
    public void testSetQuantity() {
        Product product = new Product(3, "Monitor", 8000.0, 4, "Electronics", LocalDate.of(2026, 1, 1));
        product.setQuantity(8);
        assertEquals(8, product.getQuantity());
    }

    @Test
    public void testIsExpiredTrue() {
        Product product = new Product(4, "Old Item", 100.0, 2, "General", LocalDate.of(2020, 1, 1));
        assertTrue(product.isExpired());
    }

    @Test
    public void testIsExpiredFalse() {
        Product product = new Product(5, "New Item", 100.0, 2, "General", LocalDate.of(2028, 1, 1));
        assertFalse(product.isExpired());
    }

    @Test
    public void testCalculateTotalValue() {
        Product product = new Product(6, "Laptop", 50000.0, 2, "Electronics", LocalDate.of(2028, 1, 1));
        assertEquals(100000.0, product.calculateTotalValue(), 0.001);
    }
}
