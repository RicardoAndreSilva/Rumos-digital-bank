package pt.rumos.DigitalBank.management.model;

public class DebitCard {
    private static int uniqueDebitCardNumber = 1000;
    private int cardNumber;
    private double balance;
    private Customer customer;


    public DebitCard(Customer customer) {
        this.cardNumber = generateUniqueCardNumber();
        this.customer = customer;
        this.balance = 0.0;
    }

    public static int getUniqueDebitCardNumber() {
        return uniqueDebitCardNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    private int generateUniqueCardNumber() {
        return uniqueDebitCardNumber++;

    }


}
