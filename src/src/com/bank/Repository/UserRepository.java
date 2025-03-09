package src.com.bank.Repository;

import src.com.bank.Entity.UserEntity;
import java.util.*;
import java.util.stream.Collectors;


public class UserRepository {

    private static Set<UserEntity> userSet = new HashSet<>();

    static{
        UserEntity admin = new UserEntity("admin","admin",0.0,12345679,"admin");
        UserEntity user1 = new UserEntity("user1","user1",1000.0,12345670,"user");
        UserEntity user2 = new UserEntity("user2","user2",2000.0,12345671,"user");
        UserEntity user3 = new UserEntity("user2","user2",2000.0,12345671,"user");
        userSet.add(admin);
        userSet.add(user3);
        userSet.add(user1);
        userSet.add(user2);
    }

    public void printUser(){
        System.out.println(userSet);
    }

    public UserEntity login(String username,String password){
        List<UserEntity> result = userSet.stream().filter(
                (user) -> (username.equals(user.getUsername())) &&
                        (password.equals(user.getPassword()))).collect(Collectors.toList());
        return (result.isEmpty())?null:result.get(0);
    }







}
