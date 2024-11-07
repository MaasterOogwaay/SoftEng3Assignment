package commandLinePackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import MySQLAccessPackage.MySQLAccess;
import customerPackage.Customer;

public class CommandLine {
	
	private static void listNewsAgentFunctionalityAvailable() {
		
		//Present Newsagent with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Customer");
		System.out.println("2. Delivery Area");
		System.out.println("3. Delivery Docket");
		System.out.println("4. Orders");
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
		System.out.println("3. Update Customer Record by ID");
		System.out.println("4. Delete Customer Record by ID");
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
	
	private static void listOrdersFunctionalityAvailable() {
		
		//Present Customer with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Order");
		System.out.println("2. Read Order");
		System.out.println("3. Update Order by ID");
		System.out.println("4. Delete Order by ID");
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
	                                System.out.println("Creating customer account");
	                                System.out.println("Please enter Customer Name:");
	                                String custName = keyboard.nextLine();

	                                System.out.println("Please enter Customer Address:");
	                                String custAddr = keyboard.nextLine();

	                                System.out.println("Please enter Customer Phone Number:");
	                                String custPhone = keyboard.nextLine();

	                                try {
	                                    // Create Customer object
	                                    Customer newCustomer = new Customer(custName, custAddr, custPhone);

	                                    // Create MySQLAccess object and insert the customer
	                                    MySQLAccess dbAccess = new MySQLAccess();
	                                    boolean success = dbAccess.insertCustomerDetailsAccount(newCustomer);

	                                    if (success) {
	                                        System.out.println("Customer created successfully.");
	                                    } else {
	                                        System.out.println("Failed to create customer.");
	                                    }
	                                } catch (Exception e) {
	                                    System.out.println("Error: " + e.getMessage());
	                                }

	                                break;
	                            case "2":
	                                System.out.println("Displaying Customer Records (Placeholder).");
	                                System.out.println("Retrieving all customer records...");

	                                try {
	                                    MySQLAccess dbAccess = new MySQLAccess();
	                                    ResultSet resultSet = dbAccess.retrieveAllCustomerAccounts();

	                                    if (resultSet != null) {
	                                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
	                                        System.out.printf("%10s %30s %30s %30s%n", "ID", "Name", "Address", "Phone Number");
	                                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");

	                                        // Iterate through the ResultSet and print each record
	                                        while (resultSet.next()) {
	                                            int id = resultSet.getInt("id");
	                                            String name = resultSet.getString("name");
	                                            String address = resultSet.getString("address");
	                                            String phoneNumber = resultSet.getString("phoneNumber");

	                                            System.out.printf("%10d %30s %30s %30s%n", id, name, address, phoneNumber);
	                                        }
	                                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
	                                    } else {
	                                        System.out.println("No customer records found.");
	                                    }

	                                } catch (Exception e) {
	                                    System.out.println("Error retrieving customer records: " + e.getMessage());
	                                }
	                                break;
	                            case "3": // Update Customer Record by ID
	                                System.out.println("Please enter the ID of the customer you wish to update:");
	                                
	                                try {
	                                    int customerId = Integer.parseInt(keyboard.nextLine());  // Convert user input to an integer

	                                    // Prompt the user for new details
	                                    System.out.println("Enter new name:");
	                                    String newName = keyboard.nextLine();
	                                    System.out.println("Enter new address:");
	                                    String newAddress = keyboard.nextLine();
	                                    System.out.println("Enter new phone number:");
	                                    String newPhoneNumber = keyboard.nextLine();

	                                    // Create MySQLAccess object and update the customer
	                                    MySQLAccess dbAccess = new MySQLAccess();
	                                    boolean success = dbAccess.updateCustomerDetailsById(customerId, newName, newAddress, newPhoneNumber);

	                                    if (success) {
	                                        System.out.println("Customer with ID " + customerId + " was updated successfully.");
	                                    } else {
	                                        System.out.println("No customer found with ID " + customerId + ".");
	                                    }

	                                } catch (NumberFormatException e) {
	                                    System.out.println("Invalid input. Please enter a numeric ID.");
	                                } catch (Exception e) {
	                                    System.out.println("Error updating customer record: " + e.getMessage());
	                                }
	                                break;
	                            case "4":
	                                System.out.println("Please enter the ID of the customer you wish to delete (-99 to delete all):");
	                                int customerId;
	                                
	                                try {
	                                    customerId = Integer.parseInt(keyboard.nextLine()); // Convert user input to an integer

	                                    MySQLAccess dbAccess = new MySQLAccess();
	                                    boolean success = dbAccess.deleteCustomerById(customerId);

	                                    if (success) {
	                                    	if (customerId == -99) {
	                                    		System.out.println("All customer records were deleted successfully.");
	                                    	} else {
	                                    		System.out.println("Customer with ID " + customerId + " was deleted successfully.");
	                                    	}
	                                    } else {
	                                        System.out.println("No customer found with ID " + customerId + ".");
	                                    }

	                                } catch (NumberFormatException e) {
	                                    System.out.println("Invalid input. Please enter a numeric ID.");
	                                } catch (Exception e) {
	                                    System.out.println("Error deleting customer record: " + e.getMessage());
	                                }
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
	                    
	                case "4": // Orders Functionality
	                    boolean orderMenuOpen = true;
	                    while (orderMenuOpen) {
	                    	listOrdersFunctionalityAvailable(); // Show Orders Submenu
	                        String orderChoice = keyboard.nextLine();  // Take user input
	
	                        switch (orderChoice) {
	                            case "1":
	                                System.out.println("Order Created (Placeholder).");
	                                break;
	                            case "2":
	                                System.out.println("Displaying Today's Order (Placeholder).");
	                                break;
	                            case "3":
	                                System.out.println("Order Updated (Placeholder).");
	                                break;
	                            case "4":
	                                System.out.println("Order Deleted (Placeholder).");
	                                break;
	                            case "99":
	                            	orderMenuOpen = false;  // Return to Main Menu
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
