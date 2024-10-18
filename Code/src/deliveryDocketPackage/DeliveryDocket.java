package deliveryDocketPackage;

import java.util.List;

import customerPackage.Customer;
import deliveryAreaPackage.DeliveryArea;
import deliveryPersonPackage.DeliveryPerson;
import ordersPackage.Orders;
import publicationPackage.Publication;

public class DeliveryDocket {
	
	private int docketId;
	private DeliveryArea deliveryArea;
	private DeliveryPerson deliveryPerson;
	private List<Publication> publications;
	private List<Orders> orders;
	private List<Customer> customer;
	private String deliveryDate;
	
	public DeliveryDocket(int docketId, DeliveryArea deliveryArea, DeliveryPerson deliveryPerson,
			List<Publication> publications, List<Orders> orders, List<Customer> customers, String deliveryDate) {
		super();
		this.docketId = docketId;
		this.deliveryArea = deliveryArea;
		this.deliveryPerson = deliveryPerson;
		this.publications = publications;
		this.orders = orders;
		this.customer = customers;
		this.deliveryDate = deliveryDate;
	}
	
	public int getDocketId() {
		return docketId;
	}

	public void setDocketId(int docketId) {
		this.docketId = docketId;
	}

	public DeliveryArea getDeliveryArea() {
		return deliveryArea;
	}

	public void setDeliveryArea(DeliveryArea deliveryArea) {
		this.deliveryArea = deliveryArea;
	}

	public DeliveryPerson getDeliveryPerson() {
		return deliveryPerson;
	}

	public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public static void generateDocket() {}
	
	public static void updateDocket() {}
	
	public static void deleteDocket() {}
	
	public static void printDocket() {
        System.out.println("Docket ID: " + docketId);
        System.out.println("Delivery Area: " + deliveryArea.getAreaName());
        System.out.println("Delivery Person: " + deliveryPerson.getName());
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Publications:");
        for (Publication publication : publications) {
            System.out.println(" - " + publication.getName());
        }
        System.out.println("Customer Orders:");
        for (Orders order : orders) {
            System.out.println("Customer: " + order.getCustomerDetails() + " ordered " + order.getOrderDetails());
        }
	}

}
