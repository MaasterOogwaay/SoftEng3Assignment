package ordersPackage;

import customerPackage.Customer;
import exceptionHandlerPackage.ExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderDetailsTest {
    private Order order;
    private Customer customer;

    @BeforeEach
    void setUp() {
        Order.clearAllOrders();
        try {
            customer = new Customer("John Doe", "123 Main St", "1234567890");
        } catch (ExceptionHandler e) {
            e.printStackTrace();
        }
        order = new Order(50.0, "Newspaper", customer);
    }

    @Test
    void testCreateOrder_Success() {
        assertNotNull(order);
        assertEquals(50.0, order.getOrderPrice());
        assertEquals("Newspaper", order.getOrderType());
        assertEquals(customer, order.getCustomerDetails());
        assertEquals(-1, order.getInvoiceId());
    }

    @Test
    void testCreateOrder_InvalidPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Order(-10.0, "Magazine", customer);
        }, "Order price must be greater than zero.");
    }

    @Test
    void testCreateOrder_InvalidOrderType() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Order(20.0, "", customer);
        }, "Order type cannot be null or empty.");
    }

    @Test
    void testCreateOrder_InvalidCustomerDetails() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Order(20.0, "Magazine", null);
        }, "Customer details cannot be null.");
    }

    @Test
    void testGetOrder_Success() {
        Order retrievedOrder = Order.getOrderById(order.getOrderId());
        assertEquals(order, retrievedOrder);
    }

    @Test
    void testGetOrder_NotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            Order.getOrderById("nonexistent-id");
        }, "Order with ID nonexistent-id not found.");
    }

    @Test
    void testUpdateOrder_Success() {
        try {
            Customer newCustomer = new Customer("Jane Doe", "456 Another St", "0987654321");
            Order.updateOrder(order.getOrderId(), 75.0, "Magazine", newCustomer);
            Order updatedOrder = Order.getOrderById(order.getOrderId());
            assertEquals(75.0, updatedOrder.getOrderPrice());
            assertEquals("Magazine", updatedOrder.getOrderType());
            assertEquals(newCustomer, updatedOrder.getCustomerDetails());
        } catch (ExceptionHandler e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDeleteOrder_Success() {
        Order.deleteOrder(order.getOrderId());
        assertThrows(IllegalArgumentException.class, () -> {
            Order.getOrderById(order.getOrderId());
        }, "Order with ID " + order.getOrderId() + " not found.");
    }

    @Test
    void testGetAllOrders() {
        Order secondOrder = new Order(30.0, "Magazine", customer);
        assertEquals(2, Order.getAllOrders().size());
    }
}
