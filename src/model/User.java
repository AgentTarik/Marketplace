package model;

public class User {
    private String username;
    private String password;
    private String cpf;
    private String address;
    private String type;

    public User(String username, String password, String cpf, String address, String type) {
        this.username = username;
        this.password = password;
        this.cpf = cpf;
        this.address = address;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
