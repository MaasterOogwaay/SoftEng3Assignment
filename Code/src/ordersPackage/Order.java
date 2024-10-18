package ordersPackage;

public class Order {
    private int orderId;
    private String customerName;
    private String orderType;
    private int orderQuantity;

    // Constructor
    public Order(int orderId, String customerName, String orderType, int orderQuantity) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderType = orderType;
        this.orderQuantity = orderQuantity;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
