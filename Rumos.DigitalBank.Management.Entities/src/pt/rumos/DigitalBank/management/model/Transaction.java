package pt.rumos.DigitalBank.management.model;

import java.time.LocalDateTime;

public class Transaction {
private TransactionType type;
private double amount;
private LocalDateTime timeTransaction;

    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timeTransaction = LocalDateTime.now();
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimeTransaction() {
        return timeTransaction;
    }
}

