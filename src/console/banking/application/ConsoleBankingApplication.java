package console.banking.application;

import java.util.Scanner;

/**
 *
 * @author chuks
 */
public class ConsoleBankingApplication {

    public static void main(String[] args) {
        // TODO code application logic here
        
        BankAccountDetails obj = new BankAccountDetails("Tunde", "8483933849383933039");
        obj.showMenu();
    }
    
    
    
}

class BankAccountDetails {
    
    String accountName;
    String accountNumber;
    int previousTransaction;
    int accountBalance;
    
    BankAccountDetails(String customerName, String customerId){
        this.accountName = customerName;
        this.accountNumber = customerId;     
    }
    
    private void deposit(int amount){
        
        if(amount != 0){
            accountBalance = accountBalance + amount;
            previousTransaction = amount;            
        }       
    }
    
    private void withdraw(int amount){
        if(amount != 0){
            accountBalance = accountBalance - amount;
            previousTransaction = -1  * amount;
        }
    }
    
    private void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        }
        else if (previousTransaction < 0){
            System.out.println("Withdrew: " + previousTransaction);
        }
        else {
            System.out.println("No Transaction Occured \n" + "Current Account Balance" + accountBalance);
        }
    }
    
    public void showMenu(){
        
        char inputedCharacter = '\0';
        Scanner option = new Scanner(System.in);
        
        System.out.println("\n");
        System.out.println("Welcome to Wiley Bank " + accountName);
        System.out.println("Your Wiley account no is " + accountNumber);
        System.out.println("\n");
        System.out.println("A. CHECK BALANCE");
        System.out.println("B. DEPOSIT");
        System.out.println("C. WITHDRAW");
        System.out.println("D. PREVIOUS TRANSACTION");
        System.out.println("E. EXIT");
        
        do {
            System.out.println("=============================================");
            System.out.println("Enter an option");
            System.out.println("=============================================");
            inputedCharacter = option.next().charAt(0);
            System.out.println("\n");
            
            switch(inputedCharacter)
            {
                case 'A':
                    System.out.println("-------------------------------------");
                    System.out.println("Account Balanace = "+ accountBalance);
                    System.out.println("-------------------------------------");
                    System.out.println("\n");
                    break;
                    
                case 'B':
                    System.out.println("-------------------------------------");
                    System.out.println("Enter amount to Deposit");
                    System.out.println("-------------------------------------");
                    int amount = option.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                    
                case 'C':
                    System.out.println("-------------------------------------");
                    System.out.println("Enter amount to Withdraw");
                    System.out.println("-------------------------------------");
                    int amount2 = option.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;
                    
                case 'D':
                    System.out.println("-------------------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------------------");
                    System.out.println("\n");
                    break;
                    
                case 'E':
                    System.out.println("**************************************");
                    System.out.println("Always at your service");
                    System.out.println("**************************************");
                    
                default:
                    System.out.println("-------------------------------------");
                    System.out.println("Invalid option please try again");
                    System.out.println("-------------------------------------");
                    System.out.println("\n");
                    break;
                    
            }
    
            
        }
        while(inputedCharacter != 'E');    
    
        
        
    }
    
    
}
