package invoicePackage;

import customerPackage.Customer;
import exceptionHandlerPackage.ExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvoiceTest {
    private Invoice invoice;
    private Customer customer;

    @BeforeEach
    void setUp() {
        try {
            customer = new Customer("John Doe", "123 Main St", "1234567890");
        } catch (ExceptionHandler e) {
            e.printStackTrace();
        }
        invoice = new Invoice(100.0, customer, "2024-11-08");
    }

    @Test
    void testCreateInvoice_Success() {
        assertNotNull(invoice);
        assertEquals(100.0, invoice.getAmount());
        assertEquals(customer, invoice.getCustomer());
        assertEquals("2024-11-08", invoice.getBillingDate());
    }

    @Test
    void testCreateInvoice_InvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Invoice(-50.0, customer, "2024-11-08");
        }, "Invoice amount must be greater than zero.");
    }

    @Test
    void testCreateInvoice_InvalidCustomer() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Invoice(100.0, null, "2024-11-08");
        }, "Customer details cannot be null.");
    }

    @Test
    void testCreateInvoice_InvalidBillingDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Invoice(100.0, customer, "");
        }, "Billing date cannot be null or empty.");
    }

    @Test
    void testUpdateInvoice_Success() {
        try {
            Customer newCustomer = new Customer("Jane Doe", "456 Another St", "0987654321");
            invoice.updateInvoice(150.0, newCustomer, "2024-12-01");
            assertEquals(150.0, invoice.getAmount());
            assertEquals(newCustomer, invoice.getCustomer());
            assertEquals("2024-12-01", invoice.getBillingDate());
        } catch (ExceptionHandler e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDeleteInvoice() {
        Invoice.deleteInvoice(invoice.getInvoiceId());
        assertThrows(IllegalArgumentException.class, () -> {
            Invoice.getInvoiceById(invoice.getInvoiceId());
        }, "Invoice with ID " + invoice.getInvoiceId() + " not found.");
    }
}
