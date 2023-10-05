package controller;

import model.Computer;
import model.Part;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class ComputerController {
    private Computer computer;
    private LinkedList<Computer> products;
    private PartsController partsController;
    private int nextID;
    private LinkedList<Computer> computers;

    public ComputerController() {
        partsController = new PartsController();
        computers = new LinkedList<>();
        read();
    }

    public void read() {
        try {
            FileReader fileReader = new FileReader("data/computers.csv");
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split(",");
                computer = new Computer(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]),
                        data[4]
                );
                computers.add(computer);
            }
            fileReader.close();
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getNextID() {
        nextID = computers.size()+1;
        return nextID;
    }

    public Part[] findComputerParts(int IDPC){
        Part[] parts = new Part[5];
        int j = 0;
        PartsController partsController = new PartsController();
        for (int i = 0; i < partsController.getParts().size(); i++) {
            if (partsController.getParts().get(i).getIDPC() == IDPC){
                parts[j] = partsController.getParts().get(i);
                j++;
            }
        }
        return parts;
    }

    public void loadComputerParts(){
        PartsController partsController = new PartsController();
        for (int i = 0; i < computers.size(); i++) {
            Part[] parts = new Part[5];
            int k = 0;
            for (int j = 0; j < partsController.getParts().size(); j++) {
                if (computers.get(i).getID() == partsController.getParts().get(j).getIDPC()){
                    parts[k] = partsController.getParts().get(j);
                    k++;
                }
            }
            computers.get(i).setParts(parts);
        }
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
        for (int i = 0; i < computers.size(); i++) {
            if (username.equals(computers.get(i).getUser())) {
                userProducts.add(computers.get(i));
            }
        }
        return userProducts;
    }

    public void create(int ID, String name, int quantity, double value, String user, String[] partsNames) {
        try {
            FileWriter fileWriter = new FileWriter("data/computers.csv", true);
            fileWriter.write(ID+","+name+","+quantity+","+value+","+user);
            fileWriter.write(System.lineSeparator());
            computer = new Computer(ID,name,quantity,value,user);
            computers.add(computer);

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
            for (int i = 0; i < computers.size(); i++) {
                if (computers.get(i).getID() == ID) {
                    computers.get(i).setName(newName);
                    computers.get(i).setQuantity(newQuantity);
                    computers.get(i).setValue(newValue);

                }
                fileWriter.write(computers.get(i).getID() + ","
                        + computers.get(i).getName() + ","
                        +computers.get(i).getQuantity()+","
                        +computers.get(i).getQuantity()+","
                        +computers.get(i).getValue()+","
                        +computers.get(i).getUser());
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //Update a single Computer quantity
    public void update(String computerName) {
        try {
            FileWriter fileWriter = new FileWriter("data/computers.csv", false);
            for (int i = 0; i < computers.size(); i++) {
                if (computers.get(i).getName().equals(computerName) && computers.get(i).getQuantity() > 0) {
                    computers.get(i).setQuantity(computers.get(i).getQuantity() - 1);
                }
                fileWriter.write(computers.get(i).getID() + ","
                        + computers.get(i).getName() + ","
                        +computers.get(i).getQuantity()+","
                        +computers.get(i).getQuantity()+","
                        +computers.get(i).getValue()+","
                        +computers.get(i).getUser());
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Computer> sellingComputers(){
        LinkedList<Computer> sellingComputers = new LinkedList<>();
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getQuantity() > 0){
                sellingComputers.add(computers.get(i));
            }
        }
        return sellingComputers;
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

    public LinkedList<Computer> getComputers() {
        return computers;
    }
}
