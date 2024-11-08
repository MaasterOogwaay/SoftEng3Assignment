package commandLinePackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import MySQLAccessPackage.MySQLAccess;
import customerPackage.Customer;
<<<<<<< HEAD
import publicationPackage.Publication;

public class CommandLine {

	private static void listNewsAgentFunctionalityAvailable() {

		//Present Newsagent with Functionality Options
=======
import newsAgentPackage.NewsAgent;

public class CommandLine {

	private static boolean isLoggedIn = false;

	private static void listSignUpLogInFunctionalityAvailable() {

		// Present Newsagent with Sign Up or Log In Options

		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Sign Up");
		System.out.println("2. Log In");
		System.out.println("99. Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");

	}

	private static void listNewsAgentFunctionalityAvailable() {

		// Present Newsagent with Functionality Options
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f

		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Customer");
		System.out.println("2. Delivery Area");
		System.out.println("3. Delivery Docket");
		System.out.println("4. Orders");
		System.out.println("5. Publications");
		System.out.println("99. Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");

	}

	private static void listCustomerFunctionalityAvailable() {

<<<<<<< HEAD
		//Present Customer with Functionality Options
=======
		// Present Customer with Functionality Options
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f

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

<<<<<<< HEAD
		//Present Customer with Functionality Options
=======
		// Present Customer with Functionality Options
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f

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

<<<<<<< HEAD
		//Present Customer with Functionality Options
=======
		// Present Customer with Functionality Options
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f

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

<<<<<<< HEAD
		//Present Customer with Functionality Options
=======
		// Present Customer with Functionality Options
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f

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

<<<<<<< HEAD
	}
	private static void listPublicationFunctionalityAvailable() {

		//Present Customer with Functionality Options

		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create New Publication");
		System.out.println("2. View ALL Publications");
		System.out.println("3. Update Publication by ID");
		System.out.println("4. Delete Publication by ID");
		System.out.println("99. Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");

	}


	private static boolean printCustomerTable(ResultSet rs) throws Exception {

		//Print The Contents of the Full Customer Table

		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
=======
	}

	private static boolean printCustomerTable(ResultSet rs) throws Exception {

		// Print The Contents of the Full Customer Table

		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------");
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s", rs.getMetaData().getColumnName(i));
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
<<<<<<< HEAD
		}// end while
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

		return true;

	}
	private static boolean printPublicationTable(ResultSet rs) throws Exception {

		//Print The Contents of the Full Publication Table

		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("pubname");
			String price = rs.getString("pubprice");
			String quantity = rs.getString("pubquantity");
			String frequency = rs.getString("pubfrequency");
			System.out.printf("%30s", id);
			System.out.printf("%30s", name);
			System.out.printf("%30s", price);
			System.out.printf("%30s", quantity);
			System.out.printf("%30s", frequency);
			System.out.println();
		}// end while
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

		return true;

=======
		} // end while
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------");

