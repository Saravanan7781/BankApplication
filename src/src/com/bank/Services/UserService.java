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
}
