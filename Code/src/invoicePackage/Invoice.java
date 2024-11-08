package invoicePackage;

import customerPackage.Customer;
import java.util.HashMap;
import java.util.Map;

public class Invoice {
    private static Map<String, Invoice> invoices = new HashMap<>();
    private String invoiceId;
    private double amount;
    private Customer customer;
    private String billingDate;

    public Invoice(double amount, Customer customer, String billingDate) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invoice amount must be greater than zero.");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer details cannot be null.");
        }
        if (billingDate == null || billingDate.isEmpty()) {
            throw new IllegalArgumentException("Billing date cannot be null or empty.");
        }
        this.invoiceId = generateInvoiceId();
        this.amount = amount;
        this.customer = customer;
        this.billingDate = billingDate;
        invoices.put(this.invoiceId, this);
    }

    public String getInvoiceId() {
        return invoiceId;
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

    public void updateInvoice(double amount, Customer customer, String billingDate) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invoice amount must be greater than zero.");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer details cannot be null.");
        }
        if (billingDate == null || billingDate.isEmpty()) {
            throw new IllegalArgumentException("Billing date cannot be null or empty.");
        }
        this.amount = amount;
        this.customer = customer;
        this.billingDate = billingDate;
    }

    public static void deleteInvoice(String invoiceId) {
        if (!invoices.containsKey(invoiceId)) {
            throw new IllegalArgumentException("Invoice with ID " + invoiceId + " not found.");
        }
        invoices.remove(invoiceId);
    }

    public static Invoice getInvoiceById(String invoiceId) {
        if (!invoices.containsKey(invoiceId)) {
            throw new IllegalArgumentException("Invoice with ID " + invoiceId + " not found.");
        }
        return invoices.get(invoiceId);
    }

    private String generateInvoiceId() {
        return "INV-" + java.util.UUID.randomUUID().toString();
    }
}
