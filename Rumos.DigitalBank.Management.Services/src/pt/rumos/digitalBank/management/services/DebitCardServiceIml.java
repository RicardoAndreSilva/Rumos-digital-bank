package pt.rumos.digitalBank.management.services;

import pt.rumos.DigitalBank.management.model.Customer;
import pt.rumos.DigitalBank.management.model.DebitCard;
import pt.rumos.digitabank.management.interfaces.IDebitCardService;

import java.util.ArrayList;
import java.util.List;

public class DebitCardServiceIml implements IDebitCardService {
    private static final DebitCardServiceIml INSTANCE= new DebitCardServiceIml();
    private List<DebitCard> debitCards;
    private BankAccountService bankAccountService;


    public DebitCardServiceIml(BankAccountService bankAccountService) {
        debitCards = new ArrayList<>();
        this.bankAccountService = bankAccountService;
    }

    @Override
    public DebitCard createDebitCard(Customer customer) {
        DebitCard debitCard = new DebitCard(customer);
        debitCards.add(debitCard);
        return debitCard;
    }

    @Override
    public DebitCard getDebitCardByNumber(int cardNumber) {
        for (DebitCard debitCard : debitCards) {
            if (debitCard.getCardNumber() == cardNumber) {
                return debitCard;
            }
        }
        return null;
    }

    @Override
    public boolean depositToDebitCard(int cardNumber, double amount) {
        DebitCard debitCard = getDebitCardByNumber(cardNumber);
        if (debitCard != null) {

        }
        return false;
    }

    @Override
    public boolean withdrawFromDebitCard(int cardNumber, double amount) {
        DebitCard debitCard = getDebitCardByNumber(cardNumber);
        if (debitCard != null) {

        }
        return false;
    }

    public boolean transferToDebitCard(int sourceCardNumber, int destinationCardNumber, double amount) {
        DebitCard sourceCard = getDebitCardByNumber(sourceCardNumber);
        DebitCard destinationCard = getDebitCardByNumber(destinationCardNumber);

        if (sourceCard != null && destinationCard != null) {

        }
        return false;
    }

}

