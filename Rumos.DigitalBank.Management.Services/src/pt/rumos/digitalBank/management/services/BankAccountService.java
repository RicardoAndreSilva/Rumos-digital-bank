package pt.rumos.digitalBank.management.services;

import pt.rumos.DigitalBank.management.model.BankAccount;
import pt.rumos.DigitalBank.management.model.Transaction;

import java.util.List;

public interface BankAccountService {
    void deposit(BankAccount account, double amount);

    void withdraw(BankAccount account, double amount);

    List<Transaction> getTransactionHistory(BankAccount account);
}

