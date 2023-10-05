package model;

public class Pending {
    private String userOwner;
    private String buyer;
    private String partName;
    private double value;
    private boolean isSubmitted;

    public Pending(String userOwner, String buyer, String partName, double value, boolean isSubmitted) {
        this.userOwner = userOwner;
        this.buyer = buyer;
        this.partName = partName;
        this.value = value;
        this.isSubmitted = isSubmitted;
    }

    public String getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(String userOwner) {
        this.userOwner = userOwner;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }
}
