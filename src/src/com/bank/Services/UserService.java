package src.com.bank.Services;

import src.com.bank.Entity.UserEntity;
import src.com.bank.Repository.UserRepository;

public class UserService {
    UserRepository user = new UserRepository();
    public void getUser(){
        user.printUser();
    }

    public UserEntity login(String username, String password){
        return user.login(username,password);
    }

    public boolean createAccount(String name, String password,int contact){
        if(user.createAccount(name,password,contact)){
            System.out.println("Account created Successfully.");
            return true;
        }
        System.out.println("User Already exists");
        return false;
    }

    public Double getBalance(String userId){
        return user.getBalance(userId);
    }

    public boolean transferFund(String userId,double amountTobeSent,String payeeId){
        return user.transferFund(userId,amountTobeSent,payeeId);
    }
}
