package publicationPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import deliveryPersonPackage.DeliveryPerson;
import exceptionHandlerPackage.ExceptionHandler;

class PublicationTest1 {

	private Publication publicationObj;

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
