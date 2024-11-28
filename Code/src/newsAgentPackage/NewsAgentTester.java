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
	
	// Test #: 6
	// Test Objective: Test minimum username length
	// Inputs: userName = "AB"
	// Expected Output: Test is successful
	@Test
	void testValidateUserName005() {
	    try {
	        NewsAgent.validateUserName("AB"); // Minimum boundary
	    } catch (Exception e) {
	        fail("Exception not expected for valid userName at minimum length.");
	    }
	}

	// Test #: 7
	// Test Objetive: Test maximum username length
	// Inputs: userName = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ"
	// Expected Output: Test is successful
	@Test
	void testValidateUserName006() {
	    try {
	        NewsAgent.validateUserName("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX"); // Maximum boundary
	    } catch (Exception e) {
	        fail("Exception not expected for valid userName at maximum length.");
	    }
	}
	
	// Test #: 8
	// Test Objective: Catch invalid username
	// Inputs: userName = "A"
	// Expected Output: "Username does not meet minimum length requirements"
	@Test
	void testValidateUserName007() {
		try {
			NewsAgent.validateUserName("A"); // Below minimum
			fail("Exception expected");
	    } catch (Exception e) {
	    	assertEquals("Username does not meet minimum length requirements", e.getMessage());
	    }
	}

	// Test #: 9
	// Test Objective: Catch invalid username
	// Inputs: userName = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZA"
	// Expected Output: "Username exceeds maximum length requirements"
	@Test
	void testValidateUserName008() {
	    try {
	    	 NewsAgent.validateUserName("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZA");
	    	 fail("Exception expected");
	    } catch (Exception e) {
	    	assertEquals("Username exceeds maximum length requirements", e.getMessage());
	    }
	}
	
	// Test #: 10
	// Test Objective: Catch invalid username
	// Inputs: userName = ""
	// Expected Output: ""Username NOT specified""
	@Test
	void testValidateUserName009() {
	    try {
	    	NewsAgent.validateUserName("");
	    	 fail("Exception expected");
	    } catch (Exception e) {
	    	assertEquals("Username NOT specified", e.getMessage());
	    }
	}
	
	// Test #: 11
	// Test Objective: Accepts minimum length password
	// Inputs: passWord = "AB"
	// Expected Output: Test passes successfully
	@Test
	void testValidatePassWord010() {
	    try {
	        NewsAgent.validatePassWord("AB"); // Minimum boundary
	    } catch (Exception e) {
	        fail("Exception not expected for valid passWord at minimum length.");
	    }
	}
	// Test #: 12
	// Test Objective: Accepts maximum length password
	// Inputs: passWord = "ABCDEFGHIJ"
	// Expected Output: Test passes successfully
	@Test
	void testValidatePassWord011() {
	    try {
	        NewsAgent.validatePassWord("ABCDEFGHIJ"); // Maximum boundary
	    } catch (Exception e) {
	        fail("Exception not expected for valid passWord at maximum length.");
	    }
	}

	// Test #: 13
	// Test Objective: Fails when passWord is below minimum requirement
	// Inputs: passWord = "A"
	// Expected Output: "Password does not meet minimum length requirements"
	@Test
	void testValidatePassWord012() {
	    try {
			NewsAgent.validatePassWord("A");
			fail("Exception expected");
		} catch (Exception e) {
			assertEquals("Password does not meet minimum length requirements", e.getMessage());
		}
	}

	// Test #: 14
	// Test Objective: Fails when passWord is above maximum requirement
	// Inputs: passWord = "ABCDEFGHIJK"
	// Expected Output: "Password exceeds maximum length requirements"
	@Test
	void testValidatePassWord013() {
	    try {
			NewsAgent.validatePassWord("ABCDEFGHIJK");
			fail("Exception expected");
		} catch (Exception e) {
			assertEquals("Password exceeds maximum length requirements", e.getMessage());
		}
	}

	// Test #: 15
	// Test Objective: Fails when passWord is empty
	// Inputs: passWord = ""
	// Expected Output: "Password NOT specified"
	@Test
	void testValidatePassWord014() {
	    try {
			NewsAgent.validatePassWord("");
			fail("Exception expected");
		} catch (Exception e) {
			assertEquals("Password NOT specified", e.getMessage());
		}
	}






}
