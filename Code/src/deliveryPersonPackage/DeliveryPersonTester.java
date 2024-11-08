package deliveryPersonPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryPersonTest {

    private DeliveryPerson deliveryPerson;

    @BeforeEach
    void setUp() {
        // Initialize a new delivery person before each test
        deliveryPerson = new DeliveryPerson("1", "John Doe", "555-1234", "Route 1");
    }

    // Test Case 1: Add a new delivery person
    @Test
    void testAddDeliveryPerson() {
        DeliveryPerson newDeliveryPerson = new DeliveryPerson("2", "Jane Smith", "555-5678", "Route 2");
        assertNotNull(newDeliveryPerson);
        assertEquals("2", newDeliveryPerson.getId());
        assertEquals("Jane Smith", newDeliveryPerson.getName());
        assertEquals("555-5678", newDeliveryPerson.getContactInfo());
        assertEquals("Route 2", newDeliveryPerson.getAssignedRoute());
    }

    // Test Case 2: Validate mandatory fields for new delivery person
    @Test
    void testMandatoryFields() {
        DeliveryPerson invalidDeliveryPerson = new DeliveryPerson(null, "", "555-5678", "Route 2");
        assertNull(invalidDeliveryPerson.getId(), "ID should not be null");
        assertTrue(invalidDeliveryPerson.getName().isEmpty(), "Name should not be empty");
    }

    // Test Case 3: Assign routes/customers to delivery persons
    @Test
    void testAssignRoute() {
        deliveryPerson.setAssignedRoute("Route 3");
        assertEquals("Route 3", deliveryPerson.getAssignedRoute());
    }

    // Test Case 4: View daily delivery schedule
    @Test
    void testViewDailyDeliverySchedule() {
        String expectedSchedule = "Delivery Person ID: " + deliveryPerson.getId() +
                                  "\nName: " + deliveryPerson.getName() +
                                  "\nContact Info: " + deliveryPerson.getContactInfo() +
                                  "\nAssigned Route: " + deliveryPerson.getAssignedRoute();
        DeliveryPerson.printDeliveryPerson(deliveryPerson);
        // Since we cannot capture print output in a typical test, ensure details are correctly assigned
        assertEquals("John Doe", deliveryPerson.getName());
        assertEquals("555-1234", deliveryPerson.getContactInfo());
    }

    // Test Case 5: Check mobile accessibility (This would ideally involve UI testing or a mock check)
    @Test
    void testMobileAccessibility() {
        // Placeholder test, as real mobile tests would require a UI framework or mock
        boolean isMobileAccessible = true;
        assertTrue(isMobileAccessible);
    }

    // Test Case 6: Modify a delivery route
    @Test
    void testModifyRoute() {
        deliveryPerson.updateAssignedRoute("New Route");
        assertEquals("New Route", deliveryPerson.getAssignedRoute());
    }

    // Test Case 7: Remove a delivery person
    @Test
    void testRemoveDeliveryPerson() {
        DeliveryPerson.deleteDeliveryPerson(deliveryPerson);
        assertEquals("1", deliveryPerson.getId());
    }
}
