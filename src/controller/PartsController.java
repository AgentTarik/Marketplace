package controller;

import model.Part;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class PartsController {
    private Part part;
    private LinkedList<Part> parts;

    public PartsController() {
        parts = new LinkedList<>();
        read();
    }

    public void read() {
        try {
            FileReader fileReader = new FileReader("data/parts.csv");
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split(",");
                part = new Part(
                        Integer.parseInt(data[0]),
                        Integer.parseInt(data[1]),
                        Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]),
                        data[4],
                        data[5],
                        data[6],
                        data[7]
                );
                parts.add(part);
            }
            fileReader.close();
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Part> getParts() {
        return parts;
    }

    public String[] readByCategory(String category) {
        LinkedList<Part> selectedParts = new LinkedList<>();

        for (int i = 0; i < parts.size(); i++) {
            if (category.equals(parts.get(i).getCategory())){
                selectedParts.add(parts.get(i));
            }
        }

        String[] selectedPartsArray = new String[selectedParts.size()];
        for (int i = 0; i < selectedPartsArray.length; i++) {
            selectedPartsArray[i] = selectedParts.get(i).getName();
        }

        return selectedPartsArray;
    }

    public String[] readByCategory(String category, String name) {
        String brand = "";
        for (int i = 0; i < parts.size(); i++) {
            if (name.equals(parts.get(i).getName())){
                brand = parts.get(i).getBrand();
                System.out.println(brand);
            }
        }
        
        LinkedList<Part> selectedParts = new LinkedList<>();
        for (int i = 0; i < parts.size(); i++) {
            if (category.equals(parts.get(i).getCategory()) && category.equals("cpu") && parts.get(i).getBrand().equals(brand)){
                selectedParts.add(parts.get(i));
            }
        }

        String[] selectedPartsArray = new String[selectedParts.size()];
        for (int i = 0; i < selectedPartsArray.length; i++) {
            selectedPartsArray[i] = selectedParts.get(i).getName();
        }

        return selectedPartsArray;
    }

    public LinkedList<Part> read(String userOwner) {
        LinkedList<Part> userParts = new LinkedList<>();
        for (int i = 0; i < parts.size(); i++) {
            if (userOwner.equals(parts.get(i).getUserOwner())) {
                userParts.add(parts.get(i));
            }
        }
        return userParts;
    }

    public int newID(){
        return parts.get(parts.size()-1).getID() +1;
    }

    public void create(int ID, int IDPC, int quantity, double price, String name, String category, String brand, String userOnwer) {
        try {
            FileWriter fileWriter = new FileWriter("data/parts.csv", true);
            fileWriter.write(ID + "," + IDPC + "," + quantity + "," + price + "," + name + "," + category + "," + brand + "," + userOnwer);
            fileWriter.write(System.lineSeparator());
            part = new Part(ID, IDPC, quantity, price, name, category, brand, userOnwer);
            parts.add(part);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int ID, String newName) {
        try {
            FileWriter fileWriter = new FileWriter("data/parts.csv", false);
            for (int i = 0; i < parts.size(); i++) {
                if (parts.get(i).getID() == ID) {
                    parts.get(i).setName(newName);
                }
                fileWriter.write(
                parts.get(i).getID() + "," +
                    parts.get(i).getIDPC() + "," +
                    parts.get(i).getQuantity() + "," +
                    parts.get(i).getPrice() + "," +
                    parts.get(i).getName() + "," +
                    parts.get(i).getCategory() + "," +
                    parts.get(i).getBrand() + "," +
                    parts.get(i).getUserOwner()
                );
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(int ID) {
        try {
            FileWriter fileWriter = new FileWriter("data/parts.csv", false);
            for (int i = 0; i < parts.size(); i++) {
                if (parts.get(i).getID() != ID) {
                    fileWriter.write(
                    parts.get(i).getID() + "," +
                        parts.get(i).getIDPC() + "," +
                        parts.get(i).getQuantity() + "," +
                        parts.get(i).getPrice() + "," +
                        parts.get(i).getName() + "," +
                        parts.get(i).getCategory() + "," +
                        parts.get(i).getBrand() + "," +
                        parts.get(i).getUserOwner()
                    );
                    fileWriter.write(System.lineSeparator());
                } else {
                    parts.set(i, null);
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
