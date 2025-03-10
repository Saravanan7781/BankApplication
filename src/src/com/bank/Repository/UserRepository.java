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
                        (password.equals(user.getPassword()))).toList();
        return (result.isEmpty())?null:result.get(0);
    }

    public boolean createAccount(String name,String password,int contact){
        UserEntity newUser = new UserEntity(name,password,0.0,contact,"user");
        return userSet.add(newUser);
    }


    public Double getBalance(String userId){
        List<UserEntity> list = userSet.stream().filter(user -> (user.getUsername().equals(userId))).collect(Collectors.toList());
        return (list.isEmpty())?null:list.get(0).getBalance();
    }


    public boolean transferFund(String userId,double amountTobeSent,String payeeId){
        return debitFromUser(userId,amountTobeSent)
                && creditToUser(payeeId,amountTobeSent);
    }

    private boolean debitFromUser(String userId,double amountToBeDebited){
        List<UserEntity> finalList = userSet.stream().filter(userEntity -> userEntity.getUsername().equals(userId))
                .collect(Collectors.toList());
        if(finalList.isEmpty()){
            return false;
        }
        UserEntity oldUser = finalList.get(0);
        double originalAmount = oldUser.getBalance() - amountToBeDebited;
        userSet.remove(finalList.get(0));
        UserEntity newUser = new UserEntity(userId,oldUser.getPassword(),originalAmount
                ,oldUser.getContact(),oldUser.getRole());
        userSet.add(newUser);
        return true;
    }

    private boolean creditToUser(String userId,double amountToBeCredited){
        List<UserEntity> finalList = userSet.stream().filter(userEntity -> userEntity.getUsername().equals(userId))
                .collect(Collectors.toList());
        if(finalList.isEmpty()){
            return false;
        }
        UserEntity oldUser = finalList.get(0);
        double originalAmount = oldUser.getBalance() + amountToBeCredited;
        userSet.remove(finalList.get(0));
        UserEntity newUser = new UserEntity(userId,oldUser.getPassword(),originalAmount
                ,oldUser.getContact(),oldUser.getRole());
        userSet.add(newUser);
        return true;
    }






}
