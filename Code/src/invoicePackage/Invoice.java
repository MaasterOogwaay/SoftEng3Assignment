package invoicePackage;

import customerPackage.Customer;
import exceptionHandlerPackage.ExceptionHandler;

public class Invoice {
    private int id;
    private double amount;
    private Customer customer;
    private String billingDate;

    public Invoice(int id, double amount, Customer customer, String billingDate) throws ExceptionHandler {
        this.id = id;
        validateAmount(amount);
        validateCustomer(customer);
        validateBillingDate(billingDate);
        this.amount = amount;
        this.customer = customer;
        this.billingDate = billingDate;
    }

    public void setId(int invoiceId) {
        id = invoiceId;
    }

    public void setAmount(double amount) throws ExceptionHandler {
        validateAmount(amount);
        this.amount = amount;
    }

    public void setCustomer(Customer customer) throws ExceptionHandler {
        validateCustomer(customer);
        this.customer = customer;
    }

    public void setBillingDate(String billingDate) throws ExceptionHandler {
        validateBillingDate(billingDate);
        this.billingDate = billingDate;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public Customer getCustomer() {
        return customer;
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
a