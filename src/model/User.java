package model;

import java.util.LinkedList;

public class User {
    private String username;
    private String password;
    private String type;

    public User(String username, String password,String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
}
