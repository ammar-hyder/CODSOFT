import java.util.ArrayList;
import java.util.Scanner;

class Bank_Account{
    private int Balance;
    private int Pin;
    public Bank_Account(int pin) {
        Pin = pin;
    }
    public int getBalance() {
        return Balance;
    }
    public void setBalance(int balance) {
        Balance = balance;
    }
    public int getPin() {
        return Pin;
    }
    public void setPin(int pin) {
        Pin = pin;
    }
}
class ATM_Machine{
    Bank_Account Acc;
    boolean AccessGiven=false;

    public ATM_Machine(Bank_Account acc) {
        Acc = acc;
    }
    public void checkPin(int pin){
        if (Acc.getPin()==pin){
            AccessGiven=true;
        }
    }
    public void withdraw(int amount){
        if(!AccessGiven){
            System.out.println("Access denied.");
            return;
        }
        else {
            if (amount > Acc.getBalance()) {
                System.out.println("Insufficient Balance.");
            }
            else {
                Acc.setBalance( Acc.getBalance()-amount );
                System.out.println(amount+" withdrawn successfully.");
            }
        }
    }
    public void deposit(int amount){
        if(!AccessGiven){
            System.out.println("Access denied.");
            return;
        }
        Acc.setBalance( Acc.getBalance()+amount );
        System.out.println(amount+" deposited successfully.");
    }
    public void viewBalance(){
        if(!AccessGiven){
            System.out.println("Access denied.");
            return;
        }
        System.out.println("Current Account Balance: "+Acc.getBalance());
    }
}
public class TASK3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank_Account account = new Bank_Account(1234);
        ATM_Machine atmMachine =new ATM_Machine(account);
        while (true){
            System.out.println("Enter Pin");
            atmMachine.checkPin(scanner.nextInt());
            if(!atmMachine.AccessGiven) {
                System.out.println("Incorrect Pin");
            }
            else{
                break;
            }
        }

        for (;;){
                System.out.println("<------------------->");
                System.out.println("1. Withdraw");
                System.out.println("2. Deposit");
                System.out.println("3. View Balance");
                System.out.println("4. Exit");
                System.out.println("<------------------->");
            System.out.println("Enter choice");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the amount to Withdraw ");
                    atmMachine.withdraw(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Enter amount to Deposit");
                    atmMachine.deposit(scanner.nextInt());
                    break;
                case 3:
                    atmMachine.viewBalance();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect Choice");
            }
        }
    }
}
