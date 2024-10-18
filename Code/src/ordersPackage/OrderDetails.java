package ordersPackage;

import java.util.HashMap;
import java.util.Map;

public class OrderDetails {
    // Attributes
    private static int orderIdCounter = 1;
    private Map<Integer, Order> orders;

    // Constructor
    public OrderDetails() {
        orders = new HashMap<>();
    }

    // Create Order
    public int createOrder(String customerName, String orderType, int orderQuantity) {
        if (orderQuantity <= 0 || !(orderType instanceof String) || orderType == null) {
            throw new IllegalArgumentException("Invalid order details");
        }
        int orderId = orderIdCounter++;
        Order newOrder = new Order(orderId, customerName, orderType, orderQuantity);
        orders.put(orderId, newOrder);
        return orderId;
    }

    // Delete Order
    public boolean deleteOrder(int orderId) {
        if (!orders.containsKey(orderId)) {
            throw new IllegalArgumentException("Order does not exist");
        }
        orders.remove(orderId);
        return true;
    }

    // Edit Order
    public void editOrder(int orderId, String newOrderType, int newOrderQuantity) {
        if (!orders.containsKey(orderId)) {
            throw new IllegalArgumentException("Order does not exist");
        }
        if (newOrderType == null || newOrderQuantity <= 0) {
            throw new IllegalArgumentException("Invalid input for updating order");
        }
        Order orderToEdit = orders.get(orderId);
        orderToEdit.setOrderType(newOrderType);
        orderToEdit.setOrderQuantity(newOrderQuantity);
    }

    // View Active Orders
    public Map<Integer, Order> viewActiveOrders() {
        return new HashMap<>(orders);
    }

    // Log Customer Holidays
    public void logCustomerHoliday(int orderId, String holidayStartDate, String holidayEndDate) {
        if (!orders.containsKey(orderId)) {
            throw new IllegalArgumentException("Order does not exist");
        }
        // Implementation to log customer holiday dates
    }

    // Generate Daily Summary
    public void generateDailySummary() {
        // Implementation to generate a summary of orders for the day
    }

    // Check Stock Availability
    public boolean checkStockAvailability(String orderType, int orderQuantity) {
        // Implementation to check stock availability
        return true;
    }
}

