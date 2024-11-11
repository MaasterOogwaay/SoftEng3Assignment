package MySQLAccessPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import customerPackage.Customer;
import deliveryPersonPackage.DeliveryPerson;
import publicationPackage.Publication;
import warningsPackage.Warnings;
import newsAgentPackage.NewsAgent;

import java.sql.ResultSet;


public class MySQLAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host ="localhost:3306";//"localhost:3307"
	final private String user = "root";
	final private String password = "admin";
	
	
	public MySQLAccess() throws Exception {
		
		try {
			
			//Load MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Setup the connection with the DB
			//connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/?user=root");
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/newsagentapp?" + "user=" + user + "&password=" + password);
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
            preparedStatement = connect.prepareStatement("INSERT INTO newsagentApp.orders VALUES (default, ?, ?, ?, ?)");
            preparedStatement.setDouble(1, o.getOrderPrice());
            preparedStatement.setString(2, o.getOrderType());
            preparedStatement.setString(3, o.getCustomerDetails().getName());
            preparedStatement.setString(4, o.getOrderDate().toString());
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
                Date orderDate = resultSet.getDate("order_date");

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
}
	//////////////////////////////Warnings/DeliveryPerson Zone////////////////////////////////////////////

	public boolean insertDeliveryPersonDetails(DeliveryPerson d) {
		boolean insertSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement("INSERT INTO newsagentApp.delivery_person VALUES (default, ?, ?, ?)");
			preparedStatement.setString(1, d.getName());
			preparedStatement.setString(2, d.getContactInfo());
			preparedStatement.setString(3, d.getAssignedRoute());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			insertSuccessful = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return insertSuccessful;
	}

	// Insert Warning details
	public boolean insertWarningDetails(Warnings w) {
		boolean insertSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement("INSERT INTO newsagentApp.warning VALUES (default, ?, ?, ?)");
			preparedStatement.setInt(1, w.getCustomerId());
			preparedStatement.setString(2, w.getReason());
			preparedStatement.setTimestamp(3, w.getDateIssued());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			insertSuccessful = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return insertSuccessful;
	}

	// READ Operations

	// Retrieve all DeliveryPersons
	public ResultSet retrieveAllDeliveryPersons() {
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM newsagentApp.delivery_person");

		} catch (Exception e) {
			resultSet = null;
			e.printStackTrace();
		}
		return resultSet;
	}

	// Retrieve all Warnings
	public ResultSet retrieveAllWarnings() {
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM newsagentApp.warning");

		} catch (Exception e) {
			resultSet = null;
			e.printStackTrace();
		}
		return resultSet;
	}

	// UPDATE Operations

	// Update DeliveryPerson details by ID
	public boolean updateDeliveryPersonDetailsById(int personId, String newName, String newPhone, String newRoute) {
		boolean updateSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement("UPDATE newsagentApp.delivery_person SET name = ?, phone = ?, route = ? WHERE id = ?");
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, newPhone);
			preparedStatement.setString(3, newRoute);
			preparedStatement.setInt(4, personId);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			updateSuccessful = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return updateSuccessful;
	}

	// Update Warning details by ID
	public boolean updateWarningDetailsById(int warningId, int newCustomerId, String newReason, Timestamp newDateIssued) {
		boolean updateSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement("UPDATE newsagentApp.warning SET customer_id = ?, reason = ?, date_issued = ? WHERE id = ?");
			preparedStatement.setInt(1, newCustomerId);
			preparedStatement.setString(2, newReason);
			preparedStatement.setTimestamp(3, newDateIssued);
			preparedStatement.setInt(4, warningId);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			updateSuccessful = false;
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

		return updateSuccessful;
	}

	// DELETE Operations

	// Delete DeliveryPerson by ID
	public boolean deleteDeliveryPersonById(int personId) {
		boolean deleteSuccessful = true;

		try {
			if (personId == -99) {
				preparedStatement = connect.prepareStatement("DELETE FROM newsagentApp.delivery_person");
			} else {
				preparedStatement = connect.prepareStatement("DELETE FROM newsagentApp.delivery_person WHERE id = ?");
				preparedStatement.setInt(1, personId);
			}
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			deleteSuccessful = false;
			e.printStackTrace();
		}

		return deleteSuccessful;
	}

	// Delete Warning by ID
	public boolean deleteWarningById(int warningId) {
		boolean deleteSuccessful = true;

		try {
			if (warningId == -99) {
				preparedStatement = connect.prepareStatement("DELETE FROM newsagentApp.warning");
			} else {
				preparedStatement = connect.prepareStatement("DELETE FROM newsagentApp.warning WHERE id = ?");
				preparedStatement.setInt(1, warningId);
			}
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			deleteSuccessful = false;
			e.printStackTrace();
		}

		return deleteSuccessful;
	}

}// end Class


