package warningsPackage;

public class Warnings {
    private String warningId;
    private String warningReason;
    private String warningStatus;
    private String deliveryPersonId;
    private String dateIssued;
    
    public Warnings() {}
    
    public String getWarningId() {}
    
    public String getWarningReason() {}
    
    public String getWarningStatus() {}
    
    public String getDeliveryPersonId() {}
    
    public String getDateIssued() {}
    
    
    
    public void setWarningId(String warningId) {}
    
    public void setWarningReason(String warningReason) {}
    
    public void setWarningStatus(String warningStatus) {}
    
    public void setDeliveryPersonId(String deliveryPersonId) {}
    
    public void setDateIssued(String dateIssued) {}
    
    
    
    public String updateWarningReason(String newReason) {}
    
    public String updateWarningStatus(String newStatus) {}
    
    public String updateDateIssued(String newDateIssued) {}
    
    
    
    public static void printWarning(Warning warning) {}
    public static void deleteWarning(Warning warning) {}
}
