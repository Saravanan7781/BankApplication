package src.com.bank.Main;
import src.com.bank.Entity.UserEntity;
import src.com.bank.Services.UserService;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static UserService service = new UserService();
    public static void main(String[] args) {
        Main main = new Main();
        do{
            System.out.println("Enter username:");
            String username = sc.next();
            System.out.println("Enter your password:");
            String password = sc.next();
            UserEntity user = service.login(username,password);
            if(user!=null && user.getRole().equals("admin")){
                System.out.println("<------------------------Logged in as Admin--------------------------->");
                main.initAdmin();
            }
            else if(user!=null && user.getRole().equals("user")){
                System.out.println("<------------------------Logged in as Customer--------------------------->");
                main.initCustomer(user);
            }
            else{
                System.out.println("Incorrect credential, Please try again!");
            }
        }while(true);

    }

    private void initCustomer(UserEntity user){
        boolean run = true;
        do{
            System.out.println("1) Exit/Logout");
            System.out.println("2)Check Bank Balance");
            System.out.println("3)Fund Transfer");
            int response = sc.nextInt();
            switch (response){
                case 1:
                    System.out.println("<------------------------Logging out--------------------------->");
                    run = false;
                    break;
                case 2:
                    Double balance = getBalance(user.getUsername());
                    if(balance!=null){
                        System.out.println("Your Bank Balance is "+balance);
                    }
                    else
                        System.out.println("UserId is wrong");
                    break;
                case 3:
                    System.out.println("Enter payee id: ");
                    String payeeId = sc.next();
                    System.out.println("Enter amount to be sent");
                    double amountTobeSent = sc.nextDouble();
                    double balanceAmount = getBalance(user.getUsername());
                    if(balanceAmount<=amountTobeSent)
                        System.out.println("Not enough balance!");
                    else{
                        if(transferFund(user.getUsername(),amountTobeSent,payeeId)){
                            System.out.println("Fund Transferred Successfuly");
                        }
                        else
                            System.out.println("Error in transferring funds");
                    }

                default:
                    System.out.println("Please select from only the listed commands.");
                    break;
            }
        }while(run);
    }

    private void initAdmin(){
        boolean run = true;
        do{
            System.out.println("1)Create new Customer");
            System.out.println("2) Exit/Logout");
            int response = sc.nextInt();
            switch (response){
                case 1:
                    System.out.println("Enter customer's name: ");
                    String name = sc.next();
                    System.out.println("Enter customer's password");
                    String password = sc.next();
                    System.out.println("Enter customer's contact number");
                    int phone = sc.nextInt();
                    createAccount(name,password,phone);
                    break;
                case 2:
                    System.out.println("<------------------------Logging out--------------------------->");
                    run = false;
                    break;
                default:
                    System.out.println("Please select from only the listed commands.");
            }
        }while(run);
    }

    /*purpose; to create account for users by admin
      role: Admin*/

    private boolean createAccount(String name,String password,int phone){
        return service.createAccount(name,password,phone);
    }

    private Double getBalance(String userId){
        return service.getBalance(userId);
    }

    private boolean transferFund(String userId,double amountTobeSent,String payeeId){
        return service.transferFund(userId,amountTobeSent,payeeId);
    }
}
