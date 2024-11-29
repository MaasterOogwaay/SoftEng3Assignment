package commandLinePackage;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import MySQLAccessPackage.MySQLAccess;
import customerPackage.Customer;
import deliveryAreaPackage.DeliveryArea;
import deliveryDocketPackage.DeliveryDocket;
import deliveryPersonPackage.DeliveryPerson;
import exceptionHandlerPackage.ExceptionHandler;
import invoicePackage.Invoice;
import newsAgentPackage.NewsAgent;
import ordersPackage.Order;
import publicationPackage.Publication;
import warningsPackage.Warnings;

public class CommandLine {

	private static boolean isLoggedIn = false;

	public static boolean isLoggedIn() {
		return isLoggedIn;
	}

	static void listSignUpLogInFunctionalityAvailable() {

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

	static void listNewsAgentFunctionalityAvailable() {

		// Present Newsagent with Functionality Options

		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Customer");
		System.out.println("2. Delivery Area");
		System.out.println("3. Delivery Docket");
		System.out.println("4. Orders");
		System.out.println("5. Invoice");
		System.out.println("6. Publications");
		System.out.println("7. Delivery Person");
		System.out.println("8. Warnings");
		System.out.println("99. Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");

	}

	static void listCustomerFunctionalityAvailable() {

		// Present Customer with Functionality Options

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
	static void listAreaFunctionalityAvailable() {

		// Present Area Functionality Options

		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Area");
		System.out.println("2. View ALL Areas");
		System.out.println("3. Update Area by ID");
		System.out.println("4. Delete Area Record by ID");
		System.out.println("99. Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");

	}

	static void listDeliveryDocketFunctionalityAvailable() {

		// Present Customer with Functionality Options

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

	static void listDeliveryAreaFunctionalityAvailable() {

		// Present Customer with Functionality Options

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

	static void listOrdersFunctionalityAvailable() {

		// Present Customer with Functionality Options

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

	static void listInvoiceFunctionalityAvailable() {
		System.out.println("\nInvoice Functionality:");
		System.out.println("1. Create Invoice");
		System.out.println("2. Display Invoice");
		System.out.println("3. Update Invoice");
		System.out.println("4. Delete Invoice");
		System.out.println("99. Return to Previous Page");
		System.out.print("Please select an option: ");
	}


	static void listPublicationFunctionalityAvailable() {

		// Present Customer with Functionality Options

		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create New Publication");
		System.out.println("2. View ALL Publications");
		System.out.println("3. Update Publication by ID");
		System.out.println("4. Delete Publication by ID");
		System.out.println("99. Return to Previous Page");
		System.out.println("=============================================");
		System.out.println(" ");

	}

	private static boolean printCustomerTable(ResultSet rs) throws Exception {

		// Print The Contents of the Full Customer Table

		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------");
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
		} // end while







		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------");

		return true;

	}


	static void listDeliveryPersonFunctionalityAvailable() {
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Delivery Person");
		System.out.println("2. Read Delivery Persons");
		System.out.println("3. Update Delivery Person by ID");
		System.out.println("4. Delete Delivery Person by ID");
		System.out.println("99. Return to Menu");
		System.out.println("=============================================");
		System.out.println(" ");
	}
	 static void listWarningsFunctionalityAvailable() {
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Warning");
		System.out.println("2. Read Warnings");
		System.out.println("3. Update Warning");
		System.out.println("4. Delete Warning");
		System.out.println("99. Return to Menu");
		System.out.println("=============================================");
		System.out.println(" ");
	}




	// Main method with logic to switch between menus
	public static void main(String[] args) {

		try {
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
								int customerId = Integer.parseInt(keyboard.nextLine()); // Convert user input to an
								// integer

								// Prompt the user for new details
								System.out.println("Enter new name:");
								String newName = keyboard.nextLine();
								System.out.println("Enter new address:");
								String newAddress = keyboard.nextLine();
								System.out.println("Enter new phone number:");
								String newPhoneNumber = keyboard.nextLine();

								// Create MySQLAccess object and update the customer
								MySQLAccess dbAccess = new MySQLAccess();
								boolean success = dbAccess.updateCustomerDetailsById(customerId, newName, newAddress,
										newPhoneNumber);

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
						case "4": // Delete Customer By ID
							System.out.println(
									"Please enter the ID of the customer you wish to delete (-99 to delete all):");
							int customerId;

							try {
								customerId = Integer.parseInt(keyboard.nextLine()); // Convert user input to an integer

								// Create MySQLAccess object and delete the customer
								MySQLAccess dbAccess = new MySQLAccess();
								boolean success = dbAccess.deleteCustomerById(customerId);

								if (success) {
									if (customerId == -99) {
										System.out.println("All customer records were deleted successfully.");
									} else {
										System.out.println(
												"Customer with ID " + customerId + " was deleted successfully.");
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
							customerMenuOpen = false; // Return to Main Menu
							break;
						default:
							System.out.println("No valid option selected.");
						}
					}
					break;
				///////////////////////////////

				case "2": // Delivery Area Functionality
					boolean areaMenuOpen = true;
					//MySQLAccess dbAccess = new MySQLAccess();
					while (areaMenuOpen) {
						MySQLAccess dbAccess = new MySQLAccess();
						listAreaFunctionalityAvailable(); // Show Area Submenu
						String areaChoice = keyboard.nextLine(); // Take user input

						switch (areaChoice) {
						case "1": // Create Area 
							System.out.println("Creating Area");
							System.out.println("Please enter Area Name:");
							String areaName = keyboard.nextLine();

							System.out.println("Please enter Area description:");
							String areaDes = keyboard.nextLine();

							System.out.println("Please enter Area Driver Listed below ID (If none listed create driver):");
							try {
								ResultSet rs = dbAccess.retrieveAllAreas();
								printTable(rs, "Delivery Persons");
							} catch (Exception e) {
								System.out.println("Error: " + e.getMessage());
							}
							String areaDriver = keyboard.nextLine();
							//checkforDeliveryPersonId(areaDriver);//getBackTo

							try {
								// Create Area object
								DeliveryArea newArea = new DeliveryArea(areaName,areaDes,areaDriver);

								// Create MySQLAccess object and insert the customer
								
								boolean success = dbAccess.insertArea(newArea);

								if (success) {
									System.out.println("Area created successfully.");
								} else {
									System.out.println("Failed to create area.");
								}
							} catch (Exception e) {
								System.out.println("Error: " + e.getMessage());
							}

							break;
						case "2": // Read All Area Details
							try {
								ResultSet rs = dbAccess.retrieveAllAreas();
								printTable(rs, "Areas");
							} catch (Exception e) {
								System.out.println("Error: " + e.getMessage());
							}
							break;
						case "3": // Update Areas by ID
							System.out.println("Please enter the ID of the area you wish to update:");

							try {
								int areaId = Integer.parseInt(keyboard.nextLine()); // Convert user input to an
								// integer

								// Prompt the user for new details
								System.out.println("Enter new area name:");
								String newName = keyboard.nextLine();
								System.out.println("Enter new description:");
								String newDes = keyboard.nextLine();
								System.out.println("Enter new Delivery Driver:");
								String newDriver = keyboard.nextLine();

								// Create MySQLAccess object and update the customer
								
								boolean success = dbAccess.updateAreaById(areaId, newName, newDes,
										newDriver);

								if (success) {
									System.out.println("Area with ID " + areaId + " was updated successfully.");
								} else {
									System.out.println("No customer found with ID " + areaId + ".");
								}

							} catch (NumberFormatException e) {
								System.out.println("Invalid input. Please enter a numeric ID.");
							} catch (Exception e) {
								System.out.println("Error updating customer record: " + e.getMessage());
							}
							break;
						case "4": // Delete area By ID
							System.out.println(
									"Please enter the ID of the area you wish to delete (-99 to delete all):");
							int areaId;

							try {
								areaId = Integer.parseInt(keyboard.nextLine()); // Convert user input to an integer

								// Create MySQLAccess object and delete the area
								
								boolean success = dbAccess.deleteAreaById(areaId);

								if (success) {
									if (areaId == -99) {
										System.out.println("All area records were deleted successfully.");
									} else {
										System.out.println(
												"Area with ID " + areaId + " was deleted successfully.");
									}
								} else {
									System.out.println("No area found with ID " + areaId + ".");
								}

							} catch (NumberFormatException e) {
								System.out.println("Invalid input. Please enter a numeric ID.");
							} catch (Exception e) {
								System.out.println("Error deleting area record: " + e.getMessage());
							}
							break;
						case "99":
							areaMenuOpen = false; // Return to Main Menu
							break;
						default:
							System.out.println("No valid option selected.");
						}
					}
					break;
				/////////////////////////////////////
				case "3": // Delivery Docket Functionality
					boolean docketMenuOpen = true;
					while (docketMenuOpen) {
						listDeliveryDocketFunctionalityAvailable(); // Show Delivery Docket Submenu
						String docketChoice = keyboard.nextLine(); // Take user input

						switch (docketChoice) {
						case "1": // Create Delivery Docket
						    System.out.println("Enter Delivery Date (YYYY-MM-DD):");
						    String deliveryDate = keyboard.nextLine();

						    System.out.println("Enter Delivery Area:");
						    String deliveryArea = keyboard.nextLine();

						    System.out.println("Enter Delivery Person:");
						    String deliveryPerson = keyboard.nextLine();

						    System.out.println("Enter Publications:");
						    String publications = keyboard.nextLine();
						    
						    System.out.println("Enter customer:");
						    String customerName = keyboard.nextLine();
						    
						    try {
						    	DeliveryDocket docket = new DeliveryDocket(deliveryDate, deliveryArea, deliveryPerson, publications, customerName);
						    	
						    	MySQLAccess dbAccess = new MySQLAccess();
						    	boolean success = dbAccess.insertDeliveryDocket(docket);
						    	if (success) {
						    		System.out.println("Docket created successfully");
						    	} else {
						    		System.out.println("Failed to create docket");
						    	}
						    } catch (Exception e) {
						    	System.out.println("Error: " + e.getMessage());
						    }
						    
						    break;

						case "2": // View All Delivery Dockets
						    System.out.println("Retrieving all delivery dockets...");

						    try {
						        MySQLAccess dbAccess = new MySQLAccess();
						        ResultSet resultSet = dbAccess.retrieveAllDeliveryDockets();

						        if (resultSet != null) {
						            System.out.println("---------------------------------------------------------------------------------------------------");
						            System.out.printf("%10s %20s %20s %20s %30s%n", "ID", "Date", "Area", "Person", "Publications", "Customer");
						            System.out.println("---------------------------------------------------------------------------------------------------");

						            while (resultSet.next()) {
						                int id = resultSet.getInt("id");
						                String date = resultSet.getString("deliveryDate");
						                String area = resultSet.getString("deliveryArea");
						                String person = resultSet.getString("deliveryPerson");
						                String pubs = resultSet.getString("publicationIds");
						                String cust = resultSet.getString("customer");

						                System.out.printf("%10d %20s %20s %20s %30s%n", id, date, area, person, pubs, cust);
						            }
						            System.out.println("---------------------------------------------------------------------------------------------------");
						        } else {
						            System.out.println("No delivery dockets found.");
						        }
						    } catch (Exception e) {
						        System.out.println("Error retrieving delivery dockets: " + e.getMessage());
						    }
						    break;

						case "3": // Update Docket by ID
						    System.out.println("Enter the ID of the Delivery Docket you wish to update:");
						    int docketId = Integer.parseInt(keyboard.nextLine());

						    System.out.println("Enter new Delivery Date:");
						    String newDeliveryDate = keyboard.nextLine();
						    
						    System.out.println("Enter new Delivery Area:");
						    String newDeliveryArea = keyboard.nextLine();

						    System.out.println("Enter new Delivery Person:");
						    String newDeliveryPerson = keyboard.nextLine();

						    System.out.println("Enter new Publications:");
						    String newPublications = keyboard.nextLine();

						    System.out.println("Enter new Customer Name (leave blank to keep current):");
						    String newCustomer = keyboard.nextLine();

						    try {
						        MySQLAccess dbAccess = new MySQLAccess();
						        boolean success = dbAccess.updateDeliveryDocketById(docketId, newDeliveryDate, newDeliveryArea, newDeliveryPerson, newPublications, newCustomer);

						        if (success) {
						            System.out.println("Delivery Docket updated successfully.");
						        } else {
						            System.out.println("No Delivery Docket found with ID " + docketId + ".");
						        }
						    } catch (Exception e) {
						        System.out.println("Error updating Delivery Docket: " + e.getMessage());
						    }
						    break;

						case "4": // Delete Docket by ID
						    System.out.println("Enter the ID of the Delivery Docket you wish to delete:");
						    int deleteDocketId = Integer.parseInt(keyboard.nextLine());

						    try {
						        MySQLAccess dbAccess = new MySQLAccess();
						        boolean success = dbAccess.deleteDeliveryDocketById(deleteDocketId);

						        if (success) {
						        	if (deleteDocketId == -99) {
						        		System.out.println("All Delivery Dockets deleted successfully.");
						        	} else {
						        		System.out.println("Delivery Docket deleted successfully.");
						        	}
						        } else {
						            System.out.println("No Delivery Docket found with ID " + deleteDocketId + ".");
						        }
						    } catch (Exception e) {
						        System.out.println("Error deleting Delivery Docket: " + e.getMessage());
						    }
						    break;

						case "99":
							docketMenuOpen = false; // Return to Main Menu
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
						String orderChoice = keyboard.nextLine(); // Take user input

						switch (orderChoice) {
						case "1": // Create Order
							System.out.println("Creating new Order");
							System.out.println("Please enter Order Price:");
							double orderPrice = Double.parseDouble(keyboard.nextLine());

							System.out.println("Please enter Order Type:");
							String orderType = keyboard.nextLine();

							System.out.println("Please enter Customer Name:");
							String customerName = keyboard.nextLine();

							System.out.println("Please enter Customer Address:");
							String customerAddress = keyboard.nextLine();

							System.out.println("Please enter Customer Phone Number:");
							String customerPhone = keyboard.nextLine();

							try {
								// Create Order object
								Customer customer = new Customer(customerName, customerAddress, customerPhone);
								Order newOrder = new Order(orderPrice, orderType, customer);

								MySQLAccess dbAccess = new MySQLAccess();
								boolean success = dbAccess.insertOrderDetails(newOrder);

								if (success) {
									System.out.println("Order created successfully.");
								} else {
									System.out.println("Failed to create Order.");
								}
							} catch (ExceptionHandler e) {
								System.out.println("Error: " + e.getMessage());
							}
							break;

						case "2": // Display Order
							System.out.println("Please enter Order ID to display:");
							int orderIdToDisplay = Integer.parseInt(keyboard.nextLine());

							try {
								MySQLAccess dbAccess = new MySQLAccess();
								Order retrievedOrder = dbAccess.getOrderById(orderIdToDisplay);

								if (retrievedOrder != null) {
									System.out.println("Order Details:");
									System.out.println("Order ID: " + retrievedOrder.getId());
									System.out.println("Order Price: " + retrievedOrder.getOrderPrice());
									System.out.println("Order Type: " + retrievedOrder.getOrderType());
									System.out.println("Customer Name: " + retrievedOrder.getCustomerDetails().getName());
									System.out.println("Order Date: " + retrievedOrder.getOrderDate());
								} else {
									System.out.println("Order not found.");
								}
							} catch (ExceptionHandler e) {
								System.out.println("Error: " + e.getMessage());
							}
							break;

						case "3": // Update Order
							System.out.println("Please enter Order ID to update:");
							int orderIdToUpdate = Integer.parseInt(keyboard.nextLine());

							System.out.println("Please enter new Order Price:");
							double newOrderPrice = Double.parseDouble(keyboard.nextLine());

							System.out.println("Please enter new Order Type:");
							String newOrderType = keyboard.nextLine();

							System.out.println("Please enter new Customer Name:");
							String newCustomerName = keyboard.nextLine();

							System.out.println("Please enter new Customer Address:");
							String newCustomerAddress = keyboard.nextLine();

							System.out.println("Please enter new Customer Phone Number:");
							String newCustomerPhone = keyboard.nextLine();

							try {
								// Create a Customer object with new details
								Customer newCustomer = new Customer(newCustomerName, newCustomerAddress, newCustomerPhone);

								// Convert the current date to SQL Date format for updating the order record
								MySQLAccess dbAccess = new MySQLAccess();
								java.util.Date currentDate = new java.util.Date();
								java.sql.Date sqlOrderDate = new java.sql.Date(currentDate.getTime());
								boolean success = dbAccess.updateOrderDetailsById(orderIdToUpdate, newOrderPrice, newOrderType, newCustomer, sqlOrderDate);



								if (success) {
									System.out.println("Order updated successfully.");
								} else {
									System.out.println("Failed to update Order.");
								}
							} catch (ExceptionHandler e) {
								System.out.println("Error: " + e.getMessage());
							}
							break;

						case "4": // Delete Order
							System.out.println("Please enter Order ID to delete:");
							int orderIdToDelete = Integer.parseInt(keyboard.nextLine());

							try {
								MySQLAccess dbAccess = new MySQLAccess();
								boolean success = dbAccess.deleteOrderById(orderIdToDelete);

								if (success) {
									System.out.println("Order deleted successfully.");
								} else {
									System.out.println("Failed to delete Order.");
								}
							} catch (ExceptionHandler e) {
								System.out.println("Error: " + e.getMessage());
							}
							break;

						case "99": // Return to Main Menu
							orderMenuOpen = false;
							break;

						default:
							System.out.println("No valid option selected.");
						}
					} 
					break;

				case "5": // Invoice Functionality
					boolean invoiceMenuOpen = true;
					while (invoiceMenuOpen) {
						listInvoiceFunctionalityAvailable(); // Show Invoice Submenu
						String invoiceChoice = keyboard.nextLine(); // Take user input

						switch (invoiceChoice) {
						case "1": // Create Invoice
							System.out.println("Creating new Invoice");
							System.out.println("Please enter Invoice Amount:");
							double invoiceAmount = Double.parseDouble(keyboard.nextLine());

							System.out.println("Please enter Customer Name:");
							String customerName = keyboard.nextLine();

							System.out.println("Please enter Customer Address:");
							String customerAddress = keyboard.nextLine();

							System.out.println("Please enter Customer Phone Number:");
							String customerPhone = keyboard.nextLine();

							System.out.println("Please enter Billing Date:");
							String billingDate = keyboard.nextLine();

							try {
								// Create Customer object
								Customer customer = new Customer(customerName, customerAddress, customerPhone);

								// Use MySQLAccess to insert invoice details into the database
								MySQLAccess dbAccess = new MySQLAccess();
								boolean success = dbAccess.insertInvoiceDetails(new Invoice(0, invoiceAmount, customer, billingDate));

								if (success) {
									System.out.println("Invoice created successfully.");
								} else {
									System.out.println("Failed to create invoice.");
								}
							} catch (ExceptionHandler e) {
								System.out.println("Error: " + e.getMessage());
							}
							break;

						case "2": // Read Invoice
							System.out.println("Please enter Invoice ID to display:");
							int invoiceIdToDisplay = Integer.parseInt(keyboard.nextLine());

							try {
								MySQLAccess dbAccess = new MySQLAccess();
								Invoice retrievedInvoice = dbAccess.getInvoiceById(invoiceIdToDisplay);

								if (retrievedInvoice != null) {
									System.out.println("Invoice Details:");
									System.out.println("Invoice ID: " + retrievedInvoice.getId());
									System.out.println("Amount: " + retrievedInvoice.getAmount());
									System.out.println("Customer Name: " + retrievedInvoice.getCustomer().getName());
									System.out.println("Billing Date: " + retrievedInvoice.getBillingDate());
								} else {
									System.out.println("Invoice not found.");
								}
							} catch (Exception e) {
								System.out.println("Error: " + e.getMessage());
							}
							break;

						case "3": // Update Invoice
							System.out.println("Please enter Invoice ID to update:");
							int invoiceIdToUpdate = Integer.parseInt(keyboard.nextLine());

							System.out.println("Please enter new Invoice Amount:");
							double newInvoiceAmount = Double.parseDouble(keyboard.nextLine());

							System.out.println("Please enter new Customer Name:");
							String newCustomerName = keyboard.nextLine();

							System.out.println("Please enter new Customer Address:");
							String newCustomerAddress = keyboard.nextLine();

							System.out.println("Please enter new Customer Phone Number:");
							String newCustomerPhone = keyboard.nextLine();

							System.out.println("Please enter new Billing Date:");
							String newBillingDate = keyboard.nextLine();

							try {
								// Create a Customer object with new details
								Customer newCustomer = new Customer(newCustomerName, newCustomerAddress, newCustomerPhone);

								// Use MySQLAccess object to update the invoice in the database
								MySQLAccess dbAccess = new MySQLAccess();
								boolean success = dbAccess.updateInvoiceDetailsById(invoiceIdToUpdate, newInvoiceAmount, newCustomer, newBillingDate);

								if (success) {
									System.out.println("Invoice updated successfully.");
								} else {
									System.out.println("Failed to update invoice.");
								}
							} catch (ExceptionHandler e) {
								System.out.println("Error: " + e.getMessage());
							}
							break;

						case "4": // Delete Invoice
							System.out.println("Please enter Invoice ID to delete:");
							int invoiceIdToDelete = Integer.parseInt(keyboard.nextLine());

							try {
								MySQLAccess dbAccess = new MySQLAccess();
								boolean success = dbAccess.deleteInvoiceById(invoiceIdToDelete);

								if (success) {
									System.out.println("Invoice deleted successfully.");
								} else {
									System.out.println("Failed to delete invoice.");
								}
							} catch (Exception e) {
								System.out.println("Error: " + e.getMessage());
							}
							break;

						case "99": // Return to Main Menu
							invoiceMenuOpen = false;
							break;

						default:
							System.out.println("No valid option selected.");
						}
					}


				case "6": // Publication Functionality
					boolean publicationMenuOpen = true;
					while (publicationMenuOpen) {
						listPublicationFunctionalityAvailable(); // Show Publication Submenu
						String publicationChoice = keyboard.nextLine(); // Take user input

						switch (publicationChoice) {
						case "1": // Create Customer Account
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
								Publication newPublication = new Publication(pubName, pubPrice, pubQuantity,
										pubFrequency);

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
							System.out.println("Retrieving all publication records...");
							try {
								MySQLAccess dbAccess = new MySQLAccess();

								ResultSet resultSet = dbAccess.retrieveAllPublications();

								if (resultSet != null) {
									System.out.println(
											"------------------------------------------------------------------------------------------------------------------------------------");
									System.out.printf("%10s %20s %20s %30s %20s %n", "ID", "Name", "Price", "Quantity",
											"Frequency");
									System.out.println(
											"------------------------------------------------------------------------------------------------------------------------------------");

									// Iterate through the ResultSet and print each record
									while (resultSet.next()) {
										int id = resultSet.getInt("id");
										String name = resultSet.getString("name");
										String price = resultSet.getString("price");
										String quantity = resultSet.getString("quantity");
										String frequency = resultSet.getString("frequency");

										System.out.printf("%10d  %20s %20s %30s %20s %n", id, name, price, quantity,
												frequency);
									}
									System.out.println(
											"------------------------------------------------------------------------------------------------------------------------------------");
								} else {
									System.out.println("No Publications found.");
								}

							} catch (Exception e) {
								System.out.println("Error retrieving Publications: " + e.getMessage());
							}
							break;
						case "3":
							System.out.println("Please enter the ID of the publicatoin you wish to update:");

							try {
								int publicationId = Integer.parseInt(keyboard.nextLine()); // Convert user input to an
								// integer

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
								boolean success = dbAccess.updatePublicationDetailsById(publicationId, newName,
										newPrice, newQuantity, newFrequency);

								if (success) {
									System.out.println(
											"Publication with ID " + publicationId + " was updated successfully.");
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
							System.out.println(
									"Please enter the ID of the publication you wish to delete (-99 to delete all):");
							int publicationId;

							try {
								publicationId = Integer.parseInt(keyboard.nextLine()); // Convert user input to an
								// integer

								MySQLAccess dbAccess = new MySQLAccess();
								boolean success = dbAccess.deletePublicationById(publicationId);

								if (success) {
									if (publicationId == -99) {
										System.out.println("All publication records were deleted successfully.");
									} else {
										System.out.println(
												"Publication with ID " + publicationId + " was deleted successfully.");
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
							publicationMenuOpen = false; // Return to Main Menu
							break;
						default:
							System.out.println("No valid option selected.");
						}
					}
					break;
					
					
					

				case "7": // delivery person
					boolean deliveryPersonMenuOpen = true;
					MySQLAccess dbAccess = new MySQLAccess();
					while (deliveryPersonMenuOpen) {
						listDeliveryPersonFunctionalityAvailable(); // Show Delivery Person Submenu
						String deliveryPersonChoice = keyboard.nextLine();  // Take user input

						switch (deliveryPersonChoice) {
						case "1": // Create Delivery Person
							try {
								System.out.println("Enter ID Number:");
								String id = keyboard.nextLine();

								System.out.println("Enter Delivery Person's Name:");
								String name = keyboard.nextLine();

								System.out.println("Enter Contact Number:");
								String contactInfo = keyboard.nextLine();

								System.out.println("Enter Assigned Route:");
								String assignedRoute = keyboard.nextLine();

								// Create DeliveryPerson object
								DeliveryPerson deliveryPerson = new DeliveryPerson(id, name, contactInfo, assignedRoute);

								// Call the method

								boolean success = dbAccess.insertDeliveryPersonDetails(deliveryPerson);

								// Handle the result
								if (success) {
									System.out.println("Delivery Person created successfully.");
								} else {
									System.out.println("Error creating Delivery Person.");
								}
							} catch (Exception e) {
								System.out.println("Error: " + e.getMessage());
								e.printStackTrace();
							}
							break;

						case "2": // Read Delivery Persons
							try {
								ResultSet rs = dbAccess.retrieveAllDeliveryPersons();
								printTable(rs, "Delivery Persons");
							} catch (Exception e) {
								System.out.println("Error: " + e.getMessage());
							}
							break;

						case "3": // Update Delivery Person by ID
							try {
								System.out.println("Enter Delivery Person ID to Update:");
								String id = keyboard.nextLine();

								System.out.println("Enter New Name:");
								String newName = keyboard.nextLine();

								System.out.println("Enter New Contact Number:");
								String newContactInfo = keyboard.nextLine();

								System.out.println("Enter New Route:");
								String newAssignedRoute = keyboard.nextLine();

								boolean success = dbAccess.updateDeliveryPersonDetailsById(id, newName, newContactInfo, newAssignedRoute);
								if (success) {
									System.out.println("Delivery Person with ID " + id + " was updated successfully.");
								} else {
									System.out.println("No Delivery Person found with ID " + id + ".");
								}
							} catch (NumberFormatException e) {
								System.out.println("Invalid ID. Please enter a numeric value.");
							} catch (Exception e) {
								System.out.println("Error updating Delivery Person: " + e.getMessage());
							}
							break;

						case "4": // Delete Delivery Person by ID
							try {
								System.out.println("Enter Delivery Person ID to Delete:");
								int id = Integer.parseInt(keyboard.nextLine());

								boolean success = dbAccess.deleteDeliveryPersonById(id);
								if (success) {
									System.out.println("Delivery Person with ID " + id + " was deleted successfully.");
								} else {
									System.out.println("No Delivery Person found with ID " + id + ".");
								}
							} catch (NumberFormatException e) {
								System.out.println("Invalid ID. Please enter a numeric value.");
							} catch (Exception e) {
								System.out.println("Error deleting Delivery Person: " + e.getMessage());
							}
							break;

						case "99":
							deliveryPersonMenuOpen = false;  // Return to Main Menu
							break;
						default:
							System.out.println("No valid option selected.");
						}
					}
					break;





				case "8": // Warning Functionality
					boolean warningMenuOpen = true;
					MySQLAccess dbAccess1 = new MySQLAccess(); // Ensure consistent database access
					while (warningMenuOpen) {
						listWarningsFunctionalityAvailable(); // Show Warnings 
						String warningChoice = keyboard.nextLine(); // Take user input

						boolean success1 = false; // Declare 'success' variable here, outside the switch

						switch (warningChoice) {
						case "1": // Create Warning
							try {
								System.out.println("Enter Warning Id:");
								String id = keyboard.nextLine();

								System.out.println("Enter Warning Reason:");
								String reason = keyboard.nextLine();

								System.out.println("Enter Warning Status:");
								String status = keyboard.nextLine();

								System.out.println("Enter Delivery Person ID:");
								String deliveryPersonId = keyboard.nextLine();

								System.out.println("Enter Date Issued (yyyy-MM-dd):");
								String dateIssued = keyboard.nextLine(); // Treat as String

								Warnings warning = new Warnings(id, reason, status, deliveryPersonId, dateIssued);
								boolean success = dbAccess1.insertWarningDetails(warning);


								if (success
										) {
									System.out.println("Warning created successfully.");
								} else {
									System.out.println("Error creating Warning.");
								}
							} catch (Exception e) {
								System.out.println("Error: " + e.getMessage());
							}
							break;

						case "2": // Read Warnings
							try {
								ResultSet rs = dbAccess1.retrieveAllWarnings();
								if (rs != null && rs.isBeforeFirst()) { // Check if ResultSet has data
									printTable(rs, "Warnings");
								} else {
									System.out.println("No warnings found in the database.");
								}
							} catch (Exception e) {
								System.out.println("Error: " + e.getMessage());
								e.printStackTrace();
							}
							break;



						case "3": // Update Warning by ID
							try {
								System.out.println("Enter Warning ID to Update:");
								String warningId = keyboard.nextLine();

								System.out.println("Enter New Warning Reason:");
								String newReason = keyboard.nextLine();

								System.out.println("Enter New Warning Status:");
								String newStatus = keyboard.nextLine();

								System.out.println("Enter New Delivery Person ID:");
								String newDeliveryPersonId = keyboard.nextLine();

								System.out.println("Enter New Date Issued (yyyy-MM-dd):");
								String newDateIssued = keyboard.nextLine();

								// Attempt to update the warning
								boolean success = dbAccess1.updateWarningDetailsById(warningId, newReason, newStatus, newDeliveryPersonId, newDateIssued);

								// Provide feedback
								if (success) {
									System.out.println("Warning with ID " + warningId + " was updated successfully.");
								} else {
									System.out.println("Error updating Warning with ID " + warningId + ". Please check the inputs or ID.");
								}
							} catch (Exception e) {
								System.out.println("Error updating Warning: " + e.getMessage());
								e.printStackTrace();
							}
							break;


						case "4": // Delete Warning by ID
							try {
								System.out.println("Enter Warning ID to Delete (enter -99 to delete all warnings):");
								String id = keyboard.nextLine(); // Read input as String

								success1 = dbAccess1.deleteWarningById(id);

								if (success1) {
									if ("-99".equals(id)) {
										System.out.println("All warnings were deleted successfully.");
									} else {
										System.out.println("Warning with ID " + id + " was deleted successfully.");
									}
								} else {
									if ("-99".equals(id)) {
										System.out.println("Error deleting all warnings.");
									} else {
										System.out.println("Error deleting Warning with ID " + id + ".");
									}
								}
							} catch (Exception e) {
								System.out.println("Error deleting Warning: " + e.getMessage());
							}
							break;



						case "99":
							warningMenuOpen = false;  // Return to Main Menu
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

			keyboard.close();
		} catch (Exception e) {
			System.out.println("PROGRAM TERMINATED - ERROR MESSAGE:" + e.getMessage());
		} // end try-catch

	} // end main



	public static void printTable(ResultSet rs, String tableName) {
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			// Print Table Header
			System.out.println("Table: " + tableName);
			for (int i = 1; i <= columnCount; i++) {
				System.out.printf("%-20s", metaData.getColumnLabel(i));
			}
			System.out.println();

			// Print Rows
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.printf("%-20s", rs.getString(i));
				}
				System.out.println();
			}
			System.out.println("=".repeat(80));
		} catch (Exception e) {
			System.out.println("Error printing table: " + e.getMessage());
		}
	}





}