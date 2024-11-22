package deliveryAreaPackage;

import MySQLAccessPackage.MySQLAccess.DeliveryWarningHandler;
import exceptionHandlerPackage.ExceptionHandler;

public class DeliveryArea {
	
	private int id;
	private String name;
	private String des;
	private String Driver_id;
	
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getDriver_id() {
		return Driver_id;
	}

	public void setDriver_id(String driver_id) {
		Driver_id = driver_id;
	}

	public DeliveryArea(String areaName, String areaDes, String areaDriver_id) throws ExceptionHandler  {
		
		id = 0;
		
		// Validate Input
		try {
			
			validateName(areaName);
			validateDes(areaDes);
			validateID(areaDriver_id);
			
		}
		catch (ExceptionHandler e) {
			throw e;
		}
		
		// Set Attributes
		name = areaName;
		des = areaDes;
		Driver_id = areaDriver_id;
	}
	
	public static void validateName(String areaName) throws ExceptionHandler {
		
		//Agree Formating Rules on "Customer Name"
		//E.G. Name String must be a minimum of 2 characters and a maximum of 50 characters
		
		if (areaName.isBlank() || areaName.isEmpty())
			throw new ExceptionHandler("Area Name NOT specified");
		else if (areaName.length() < 2)
			throw new ExceptionHandler("Area Name does not meet minimum length requirements");
		else if (areaName.length() > 50)
			throw new ExceptionHandler("Area Name exceeds maximum length requirements");
		
	}
	
	public static void validateDes(String areaDes) throws ExceptionHandler {
		
		//Agree Formating Rules on "Customer Address"
		//E.G. Name String must be a minimum of 5 characters and a maximum of 60 characters
		
		if (areaDes.isBlank() || areaDes.isEmpty())
			throw new ExceptionHandler("Area Description NOT specified");
		else if (areaDes.length() < 5)
			throw new ExceptionHandler("Area Description does not meet minimum length requirements");
		else if (areaDes.length() > 60)
			throw new ExceptionHandler("Area Description Address exceeds maximum length requirements");
		
	}
	
	public static void validateID(String Driver_id) throws ExceptionHandler {
		
		//Agree Formating Rules on "Customer PhoneNumber"
		//E.G. Name String must be a minimum of 7 characters and a maximum of 15 characters
		
		
		//DeliveryWarningHandler.checkforDeliveryPersonId(Driver_id);
//		return false;
//		if (custPhone.isBlank() || custPhone.isEmpty())
//			throw new ExceptionHandler("Customer PhoneNumber NOT specified");
//		else if (custPhone.length() < 7)
//			throw new ExceptionHandler("Customer PhoneNumber does not meet minimum length requirements");
//		else if (custPhone.length() > 15)
//			throw new ExceptionHandler("Customer PhoneNumber does not exceeds maximum length requirements");
//		
	}
	

}

