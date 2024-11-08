package customerPackage;

import exceptionHandlerPackage.ExceptionHandler;

public class Customer {
	
	private int id;
	private String name;
	private String address;
	private String phoneNumber;
	
	public void setId(int custId) {
		id = custId;
	}
	
	public void setName(String custName) {
		name = custName;
	}
	
	public void setAddress(String custAddr) {
		address = custAddr;
	}
	
	public void setPhoneNumber(String custPhone) {
		phoneNumber = custPhone;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
		
	}
	
	public Customer(String custName, String custAddr, String custPhone) throws ExceptionHandler  {
		
		id = 0;
		
		// Validate Input
		try {
			
			validateName(custName);
			validateAddress(custAddr);
			validatePhoneNumber(custPhone);
			
		}
		catch (ExceptionHandler e) {
			throw e;
		}
		
		// Set Attributes
		name = custName;
		address = custAddr;
		phoneNumber = custPhone;
	}
	
	public static void validateName(String custName) throws ExceptionHandler {
		
		//Agree Formating Rules on "Customer Name"
		//E.G. Name String must be a minimum of 2 characters and a maximum of 50 characters
		
		if (custName.isBlank() || custName.isEmpty())
			throw new ExceptionHandler("Customer Name NOT specified");
		else if (custName.length() < 2)
			throw new ExceptionHandler("Customer Name does not meet minimum length requirements");
		else if (custName.length() > 50)
			throw new ExceptionHandler("Customer Name exceeds maximum length requirements");
		
	}
	
	public static void validateAddress(String custAddr) throws ExceptionHandler {
		
		//Agree Formating Rules on "Customer Address"
		//E.G. Name String must be a minimum of 5 characters and a maximum of 60 characters
		
		if (custAddr.isBlank() || custAddr.isEmpty())
			throw new ExceptionHandler("Customer Address NOT specified");
		else if (custAddr.length() < 5)
			throw new ExceptionHandler("Customer Address does not meet minimum length requirements");
		else if (custAddr.length() > 60)
			throw new ExceptionHandler("Customer Address exceeds maximum length requirements");
		
	}
	
	public static void validatePhoneNumber(String custPhone) throws ExceptionHandler {
		
		//Agree Formating Rules on "Customer PhoneNumber"
		//E.G. Name String must be a minimum of 7 characters and a maximum of 15 characters
		
		if (custPhone.isBlank() || custPhone.isEmpty())
			throw new ExceptionHandler("Customer PhoneNumber NOT specified");
		else if (custPhone.length() < 7)
			throw new ExceptionHandler("Customer PhoneNumber does not meet minimum length requirements");
		else if (custPhone.length() > 15)
			throw new ExceptionHandler("Customer PhoneNumber does not exceeds maximum length requirements");
		
	}
	

}

