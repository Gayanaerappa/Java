import java.util.ArrayList;
import java.util.Scanner;

// Bank Account Class
class BankAccount {
    private int accountNumber;
    private String name;
    private double balance;

    public BankAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("✅ Amount Deposited Successfully!");
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("✅ Amount Withdrawn Successfully!");
        }
    }

    public void display() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name      : " + name);
        System.out.println("Balance   : " + balance);
        System.out.println("---------------------------");
    }
}

// Main Class
public class BankManagementSystem {
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n====== BANK MENU ======");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View All Accounts");
            System.out.println("5. Search Account");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    displayAccounts();
                    break;
                case 5:
                    searchAccount();
                    break;
                case 0:
                    System.out.println("👋 Thank you!");
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }

        } while (choice != 0);
    }

    // Create Account
    public static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        accounts.add(new BankAccount(accNo, name, balance));
        System.out.println("✅ Account Created Successfully!");
    }

    // Deposit
    public static void depositMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();
                acc.deposit(amount);
                return;
            }
        }
        System.out.println("❌ Account Not Found!");
    }

    // Withdraw
    public static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();
                acc.withdraw(amount);
                return;
            }
        }
        System.out.println("❌ Account Not Found!");
    }

    // Display All Accounts
    public static void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("❌ No Accounts Available!");
        } else {
            for (BankAccount acc : accounts) {
                acc.display();
            }
        }
    }

    // Search Account
    public static void searchAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                acc.display();
                return;
            }
        }
        System.out.println("❌ Account Not Found!");
    }
}
