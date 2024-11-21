package invoicePackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import customerPackage.Customer;
import exceptionHandlerPackage.ExceptionHandler;

import static org.junit.jupiter.api.Assertions.*;

public class InvoiceTest {

    private Invoice invoice;
    private Customer customer;

    @BeforeEach
    public void setUp() throws ExceptionHandler {
        customer = new Customer("Casemiro", "Manchester Place", "0161-2345");
        invoice = new Invoice(1, 100.0, customer, "2024-11-21");
    }

    @Test
    public void testInvoiceCreation() throws ExceptionHandler {
        // Test initial creation values
        assertEquals(100.0, invoice.getAmount(), 0.001, "Amount should match initial value");
        assertEquals(customer, invoice.getCustomer(), "Customer details should match initial value");
        assertEquals("2024-11-21", invoice.getBillingDate(), "Billing date should match initial value");
    }

    @Test
    public void testSetInvoiceAmount() throws ExceptionHandler {
        // Test setting a valid amount
        invoice.setAmount(150.0);
        assertEquals(150.0, invoice.getAmount(), 0.001, "Amount should update correctly");

        // Test setting an invalid amount
        ExceptionHandler thrown = assertThrows(ExceptionHandler.class, () -> {
            invoice.setAmount(-50.0);
        });
        assertEquals("Invoice amount must be greater than zero.", thrown.getMessage());
    }

    @Test
    public void testSetCustomerDetails() throws ExceptionHandler {
        // Test setting valid customer details
        Customer newCustomer = new Customer("Lisandro Martinez", "Defender Lane", "0161-6789");
        invoice.setCustomer(newCustomer);
        assertEquals(newCustomer, invoice.getCustomer(), "Customer details should update correctly");

        // Test setting invalid customer details
        ExceptionHandler thrown = assertThrows(ExceptionHandler.class, () -> {
            invoice.setCustomer(null);
        });
        assertEquals("Customer details cannot be null.", thrown.getMessage());
    }

    @Test
    public void testSetBillingDate() throws ExceptionHandler {
        // Test setting billing date
        String newBillingDate = "2024-12-01";
        invoice.setBillingDate(newBillingDate);
        assertEquals(newBillingDate, invoice.getBillingDate(), "Billing date should update correctly");
    }
}
