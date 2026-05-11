package testersquad;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.Map;

public class TestShoppingCart {

    private Product createKeyboard() {
        return new Product(1, "Keyboard", 500.0, 10, "Electronics", LocalDate.of(2026, 12, 31));
    }

    @Test
    public void testNewCartIsEmpty() {
        ShoppingCart cart = new ShoppingCart();
        assertTrue(cart.isEmpty());
        assertEquals(0, cart.getTotalQuantity());
    }

    @Test
    public void testAddItem() {
        ShoppingCart cart = new ShoppingCart();
        Product product = createKeyboard();

        cart.addItem(product, 2);

        assertTrue(cart.containsProduct(product));
        assertEquals(2, (int) cart.getItems().get(product));
    }

    @Test
    public void testAddSameItemUpdatesQuantity() {
        ShoppingCart cart = new ShoppingCart();
        Product product = createKeyboard();

        cart.addItem(product, 2);
        cart.addItem(product, 3);

        assertEquals(5, (int) cart.getItems().get(product));
    }

    @Test
    public void testRemoveItemPartially() {
        ShoppingCart cart = new ShoppingCart();
        Product product = createKeyboard();

        cart.addItem(product, 5);
        cart.removeItem(product, 2);

        assertEquals(3, (int) cart.getItems().get(product));
    }

    @Test
    public void testRemoveItemCompletely() {
        ShoppingCart cart = new ShoppingCart();
        Product product = createKeyboard();

        cart.addItem(product, 2);
        cart.removeItem(product, 2);

        assertFalse(cart.containsProduct(product));
        assertTrue(cart.isEmpty());
    }

    @Test
    public void testCalculateTotalPrice() {
        ShoppingCart cart = new ShoppingCart();
        Product product = createKeyboard();

        cart.addItem(product, 2);

        assertEquals(1000.0, cart.calculateTotalPrice(), 0.001);
    }

    @Test
    public void testClearCart() {
        ShoppingCart cart = new ShoppingCart();
        Product product = createKeyboard();

        cart.addItem(product, 2);
        cart.clear();

        assertTrue(cart.isEmpty());
        assertEquals(0, cart.getTotalQuantity());
    }

    @Test
    public void testGetItemsAboveThreshold() {
        ShoppingCart cart = new ShoppingCart();
        Product keyboard = createKeyboard();
        Product mouse = new Product(2, "Mouse", 300.0, 3, "Electronics", LocalDate.of(2026, 12, 31));

        cart.addItem(keyboard, 5);
        cart.addItem(mouse, 2);

        Map<Product, Integer> result = cart.getItemsAboveThreshold(3);

        assertTrue(result.containsKey(keyboard));
        assertFalse(result.containsKey(mouse));
    }

    @Test
    public void testUpdateQuantity() {
        ShoppingCart cart = new ShoppingCart();
        Product product = createKeyboard();

        cart.addItem(product, 2);
        cart.updateQuantity(product, 7);

        assertEquals(7, (int) cart.getItems().get(product));
    }
}
