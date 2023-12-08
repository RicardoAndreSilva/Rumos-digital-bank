package pt.rumos.DigitalBank.management.ui;

import pt.rumos.DigitalBank.management.model.BankAccount;
import pt.rumos.DigitalBank.management.model.DebitCard;
import pt.rumos.DigitalBank.management.utils.Console;
import pt.rumos.digitalBank.management.services.BankAccountService;
import pt.rumos.digitalBank.management.services.CreditCardServiceIml;
import pt.rumos.digitalBank.management.services.DebitCardServiceIml;

public class ATM {
    private DebitCardServiceIml debitCardService;

    public ATM(DebitCardServiceIml debitCardService) {
        this.debitCardService = debitCardService;
    }

    public void start(DebitCard debitCard) {
        Console.writeLine("Welcome to Rumos Digital Bank ATM");
        Console.writeLine("Please insert your debit card.");

        if (authenticateDebitCard(debitCard)) {

        } else {
            Console.writeLine("Card authentication failed. Exiting.");
        }
    }

    private boolean authenticateDebitCard(DebitCard debitCard) {
        Console.write("Enter your card number: ");
        int cardNumber = Console.readInt();
        Console.write("Enter your PIN: ");
        int pin = Console.readInt();

        return true;
    }

    private void showATMOptions() {
        while (true) {
            Console.writeLine("Choose an option:");
            Console.writeLine("1. Check balance");
            Console.writeLine("2. Withdraw");
            Console.writeLine("3. Deposit");
            Console.writeLine("4. Transfer");
            Console.writeLine("5. Exit ATM");

            int choice = Console.readInt();

            switch (choice) {
                case 1:
                    checkBalance();
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
                    Console.writeLine("Exiting ATM. Goodbye!");
                    return;
                default:
                    Console.writeLine("Invalid choice. Please try again.");
            }
        }
    }

    private void withdraw() {
        Console.writeLine("Enter amount to withdraw");
        double amount = Console.readDouble();

        /*if (debitCard.withdraw((amount))) {
            Console.writeLine("Withdrawal successful. Remaining balance: " + debitCard.getBalance());
        } else {
            Console.writeLine("Insufficient funds");
        }*/
    }

    private void deposit() {
        Console.write("Enter the amount to deposit: ");
        double amount = Console.readDouble();

       /* debitCard.deposit(amount);
        Console.writeLine("New balance: " + debitCard.getBalance());
        */

    }

    private void transfer() {
        Console.writeLine(("enter recipient account number"));
        String recipientAccountNumber = Console.readLine();

        Console.write("Enter the amount to transfer: ");
        double amount = Console.readDouble();


    }

    private void checkBalance() {
        /*double balance = debitCardService.getBalance();
        Console.writeLine("Your current balance: " + balance);
        */

    }

}
