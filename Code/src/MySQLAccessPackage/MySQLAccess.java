package MySQLAccessPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import customerPackage.Customer;
import newsAgentPackage.NewsAgent;

import java.sql.ResultSet;


public class MySQLAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host ="localhost:3306";
	final private String user = "root";
	final private String password = "admin";
	
	
	public MySQLAccess() throws Exception {
		
		try {
			
			//Load MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Setup the connection with the DB
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


}// end Class


