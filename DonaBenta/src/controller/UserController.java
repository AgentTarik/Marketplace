package controller;

import model.User;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class UserController {
    private User user;
    private LinkedList<User> users;

    public UserController(){
        users = new LinkedList<>();
        read();
    }

    public void read(){
        try {
            FileReader fileReader = new FileReader("data/users.csv");
            Scanner scanner = new Scanner(fileReader);
            while(scanner.hasNext()){
                String[] data = scanner.nextLine().split(",");
                user = new User(data[0], data[1]);
                users.add(user);
            }
            fileReader.close();
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean read(String username, String password){
        for (int i = 0; i < users.size(); i++) {
            if (    username.equals(users.get(i).getUsername()) &&
                    password.equals(users.get(i).getPassword())     ){
                return true;
            }
        }
        return false;
    }
}
