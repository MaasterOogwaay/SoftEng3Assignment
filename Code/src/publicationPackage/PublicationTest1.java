package publicationPackage;
import java.io.*;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commandLinePackage.CommandLine;
import deliveryPersonPackage.DeliveryPerson;
import exceptionHandlerPackage.ExceptionHandler;

class PublicationTest1 {

	private Publication publicationObj;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@BeforeEach
	void setUp() throws ExceptionHandler {
		// Initialize a new delivery person before each test
		publicationObj = new Publication("The Times", "2.5", "40", "Weekly");
	}

	// Test Case 1: Add a new Publication 
	@Test
	void testAddPublication()  {
		Publication newPublication;
		try {
			newPublication = new Publication("The Daily Times", "1.5", "50", "Daily");
			System.out.println(newPublication.getName());
			assertEquals("The Daily Times", newPublication.getName());
			assertEquals("50", newPublication.getQuantity());
			assertEquals("Daily", newPublication.getFrequency());
			assertEquals("1.5", newPublication.getPrice());
		} catch (ExceptionHandler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//assertEquals("Route 2", newDeliveryPerson.getAssignedRoute());
	}
	//Test setters
	@Test
	void SettersTest() throws ExceptionHandler {
		Publication newPublication = new Publication("The Daily Times", "1.5", "50", "Daily");
		newPublication.setFrequency("Weekly");
		newPublication.setPrice("4");
		newPublication.setQuantity("3");
		newPublication.setName("The Weekly Journal");
		assertEquals("The Weekly Journal", newPublication.getName());
		assertEquals("3", newPublication.getQuantity());
		assertEquals("Weekly", newPublication.getFrequency());
		assertEquals("4", newPublication.getPrice());
		
	}
	//test valid and invalid names validateName
	@Test
	void testvalidateName() throws ExceptionHandler {
		Publication newPublication = new Publication("The Daily Times", "1.5", "50", "Daily");
		//assertThrows(newPublication.validateName("");
		//assertEquals(newPublication.validateName(""), ExceptionHandler.getMessage());
		

       // assertEquals("This is Custom exception message", exception.ge
	}
	//validate name
	@Test
	void test() throws ExceptionHandler {
		Publication newPublication = new Publication("The Daily Times", "1.5", "50", "Daily");
        ExceptionHandler thrown = assertThrows(ExceptionHandler.class, () -> {
        	newPublication.validateName("");
        });
        assertEquals("Publication Name NOT specified", thrown.getMessage());
        thrown = assertThrows(ExceptionHandler.class, () -> {
        	newPublication.validateName(" ");
        });
        assertEquals("Publication Name NOT specified", thrown.getMessage());
        thrown = assertThrows(ExceptionHandler.class, () -> {
        	newPublication.validateName("a");
        });
        assertEquals("Publication Name does not meet minimum length requirements", thrown.getMessage());
        thrown = assertThrows(ExceptionHandler.class, () -> {
        	newPublication.validateName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        });
        assertEquals("Publication Name exceeds maximum length requirements", thrown.getMessage());
        
	}
	
	//validate Price
		@Test
		void testprice() throws ExceptionHandler {
			Publication newPublication = new Publication("The Daily Times", "1.5", "50", "Daily");
	        ExceptionHandler thrown = assertThrows(ExceptionHandler.class, () -> {
	        	newPublication.validatePrice("");
	        });
	        assertEquals("Publication Price NOT specified", thrown.getMessage());
	        thrown = assertThrows(ExceptionHandler.class, () -> {
	        	newPublication.validatePrice(" ");
	        });
	        assertEquals("Publication Price NOT specified", thrown.getMessage());
	        thrown = assertThrows(ExceptionHandler.class, () -> {
	        	newPublication.validatePrice("a");
	        });
	        assertEquals("Publication Price is not a number", thrown.getMessage());
	        
	        
		}
		//validate Quantity
				@Test
				void testquan() throws ExceptionHandler {
					Publication newPublication = new Publication("The Daily Times", "1.5", "50", "Daily");
			        ExceptionHandler thrown = assertThrows(ExceptionHandler.class, () -> {
			        	newPublication.validateQuantity("");
			        });
			        assertEquals("Publication Quantity NOT specified", thrown.getMessage());
			        thrown = assertThrows(ExceptionHandler.class, () -> {
			        	newPublication.validateQuantity(" ");
			        });
			        assertEquals("Publication Quantity NOT specified", thrown.getMessage());
			        thrown = assertThrows(ExceptionHandler.class, () -> {
			        	newPublication.validateQuantity("2.2");
			        });
			        assertEquals("Publication Quantity must be a natural number", thrown.getMessage());
			        thrown = assertThrows(ExceptionHandler.class, () -> {
			        	newPublication.validateQuantity("a");
			        });
			        assertEquals("Publication Quantity is not a number", thrown.getMessage());
			        
			        
				}
				//validate frequency
				@Test
				void testfreq() throws ExceptionHandler {
					Publication newPublication = new Publication("The Daily Times", "1.5", "50", "Daily");
			        ExceptionHandler thrown = assertThrows(ExceptionHandler.class, () -> {
			        	newPublication.validateFrequency("");
			        });
			        assertEquals("Publication Frequency NOT specified", thrown.getMessage());
			        thrown = assertThrows(ExceptionHandler.class, () -> {
			        	newPublication.validateFrequency(" ");
			        });
			        assertEquals("Publication Frequency NOT specified", thrown.getMessage());
			        thrown = assertThrows(ExceptionHandler.class, () -> {
			        	newPublication.validateFrequency("2.2");
			        });
			        assertEquals("Publication Frequency Must be Daily, Weekly or Monthly", thrown.getMessage());
			        
			        
				}
					
	// Test Case 2: update new Publication
//	@Test
//	void updatePublication() {
//		Publication newPublication= new Publication("The Daily Times", "1.5", "50", "Daily");
//		
//		assertNull(newPublication.getId(), "ID should not be null");
//		assertTrue(invalidDeliveryPerson.getName().isEmpty(), "Name should not be empty");
//	}
	//
	//    // Test Case 3: Assign routes/customers to delivery persons
	//    @Test
	//    void testAssignRoute() {
	//        deliveryPerson.setAssignedRoute("Route 3");
	//        assertEquals("Route 3", deliveryPerson.getAssignedRoute());
	//    }
	//
	//    // Test Case 4: View daily delivery schedule
	//    @Test
	//    void testViewDailyDeliverySchedule() {
	//        String expectedSchedule = "Delivery Person ID: " + deliveryPerson.getId() +
	//                                  "\nName: " + deliveryPerson.getName() +
	//                                  "\nContact Info: " + deliveryPerson.getContactInfo() +
	//                                  "\nAssigned Route: " + deliveryPerson.getAssignedRoute();
	//        DeliveryPerson.printDeliveryPerson(deliveryPerson);
	//        // Since we cannot capture print output in a typical test, ensure details are correctly assigned
	//        assertEquals("John Doe", deliveryPerson.getName());
	//        assertEquals("555-1234", deliveryPerson.getContactInfo());
	//    }
	//
	//    // Test Case 5: Check mobile accessibility (This would ideally involve UI testing or a mock check)
	//    @Test
	//    void testMobileAccessibility() {
	//        // Placeholder test, as real mobile tests would require a UI framework or mock
	//        boolean isMobileAccessible = true;
	//        assertTrue(isMobileAccessible);
	//    }
	//
	//    // Test Case 6: Modify a delivery route
	//    @Test
	//    void testModifyRoute() {
	//        deliveryPerson.updateAssignedRoute("New Route");
	//        assertEquals("New Route", deliveryPerson.getAssignedRoute());
	//    }
	//
	//    // Test Case 7: Remove a delivery person
	//    @Test
	//    void testRemoveDeliveryPerson() {
	//        DeliveryPerson.deleteDeliveryPerson(deliveryPerson);
	//        assertEquals("1", deliveryPerson.getId());
	//    }

}
