package deliveryPersonPackage;

public class DeliveryPerson {
    private String id;
    private String name;
    private String contactInfo;
    private String assignedRoute;

    public DeliveryPerson() {}

    public DeliveryPerson(String id, String name, String contactInfo, String assignedRoute) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.assignedRoute = assignedRoute;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getAssignedRoute() {
        return assignedRoute;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setAssignedRoute(String assignedRoute) {
        this.assignedRoute = assignedRoute;
    }

    // Update methods
    public void updateName(String newName) {
        this.name = newName;
    }

    public void updateContactInfo(String newContactInfo) {
        this.contactInfo = newContactInfo;
    }

    public void updateAssignedRoute(String newAssignedRoute) {
        this.assignedRoute = newAssignedRoute;
    }

    // Method to print the delivery person details
    public static void printDeliveryPerson(DeliveryPerson deliveryPerson) {
        System.out.println("Delivery Person ID: " + deliveryPerson.getId());
        System.out.println("Name: " + deliveryPerson.getName());
        System.out.println("Contact Info: " + deliveryPerson.getContactInfo());
        System.out.println("Assigned Route: " + deliveryPerson.getAssignedRoute());
    }

    // Method to delete a delivery person (in a real system this might involve removing from a database)
    public static void deleteDeliveryPerson(DeliveryPerson deliveryPerson) {
        System.out.println("Delivery Person with ID " + deliveryPerson.getId() + " has been deleted.");
    }
}
