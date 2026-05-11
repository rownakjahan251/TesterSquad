package testersquad;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TestOrderManager {

    @Test
    public void testAddOrderAndGetTotalOrders() {
        OrderManager manager = new OrderManager();
        Order order = new Order(1, 101, "2026-04-30", "Cash");

        manager.addOrder(order);

        assertEquals(1, manager.getTotalOrders());
        assertTrue(manager.getOrders().contains(order));
    }

    @Test
    public void testFindOrderById() {
        OrderManager manager = new OrderManager();
        Order order = new Order(2, 102, "2026-04-30", "Card");
        manager.addOrder(order);

        assertEquals(order, manager.findOrderById(2));
    }

    @Test
    public void testRemoveOrderExisting() {
        OrderManager manager = new OrderManager();
        Order order = new Order(3, 103, "2026-04-30", "Cash");
        manager.addOrder(order);

        assertTrue(manager.removeOrder(3));
        assertEquals(0, manager.getTotalOrders());
    }

    @Test
    public void testRemoveOrderNonExisting() {
        OrderManager manager = new OrderManager();
        assertFalse(manager.removeOrder(999));
    }

    @Test
    public void testUpdateOrderStatus() {
        OrderManager manager = new OrderManager();
        Order order = new Order(4, 104, "2026-04-30", "Cash");
        manager.addOrder(order);

        boolean updated = manager.updateOrderStatus(4, OrderStatus.DELIVERED);

        assertTrue(updated);
        assertEquals(OrderStatus.DELIVERED, manager.findOrderById(4).getStatus());
    }

    @Test
    public void testGetOrdersByCustomerId() {
        OrderManager manager = new OrderManager();
        Order order1 = new Order(5, 200, "2026-04-30", "Cash");
        Order order2 = new Order(6, 201, "2026-04-30", "Card");
        manager.addOrder(order1);
        manager.addOrder(order2);

        List<Order> result = manager.getOrdersByCustomerId(200);

        assertEquals(1, result.size());
        assertEquals(order1, result.get(0));
    }

    @Test
    public void testGetOrdersWithStatus() {
        OrderManager manager = new OrderManager();
        Order order1 = new Order(7, 301, "2026-04-30", "Cash");
        Order order2 = new Order(8, 302, "2026-04-30", "Card");
        order2.setStatus(OrderStatus.SHIPPED);
        manager.addOrder(order1);
        manager.addOrder(order2);

        List<Order> shippedOrders = manager.getOrdersWithStatus(OrderStatus.SHIPPED);

        assertEquals(1, shippedOrders.size());
        assertEquals(order2, shippedOrders.get(0));
    }

    @Test
    public void testGetOrdersByPaymentMethod() {
        OrderManager manager = new OrderManager();
        Order order1 = new Order(9, 401, "2026-04-30", "Cash");
        Order order2 = new Order(10, 402, "2026-04-30", "Card");
        manager.addOrder(order1);
        manager.addOrder(order2);

        List<Order> cashOrders = manager.getOrdersByPaymentMethod("cash");

        assertEquals(1, cashOrders.size());
        assertEquals(order1, cashOrders.get(0));
    }

    @Test
    public void testGetOrdersByDateRange() {
        OrderManager manager = new OrderManager();
        Order order1 = new Order(11, 501, "2026-04-29", "Cash");
        Order order2 = new Order(12, 502, "2026-05-05", "Card");
        manager.addOrder(order1);
        manager.addOrder(order2);

        List<Order> result = manager.getOrdersByDateRange("2026-04-28", "2026-04-30");

        assertEquals(1, result.size());
        assertEquals(order1, result.get(0));
    }

    @Test
    public void testClearAllOrders() {
        OrderManager manager = new OrderManager();
        manager.addOrder(new Order(13, 601, "2026-04-30", "Cash"));
        manager.clearAllOrders();
        assertEquals(0, manager.getTotalOrders());
    }
}
