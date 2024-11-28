package deliveryDocketPackage;

import java.util.List;

import exceptionHandlerPackage.ExceptionHandler;

public class DeliveryDocket {

	private int docketId;
	private String deliveryDate;
	private String deliveryArea;
	private String deliveryPerson;
	private String publicationIds;
	private String customer;

	// Constructor
	public DeliveryDocket(String deliveryDate, String deliveryArea, String deliveryPerson, String publicationIds, String customer) {
		docketId = 0;
		this.deliveryDate = deliveryDate;
		this.deliveryArea = deliveryArea;
		this.deliveryPerson = deliveryPerson;
		this.publicationIds = publicationIds;
		this.customer = customer;
	}

	// Getters and setters
	public int getDocketId() {
		return docketId;
	}

	public void setDocketId(int docketId) {
		this.docketId = docketId;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryArea() {
		return deliveryArea;
	}

	public void setDeliveryArea(String deliveryArea) {
		this.deliveryArea = deliveryArea;
	}

	public String getDeliveryPerson() {
		return deliveryPerson;
	}

	public void setDeliveryPerson(String deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}

	public String getPublicationIds() {
		return publicationIds;
	}

	public void setPublicationIds(String publicationIds) {
		this.publicationIds = publicationIds;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public static void validateDeliveryDate(String deliveryDate) throws ExceptionHandler {
		if (deliveryDate == null || deliveryDate.isBlank() || deliveryDate.isEmpty()) {
			throw new ExceptionHandler("Delivery date NOT specified");
		}
		// Regex pattern to validate date format (YYYY-MM-DD)
		if (!deliveryDate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
			throw new ExceptionHandler("Delivery date must be in format YYYY-MM-DD");
		}
	}

	public static void validateDeliveryArea(String deliveryArea) throws ExceptionHandler {
		if (deliveryArea == null || deliveryArea.isBlank() || deliveryArea.isEmpty()) {
			throw new ExceptionHandler("Delivery area NOT specified");
		} else if (deliveryArea.length() < 2) {
			throw new ExceptionHandler("Delivery area does not meet minimum length requirements");
		} else if (deliveryArea.length() > 100) {
			throw new ExceptionHandler("Delivery area exceeds maximum length requirements");
		}
	}

	public static void validateDeliveryPerson(String deliveryPerson) throws ExceptionHandler {
		if (deliveryPerson == null || deliveryPerson.isBlank() || deliveryPerson.isEmpty()) {
			throw new ExceptionHandler("Delivery person NOT specified");
		} else if (deliveryPerson.length() < 2) {
			throw new ExceptionHandler("Delivery person does not meet minimum length requirements");
		} else if (deliveryPerson.length() > 100) {
			throw new ExceptionHandler("Delivery person exceeds maximum length requirements");
		}
	}

	public static void validatePublicationIds(String publicationIds) throws ExceptionHandler {
		if (publicationIds == null || publicationIds.isBlank() || publicationIds.isEmpty()) {
			throw new ExceptionHandler("Publication IDs NOT specified");
		}
		// Validate that the input contains only numbers and commas
		if (!publicationIds.matches("^\\d+(,\\d+)*$")) {
			throw new ExceptionHandler("Publication IDs must be a comma-separated list of numbers");
		}
	}

	public static void validateCustomer(String customer) throws ExceptionHandler {
		if (customer == null || customer.isBlank() || customer.isEmpty()) {
			throw new ExceptionHandler("Customer NOT specified");
		} else if (customer.length() < 2) {
			throw new ExceptionHandler("Customer does not meet minimum length requirements");
		} else if (customer.length() > 100) {
			throw new ExceptionHandler("Customer exceeds maximum length requirements");
		}
	}

}


