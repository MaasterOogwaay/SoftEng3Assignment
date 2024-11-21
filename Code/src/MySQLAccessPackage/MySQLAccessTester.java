package MySQLAccessPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import customerPackage.Customer;
import deliveryAreaPackage.DeliveryArea;
import deliveryDocketPackage.DeliveryDocket;
import deliveryPersonPackage.DeliveryPerson;
import exceptionHandlerPackage.ExceptionHandler;
import invoicePackage.Invoice;
import newsAgentPackage.NewsAgent;
import ordersPackage.Order;
import publicationPackage.Publication;
import warningsPackage.Warnings;

class MySQLAccessTester {
	private MySQLAccess dbAccess;
	
	@BeforeEach
	void connectToDatabase() throws Exception {
		dbAccess = new MySQLAccess();
	}

//	@Test
//	void testDatabaseConnection() {
//		try {
//			dbAccess = new MySQLAccess();
//
//			assertTrue("The connection should be valid.");
//			
//		} catch (Exception e) {
//			fail("Connection failed");
//		}
//	}
	
    // Test insert customer
    @Test
    public void testInsertCustomer() throws ExceptionHandler {
        Customer customer = new Customer("Dylan", "12 Bothar Bui", "012345678");
        boolean success = dbAccess.insertCustomerDetailsAccount(customer);

        assertTrue(success, "Customer should be created successfully.");
    }
    
    // Test insert delivery area
//    @Test
//    public void testInsertDeliveryArea() throws ExceptionHandler {
//        DeliveryArea delArea = new DeliveryArea("Dylan", "12 Bothar Bui", "012345678");
//        boolean success = dbAccess.insertDeliveryArea(delArea);
//
//        assertTrue(success, "Delivery area should be created successfully.");
//    }
    
    // Test insert Delivery Docket
    @Test
    public void testInsertDeliveryDocket() {
        DeliveryDocket docket = new DeliveryDocket("2024-11-22", "Area 51", "John Doe", "1, 2", "Customer1");
        boolean success = dbAccess.insertDeliveryDocket(docket);

        assertTrue(success, "Delivery docket should be created successfully.");
    }
    
    // Test insert Delivery person
    @Test
    public void testInsertDeliveryPerson() {
        DeliveryPerson delPerson = new DeliveryPerson("5", "Dylan", "012345678", "12");
        boolean success = dbAccess.insertDeliveryPersonDetails(delPerson);

        assertTrue(success, "Delivery person should be created successfully.");
    }
    
    // Test insert invoice
    @Test
    public void testInsertInvoice() throws ExceptionHandler {
        Invoice invoice = new Invoice(10.0, new Customer("Dylan", "12 Bothar Bui", "012345678"), "2024-11-22");
        boolean success = dbAccess.insertInvoiceDetails(invoice);

        assertTrue(success, "Invoice should be created successfully.");
    }
    
    // Test insert newsagent
    @Test
    public void testInsertNewsAgent() throws ExceptionHandler {
        NewsAgent na = new NewsAgent("mike", "russell");
        boolean success = dbAccess.signUpUser(na);

        assertTrue(success, "newsagent should be created successfully.");
    }
    
    // Test insert order
    @Test
    public void testInsertOrder() throws ExceptionHandler {
        Order o = new Order(10.0, "Weekly Subscription", new Customer("Dylan", "12 Bothar Bui", "012345678"));
        boolean success = dbAccess.insertOrderDetails(o);

        assertTrue(success, "order should be created successfully.");
    }
    
    // Test insert publication
    @Test
    public void testInsertPublication() throws ExceptionHandler {
        Publication pub = new Publication("Independent", "2.50", "5", "Weekly");
        boolean success = dbAccess.insertPublicationDetailsAccount(pub);

        assertTrue(success, "order should be created successfully.");
    }
    
    // Test insert warning
    @Test
    public void testInsertWarning() throws ExceptionHandler {
        Warnings warn = new Warnings("W002", "Overdue Payment", "Active", "D001", "2024-10-18");
        boolean success = dbAccess.insertWarningDetails(warn);

        assertTrue(success, "warning should be created successfully.");
    }

}
