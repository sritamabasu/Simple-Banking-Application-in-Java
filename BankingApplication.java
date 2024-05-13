import java.util.Scanner;
public class BankingApplication {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BankAccount bank1 = new BankAccount("Sritama","01");
        bank1.showmenu();

    }
}
class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid){
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction()
    {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        }
        else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }
        else
        {
            System.out.println("No transaction is occurred!");
        }

    }
    void showmenu(){
        char option = '\0';
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome "+customerName);
        System.out.println("Your ID is: "+customerId);
        System.out.println();
        System.out.println("A. CHECK BALANCE");
        System.out.println("B. DEPOSIT");
        System.out.println("C. WITHDRAW");
        System.out.println("D. PREVIOUS TRANSACTION");
        System.out.println("E. EXIT");

        do{
            System.out.println("=====================================");
            System.out.println("ENTER THE OPTION");
            System.out.println("=====================================");
            option = sc.next().charAt(0);
            char upperCase = Character.toUpperCase(option);

            switch (option) {
                case 'A' -> {
                    System.out.println("=====================================");
                    System.out.println("Balance is: " + balance);
                    System.out.println("=====================================");
                    System.out.println();
                }
                case 'B' -> {
                    System.out.println("=====================================");
                    System.out.println("enter the amount to deposit:");
                    System.out.println("=====================================");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println();
                }
                case 'C' -> {
                    System.out.println("=====================================");
                    System.out.println("enter the amount to withdraw:");
                    System.out.println("=====================================");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println();
                }
                case 'D' -> {
                    System.out.println("=====================================");
                    getPreviousTransaction();
                    System.out.println("=====================================");
                    System.out.println();
                }
                case 'E' -> System.out.println("=====================================");
                default -> System.out.println("Invalid option! please try again");
            }
        }while (option != 'E');
    }

}

