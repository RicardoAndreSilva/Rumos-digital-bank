package pt.rumos.DigitalBank.management.model;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private Customer primaryAccountHolder;
    private List<Customer> secondaryAccountHolders;
    private double balance;
    private final List<Transaction> transactions;

    public BankAccount(String accountNumber, Customer primaryAccountHolder) {
        this.accountNumber = accountNumber;
        this.primaryAccountHolder = primaryAccountHolder;
        this.secondaryAccountHolders = new ArrayList<>();
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getPrimaryAccountHolder() {
        return primaryAccountHolder;
    }

    public List<Customer> getSecondaryAccountHolders() {
        return secondaryAccountHolders;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addSecondaryAccountHolder(Customer secondaryAccountHolder) {
        secondaryAccountHolders.add(secondaryAccountHolder);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            createTransaction(TransactionType.DEPOSIT, amount, null);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            createTransaction(TransactionType.WITHDRAW, amount, null);
            return true;
        }
        return false;
    }

    public void transferTo(BankAccount recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            createTransaction(TransactionType.TRANSFER, amount, recipient.getAccountNumber());
        }
    }

    private void createTransaction(TransactionType type, double amount, String recipientAccountNumber) {
        Transaction transaction = new Transaction(type, amount, recipientAccountNumber);
        transactions.add(transaction);
    }
}




