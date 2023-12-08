package pt.rumos.digitalBank.management.services;

import pt.rumos.DigitalBank.management.model.CreditCard;
import pt.rumos.digitabank.management.interfaces.ICreditCardService;

import java.util.ArrayList;
import java.util.List;

public class CreditCardServiceIml implements ICreditCardService {
    private List<CreditCard> creditCards;

    public CreditCardServiceIml() {
        creditCards = new ArrayList<>();
    }

    @Override
    public CreditCard createCreditCard(double creditLimit) {
        CreditCard creditCard = new CreditCard(creditLimit);
        creditCards.add(creditCard);
        return creditCard;
    }

    @Override
    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    @Override
    public boolean makePayment(CreditCard creditCard, double amount) {
        if (creditCard != null && amount > 0 && amount <= creditCard.getCreditLimitPlafond()) {
            creditCard.authorizedPayment(amount);
            return true;
        }
        return false;
    }

    @Override
    public double checkIfIsAvailableBalance(CreditCard creditcard) {
       if(creditcard != null){
           return creditcard.getAvailableCredit();
       }
       return 0.0;
    }
}
