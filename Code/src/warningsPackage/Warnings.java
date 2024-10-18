package warningsPackage;
import warningsPackage.Warnings;

public class Warnings {
    private String warningId;
    private String warningReason;
    private String warningStatus;
    private String deliveryPersonId;
    private String dateIssued;

    public Warnings() {}

    public Warnings(String warningId, String warningReason, String warningStatus, 
                    String deliveryPersonId, String dateIssued) {
        this.warningId = warningId;
        this.warningReason = warningReason;
        this.warningStatus = warningStatus;
        this.deliveryPersonId = deliveryPersonId;
        this.dateIssued = dateIssued;
    }

    // Getters
    public String getWarningId() {
        return warningId;
    }

    public String getWarningReason() {
        return warningReason;
    }

    public String getWarningStatus() {
        return warningStatus;
    }

    public String getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    // Setters
    public void setWarningId(String warningId) {
        this.warningId = warningId;
    }

    public void setWarningReason(String warningReason) {
        this.warningReason = warningReason;
    }

    public void setWarningStatus(String warningStatus) {
        this.warningStatus = warningStatus;
    }

    public void setDeliveryPersonId(String deliveryPersonId) {
        this.deliveryPersonId = deliveryPersonId;
    }

    public void setDateIssued(String dateIssued) {
        this.dateIssued = dateIssued;
    }

    // Update methods
    public void updateWarningReason(String newReason) {
        this.warningReason = newReason;
    }

    public void updateWarningStatus(String newStatus) {
        this.warningStatus = newStatus;
    }

    public void updateDateIssued(String newDateIssued) {
        this.dateIssued = newDateIssued;
    }

    // Method to print the warning details
    public static void printWarning(Warnings warning) {
        System.out.println("Warning ID: " + warning.getWarningId());
        System.out.println("Reason: " + warning.getWarningReason());
        System.out.println("Status: " + warning.getWarningStatus());
        System.out.println("Delivery Person ID: " + warning.getDeliveryPersonId());
        System.out.println("Date Issued: " + warning.getDateIssued());
    }

    // Method to delete a warning (in a real system this might involve removing from a database)
    public static void deleteWarning(Warnings warning) {
        System.out.println("Warning with ID " + warning.getWarningId() + " has been deleted.");
    }
}
