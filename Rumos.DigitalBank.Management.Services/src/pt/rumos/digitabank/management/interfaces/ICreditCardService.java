package pt.rumos.digitabank.management.interfaces;

import pt.rumos.DigitalBank.management.model.CreditCard;

import java.util.List;

public interface ICreditCardService {
    CreditCard createCreditCard(double creditLimit);

    List<CreditCard> getCreditCards();
    boolean makePayment(CreditCard creditCard, double amount);

    double checkIfIsAvailableBalance(CreditCard creditcard);
}
