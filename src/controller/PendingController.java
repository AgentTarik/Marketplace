package controller;

import model.Part;
import model.Pending;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class PendingController {
    Pending pending;
    LinkedList<Pending> pendings;

    public PendingController(){
        pendings = new LinkedList<>();
        read();
    }

    public void read(){
        try {
            FileReader fileReader = new FileReader("data/pendings.csv");
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split(",");
                pending = new Pending(
                        data[0],
                        data[1],
                        data[2],
                        Double.parseDouble(data[3]),
                        Boolean.parseBoolean(data[4])
                );
                pendings.add(pending);
            }
            fileReader.close();
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Pending> getPendings() {
        return pendings;
    }

    public void create(String buyer, String computerName, String partName, Double value){
        if (computerName.equals("empty") && !partName.equals("empty")){
            try {
                FileWriter fileWriter = new FileWriter("data/pendings.csv", true);
                String userOwner = findOwner(partName);
                fileWriter.write(userOwner+","+buyer+","+partName+","+value+","+false);
                fileWriter.write(System.lineSeparator());
                pending = new Pending(userOwner,buyer,partName,value,false);
                pendings.add(pending);

                fileWriter.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (!computerName.equals("empty") && partName.equals("empty")) {
            String[] partsNames = findParts(computerName);
            for (int i = 0; i < partsNames.length; i++) {
                try {
                    FileWriter fileWriter = new FileWriter("data/pendings.csv", true);
                    String userOwner = findOwner(partsNames[i]);
                    fileWriter.write(userOwner+","+buyer+","+partsNames[i]+","+value+","+false);
                    fileWriter.write(System.lineSeparator());
                    pending = new Pending(userOwner,buyer,partsNames[i],value,false);
                    pendings.add(pending);

                    fileWriter.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public String findOwner(String partName){
        String ownerPart = "";
        PartsController partsController = new PartsController();
        for (int i = 0; i < partsController.getParts().size(); i++) {
            if (partsController.getParts().get(i).getName().equals(partName)){
                ownerPart = partsController.getParts().get(i).getUserOwner();
            }
        }
        return ownerPart;
    }

    public String[] findParts(String computerName){
        ComputerController computerController = new ComputerController();
        computerController.loadComputerParts();

        String[] partsNames = new String[5];

        for (int i = 0; i < computerController.getComputers().size(); i++) {
            if(computerController.getComputers().get(i).getName().equals(computerName)){
                for (int j = 0; j < partsNames.length; j++) {
                    partsNames[j] = computerController.getComputers().get(i).getParts()[j].getName();
                }
                break;
            }
        }

        return partsNames;
    }

    public void delete(){
        try {
            FileWriter fileWriter = new FileWriter("data/pendings.csv", false);
            pendings.clear();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