		return true;

>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f
	}

	// Main method with logic to switch between menus
	public static void main(String[] args) {

		try {
<<<<<<< HEAD
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
=======
			Scanner keyboard = new Scanner(System.in);
			String functionNumber;

			while (!isLoggedIn) { // Show sign-up/log-in menu until user logs in
				listSignUpLogInFunctionalityAvailable();
				functionNumber = keyboard.nextLine();

				switch (functionNumber) {
				case "1": // Sign Up
					System.out.println("Enter new username:");
					String newUsername = keyboard.nextLine();
					System.out.println("Enter new password:");
					String newPassword = keyboard.nextLine();

					try {
						MySQLAccess dbAccess = new MySQLAccess();

						NewsAgent newUser = new NewsAgent(newUsername, newPassword);

						boolean signUpSuccess = dbAccess.signUpUser(newUser);

						if (signUpSuccess) {
							System.out.println("Sign-up successful! You can now log in.");
						} else {
							System.out.println("Sign-up failed. Try again.");
						}
					} catch (Exception e) {
						System.out.println("Error during sign-up: " + e.getMessage());
					}
					break;

				case "2": // Log In
					System.out.println("Enter username:");
					String username = keyboard.nextLine();
					System.out.println("Enter password:");
					String password = keyboard.nextLine();

					try {
						MySQLAccess dbAccess = new MySQLAccess();
						isLoggedIn = dbAccess.logInUser(username, password);

						if (isLoggedIn) {
							System.out.println("Login successful! Welcome, " + username + ".");
						} else {
							System.out.println("Login failed. Check your credentials and try again.");
						}
					} catch (Exception e) {
						System.out.println("Error during login: " + e.getMessage());
					}
					break;

				case "99":
					System.out.println("Closing the NewsAgent Application.");
					keyboard.close();
					return; // Exit the application
				}
			}

			// Once logged in, proceed to main functionality menu
			boolean keepAppOpen = true;
			while (keepAppOpen) {
				listNewsAgentFunctionalityAvailable(); // Show Main Menu
				functionNumber = keyboard.nextLine();

				switch (functionNumber) {

				case "1": // Customer Functionality
					boolean customerMenuOpen = true;
					while (customerMenuOpen) {
						listCustomerFunctionalityAvailable(); // Show Customer Submenu
						String customerChoice = keyboard.nextLine(); // Take user input

						switch (customerChoice) {
						case "1": // Create Customer Account
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
						case "2": // Read All Customer Details
							System.out.println("Retrieving all customer records...");

							try {
								MySQLAccess dbAccess = new MySQLAccess();
								ResultSet resultSet = dbAccess.retrieveAllCustomerAccounts();

								if (resultSet != null) {
									System.out.println(
											"------------------------------------------------------------------------------------------------------------------------------------");
									System.out.printf("%10s %30s %30s %30s%n", "ID", "Name", "Address", "Phone Number");
									System.out.println(
											"------------------------------------------------------------------------------------------------------------------------------------");

									// Iterate through the ResultSet and print each record
									while (resultSet.next()) {
										int id = resultSet.getInt("id");
										String name = resultSet.getString("name");
										String address = resultSet.getString("address");
										String phoneNumber = resultSet.getString("phoneNumber");

										System.out.printf("%10d %30s %30s %30s%n", id, name, address, phoneNumber);
									}
									System.out.println(
											"------------------------------------------------------------------------------------------------------------------------------------");
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
								int customerId = Integer.parseInt(keyboard.nextLine()); // Convert user input to an integer
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f

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
<<<<<<< HEAD
						case "4":
=======
						case "4": // Delete Customer By ID
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f
							System.out.println("Please enter the ID of the customer you wish to delete (-99 to delete all):");
							int customerId;

							try {
								customerId = Integer.parseInt(keyboard.nextLine()); // Convert user input to an integer

<<<<<<< HEAD
=======
								// Create MySQLAccess object and delete the customer
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f
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
<<<<<<< HEAD
							customerMenuOpen = false;  // Return to Main Menu
=======
							customerMenuOpen = false; // Return to Main Menu
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f
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
<<<<<<< HEAD
						String areaChoice = keyboard.nextLine();  // Take user input
=======
						String areaChoice = keyboard.nextLine(); // Take user input
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f

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
<<<<<<< HEAD
							areaMenuOpen = false;  // Return to Main Menu
=======
							areaMenuOpen = false; // Return to Main Menu
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f
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
<<<<<<< HEAD
						String docketChoice = keyboard.nextLine();  // Take user input
=======
						String docketChoice = keyboard.nextLine(); // Take user input
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f

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
<<<<<<< HEAD
							docketMenuOpen = false;  // Return to Main Menu
=======
							docketMenuOpen = false; // Return to Main Menu
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f
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
<<<<<<< HEAD
						String orderChoice = keyboard.nextLine();  // Take user input
=======
						String orderChoice = keyboard.nextLine(); // Take user input
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f

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
<<<<<<< HEAD
							orderMenuOpen = false;  // Return to Main Menu
=======
							orderMenuOpen = false; // Return to Main Menu
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f
							break;
						default:
							System.out.println("No valid option selected.");
						}
					}
					break;

<<<<<<< HEAD
				case "5": // Publication Functionality
					boolean publicationMenuOpen = true;
					while (publicationMenuOpen) {
						listPublicationFunctionalityAvailable(); // Show Publication Submenu
						String publicationChoice = keyboard.nextLine();  // Take user input

						switch (publicationChoice) {
						case "1":
							System.out.println("Creating new Publication");
							System.out.println("Please enter Publication Name:");
							String pubName = keyboard.nextLine();

							System.out.println("Please enter Publication price:");
							String pubPrice = keyboard.nextLine();

							System.out.println("Please enter Publication quantity:");
							String pubQuantity = keyboard.nextLine();
							
							System.out.println("Please enter Publication Frequency:");
							String pubFrequency = keyboard.nextLine();

							try {
								// Create Customer object
								Publication newPublication = new Publication(pubName, pubPrice, pubQuantity, pubFrequency);

								// Create MySQLAccess object and insert the customer

								MySQLAccess dbAccess = new MySQLAccess();
								boolean success = dbAccess.insertPublicationDetailsAccount(newPublication);

								if (success) {
									System.out.println("Publication created successfully.");
								} else {
									System.out.println("Failed to create Publication.");
								}
							} catch (Exception e) {
								System.out.println("Error: " + e.getMessage());
							}

							break;
						case "2":
							System.out.println("Displaying Publication Records (Placeholder).");
							System.out.println("Retrieving all publication records...");

							try {
								MySQLAccess dbAccess = new MySQLAccess();
								
								ResultSet resultSet = dbAccess.retrieveAllPublications();

								if (resultSet != null) {
									System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
									System.out.printf("%10s %20s %20s %30s %20s %n", "ID", "Name", "Price", "Quantity","Frequency");
									System.out.println("------------------------------------------------------------------------------------------------------------------------------------");

									// Iterate through the ResultSet and print each record
									while (resultSet.next()) {
										int id = resultSet.getInt("id");
										String name = resultSet.getString("name");
										String price = resultSet.getString("price");
										String quantity = resultSet.getString("quantity");
										String frequency = resultSet.getString("frequency");

										System.out.printf("%10d  %20s %20s %30s %20s %n", id, name, price, quantity, frequency);
									}
									System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
								} else {
									System.out.println("No Publications found.");
								}

							} catch (Exception e) {
								System.out.println("Error retrieving Publications: " + e.getMessage());
							}
							break;
						case "3": // Update Customer Record by ID
							System.out.println("Please enter the ID of the publicatoin you wish to update:");

							try {
								int publicationId = Integer.parseInt(keyboard.nextLine());  // Convert user input to an integer

								// Prompt the user for new details
								System.out.println("Enter new name:");
								String newName = keyboard.nextLine();
								System.out.println("Enter new price:");
								String newPrice = keyboard.nextLine();
								System.out.println("Enter new quantity:");
								String newQuantity = keyboard.nextLine();
								System.out.println("Enter new frequency:");
								String newFrequency = keyboard.nextLine();
								// Create MySQLAccess object and update the publication
								MySQLAccess dbAccess = new MySQLAccess();
								boolean success = dbAccess.updatePublicationDetailsById(publicationId, newName, newPrice, newQuantity, newFrequency);

								if (success) {
									System.out.println("Publication with ID " + publicationId + " was updated successfully.");
								} else {
									System.out.println("No publication found with ID " + publicationId + ".");
								}

							} catch (NumberFormatException e) {
								System.out.println("Invalid input. Please enter a numeric ID.");
							} catch (Exception e) {
								System.out.println("Error updating publication: " + e.getMessage());
							}
							break;
						case "4":
							System.out.println("Please enter the ID of the publication you wish to delete (-99 to delete all):");
							int publicationId;

							try {
								publicationId = Integer.parseInt(keyboard.nextLine()); // Convert user input to an integer

								MySQLAccess dbAccess = new MySQLAccess();
								boolean success = dbAccess.deletePublicationById(publicationId);

								if (success) {
									if (publicationId == -99) {
										System.out.println("All publication records were deleted successfully.");
									} else {
										System.out.println("Publication with ID " + publicationId + " was deleted successfully.");
									}
								} else {
									System.out.println("No publication found with ID " + publicationId + ".");
								}

							} catch (NumberFormatException e) {
								System.out.println("Invalid input. Please enter a numeric ID.");
							} catch (Exception e) {
								System.out.println("Error deleting publication record: " + e.getMessage());
							}
							break;
						case "99":
							publicationMenuOpen = false;  // Return to Main Menu
							break;
						default:
							System.out.println("No valid option selected.");
						}
					}
					break;

				
=======
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f
				case "99":
					keepAppOpen = false;
					System.out.println("Closing the Application");
					break;

				default:
					System.out.println("No Valid Function Selected");
					break;
				} // end switch

			} // end while

<<<<<<< HEAD
			// Tidy up Resources
=======
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f
			keyboard.close();
		} catch (Exception e) {
			System.out.println("PROGRAM TERMINATED - ERROR MESSAGE:" + e.getMessage());
		} // end try-catch

	} // end main

<<<<<<< HEAD

=======
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f
}
