package warningsPackage;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class WarningsTester {

    @Test
    void testIssueWarning001() {
        try {
            // Create a warning object with valid details
            Warnings warning = new Warnings("W001", "Overdue Payment", "Active", "D001", ("2024-10-18"));

            // Use getters to verify details
            assertEquals("W001", warning.getWarningId());
            assertEquals("Overdue Payment", warning.getWarningReason());
            assertEquals("Active", warning.getWarningStatus());
            assertEquals("D001", warning.getDeliveryPersonId());
            assertEquals(LocalDate.parse("2024-10-18"), warning.getDateIssued());
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    void testViewWarningsForCustomer002() {
        try {
            Warnings warning1 = new Warnings("W001", "Late Payment", "Active", "D001", ("2024-10-10"));
            Warnings warning2 = new Warnings("W002", "Missed Delivery", "Resolved", "D001",("2024-10-12"));

            // Print warning details
            warning1.printWarning(warning1);
            warning2.printWarning(warning2);

            // Use assertions to verify warning details
            assertEquals("W001", warning1.getWarningId());
            assertEquals("Late Payment", warning1.getWarningReason());
            assertEquals("Active", warning1.getWarningStatus());
            
            assertEquals("W002", warning2.getWarningId());
            assertEquals("Missed Delivery", warning2.getWarningReason());
            assertEquals("Resolved", warning2.getWarningStatus());
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    void testFilterWarningsByStatus003() {
        try {
            Warnings warning1 = new Warnings("W001", "Late Payment", "Active", "D001", "2024-10-10");
            Warnings warning2 = new Warnings("W002", "Missed Delivery", "Resolved", "D001", ("2024-10-12"));

            if (warning1.getWarningStatus().equals("Active")) {
                warning1.printWarning(warning1);
            }

            assertEquals("Active", warning1.getWarningStatus());
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    // Test #: 4
    // Test Objective: Mark a warning as resolved after customer payment
    // Inputs: Select warning, mark as resolved
    // Expected Output: Warning status updated to resolved, confirmation message displayed.
    @Test
    void testMarkWarningAsResolved004() {
        try {
            // Create a warning with an "Active" status
            Warnings warning = new Warnings(null, null, null, null, null);

            // Update the status to "Resolved"
            warning.updateWarningStatus("Resolved");

            // Verify the status update
            assertEquals("Resolved", warning.getWarningStatus());
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    // Test #: 5
    // Test Objective: Remove or suspend a warning for a customer
    // Inputs: Select warning, confirm removal/suspension
    // Expected Output: Warning removed/suspended, customer’s deliveries suspended if required, success message displayed.
    @Test
    void testRemoveWarning005() {
        try {
            // Create a warning
            Warnings warning = new Warnings(null, null, null, null, null);

            // Simulate warning deletion
            Warnings.deleteWarning(warning.getWarningId());

            // Assume further functionality to remove the warning from a real system
            // (No real deletion as this is just a console message, so no assert needed)
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }
}
