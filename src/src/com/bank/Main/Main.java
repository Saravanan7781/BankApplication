package src.com.bank.Main;
import src.com.bank.Entity.UserEntity;
import src.com.bank.Services.UserService;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter username:");
        String username = sc.next();
        System.out.println("Enter your password:");
        String password = sc.next();
        UserService service = new UserService();
            UserEntity user = service.login(username,password);
        if(user!=null){
            System.out.println("Login Succesfull");
        }
        else{
            System.out.println("Incorrect credential");
        }
    }
}
