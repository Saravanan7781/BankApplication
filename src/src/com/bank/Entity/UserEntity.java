package src.com.bank.Entity;

import java.util.Objects;

public class UserEntity {
    private String username;
    private String password;
    private double balance;
    private int contact;

    private String role;

    public UserEntity(String username, String password, double balance, int contact,String role) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.contact = contact;
        this.role = role;
    }


//    @java.lang.Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", contact=" + contact +
                ", role='" + role + '\'' +
                '}';
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public int getContact() {
        return contact;
    }

    public String getRole() {
        return role;
    }
}
