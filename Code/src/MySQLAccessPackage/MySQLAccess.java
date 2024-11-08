package MySQLAccessPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import customerPackage.Customer;
<<<<<<< HEAD
import publicationPackage.Publication;
=======
import newsAgentPackage.NewsAgent;
>>>>>>> 88875a8a75292214151fe546f7b05b06c245f50f

import java.sql.ResultSet;


public class MySQLAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host ="localhost:3306";//"localhost:3307"
	final private String user = "root";
	final private String password = "";
	
	
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
	


}// end Class


