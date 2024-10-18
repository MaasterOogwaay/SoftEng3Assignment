package newsAgentPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptionHandlerPackage.ExceptionHandler;

class NewsAgentTester {

	@Test
	void testNewsAgent001() {
		try {
			
			//Call method under test
			NewsAgent newsAgentObj = new NewsAgent("MikeRussell", "SoftEng");
			
			// Use getters to check for object creation
			assertEquals(0, newsAgentObj.getId());
			assertEquals("MikeRussell", newsAgentObj.getUserName());
			assertEquals("SoftEng", newsAgentObj.getPassWord());
		}
		catch (ExceptionHandler e) {
			fail("Exception not expected");
		}
	}
	
	// Test #: 2
	// Test Objective: Catch invalid Username
	// Inputs: userName = "M"
	// Expected Output: Exception Message: "Username does not meet minimum length requirements"
	@Test
	void testValidateUserName001() {
		try {
			NewsAgent.validateUserName("M");
			fail("Exception expected");
		} catch (Exception e) {
			assertEquals("Username does not meet minimum length requirements", e.getMessage());
		}
		
	}
	
	// Test #: 3
	// Test Objective: Catch invalid password
	// Inputs: userName = "S"
	// Expected Output: Exception Message: "Password does not meet minimum length requirements"
	@Test
	void testValidatePassWord002() {
		try {
			NewsAgent.validatePassWord("S");
			fail("Exception expected");
		} catch (Exception e) {
			assertEquals("Password does not meet minimum length requirements", e.getMessage());
		}
		
	}
	
	// Test #: 4
	// Test Objective: Catch invalid Username entered
	// Inputs: userName = "longusernameinputwithoverthemaximumoffiftycharacters"
	// Expected Output: Exception Message: "Username exceeds maximum length requirements"
	@Test
	void testValidateUserName003() {
		try {
			NewsAgent.validateUserName("longusernameinputwithoverthemaximumoffiftycharacters");
			fail("Exception expected");
		} catch (Exception e) {
			assertEquals("Username exceeds maximum length requirements", e.getMessage());
		}
		
	}
	
	// Test #: 5
	// Test Objective: Catch invalid password
	// Inputs: userName = "SoftwareEngineering3"
	// Expected Output: Exception Message: "Password exceeds maximum length requirements"
	@Test
	void testValidatePassWord004() {
		try {
			NewsAgent.validatePassWord("SoftwareEngineering3");
			fail("Exception expected");
		} catch (Exception e) {
			assertEquals("Password exceeds maximum length requirements", e.getMessage());
		}
		
	}

}
