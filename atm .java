import java.util.Scanner;

public class ATM {
    private static final String USER_ID = "1234";
    private static final String USER_PIN = "5678";
    private static double balance = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userId = scanner.next();
        System.out.print("Enter User PIN: ");
        String userPin = scanner.next();

        if (authenticateUser(userId, userPin)) {
            System.out.println("Welcome to the ATM");
            showMenu();
        } else {
            System.out.println("Invalid User ID or PIN");
        }
    }

    private static boolean authenticateUser(String userId, String userPin) {
        return USER_ID.equals(userId) && USER_PIN.equals(userPin);
    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void showTransactionHistory() {
        System.out.println("Transaction History:");
        // logic to retrieve and display transaction history
    }

    private static void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    private static void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposit successful");
    }

    private static void transfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter recipient's account number: ");
        String recipientAccountNumber = scanner.next();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Transfer successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}