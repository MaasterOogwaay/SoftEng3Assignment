package ordersPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import customerPackage.Customer;
import exceptionHandlerPackage.ExceptionHandler;
import java.util.Date;

public class OrderDetailsTest {

    private Order order;
    private Customer customer;

    @BeforeEach
    public void setUp() throws ExceptionHandler {
        customer = new Customer("Bruno Fernandes", "Old Trafford Ave", "0161-8765");
        order = new Order(50.0, "Daily Subscription", customer);
    }

    @Test
    public void testOrderCreation() throws ExceptionHandler {
        // Test initial creation values
        assertEquals(50.0, order.getOrderPrice(), 0.001, "Price should match initial value");
        assertEquals("Daily Subscription", order.getOrderType(), "Order type should match initial value");
        assertEquals(customer, order.getCustomerDetails(), "Customer details should match initial value");
        assertNotNull(order.getOrderDate(), "Order date should be automatically set");
    }

    @Test
    public void testSetOrderPrice() throws ExceptionHandler {
        // Test setting a valid price
        order.setOrderPrice(75.0);
        assertEquals(75.0, order.getOrderPrice(), 0.001, "Price should update correctly");

        // Test setting an invalid price
        ExceptionHandler thrown = assertThrows(ExceptionHandler.class, () -> {
            order.setOrderPrice(-10.0);
        });
        assertEquals("Order price must be greater than zero.", thrown.getMessage());
    }

    @Test
    public void testSetOrderType() throws ExceptionHandler {
        // Test setting a valid type
        order.setType("Weekly Subscription");
        assertEquals("Weekly Subscription", order.getOrderType(), "Order type should update correctly");

        // Test setting an invalid type
        ExceptionHandler thrown = assertThrows(ExceptionHandler.class, () -> {
            order.setType("");
        });
        assertEquals("Order type cannot be null or empty.", thrown.getMessage());
    }

    @Test
    public void testSetCustomerDetails() throws ExceptionHandler {
        // Test setting valid customer details
        Customer newCustomer = new Customer("Marcus Rashford", "Carrington Rd", "0161-5432");
        order.setCustomerDetails(newCustomer);
        assertEquals(newCustomer, order.getCustomerDetails(), "Customer details should update correctly");

        // Test setting invalid customer details
        ExceptionHandler thrown = assertThrows(ExceptionHandler.class, () -> {
            order.setCustomerDetails(null);
        });
        assertEquals("Customer details cannot be null.", thrown.getMessage());
    }

    @Test
    public void testSetOrderId() {
        // Test setting an order ID
        order.setId(101);
        assertEquals(101, order.getId(), "Order ID should be set correctly");
    }

    @Test
    public void testSetOrderDate() {
        // Test setting order date
        Date newDate = new Date();
        order.setDate(newDate);
        assertEquals(newDate, order.getOrderDate(), "Order date should be set correctly");
    }
}
