
import java.util.Scanner;
class BankAccount
{
    private double balance;

    public BankAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }
    public double getBalance()
    {
        return balance;
    }
    public void deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            System.out.println("Successfully deposited: Rs " + amount);
        }
        else
        {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount)
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            System.out.println("Successfully withdrawn: Rs " + amount);
        }
        else if (amount > balance)
        {
            System.out.println("Insufficient balance.");
        }
        else
        {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
public class ATM
{
    private BankAccount account;
    public ATM(BankAccount account)
    {
        this.account = account;
    }
    public void displayMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        while (choice != 4);
        scanner.close();
    }
    private void checkBalance()
    {
        System.out.println("Current Balance: Rs " + account.getBalance());
    }
    private void deposit()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }
    private void withdraw()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
    public static void main(String[] args)
    {
        BankAccount userAccount = new BankAccount(0); //Initial Balance is Rs.0.0
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}