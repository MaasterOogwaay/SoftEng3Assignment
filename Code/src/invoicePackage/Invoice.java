package invoicePackage;

import customerPackage.Customer;
import exceptionHandlerPackage.ExceptionHandler;

public class Invoice {
    private int id;
    private double amount;
    private Customer customer;
    private String billingDate;

    // Constructor without id (for creating a new invoice)
    public Invoice(double amount, Customer customer, String billingDate) throws ExceptionHandler {
        validateAmount(amount);
        validateCustomer(customer);
        validateBillingDate(billingDate);
        this.amount = amount;
        this.customer = customer;
        this.billingDate = billingDate;
    }

    // Constructor with id (for retrieving an existing invoice)
    public Invoice(int id, double amount, Customer customer, String billingDate) throws ExceptionHandler {
        this(amount, customer, billingDate);
        this.id = id;  // Set the id after validation
    }

    public void setId(int invoiceId) {
        this.id = invoiceId;
    }

    public int getId() {
        return id;
    }

    public void setAmount(double amount) throws ExceptionHandler {
        validateAmount(amount);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setCustomer(Customer customer) throws ExceptionHandler {
        validateCustomer(customer);
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setBillingDate(String billingDate) throws ExceptionHandler {
        validateBillingDate(billingDate);
        this.billingDate = billingDate;
    }

    public String getBillingDate() {
        return billingDate;
    }

    // Validation methods
    private void validateAmount(double amount) throws ExceptionHandler {
        if (amount <= 0) {
            throw new ExceptionHandler("Invoice amount must be greater than zero.");
        }
    }

    private void validateCustomer(Customer customer) throws ExceptionHandler {
        if (customer == null) {
            throw new ExceptionHandler("Customer details cannot be null.");
        }
    }

    private void validateBillingDate(String billingDate) throws ExceptionHandler {
        if (billingDate == null || billingDate.isEmpty()) {
            throw new ExceptionHandler("Billing date cannot be null or empty.");
        }
    }
}
