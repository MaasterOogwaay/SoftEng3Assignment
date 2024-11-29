package deliveryAreaPackage;

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

class DeliveryAreaTest {

	//private DeliveryArea DAreaObj;
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

	// Test Case 1: Add a new area 
	@Test
	void testAddArea()  {
		DeliveryArea newArea;
		try {
			newArea = new DeliveryArea("Willow park", "accross from the college", "1");
			
			assertEquals("Willow park", newArea.getName());
			assertEquals("accross from the college", newArea.getDes());
			assertEquals("1", newArea.getDriver_id());
		} catch (ExceptionHandler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//assertEquals("Route 2", newDeliveryPerson.getAssignedRoute());
	}
	//Test setters
	@Test
	void SettersTest() throws ExceptionHandler {
		DeliveryArea newArea = new DeliveryArea("Willow park", "accross from the college", "1");
		newArea.setName("Monksland");
		newArea.setDes("where the monks live");
		newArea.setDriver_id("2");
		
		assertEquals("Monksland", newArea.getName());
		assertEquals("where the monks live", newArea.getDes());
		assertEquals("2", newArea.getDriver_id());
		
		
	}
	//test valid and invalid names validateName
	@Test
	void testvalidateName() throws ExceptionHandler {
		DeliveryArea newArea = new DeliveryArea("Willow park", "accross from the college", "1");
	
        ExceptionHandler thrown = assertThrows(ExceptionHandler.class, () -> {
        	newArea.validateName("");
        });
        assertEquals("Area Name NOT specified", thrown.getMessage());
        thrown = assertThrows(ExceptionHandler.class, () -> {
        	newArea.validateName(" ");
        });
        assertEquals("Area Name NOT specified", thrown.getMessage());
        thrown = assertThrows(ExceptionHandler.class, () -> {
        	newArea.validateName("a");
        });
        assertEquals("Area Name does not meet minimum length requirements", thrown.getMessage());
        thrown = assertThrows(ExceptionHandler.class, () -> {
        	newArea.validateName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        });
        assertEquals("Area Name exceeds maximum length requirements", thrown.getMessage());
        newArea.validateName("willow");
	}
	
	//validate Price
		@Test
		void testvalDes() throws ExceptionHandler {
			DeliveryArea newArea = new DeliveryArea("Willow park", "accross from the college", "1");
			ExceptionHandler thrown = assertThrows(ExceptionHandler.class, () -> {
	        	newArea.validateDes("");
	        });
	        assertEquals("Area Description NOT specified", thrown.getMessage());
	        thrown = assertThrows(ExceptionHandler.class, () -> {
	        	newArea.validateDes(" ");
	        });
	        assertEquals("Area Description NOT specified", thrown.getMessage());
	        thrown = assertThrows(ExceptionHandler.class, () -> {
	        	newArea.validateDes("a");
	        });
	        assertEquals("Area Description does not meet minimum length requirements", thrown.getMessage());
	        thrown = assertThrows(ExceptionHandler.class, () -> {
	        	newArea.validateDes("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	        });
	        assertEquals("Area Description Address exceeds maximum length requirements", thrown.getMessage());
	        
	        
		}
//		//validate Quantity
//				@Test
//				void testquan() throws ExceptionHandler {
//					Publication newPublication = new Publication("The Daily Times", "1.5", "50", "Daily");
//			        ExceptionHandler thrown = assertThrows(ExceptionHandler.class, () -> {
//			        	newPublication.validateQuantity("");
//			        });
//			        assertEquals("Publication Quantity NOT specified", thrown.getMessage());
//			        thrown = assertThrows(ExceptionHandler.class, () -> {
//			        	newPublication.validateQuantity(" ");
//			        });
//			        assertEquals("Publication Quantity NOT specified", thrown.getMessage());
//			        thrown = assertThrows(ExceptionHandler.class, () -> {
//			        	newPublication.validateQuantity("2.2");
//			        });
//			        assertEquals("Publication Quantity must be a natural number", thrown.getMessage());
//			        thrown = assertThrows(ExceptionHandler.class, () -> {
//			        	newPublication.validateQuantity("a");
//			        });
//			        assertEquals("Publication Quantity is not a number", thrown.getMessage());
//			        
//			        
//				}
//				//validate frequency
//				@Test
//				void testfreq() throws ExceptionHandler {
//					Publication newPublication = new Publication("The Daily Times", "1.5", "50", "Daily");
//			        ExceptionHandler thrown = assertThrows(ExceptionHandler.class, () -> {
//			        	newPublication.validateFrequency("");
//			        });
//			        assertEquals("Publication Frequency NOT specified", thrown.getMessage());
//			        thrown = assertThrows(ExceptionHandler.class, () -> {
//			        	newPublication.validateFrequency(" ");
//			        });
//			        assertEquals("Publication Frequency NOT specified", thrown.getMessage());
//			        thrown = assertThrows(ExceptionHandler.class, () -> {
//			        	newPublication.validateFrequency("2.2");
//			        });
//			        assertEquals("Publication Frequency Must be Daily, Weekly or Monthly", thrown.getMessage());
//			        
//			        
//				}
}