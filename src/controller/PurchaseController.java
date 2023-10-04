package controller;

import model.Part;
import model.Purchase;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class PurchaseController {

    private Purchase purchase;
    private LinkedList<Purchase> purchases;

    public PurchaseController() {
        purchases = new LinkedList<>();;
        read();
    }

    public void read() {
        try {
            FileReader fileReader = new FileReader("data/parts.csv");
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split(",");
                purchase = new Purchase(
                        data[0],
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                );
                purchases.add(purchase);
            }
            fileReader.close();
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public LinkedList<Purchase> read(String userOwner) {
        LinkedList<Purchase> userPurchases = new LinkedList<>();
        for (int i = 0; i < purchases.size(); i++) {
            if (userOwner.equals(purchases.get(i).getUserOwner())) {
                userPurchases.add(purchases.get(i));
            }
        }
        return userPurchases;
    }

    public void create(String userOwner, String computerName,String partName, double value) {
        try {
            FileWriter fileWriter = new FileWriter("data/purchases.csv", true);
            fileWriter.write(userOwner + "," + computerName + "," +partName + "," + value);
            fileWriter.write(System.lineSeparator());
            purchase = new Purchase(userOwner,computerName,partName,value);
            purchases.add(purchase);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



//    public void delete(int ID) {
//        try {
//            FileWriter fileWriter = new FileWriter("data/parts.csv", false);
//            for (int i = 0; i < parts.size(); i++) {
//                if (parts.get(i).getID() != ID) {
//                    fileWriter.write(
//                            parts.get(i).getID() + "," +
//                                    parts.get(i).getIDPC() + "," +
//                                    parts.get(i).getQuantity() + "," +
//                                    parts.get(i).getPrice() + "," +
//                                    parts.get(i).getName() + "," +
//                                    parts.get(i).getCategory() + "," +
//                                    parts.get(i).getBrand() + "," +
//                                    parts.get(i).getUserOwner()
//                    );
//                    fileWriter.write(System.lineSeparator());
//                } else {
//                    parts.set(i, null);
//                }
//            }
//            fileWriter.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

}
