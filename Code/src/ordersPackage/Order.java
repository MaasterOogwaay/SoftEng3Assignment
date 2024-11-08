package ordersPackage;

import customerPackage.Customer;
import invoicePackage.Invoice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Order {
    private String orderId;
    private double orderPrice;
    private String orderType;
    private Customer customerDetails;
    private Date orderDate;
    private int invoiceId;

    private static Map<String, Order> orders = new HashMap<>();

    public Order(double orderPrice, String orderType, Customer customerDetails) {
        if (orderPrice <= 0) {
            throw new IllegalArgumentException("Order price must be greater than zero.");
        }
        if (orderType == null || orderType.isEmpty()) {
            throw new IllegalArgumentException("Order type cannot be null or empty.");
        }
        if (customerDetails == null) {
            throw new IllegalArgumentException("Customer details cannot be null.");
        }

        this.orderId = UUID.randomUUID().toString();
        this.orderPrice = orderPrice;
        this.orderType = orderType;
        this.customerDetails = customerDetails;
        this.orderDate = new Date();
        this.invoiceId = -1; // Default value until invoice is assigned

        orders.put(orderId, this);
    }

    public String getOrderId() {
        return orderId;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        if (orderPrice <= 0) {
            throw new IllegalArgumentException("Order price must be greater than zero.");
        }
        this.orderPrice = orderPrice;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        if (orderType == null || orderType.isEmpty()) {
            throw new IllegalArgumentException("Order type cannot be null or empty.");
        }
        this.orderType = orderType;
    }

    public Customer getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(Customer customerDetails) {
        if (customerDetails == null) {
            throw new IllegalArgumentException("Customer details cannot be null.");
        }
        this.customerDetails = customerDetails;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public static Order getOrderById(String orderId) {
        if (!orders.containsKey(orderId)) {
            throw new IllegalArgumentException("Order with ID " + orderId + " not found.");
        }
        return orders.get(orderId);
    }

    public static void updateOrder(String orderId, double newOrderPrice, String newOrderType, Customer newCustomerDetails) {
        Order order = getOrderById(orderId);
        order.setOrderPrice(newOrderPrice);
        order.setOrderType(newOrderType);
        order.setCustomerDetails(newCustomerDetails);
    }

    public static void deleteOrder(String orderId) {
        if (!orders.containsKey(orderId)) {
            throw new IllegalArgumentException("Order with ID " + orderId + " not found.");
        }
        orders.remove(orderId);
    }

    public static Map<String, Order> getAllOrders() {
        return new HashMap<>(orders);
    }
    
    public static void clearAllOrders() {
        orders.clear();
    }

}
