package ordersPackage;

public class Orders {

	private int orderId;
	public String orderDetails;
	public String customerDetails;
	public int orderQuantity;
	public int orderPrice;
	public String orderType;
	public String customerHolidays;
	
	public Orders() {}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(String customerDetails) {
		this.customerDetails = customerDetails;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getCustomerHolidays() {
		return customerHolidays;
	}

	public void setCustomerHolidays(String customerHolidays) {
		this.customerHolidays = customerHolidays;
	}

	public static void generateOrder() {}
	
	public static void printOrder() {}
	
	public static void updateOrder() {}
	
	public static void delteOrder() {}
}
