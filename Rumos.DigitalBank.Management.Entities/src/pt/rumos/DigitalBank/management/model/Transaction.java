package pt.rumos.DigitalBank.management.model;

import java.time.LocalDateTime;

public class Transaction {
    private static int transactionIdCounter = 1; // Contador para gerar IDs
    private final int transactionId;
    private TransactionType transactionType;
    private double amount;
    private String recipientAccountNumber;
    private LocalDateTime registeredTimeTransaction;

    public Transaction(TransactionType transactionType, double amount, String recipientAccountNumber) {
        this.transactionId = transactionIdCounter++;
        this.transactionType = transactionType;
        this.amount = amount;
        this.recipientAccountNumber = recipientAccountNumber;
        this.registeredTimeTransaction = LocalDateTime.now();
    }

    public int getTransactionId() {
        return transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRecipientAccountNumber() {
        return recipientAccountNumber;
    }

    public void setRecipientAccountNumber(String recipientAccountNumber) {
        this.recipientAccountNumber = recipientAccountNumber;
    }

    public LocalDateTime getRegisteredTimeTransaction() {
        return registeredTimeTransaction;
    }
}

