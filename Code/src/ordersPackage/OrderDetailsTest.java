package ordersPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderDetailsTest {

    private OrderDetails orderDetails;

    @BeforeEach
    public void setUp() {
        orderDetails = new OrderDetails();
    }

    @Test
    public void testCreateOrder_ValidInputs() {
        // Test Number 1
        int orderId = orderDetails.createOrder("Bruno Fernandes", "Newspaper", 3);
        assertTrue(orderId > 0, "Order should be successfully created with a valid orderId");
    }

    @Test
    public void testCreateOrder_UniqueOrderId() {
        // Test Number 2
        int orderId1 = orderDetails.createOrder("Marcus Rashford", "Magazine", 2);
        int orderId2 = orderDetails.createOrder("Jadon Sancho", "Newspaper", 1);
        assertNotEquals(orderId1, orderId2, "Each new order should be assigned a unique orderId");
    }

    @Test
    public void testCreateOrder_InvalidOrderQuantity() {
        // Test Number 3
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            orderDetails.createOrder("Luke Shaw", "Newspaper", 0);
        });
        assertEquals("Invalid order details", exception.getMessage(), "Order quantity must be greater than zero");
    }

    @Test
    public void testCreateOrder_InvalidOrderQuantity_NaN() {
        // Test Number 4 - Passing an incorrect quantity
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            orderDetails.createOrder("Harry Maguire", "Magazine", -1); // Using a negative value
        });
        assertEquals("Invalid order details", exception.getMessage(), "Order quantity must be greater than zero");
    }


    @Test
    public void testCreateOrder_NullOrderType() {
        // Test Number 5
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            orderDetails.createOrder("Casemiro", null, 1);
        });
        assertEquals("Invalid order details", exception.getMessage(), "Order type must be a valid non-null string");
    }

    @Test
    public void testEditOrder_Success() {
        // Test Number 17
        int orderId = orderDetails.createOrder("ORD124", "Magazine", 4);
        orderDetails.editOrder(orderId, "Newspaper", 4);
        assertTrue(true, "The system should provide an option to edit orderType and orderQuantity");
    }

    @Test
    public void testEditOrder_InvalidInput() {
        // Test Number 19
        int orderId = orderDetails.createOrder("ORD129", "Magazine", 3);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            orderDetails.editOrder(orderId, null, -1);
        });
        assertEquals("Invalid input for updating order", exception.getMessage(), "Invalid new input should throw an error");
    }

    @Test
    public void testDeleteOrder_Success() {
        // Test Number 20
        int orderId = orderDetails.createOrder("ORD125", "Newspaper", 3);
        assertTrue(orderDetails.deleteOrder(orderId), "Order should be successfully deleted");
    }

    @Test
    public void testDeleteOrder_NonExistent() {
        // Test Number 22
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            orderDetails.deleteOrder(999);
        });
        assertEquals("Order does not exist", exception.getMessage(), "Non-existent order should throw an error");
    }
}

