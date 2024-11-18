package warningsPackage;

//import java.time.LocalDate;

public class Warnings {
    private String warningId;
    private String warningReason;
    private String warningStatus;
    private String deliveryPersonId;
    private String dateIssued;


    public Warnings(String warningId, String warningReason, String warningStatus, 
                    String deliveryPersonId, String dateIssued) {
        if (warningId == null || warningId.isEmpty()) {
            throw new IllegalArgumentException("Warning ID cannot be null or empty");
        }
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
        if (warningId == null || warningId.isEmpty()) {
            throw new IllegalArgumentException("Warning ID cannot be null or empty");
        }
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
    public void printWarning(Warnings warning1) {
        System.out.println("Warning ID: " + warning1.getWarningId());
        System.out.println("Reason: " + warning1.getWarningReason());
        System.out.println("Status: " + warning1.getWarningStatus());
        System.out.println("Delivery Person ID: " + warning1.getDeliveryPersonId());
        System.out.println("Date Issued: " + warning1.getDateIssued());
    }

    // Method to delete a warning
    public static void deleteWarning(String warningId) {
        System.out.println("Warning with ID " + warningId + " has been deleted.");
    }
}
