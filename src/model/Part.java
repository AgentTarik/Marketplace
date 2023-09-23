package model;

public class Part {
    private int ID, IDPC, quantity;
    private double price;
    private String name, category, brand;
    private String userOwner;

    public Part(int ID, int IDPC, int quantity, double price, String name, String cate, String brand, String userOwner) {
        this.ID = ID;
        this.IDPC = IDPC;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.category = cate;
        this.brand = brand;
        this.userOwner = userOwner;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDPC() {
        return IDPC;
    }

    public void setIDPC(int IDPC) {
        this.IDPC = IDPC;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(String userOwner) {
        this.userOwner = userOwner;
    }
}
