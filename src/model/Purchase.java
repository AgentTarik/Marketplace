package model;

public class Purchase {
    private String userOwner, computerName, partName;
    private double value;

    public Purchase(String userOwner, String computerName, String partName, double value) {
        this.userOwner = userOwner;
        this.computerName = computerName;
        this.partName = partName;
        this.value = value;
    }

    public String getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(String userOwner) {
        this.userOwner = userOwner;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
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
}
