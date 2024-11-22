package MySQLAccessPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import customerPackage.Customer;
import deliveryAreaPackage.DeliveryArea;
import deliveryDocketPackage.DeliveryDocket;
import deliveryPersonPackage.DeliveryPerson;

import java.sql.Date;

import invoicePackage.Invoice;
import newsAgentPackage.NewsAgent;
import warningsPackage.Warnings;
import ordersPackage.Order;
import publicationPackage.Publication;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MySQLAccess {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	final private String host ="localhost:3306";//"localhost:3306"
	final private String user = "root";
	final private String password = "admin";


	public MySQLAccess() throws Exception {

		try {

			//Load MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/?user=root");
			//connect = DriverManager.getConnection("jdbc:mysql://" + host + "/newsagentapp?" + "user=" + user + "&password=" + password);
		}
		catch (Exception e) {
			throw e;
		}


	}

	// Method to sign up a new user by adding them to the database
	public boolean signUpUser(NewsAgent na) {
		boolean insertSucessfull = true;
		try {
			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("INSERT INTO newsagentApp.users (username, password) VALUES (?, ?)");
			preparedStatement.setString(1, na.getUserName());
			preparedStatement.setString(2, na.getPassWord()); 
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			insertSucessfull = false;
		}
		return insertSucessfull;
	} // end signUpUser

	// Method to log in a user by validating their credentials
	public boolean logInUser(String username, String password) {
		boolean logInSucessfull = true;
		try {
			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("SELECT * FROM newsagentApp.users WHERE username = ? AND password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.executeQuery();
		} catch (Exception e) {
			logInSucessfull = false;
		}
		return logInSucessfull;
	} // End logInUser

	public boolean insertCustomerDetailsAccount(Customer c) {

		boolean insertSucessfull = true;

		//Add Code here to call embedded SQL to insert Customer into DB

		try {

			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("insert into newsagentApp.customer values (default, ?, ?, ?)");
			preparedStatement.setString(1, c.getName());
			preparedStatement.setString(2, c.getAddress());
			preparedStatement.setString(3, c.getPhoneNumber());
			preparedStatement.executeUpdate();


		}
		catch (Exception e) {
			insertSucessfull = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return insertSucessfull;

	}// end insertCustomerDetailsAccount

	public boolean updateCustomerDetailsById(int custId, String newName, String newAddress, String newPhoneNumber) {

		boolean insertSucessfull = true;

		//Add Code here to call embedded SQL to update Customer

		try {

			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("update newsagentApp.customer SET name = ?, address = ?, phoneNumber = ? WHERE id = ?");
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, newAddress);
			preparedStatement.setString(3, newPhoneNumber);
			preparedStatement.setInt(4, custId);
			preparedStatement.executeUpdate();


		}
		catch (Exception e) {
			insertSucessfull = false;
		}

		return insertSucessfull;

	}// end updateCustomerDetailsById

	public ResultSet retrieveAllCustomerAccounts() {

		//Add Code here to call embedded SQL to view Customer Details

		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("Select * from newsagentApp.customer");

		}
		catch (Exception e) {
			resultSet = null;
		}
		return resultSet;
	}

	public boolean deleteCustomerById(int custID) {

		boolean deleteSucessfull = true;

		//Add Code here to call embedded SQL to insert Customer into DB

		try {

			//Create prepared statement to issue SQL query to the database
			if (custID == -99)
				//Delete all entries in Table
				preparedStatement = connect.prepareStatement("delete from newsagentApp.customer");
			else
				//Delete a particular Customer
				preparedStatement = connect.prepareStatement("delete from newsagentApp.customer where id = " + custID);
			preparedStatement.executeUpdate();

		}
		catch (Exception e) {
			deleteSucessfull = false;
		}

		return deleteSucessfull;

	}
	
	
	public boolean deleteDocketById(int docketId) {

		boolean deleteSucessfull = true;

		//Add Code here to call embedded SQL to insert Customer into DB

		try {

			//Create prepared statement to issue SQL query to the database
			if (docketId == -99)
				//Delete all entries in Table
				preparedStatement = connect.prepareStatement("delete from newsagentApp.delivery_docket");
			else
				//Delete a particular Customer
				preparedStatement = connect.prepareStatement("delete from newsagentApp.delivery_docket where id = " + docketId);
			preparedStatement.executeUpdate();

		}
		catch (Exception e) {
			deleteSucessfull = false;
		}

		return deleteSucessfull;

	}
	//////////////////////////////Publication Zone////////////////////////////////////////////
	public boolean insertPublicationDetailsAccount(Publication p) {

		boolean insertSucessfull = true;

		//Add Code here to call embedded SQL to insert Customer into DB

		try {

			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("insert into newsagentApp.publication values (default, ?, ?, ?, ?)");
			preparedStatement.setString(1, p.getName());
			preparedStatement.setString(2, p.getPrice());
			preparedStatement.setString(3, p.getQuantity());
			preparedStatement.setString(4, p.getFrequency());
			preparedStatement.executeUpdate();


		}
		catch (Exception e) {
			insertSucessfull = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return insertSucessfull;

	}// end insertPublicationDetails

	public boolean updatePublicationDetailsById(int pubId, String newName, String newPrice, String newQuantity, String newFrequency) {

		boolean insertSucessfull = true;

		//Add Code here to call embedded SQL to update Publication

		try {

			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("update newsagentApp.publication SET name = ?, price = ?, quantity = ?, frequency = ? WHERE id = ?");
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, newPrice);
			preparedStatement.setString(3, newQuantity);
			preparedStatement.setString(4, newFrequency);
			preparedStatement.setInt(5, pubId);
			preparedStatement.executeUpdate();


		}
		catch (Exception e) {
			insertSucessfull = false;
		}

		return insertSucessfull;

	}// end updateCustomerDetailsById

	public ResultSet retrieveAllPublications() {

		//Add Code here to call embedded SQL to view Publications Details

		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("Select * from newsagentApp.publication");

		}
		catch (Exception e) {
			resultSet = null;
		}
		return resultSet;
	}

	public boolean deletePublicationById(int pubID) {

		boolean deleteSucessfull = true;

		//Add Code here to call embedded SQL to insert Publication into DB

		try {

			//Create prepared statement to issue SQL query to the database
			if (pubID == -99)
				//Delete all entries in Table
				preparedStatement = connect.prepareStatement("delete from newsagentApp.publication");
			else
				//Delete a particular Customer
				preparedStatement = connect.prepareStatement("delete from newsagentApp.publication where id = " + pubID);
			preparedStatement.executeUpdate();

		}
		catch (Exception e) {
			deleteSucessfull = false;
		}

		return deleteSucessfull;



	}

	//////////////////////////////Orders/Invoices Zone////////////////////////////////////////////
	// Create - Insert Order Details
	public boolean insertOrderDetails(Order o) {
		boolean insertSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement("INSERT INTO newsagentApp.orders (price, type, customer_name, customer_address, order_date) VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setDouble(1, o.getOrderPrice());
			preparedStatement.setString(2, o.getOrderType());
			preparedStatement.setString(3, o.getCustomerDetails().getName());
			preparedStatement.setString(4, o.getCustomerDetails().getAddress());
			preparedStatement.setDate(5, new java.sql.Date(o.getOrderDate().getTime()));
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			insertSuccessful = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return insertSuccessful;
	}

	// Read - Get Order by ID
	public Order getOrderById(int orderId) {
		Order order = null;

		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM newsagentApp.orders WHERE id = ?");
			preparedStatement.setInt(1, orderId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				double price = resultSet.getDouble("price");
				String type = resultSet.getString("type");
				String customerName = resultSet.getString("customer_name");
				String customerAddress = resultSet.getString("customer_address");
				String customerPhone = resultSet.getString("customer_phone");

				// Convert java.sql.Date to java.util.Date
				Date sqlDate = resultSet.getDate("order_date");
				java.util.Date orderDate = new java.util.Date(sqlDate.getTime());

				Customer customer = new Customer(customerName, customerAddress, customerPhone);
				order = new Order(price, type, customer);
				order.setId(orderId);
				order.setDate(orderDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return order;
	}


	// Read - Retrieve All Orders
	public ResultSet retrieveAllOrders() {
		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM newsagentApp.orders");
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			resultSet = null;
			e.printStackTrace();
		}
		return resultSet;
	}

	// Update - Update Order Details by ID
	public boolean updateOrderDetailsById(int orderId, double newPrice, String newType, Customer newCustomer, Date newDate) {
		boolean updateSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement("UPDATE newsagentApp.orders SET price = ?, type = ?, customer_name = ?, customer_address = ?, customer_phone = ?, order_date = ? WHERE id = ?");
			preparedStatement.setDouble(1, newPrice);
			preparedStatement.setString(2, newType);
			preparedStatement.setString(3, newCustomer.getName());
			preparedStatement.setString(4, newCustomer.getAddress());
			preparedStatement.setString(5, newCustomer.getPhoneNumber());
			preparedStatement.setString(6, newDate.toString());
			preparedStatement.setInt(7, orderId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			updateSuccessful = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return updateSuccessful;
	}

	// Delete - Delete Order by ID
	public boolean deleteOrderById(int orderId) {
		boolean deleteSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement("DELETE FROM newsagentApp.orders WHERE id = ?");
			preparedStatement.setInt(1, orderId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			deleteSuccessful = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return deleteSuccessful;
	}

	// Create - Insert Invoice Details
	public boolean insertInvoiceDetails(Invoice i) {
		boolean insertSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement("INSERT INTO newsagentApp.invoices VALUES (default, ?, ?, ?, ?)");
			preparedStatement.setDouble(1, i.getAmount());
			preparedStatement.setString(2, i.getCustomer().getName());
			preparedStatement.setString(3, i.getCustomer().getAddress());
			preparedStatement.setString(4, i.getBillingDate());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			insertSuccessful = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return insertSuccessful;
	}

	// Read - Get Invoice by ID
	public Invoice getInvoiceById(int invoiceId) {
		Invoice invoice = null;

		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM newsagentApp.invoices WHERE id = ?");
			preparedStatement.setInt(1, invoiceId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				double amount = resultSet.getDouble("amount");
				String customerName = resultSet.getString("customer_name");
				String customerAddress = resultSet.getString("customer_address");
				String billingDate = resultSet.getString("billing_date");

				Customer customer = new Customer(customerName, customerAddress, resultSet.getString("customer_phone"));
				invoice = new Invoice(invoiceId, amount, customer, billingDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return invoice;
	}

	// Read - Retrieve All Invoices
	public ResultSet retrieveAllInvoices() {
		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM newsagentApp.invoices");
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			resultSet = null;
			e.printStackTrace();
		}
		return resultSet;
	}

	// Update - Update Invoice Details by ID
	public boolean updateInvoiceDetailsById(int invoiceId, double newAmount, Customer newCustomer, String newBillingDate) {
		boolean updateSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement("UPDATE newsagentApp.invoices SET amount = ?, customer_name = ?, customer_address = ?, billing_date = ? WHERE id = ?");
			preparedStatement.setDouble(1, newAmount);
			preparedStatement.setString(2, newCustomer.getName());
			preparedStatement.setString(3, newCustomer.getAddress());
			preparedStatement.setString(4, newBillingDate);
			preparedStatement.setInt(5, invoiceId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			updateSuccessful = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return updateSuccessful;
	}

	// Delete - Delete Invoice by ID
	public boolean deleteInvoiceById(int invoiceId) {
		boolean deleteSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement("DELETE FROM newsagentApp.invoices WHERE id = ?");
			preparedStatement.setInt(1, invoiceId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			deleteSuccessful = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return deleteSuccessful;
	}

	//////////////////////////////Warnings/DeliveryPerson Zone////////////////////////////////////////////
	public class DeliveryWarningHandler {
		private Connection connect;
		private PreparedStatement preparedStatement;
		private Statement statement;
		private ResultSet resultSet;

		// Insert DeliveryPerson Details		
		public boolean insertDeliveryPersonDetails(DeliveryPerson deliveryPerson) {

			boolean insertSuccessful = true;
			try {
				preparedStatement = connect.prepareStatement(
						"INSERT INTO newsagentApp.delivery_person (id, name, contactInfo, assignedRoute) VALUES (?, ?, ?,?)");
				preparedStatement.setString(1, deliveryPerson.getId());

				preparedStatement.setString(2, deliveryPerson.getName());
				preparedStatement.setString(3, deliveryPerson.getContactInfo());
				preparedStatement.setString(4, deliveryPerson.getAssignedRoute());
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				insertSuccessful = false;
				e.printStackTrace();
				System.out.print(e.getMessage());
			}
			return insertSuccessful;

		}}

	public ResultSet retrieveAllDeliveryPersons() {
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM newsagentApp.delivery_person");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public boolean checkforDeliveryPersonId(String id) {
		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM newsagentApp.delivery_person WHERE id = ?");
			preparedStatement.setString(1, id);
			statement.executeQuery("SELECT * FROM newsagentApp.delivery_person WHERE id = ?");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Update DeliveryPerson Details by ID
	public boolean updateDeliveryPersonDetailsById(String id, String newName, String newContactInfo, String newAssignedRoute) {
		boolean updateSuccessful = true;
		try {
			preparedStatement = connect.prepareStatement(
					"UPDATE newsagentApp.delivery_person SET name = ?, contactInfo = ?, assignedRoute = ? WHERE id = ?");
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, newContactInfo);
			preparedStatement.setString(3, newAssignedRoute);
			preparedStatement.setString(4, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			updateSuccessful = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return updateSuccessful;
	}

	// Delete DeliveryPerson by ID or all if -99
	public boolean deleteDeliveryPersonById(int personId) {
		boolean deleteSuccessful = true;
		try {
			preparedStatement = personId == -99
					? connect.prepareStatement("DELETE FROM newsagentApp.delivery_person")
							: connect.prepareStatement("DELETE FROM newsagentApp.delivery_person WHERE id = ?");
			if (personId != -99) preparedStatement.setInt(1, personId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			deleteSuccessful = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return deleteSuccessful;
	}

	public boolean updateWarningDetailsById(String warningId, String newReason, String newStatus,
			String newDeliveryPersonId, String newDateIssued) {

		boolean updateSuccessful = true;
		try {
			// Correct the parameter order to match the query
			preparedStatement = connect.prepareStatement(
					"UPDATE newsagentApp.warning SET warning_reason = ?, warning_status = ?, delivery_person_id = ?, date_issued = ? WHERE warning_id = ?");

			// Set the parameters in the correct order
			preparedStatement.setString(1, newReason);            // warning_reason
			preparedStatement.setString(2, newStatus);            // warning_status
			preparedStatement.setString(3, newDeliveryPersonId);  // delivery_person_id
			preparedStatement.setString(4, newDateIssued);        // date_issued
			preparedStatement.setString(5, warningId);            // warning_id (WHERE clause)

			// Execute update
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected == 0) {
				updateSuccessful = false; // No rows were updated
			}
		} catch (Exception e) {
			updateSuccessful = false;
			e.printStackTrace();
		}
		return updateSuccessful;
	}


	public ResultSet retrieveAllWarnings() {
		{
			try {
				statement = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				resultSet = statement.executeQuery("SELECT * FROM newsagentApp.warning");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return resultSet;
		}
		// TODO Auto-generated method stub
	}

	public boolean insertWarningDetails(Warnings warning) {
		{
			boolean insertSuccessful = true;
			try {
				// Fix: Ensure query has 5 placeholders for 5 parameters
				preparedStatement = connect.prepareStatement(
						"INSERT INTO newsagentapp.warning (warning_Id, warning_reason, warning_status, delivery_person_id, date_issued) VALUES (?, ?, ?, ?, ?)"
						);
				// Set the 5 parameters correctly
				preparedStatement.setString(1, warning.getWarningId());
				preparedStatement.setString(2, warning.getWarningReason());
				preparedStatement.setString(3, warning.getWarningStatus());
				preparedStatement.setString(4, warning.getDeliveryPersonId());
				preparedStatement.setString(5, warning.getDateIssued()); // Treat dateIssued as a String

				preparedStatement.executeUpdate();
			} catch (Exception e) {
				insertSuccessful = false;
				e.printStackTrace();
			}
			return insertSuccessful;
		}
		// TODO Auto-generated method stub
	}

	public boolean deleteWarningById(String id) {
		{
			boolean deleteSuccessful = true;
			try {
				if ("-99".equals(id)) {
					// Special case: Delete all warnings
					preparedStatement = connect.prepareStatement("DELETE FROM newsagentApp.warning");
				} else {
					// Delete a specific warning
					preparedStatement = connect.prepareStatement("DELETE FROM newsagentApp.warning WHERE warning_id = ?");
					preparedStatement.setString(1, id);
				}
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				deleteSuccessful = false;
				e.printStackTrace();
			}
			return deleteSuccessful;
		}
		// TODO Auto-generated method stub
	}

	public boolean insertDeliveryPersonDetails(DeliveryPerson deliveryPerson)  {

		boolean insertSuccessful = true;
		try {
			preparedStatement = connect.prepareStatement(
					"INSERT INTO newsagentApp.delivery_person (id, name, contact_info, assigned_route) VALUES (?, ?, ?,?)");
			preparedStatement.setString(1, deliveryPerson.getId());

			preparedStatement.setString(2, deliveryPerson.getName());
			preparedStatement.setString(3, deliveryPerson.getContactInfo());
			preparedStatement.setString(4, deliveryPerson.getAssignedRoute());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			insertSuccessful = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return insertSuccessful;

	}
	
    // Method to insert delivery docket into the database
    public boolean insertDeliveryDocket(DeliveryDocket docket) {
    	boolean insertSuccessfull = true;
        try {
        	preparedStatement = connect.prepareStatement("INSERT INTO newsagentApp.delivery_docket (deliveryDate, deliveryArea, deliveryPerson, publicationIds, customer) VALUES (?, ?, ?, ?, ?)");
        	preparedStatement.setString(1, docket.getDeliveryDate());
        	preparedStatement.setString(2, docket.getDeliveryArea());
        	preparedStatement.setString(3, docket.getDeliveryPerson());
            preparedStatement.setString(4, docket.getPublicationIds());
            preparedStatement.setString(5, docket.getCustomer());
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
        	insertSuccessfull = false;
            System.out.println("Error creating Delivery Docket: " + e.getMessage());
        }
        return insertSuccessfull;
    }

    // Method to read all the dockets from the database
    public ResultSet retrieveAllDeliveryDockets() {
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM newsagentApp.delivery_docket");
        } catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
            return resultSet = null;
        }
        return resultSet;
    }

    // Method to update delivery docket by id
    public boolean updateDeliveryDocketById(int docketId, String newDeliveryDate, String newDeliveryArea, String newDeliveryPerson, String newPublicationIds, String newCustomer) {
    	boolean insertSuccessfull = true;
    	try {
        	preparedStatement = connect.prepareStatement("UPDATE newsagentApp.delivery_docket SET deliveryDate = ?, deliveryArea = ?, deliveryPerson = ?, publicationIds = ?, customer = ? WHERE docketId = ?");
        	preparedStatement.setString(1, newDeliveryDate);
        	preparedStatement.setString(2, newDeliveryArea);
        	preparedStatement.setString(3, newDeliveryPerson);
            preparedStatement.setString(4, newPublicationIds); 
            preparedStatement.setString(5, newCustomer);
            preparedStatement.setInt(6, docketId);
            preparedStatement.executeUpdate();
           
        } catch (Exception e) {
        	insertSuccessfull = false;
            System.out.println("Error updating Delivery Docket: " + e.getMessage());
        }
    	return insertSuccessfull;
    }

    // Method to delete a delivery docket by ID
    public boolean deleteDeliveryDocketById(int docketId) {
    	boolean deleteSuccessfull = true;
        try {
        	if (docketId == -99) {
        		preparedStatement = connect.prepareStatement("DELETE * FROM newsagentApp.delivery_docket");	
        	} else {
        		preparedStatement = connect.prepareStatement("DELETE FROM newsagentApp.delivery_docket WHERE docketId = " + docketId);
        	}
        		
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error deleting Delivery Docket: " + e.getMessage());
            deleteSuccessfull = false;
        }
        return deleteSuccessfull;
    }
    
    
    
    public boolean insertArea(DeliveryArea d) {

		boolean insertSucessfull = true;

		//Add Code here to call embedded SQL to insert Customer into DB

		try {

			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("insert into newsagentApp.areas values (default, ?, ?, ?)");
			preparedStatement.setString(1, d.getName());
			preparedStatement.setString(2, d.getDes());
			preparedStatement.setString(3, d.getDriver_id());
			preparedStatement.executeUpdate();


		}
		catch (Exception e) {
			insertSucessfull = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return insertSucessfull;

	}// end insertCustomerDetailsAccount

	public boolean updateAreaById(int areaId, String newName, String newDes, String newDriver) {

		boolean insertSucessfull = true;

		//Add Code here to call embedded SQL to update Customer

		try {

			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("update newsagentApp.areas SET name = ?, Description = ?, Driver_ID = ? WHERE id = ?");
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, newDes);
			preparedStatement.setString(3, newDriver);
			preparedStatement.setInt(4, areaId);
			preparedStatement.executeUpdate();


		}
		catch (Exception e) {
			insertSucessfull = false;
		}

		return insertSucessfull;

	}// end updateareaById

	public ResultSet retrieveAllAreas() {

		//Add Code here to call embedded SQL to view Area Details

		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("Select * from newsagentApp.areas");

		}
		catch (Exception e) {
			resultSet = null;
		}
		return resultSet;
	}

	public boolean deleteAreaById(int areaID) {

		boolean deleteSucessfull = true;

		//Add Code here to call embedded SQL to insert Customer into DB

		try {

			//Create prepared statement to issue SQL query to the database
			if (areaID == -99)
				//Delete all entries in Table
				preparedStatement = connect.prepareStatement("delete from newsagentApp.areas");
			else
				//Delete a particular Customer
				preparedStatement = connect.prepareStatement("delete from newsagentApp.areas where id = " + areaID);
			preparedStatement.executeUpdate();

		}
		catch (Exception e) {
			deleteSucessfull = false;
		}

		return deleteSucessfull;

	}
	

}


