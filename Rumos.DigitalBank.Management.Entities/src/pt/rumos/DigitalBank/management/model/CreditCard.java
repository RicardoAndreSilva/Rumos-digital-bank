package pt.rumos.DigitalBank.management.model;

public class CreditCard {
    private static int uniqueCreditCardNumber = 1000;
    private final int cardNumber;
    private double creditLimitPlafond;
    private double currentBalance;
    private double usedCredit;

    public CreditCard(double creditLimit) {
        this.cardNumber = generateUniqueCardNumber();
        this.creditLimitPlafond = creditLimit;
        this.currentBalance = 0.0;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public double getCreditLimitPlafond() {
        return creditLimitPlafond;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    private int generateUniqueCardNumber() {
        return uniqueCreditCardNumber++;
    }

    public boolean makePurchase(double amount) {
        if (amount > 0 && currentBalance + amount <= creditLimitPlafond) {
            currentBalance += amount;
            return true;
        }
        return false;
    }

    public void authorizedPayment(double amount) {
        if(amount  <= creditLimitPlafond -usedCredit){
            usedCredit += amount;
        }
    }

    public double getAvailableCredit() {
        return creditLimitPlafond - usedCredit;
    }
}
