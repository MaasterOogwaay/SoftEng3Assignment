package ordersPackage;

import customerPackage.Customer;
import java.util.Date;
import exceptionHandlerPackage.ExceptionHandler;

public class Order {
    private int id;
    private double price;
    private String type;
    private Customer details;
    private Date date;

    public Order(double price, String type, Customer details) throws ExceptionHandler {
        this.id = id;
        validatePrice(price);
        validateType(type);
        validateCustomerDetails(details);
        this.price = price;
        this.type = type;
        this.details = details;
        this.date = date;
    }

    public void setId(int orderId) {
        id = orderId;
    }

    public void setOrderPrice(double orderPrice) throws ExceptionHandler {
        validatePrice(orderPrice);
        price = orderPrice;
    }

    public void setType(String orderType) throws ExceptionHandler {
        validateType(orderType);
        type = orderType;
    }

    public void setCustomerDetails(Customer customerDetails) throws ExceptionHandler {
        validateCustomerDetails(customerDetails);
        details = customerDetails;
    }

    public int getOrderById(int orderId) {
        return id;
    }

    public double getOrderPrice() {
        return price;
    }

    public String getOrderType() {
        return type;
    }

    public Customer getCustomerDetails() {
        return details;
    }

    public Date getOrderDate() {
        return date;
    }

    // Validation methods
    private void validatePrice(double price) throws ExceptionHandler {
        if (price <= 0) {
            throw new ExceptionHandler("Order price must be greater than zero.");
        }
    }

    private void validateType(String type) throws ExceptionHandler {
        if (type == null || type.isEmpty()) {
            throw new ExceptionHandler("Order type cannot be null or empty.");
        }
    }

    private void validateCustomerDetails(Customer customer) throws ExceptionHandler {
        if (customer == null) {
            throw new ExceptionHandler("Customer details cannot be null.");
        }
    }
}
