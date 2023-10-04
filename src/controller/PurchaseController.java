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
        purchases = new LinkedList<>();
        ;
        read();
    }

    public void read() {
        try {
            FileReader fileReader = new FileReader("data/purchases.csv");
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
            if (purchases.get(i).getUserOwner().equals(userOwner)) {
                userPurchases.add(purchases.get(i));
            }
        }
        return userPurchases;
    }


    public double cartValue(String userOwner) {
        LinkedList<Purchase> userPurchases = new LinkedList<>();
        double totalValue = 0;
        userPurchases = read(userOwner);
        for (int i = 0; i < userPurchases.size(); i++) {
            totalValue = totalValue + userPurchases.get(i).getValue();
        }
        return totalValue;
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


   //deletes all Purchases from an user's Cart
    public void delete(String userOwner) {
        try {
            FileWriter fileWriter = new FileWriter("data/purchases.csv", false);
            for (int i = 0; i < purchases.size(); i++) {
                if (!(purchases.get(i).getUserOwner().equals(userOwner))) {
                    fileWriter.write(
                            purchases.get(i).getUserOwner() + "," +
                                    purchases.get(i).getComputerName() + "," +
                                    purchases.get(i).getPartName() + "," +
                                    purchases.get(i).getValue()
                    );
                    fileWriter.write(System.lineSeparator());
                } else {
                    purchases.set(i, null);
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
