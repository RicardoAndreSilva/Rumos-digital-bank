package pt.rumos.DigitalBank.management.model;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private final int accountNumber;
    private Customer primaryAccountHolder;
    private List<Customer> secondaryAccountHolders;
    private double balance;
    private List<Transaction> transactionHistory;

    public BankAccount(int accountNumber, Customer primaryAccountHolder) {
        this.accountNumber = accountNumber;
        this.primaryAccountHolder = primaryAccountHolder;
        this.secondaryAccountHolders = new ArrayList<>();
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getPrimaryAccountHolder() {
        return primaryAccountHolder;
    }

    private List<Customer> getSecondaryAccountHolders() {
        return secondaryAccountHolders;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void addSecondaryAccountHolder(Customer secondaryAccountHolder) {
        if (secondaryAccountHolders.size() < 4) {
            secondaryAccountHolders.add(secondaryAccountHolder);
        } else {
            throw new IllegalArgumentException("Maximum number of secondary account holders reached.");
        }
    }

    public void removeSecondaryAccountHolder(Customer secondaryAccountHolder) {
        secondaryAccountHolders.remove(secondaryAccountHolder);
    }
}



