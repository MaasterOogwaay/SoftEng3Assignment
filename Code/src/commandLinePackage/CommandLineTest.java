package commandLinePackage;
import java.io.*; 
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.sql.ResultSet;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MySQLAccessPackage.MySQLAccess;
import exceptionHandlerPackage.ExceptionHandler;
import publicationPackage.Publication;

class CommandLineTest {

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
	@Test
	void testCLI()  {
		CommandLine cli= new CommandLine();
	}



	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	//listSignUpLogInFunctionalityAvailable()
	@Test
	void testlistSignUpLogInFunctionalityAvailable() {
		System.setOut(new PrintStream(outputStreamCaptor));
		CommandLine cli= new CommandLine();
		cli.listSignUpLogInFunctionalityAvailable();
		assertEquals("=============================================\r\nPlease choose ONE of the following options:\r\n1. Sign Up\r\n2. Log In\r\n99. Close the NewsAgent Application\r\n=============================================", outputStreamCaptor.toString().trim());
		System.setOut(standardOut);
	}
	//listNewsAgentFunctionalityAvailable()
	@Test
	void testlistNewsAgentFunctionalityAvailable() {
		System.setOut(new PrintStream(outputStreamCaptor));
		CommandLine cli= new CommandLine();
		cli.listNewsAgentFunctionalityAvailable();
		assertEquals("=============================================\r\nPlease choose ONE of the following options:\r\n1. Customer\r\n2. Delivery Area\r\n3. Delivery Docket\r\n4. Orders\r\n5. Invoice\r\n6. Publications\r\n7. Delivery Person\r\n8. Warnings\r\n99. Close the NewsAgent Application\r\n=============================================", outputStreamCaptor.toString().trim());
		System.setOut(standardOut);
	}
	//listCustomerFunctionalityAvailable()
	@Test
	void testlistCustomerFunctionalityAvailable() {
		System.setOut(new PrintStream(outputStreamCaptor));
		CommandLine cli= new CommandLine();
		cli.listCustomerFunctionalityAvailable();
		assertEquals("=============================================\r\nPlease choose ONE of the following options:\r\n1. Create Customer Account\r\n2. View ALL Customer Records\r\n3. Update Customer Record by ID\r\n4. Delete Customer Record by ID\r\n99. Close the NewsAgent Application\r\n=============================================", outputStreamCaptor.toString().trim());
		System.setOut(standardOut);
	}
	//listAreaFunctionalityAvailable()
	@Test
	void testlistAreaFunctionalityAvailable(){
		System.setOut(new PrintStream(outputStreamCaptor));
		CommandLine cli= new CommandLine();
		cli.listAreaFunctionalityAvailable();
		assertEquals("=============================================\r\nPlease choose ONE of the following options:\r\n1. Create Area\r\n2. View ALL Areas\r\n3. Update Area by ID\r\n4. Delete Area Record by ID\r\n99. Close the NewsAgent Application\r\n=============================================", outputStreamCaptor.toString().trim());
		System.setOut(standardOut);
	}
	//listDeliveryDocketFunctionalityAvailable()
	@Test
	void testlistDeliveryDocketFunctionalityAvailable(){
		System.setOut(new PrintStream(outputStreamCaptor));
		CommandLine cli= new CommandLine();
		cli.listDeliveryDocketFunctionalityAvailable();
		assertEquals("=============================================\r\nPlease choose ONE of the following options:\r\n1. Create Delivery Docket\r\n2. Read Todays Docket\r\n3. Update Docket by ID\r\n4. Delete Docket by ID\r\n99. Return to Previous Page\r\n=============================================", outputStreamCaptor.toString().trim());
		System.setOut(standardOut);
	}
	//listDeliveryAreaFunctionalityAvailable()
	@Test
	void testlistDeliveryAreaFunctionalityAvailable(){
		System.setOut(new PrintStream(outputStreamCaptor));
		CommandLine cli= new CommandLine();
		cli.listDeliveryAreaFunctionalityAvailable();
		assertEquals("=============================================\r\nPlease choose ONE of the following options:\r\n1. Create Delivery Area\r\n2. Read Delivery Areas\r\n3. Update Delivery Area by ID\r\n4. Delete Delivery Area by ID\r\n99. Return to Previous Page\r\n=============================================", outputStreamCaptor.toString().trim());
		System.setOut(standardOut);
	}
	//listOrdersFunctionalityAvailable()
	@Test
	void testlistOrdersFunctionalityAvailable(){
		System.setOut(new PrintStream(outputStreamCaptor));
		CommandLine cli= new CommandLine();
		cli.listOrdersFunctionalityAvailable();
		assertEquals("=============================================\r\nPlease choose ONE of the following options:\r\n1. Create Order\r\n2. Read Order\r\n3. Update Order by ID\r\n4. Delete Order by ID\r\n99. Return to Previous Page\r\n=============================================", outputStreamCaptor.toString().trim());
		System.setOut(standardOut);
	}
	//listInvoiceFunctionalityAvailable()
	@Test
	void testlistInvoiceFunctionalityAvailable(){
		System.setOut(new PrintStream(outputStreamCaptor));
		CommandLine cli= new CommandLine();
		cli.listInvoiceFunctionalityAvailable();
		assertEquals("Invoice Functionality:\r\n1. Create Invoice\r\n2. Display Invoice\r\n3. Update Invoice\r\n4. Delete Invoice\r\n99. Return to Previous Page\r\nPlease select an option:", outputStreamCaptor.toString().trim());
		System.setOut(standardOut);
	}
	//listPublicationFunctionalityAvailable()
	@Test

