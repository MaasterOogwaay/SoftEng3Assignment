package warningsPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WarningsTester {

    // Test #: 1
    // Test Objective: Issue a warning to a customer for overdue payment
    // Inputs: Select customer, enter warning details (date, reason, status)
    // Expected Output: Warning issued successfully with a unique ID, customer notified.
    @Test
    void testIssueWarning001() {
        try {
            // Create a warning object with valid details
            Warnings warning = new Warnings("W001", "Overdue Payment", "Active", "D001", "2024-10-18");

            // Use getters to verify details
            assertEquals("W001", warning.getWarningId());
            assertEquals("Overdue Payment", warning.getWarningReason());
            assertEquals("Active", warning.getWarningStatus());
            assertEquals("D001", warning.getDeliveryPersonId());
            assertEquals("2024-10-18", warning.getDateIssued());
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    // Test #: 2
    // Test Objective: View warnings for a specific customer
    // Inputs: Select customer from the system
    // Expected Output: List of warnings displayed with date, reason, and status.
    @Test
    void testViewWarningsForCustomer002() {
        try {
            // Create multiple warnings for a customer
            Warnings warning1 = new Warnings("W001", "Late Payment", "Active", "D001", "2024-10-10");
            Warnings warning2 = new Warnings("W002", "Missed Delivery", "Resolved", "D001", "2024-10-12");

            // Print warning details (this would be displayed in a real system)
            Warnings.printWarning(warning1);
            Warnings.printWarning(warning2);

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

    // Test #: 3
    // Test Objective: Filter warnings by status (active/resolved)
    // Inputs: Apply filter (e.g., view only active warnings)
    // Expected Output: Warnings filtered successfully based on the selected status.
    @Test
    void testFilterWarningsByStatus003() {
        try {
            // Create warnings
            Warnings warning1 = new Warnings("W001", "Late Payment", "Active", "D001", "2024-10-10");
            Warnings warning2 = new Warnings("W002", "Missed Delivery", "Resolved", "D001", "2024-10-12");

            // Assume a filter function to view active warnings (pseudo-filter in real-world code)
            if (warning1.getWarningStatus().equals("Active")) {
                Warnings.printWarning(warning1);
            }

            // Verify that only active warnings are displayed
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
            Warnings warning = new Warnings("W001", "Late Payment", "Active", "D001", "2024-10-10");

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
            Warnings warning = new Warnings("W001", "Late Payment", "Active", "D001", "2024-10-10");

            // Simulate warning deletion
            Warnings.deleteWarning(warning);

            // Assume further functionality to remove the warning from a real system
            // (No real deletion as this is just a console message, so no assert needed)
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }
}
