package deliveryDocketPackage;

import java.util.List;

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
}


