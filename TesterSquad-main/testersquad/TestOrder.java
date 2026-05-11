package testersquad;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestOrder {

    @Test
    public void testOrderConstructorAndGetters() {
        Order order = new Order(501, 101, "2026-04-30", "Cash");

        assertEquals(501, order.getOrderId());
        assertEquals(101, order.getCustomerId());
        assertEquals("2026-04-30", order.getOrderDate());
        assertEquals("Cash", order.getPaymentMethod());
        assertEquals(OrderStatus.PENDING, order.getStatus());
        assertEquals(0.0, order.getTotalPrice(), 0.001);
    }

    @Test
    public void testSetOrderId() {
        Order order = new Order(501, 101, "2026-04-30", "Cash");
        order.setOrderId(999);
        assertEquals(999, order.getOrderId());
    }

    @Test
    public void testSetCustomerId() {
        Order order = new Order(501, 101, "2026-04-30", "Cash");
        order.setCustomerId(202);
        assertEquals(202, order.getCustomerId());
    }

    @Test
    public void testSetOrderDate() {
        Order order = new Order(501, 101, "2026-04-30", "Cash");
        order.setOrderDate("2026-05-01");
        assertEquals("2026-05-01", order.getOrderDate());
    }

    @Test
    public void testSetPaymentMethod() {
        Order order = new Order(501, 101, "2026-04-30", "Cash");
        order.setPaymentMethod("Card");
        assertEquals("Card", order.getPaymentMethod());
    }

    @Test
    public void testSetStatus() {
        Order order = new Order(501, 101, "2026-04-30", "Cash");
        order.setStatus(OrderStatus.SHIPPED);
        assertEquals(OrderStatus.SHIPPED, order.getStatus());
    }
}