	void testlistPublicationFunctionalityAvailable(){
		System.setOut(new PrintStream(outputStreamCaptor));
		CommandLine cli= new CommandLine();
		cli.listPublicationFunctionalityAvailable();
		assertEquals("=============================================\r\nPlease choose ONE of the following options:\r\n1. Create New Publication\r\n2. View ALL Publications\r\n3. Update Publication by ID\r\n4. Delete Publication by ID\r\n99. Return to Previous Page\r\n=============================================", outputStreamCaptor.toString().trim());
		System.setOut(standardOut);
	}

	//listDeliveryPersonFunctionalityAvailable()
	@Test
	void testlistDeliveryPersonFunctionalityAvailable() {
		System.setOut(new PrintStream(outputStreamCaptor));
		CommandLine cli= new CommandLine();
		cli.listDeliveryPersonFunctionalityAvailable() ;
		assertEquals("=============================================\r\nPlease choose ONE of the following options:\r\n1. Create Delivery Person\r\n2. Read Delivery Persons\r\n3. Update Delivery Person by ID\r\n4. Delete Delivery Person by ID\r\n99. Return to Menu\r\n=============================================", outputStreamCaptor.toString().trim());
		System.setOut(standardOut);
	}
	//listWarningsFunctionalityAvailable()
	@Test
	void testlistWarningsFunctionalityAvailable() {
		System.setOut(new PrintStream(outputStreamCaptor));
		CommandLine cli= new CommandLine();
		CommandLine.listWarningsFunctionalityAvailable() ;
		assertEquals("=============================================\r\nPlease choose ONE of the following options:\r\n1. Create Warning\r\n2. Read Warnings\r\n3. Update Warning\r\n4. Delete Warning\r\n99. Return to Menu\r\n=============================================", outputStreamCaptor.toString().trim());
		System.setOut(standardOut);
	}
	/*
	 * //testmain
	 * 
	 * @Test public void testMain() throws IOException { System.out.println("main");
	 * String[] args = null; final InputStream original = System.in;
	 * 
	 * final FileInputStream fips = new FileInputStream(new
	 * File("/NewsAgentApplication/src/commandLinePackage/mainTestFile1"));
	 * System.setIn(fips); CommandLine.main(args); System.setIn(original); }
	 */
	
	//printTable()
	@Test
	void testprintTable() {
		System.setOut(new PrintStream(outputStreamCaptor));
		CommandLine cli= new CommandLine();
		MySQLAccess dbAccess;
		try {
			dbAccess = new MySQLAccess();
			ResultSet rs = dbAccess.retrieveAllAreas();
			CommandLine.printTable(rs, "Areas"); ;
			assertEquals("Table: Areas\r\nid                  name                Description         Driver_ID           \r\n================================================================================", outputStreamCaptor.toString().trim());
			System.setOut(standardOut);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
