package commandLinePackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import MySQLAccessPackage.MySQLAccess;

public class CommandLine {
	
	private static void listNewsAgentFunctionalityAvailable() {
		
		//Present Newsagent with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Customer");
		System.out.println("2. Delivery Area");
		System.out.println("3. Delivery Docket");
		System.out.println("99. Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}
	
	private static void listCustomerFunctionalityAvailable() {
		
		//Present Customer with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Customer Account");
		System.out.println("2. View ALL Customer Records");
		System.out.println("3. Delete Customer Record by ID");
		System.out.println("99. Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}
	
	private static void listDeliveryDocketFunctionalityAvailable() {
		
		//Present Customer with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Delivery Docket");
		System.out.println("2. Read Todays Docket");
		System.out.println("3. Update Docket by ID");
		System.out.println("4. Delete Docket by ID");
		System.out.println("99. Return to Previous Page");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}
	
	private static void listDeliveryAreaFunctionalityAvailable() {
		
		//Present Customer with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Delivery Area");
		System.out.println("2. Read Delivery Areas");
		System.out.println("3. Update Delivery Area by ID");
		System.out.println("4. Delete Delivery Area by ID");
		System.out.println("99. Return to Previous Page");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}

	
	private static boolean printCustomerTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Full Customer Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("custname");
			String addr = rs.getString("custaddr");
			String phone = rs.getString("custphone");
			System.out.printf("%30s", id);
			System.out.printf("%30s", name);
			System.out.printf("%30s", addr);
			System.out.printf("%30s", phone);
			System.out.println();
		}// end while
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		return true;
		
	}

    // Main method with logic to switch between menus
    public static void main(String[] args) {
    	
    	try {
	        // Configure System for Running
	        Scanner keyboard = new Scanner(System.in);
	        String functionNumber;
	        boolean keepAppOpen = true;
	
	        // Keep showing the Main Menu until the user chooses to exit
	        while (keepAppOpen) {
	            listNewsAgentFunctionalityAvailable();  // Show Main Menu
	            functionNumber = keyboard.nextLine();  // Take user input as a String
	
	            switch (functionNumber) {
	
	                case "1": // Customer Functionality
	                    boolean customerMenuOpen = true;
	                    while (customerMenuOpen) {
	                        listCustomerFunctionalityAvailable(); // Show Customer Submenu
	                        String customerChoice = keyboard.nextLine();  // Take user input
	
	                        switch (customerChoice) {
	                            case "1":
	                                System.out.println("Customer Account Created (Placeholder).");
	                                break;
	                            case "2":
	                                System.out.println("Displaying Customer Records (Placeholder).");
	                                break;
	                            case "3":
	                                System.out.println("Customer Record Deleted (Placeholder).");
	                                break;
	                            case "99":
	                                customerMenuOpen = false;  // Return to Main Menu
	                                break;
	                            default:
	                                System.out.println("No valid option selected.");
	                        }
	                    }
	                    break;
	
	                case "2": // Delivery Area Functionality
	                    boolean areaMenuOpen = true;
	                    while (areaMenuOpen) {
	                        listDeliveryAreaFunctionalityAvailable(); // Show Delivery Area Submenu
	                        String areaChoice = keyboard.nextLine();  // Take user input
	
	                        switch (areaChoice) {
	                            case "1":
	                                System.out.println("Delivery Area Created (Placeholder).");
	                                break;
	                            case "2":
	                                System.out.println("Displaying Delivery Areas (Placeholder).");
	                                break;
	                            case "3":
	                                System.out.println("Delivery Area Updated (Placeholder).");
	                                break;
	                            case "4":
	                                System.out.println("Delivery Area Deleted (Placeholder).");
	                                break;
	                            case "99":
	                                areaMenuOpen = false;  // Return to Main Menu
	                                break;
	                            default:
	                                System.out.println("No valid option selected.");
	                        }
	                    }
	                    break;
	
	                case "3": // Delivery Docket Functionality
	                    boolean docketMenuOpen = true;
	                    while (docketMenuOpen) {
	                        listDeliveryDocketFunctionalityAvailable(); // Show Delivery Docket Submenu
	                        String docketChoice = keyboard.nextLine();  // Take user input
	
	                        switch (docketChoice) {
	                            case "1":
	                                System.out.println("Delivery Docket Created (Placeholder).");
	                                break;
	                            case "2":
	                                System.out.println("Displaying Today's Docket (Placeholder).");
	                                break;
	                            case "3":
	                                System.out.println("Delivery Docket Updated (Placeholder).");
	                                break;
	                            case "4":
	                                System.out.println("Delivery Docket Deleted (Placeholder).");
	                                break;
	                            case "99":
	                                docketMenuOpen = false;  // Return to Main Menu
	                                break;
	                            default:
	                                System.out.println("No valid option selected.");
	                        }
	                    }
	                    break;
	
	                case "99":
	                    keepAppOpen = false;
	                    System.out.println("Closing the Application");
	                    break;
	
	                default:
	                    System.out.println("No Valid Function Selected");
	                    break;
	            } // end switch
	
	        } // end while
	
	        // Tidy up Resources
	        keyboard.close();
    	} catch (Exception e) {
			System.out.println("PROGRAM TERMINATED - ERROR MESSAGE:" + e.getMessage());
		} // end try-catch

    } // end main
	
	
}