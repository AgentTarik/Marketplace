package controller;

import model.Computer;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class ComputerController {
    private Computer product;
    private LinkedList<Computer> products;

    private PartsController partsController;

    private int nextID;

    public ComputerController() {
        partsController = new PartsController();
        products = new LinkedList<>();
        read();
    }

    public void read() {
        try {
            FileReader fileReader = new FileReader("data/computers.csv");
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split(",");
                product = new Computer(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]),
                        data[4]
                );
                products.add(product);
            }
            fileReader.close();
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getNextID() {
        nextID = products.size()+1;
        return nextID;
    }

    public double calculatePrice(String[] name){
        double total = 0;
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < partsController.getParts().size(); j++) {
                if (partsController.getParts().get(j).getName().equals(name[i])){
                    total = total + partsController.getParts().get(j).getPrice();
                }
            }

        }
        return total;
    }

    public LinkedList<Computer> read(String username) {
        LinkedList<Computer> userProducts = new LinkedList<>();
        for (int i = 0; i < products.size(); i++) {
            if (username.equals(products.get(i).getUser())) {
                userProducts.add(products.get(i));
            }
        }
        return userProducts;
    }

    public void create(int ID, String name, int quantity, double value, String user, String[] partsNames) {
        try {
            FileWriter fileWriter = new FileWriter("data/computers.csv", true);
            fileWriter.write(ID+","+name+","+quantity+","+value+","+user);
            fileWriter.write(System.lineSeparator());
            product = new Computer(ID,name,quantity,value,user);
            products.add(product);

            // Set new IDPC to parts in this new created PC
            partsController.create(ID, partsNames);

            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int ID, String newName, int newQuantity, double newValue) {
        try {
            FileWriter fileWriter = new FileWriter("data/computers.csv", false);
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getID() == ID) {
                    products.get(i).setName(newName);
                    products.get(i).setQuantity(newQuantity);
                    products.get(i).setValue(newValue);

                }
                fileWriter.write(products.get(i).getID() + ","
                        + products.get(i).getName() + ","
                        +products.get(i).getQuantity()+","
                        +products.get(i).getQuantity()+","
                        +products.get(i).getValue()+","
                        +products.get(i).getUser());
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(int ID) {
        try {
            FileWriter fileWriter = new FileWriter("data/computers.csv", false);
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getID() != ID) {
                    fileWriter.write(products.get(i).getID() + ","
                            + products.get(i).getName() + ","
                            +products.get(i).getQuantity()+","
                            +products.get(i).getQuantity()+","
                            +products.get(i).getValue()+","
                            +products.get(i).getUser());
                    fileWriter.write(System.lineSeparator());
                } else {
                    products.set(i, null);
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public LinkedList<Computer> getProducts() {
        return products;
    }
}
