package deliveryDocketPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptionHandlerPackage.ExceptionHandler;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DeliveryDocketTester {

	// Test #: 1
	// Test Objective: Validate a correctly formatted delivery date
	// Inputs: deliveryDate = "2024-11-22"
	// Expected Output: No exception
	@Test
	void testValidateDeliveryDate001() {
		try {
			DeliveryDocket.validateDeliveryDate("2024-11-22");
		} catch (ExceptionHandler e) {
			fail("Exception not expected for valid delivery date.");
		}
	}

	// Test #: 2
	// Test Objective: Catch empty delivery date
	// Inputs: deliveryDate = ""
	// Expected Output: Exception Message: "Delivery date NOT specified"
	@Test
	void testValidateDeliveryDate002() {
		Exception exception = assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validateDeliveryDate("");
		});
		assertEquals("Delivery date NOT specified", exception.getMessage());
	}

	// Test #: 3
	// Test Objective: Catch null delivery date
	// Inputs: deliveryDate = null
	// Expected Output: Exception Message: "Delivery date NOT specified"
	@Test
	void testValidateDeliveryDate003() {
		assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validateDeliveryDate(null);
		});
	}

	// Test #: 4
	// Test Objective: Catch incorrectly formatted delivery date
	// Inputs: deliveryDate = "22-11-2024"
	// Expected Output: Exception Message: "Delivery date must be in format YYYY-MM-DD"
	@Test
	void testValidateDeliveryDate004() {
		assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validateDeliveryDate("22-11-2024");
		});
	}

	// Test #: 5
	// Test Objective: Validate a valid delivery area
	// Inputs: deliveryArea = "Area 51"
	// Expected Output: No exception
	@Test
	void testValidateDeliveryArea001() {
		try {
			DeliveryDocket.validateDeliveryArea("12");
		} catch (ExceptionHandler e) {
			fail("Exception not expected for valid delivery area.");
		}
	}

	// Test #: 6
	// Test Objective: Catch empty delivery area
	// Inputs: deliveryArea = ""
	// Expected Output: Exception Message: "Delivery area NOT specified"
	@Test
	void testValidateDeliveryArea002() {
		assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validateDeliveryArea("");
		});
	}

	// Test #: 7
	// Test Objective: Catch delivery area below minimum length
	// Inputs: deliveryArea = "A"
	// Expected Output: Exception Message: "Delivery area does not meet minimum length requirements"
	@Test
	void testValidateDeliveryArea003() {
		assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validateDeliveryArea("A");
		});
	}

	// Test #: 8
	// Test Objective: Catch delivery area exceeding maximum length
	// Inputs: deliveryArea = "A".repeat(101)
	// Expected Output: Exception Message: "Delivery area exceeds maximum length requirements"
	@Test
	void testValidateDeliveryArea004() {
		assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validateDeliveryArea("A".repeat(101));
		});
	}

	// Test #: 9
	// Test Objective: Validate a valid delivery person
	// Inputs: deliveryPerson = "John Doe"
	// Expected Output: No exception
	@Test
	void testValidateDeliveryPerson001() {
		try {
			DeliveryDocket.validateDeliveryPerson("John Doe");
		} catch (ExceptionHandler e) {
			fail("Exception not expected for valid delivery person.");
		}
	}

	// Test #: 10
	// Test Objective: Catch empty delivery person
	// Inputs: deliveryPerson = ""
	// Expected Output: Exception Message: "Delivery person NOT specified"
	@Test
	void testValidateDeliveryPerson002() {
		assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validateDeliveryPerson("");
		});
	}

	// Test #: 11
	// Test Objective: Catch delivery person below minimum length
	// Inputs: deliveryPerson = "A"
	// Expected Output: Exception Message: "Delivery person does not meet minimum length requirements"
	@Test
	void testValidateDeliveryPerson003() {
		assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validateDeliveryPerson("A");
		});
	}

	// Test #: 12
	// Test Objective: Catch delivery person exceeding maximum length
	// Inputs: deliveryPerson = "A".repeat(101)
	// Expected Output: Exception Message: "Delivery person exceeds maximum length requirements"
	@Test
	void testValidateDeliveryPerson004() {
		assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validateDeliveryPerson("A".repeat(101));
		});
	}

	// Test #: 13
	// Test Objective: Validate valid publication IDs
	// Inputs: publicationIds = "1,2,3"
	// Expected Output: No exception
	@Test
	void testValidatePublicationIds001() {
		try {
			DeliveryDocket.validatePublicationIds("1,2,3");
		} catch (ExceptionHandler e) {
			fail("Exception not expected for valid publication IDs.");
		}
	}

	// Test #: 14
	// Test Objective: Catch empty publication IDs
	// Inputs: publicationIds = ""
	// Expected Output: Exception Message: "Publication IDs NOT specified"
	@Test
	void testValidatePublicationIds002() {
		assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validatePublicationIds("");
		});
	}

	// Test #: 15
	// Test Objective: Catch invalid publication IDs format
	// Inputs: publicationIds = "1,2,A"
	// Expected Output: Exception Message: "Publication IDs must be a comma-separated list of numbers"
	@Test
	void testValidatePublicationIds003() {
		assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validatePublicationIds("1,2,A");
		});
	}

	// Test #: 16
	// Test Objective: Validate a valid customer
	// Inputs: customer = "Customer Name"
	// Expected Output: No exception
	@Test
	void testValidateCustomer001() {
		try {
			DeliveryDocket.validateCustomer("Customer Name");
		} catch (ExceptionHandler e) {
			fail("Exception not expected for valid customer.");
		}
	}

	// Test #: 17
	// Test Objective: Catch empty customer
	// Inputs: customer = ""
	// Expected Output: Exception Message: "Customer NOT specified"
	@Test
	void testValidateCustomer002() {
		assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validateCustomer("");
		});
	}

	// Test #: 18
	// Test Objective: Catch customer below minimum length
	// Inputs: customer = "A"
	// Expected Output: Exception Message: "Customer does not meet minimum length requirements"
	@Test
	void testValidateCustomer003() {
		assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validateCustomer("A");
		});
	}

	// Test #: 19
	// Test Objective: Catch customer exceeding maximum length
	// Inputs: customer = "A".repeat(101)
	// Expected Output: Exception Message: "Customer exceeds maximum length requirements"
	@Test
	void testValidateCustomer004() {
		assertThrows(ExceptionHandler.class, () -> {
			DeliveryDocket.validateCustomer("A".repeat(101));
		});
	}

}
