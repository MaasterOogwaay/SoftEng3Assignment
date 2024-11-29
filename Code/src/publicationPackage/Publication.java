package publicationPackage;

import exceptionHandlerPackage.ExceptionHandler;

//comments
public class Publication {
	/*
	 * private Double price; private int quantity; private String name; private
	 * String frequency;
	 */
	private int id;
	private String price;
	private String quantity; 
	private String name; 
	private String frequency;
	
	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
public Publication(String pubName, String pubPrice, String pubQuantity, String pubFrequency) throws ExceptionHandler  {
		
		id = 0;
		
		// Validate Input
		validateName(pubName);
		validatePrice(pubPrice);
		validateFrequency(pubFrequency);
		validateQuantity(pubQuantity);;
		
		
		// Set Attributes
		name = pubName;
		price = pubPrice;
		frequency = pubFrequency;
		quantity = pubQuantity;
	}
	
	public static void validateName(String pubName) throws ExceptionHandler {
		
		//Agree Formating Rules on "Publication Name"
		//E.G. Name String must be a minimum of 2 characters and a maximum of 50 characters
		
		if (pubName.isBlank() || pubName.isEmpty())
			throw new ExceptionHandler("Publication Name NOT specified");
		else if (pubName.length() < 2)
			throw new ExceptionHandler("Publication Name does not meet minimum length requirements");
		else if (pubName.length() > 50)
			throw new ExceptionHandler("Publication Name exceeds maximum length requirements");
		
	}
	
	public static void validatePrice(String pubPrice) throws ExceptionHandler {
		
		
		if (pubPrice.isBlank() || pubPrice.isEmpty())
			throw new ExceptionHandler("Publication Price NOT specified");
		else if (isNotNum(pubPrice))
			throw new ExceptionHandler("Publication Price is not a number");
	}
	
	public static void validateQuantity(String pubQuantity) throws ExceptionHandler {
		
		
		if (pubQuantity.isBlank() || pubQuantity.isEmpty())
			throw new ExceptionHandler("Publication Quantity NOT specified");
		else if (isNotNum(pubQuantity))
			throw new ExceptionHandler("Publication Quantity is not a number");
		else if (isNotNaturalNum(pubQuantity))
			throw new ExceptionHandler("Publication Quantity must be a natural number");
		
	}
	public static void validateFrequency(String pubFrequency) throws ExceptionHandler {
		
		
		if (pubFrequency.isBlank() || pubFrequency.isEmpty())
			throw new ExceptionHandler("Publication Frequency NOT specified");
		else if (!pubFrequency.equals("Weekly")&&!pubFrequency.equals("Daily")&&!pubFrequency.equals("Monthly"))
			throw new ExceptionHandler("Publication Frequency Must be Daily, Weekly or Monthly");
	}
	public static boolean isNotNum(String num) {
	    try {
	        double d = Double.parseDouble(num);
	    } catch (NumberFormatException nfe) {
	        return true;
	    }
	    return false;
	}
	public static boolean isNotNaturalNum(String num) {
	    try {
	        double d = Integer.parseInt(num);
	    } catch (NumberFormatException nfe) {
	        return true;
	    }
	    return false;
	}

	/*
	 * public Publication() {}
	 * 
	 * public Double getPrice() {}
	 * 
	 * public void setPrice() {}
	 * 
	 * public Double updatePrice() {}
	 * 
	 * public int getQuantity() {}
	 * 
	 * public void setQuantity() {}
	 * 
	 * public int updateQuantity() {}
	 * 
	 * public String getName() {}
	 * 
	 * public void setName() {}
	 * 
	 * public String updateName() {}
	 * 
	 * public static void printPublication() {}
	 * 
	 * public static void printAllPublications() {}
	 * 
	 * public static void deletePublication() {}
	 */
}
