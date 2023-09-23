package model;

public class Computer {
    private int ID,quantity;
    private String name;
    private String description;
    private double value;
    private String user;
    private Part[] parts;

    public Computer(int ID, String name, int quantity, double value, String user) {
        this.ID = ID;
        this.quantity = quantity;
        this.name = name;
        this.value = value;
        this.user = user;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Part[] getParts() {
        return parts;
    }

    public void setParts(Part[] parts) {
        this.parts = parts;
    }
}
